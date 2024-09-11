package com.github.lrssmeiksts.qwiz.business.service.impl;

import com.github.lrssmeiksts.qwiz.business.handlers.InvalidIdException;
import com.github.lrssmeiksts.qwiz.business.handlers.UnexpectedException;
import com.github.lrssmeiksts.qwiz.business.handlers.UserDatabaseException;
import com.github.lrssmeiksts.qwiz.business.mappers.UserMapper;
import com.github.lrssmeiksts.qwiz.business.repository.LeaderboardRepository;
import com.github.lrssmeiksts.qwiz.business.repository.UserRepository;
import com.github.lrssmeiksts.qwiz.business.repository.model.LeaderboardDAO;
import com.github.lrssmeiksts.qwiz.business.repository.model.UserDAO;
import com.github.lrssmeiksts.qwiz.business.service.LeaderboardService;
import com.github.lrssmeiksts.qwiz.business.service.QuizResultService;
import com.github.lrssmeiksts.qwiz.business.service.QuizService;
import com.github.lrssmeiksts.qwiz.business.service.UserService;
import com.github.lrssmeiksts.qwiz.model.Leaderboard;
import com.github.lrssmeiksts.qwiz.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final LeaderboardService leaderboardService;
    private final QuizResultService quizResultService;
    private final QuizService quizService;

    @Autowired
    public UserServiceImpl (UserRepository userRepository, UserMapper userMapper,
                            LeaderboardService leaderboardService,QuizResultService quizResultService, QuizService quizService){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.leaderboardService = leaderboardService;
        this.quizResultService = quizResultService;
        this.quizService = quizService;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        Optional<User> userById = userRepository.findById(id)
                .flatMap(user -> Optional.ofNullable(userMapper.userDAOToUser(user)));
        log.info("User with ID {} is {}", id, userById);
        return userById;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = userRepository.findAll().
                stream().map(userMapper::userDAOToUser).toList();
        log.info("List of Users. The size is: {}",userList.size());
        return userList;
    }

    @Override
    public User createUser(User user) {
        try{
            Leaderboard userLeaderboard = new Leaderboard();
            userLeaderboard.setTotalScore(0);
            userLeaderboard.setQuizzesGuessed(0);
            LeaderboardDAO savedLeaderboard = leaderboardService.saveLeaderboard(userLeaderboard);
            log.debug("New leaderboard entry was created with ID: {}", savedLeaderboard.getId());

            UserDAO userDAO = userMapper.userToUserDAO(user);
            userDAO.setLeaderboardId(savedLeaderboard);
            userRepository.save(userDAO);

            User savedUser = userMapper.userDAOToUser(userDAO);
            log.debug("User was saved with id: {} and new leaderboard id: {}",
                    savedUser.getId(),savedUser.getLeaderboardId());

            return savedUser;
        }catch (JpaSystemException e){
            throw new UserDatabaseException("User was not saved due to persistence issue.",e);
        } catch (RuntimeException e){
            throw new UnexpectedException("User was not saved due to unexpected exception", e);
        }
    }

    @Override
    public User updateUser(Long id, User userUpdate) {
        log.info("Attempting to update user with ID: {}",id);
        Optional<UserDAO> optExistingUser = userRepository.findById(id);

        if(optExistingUser.isEmpty()){
            log.warn("No user found with ID: {}",id);
            throw  new InvalidIdException("No user was found with ID: "+ id);
        }

        UserDAO existingUserDAO = optExistingUser.get();
        userUpdate.setId(id);
        existingUserDAO = userMapper.userToUserDAO(userUpdate);

        try{
            UserDAO updatedUser = userRepository.save(existingUserDAO);
            log.info("User with ID: {} has been updated",id);
            return userMapper.userDAOToUser(updatedUser);
        } catch (JpaSystemException e){
            throw new UserDatabaseException("User was not updated due to persistence issue.",e);
        } catch (RuntimeException e){
            throw new UnexpectedException("User was not updated due to unexpected exception", e);
        }
    }

    @Override
    public void deleteUserById(Long id) {
        Optional<User> user = userRepository.findById(id)
                .flatMap(userDAO -> Optional.ofNullable(userMapper.userDAOToUser(userDAO)));
        if(user.isEmpty()){
            log.warn("User with ID {} doesn't exist. Deletion has failed.", id);
            throw new InvalidIdException("User with ID provided doesn't exist. ID: "+ id);
        }

        user.get().getQuizResultIds().forEach(quizResultService::deleteQuizResultById);
        log.info("All User's related quizResults have been deleted");

        user.get().getQuizIds().forEach(quizService::deleteQuizById);
        log.info("All User's related quizzes have been deleted");

        userRepository.deleteById(id);
        log.info("User's related leaderboard has been deleted.");
        log.info("User by ID: {} has been deleted",id);
    }

}
