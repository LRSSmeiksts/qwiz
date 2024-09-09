package com.github.lrssmeiksts.qwiz.business.service.impl;

import com.github.lrssmeiksts.qwiz.business.handlers.UnexpectedException;
import com.github.lrssmeiksts.qwiz.business.handlers.UserDatabaseException;
import com.github.lrssmeiksts.qwiz.business.mappers.UserMapper;
import com.github.lrssmeiksts.qwiz.business.repository.LeaderboardRepository;
import com.github.lrssmeiksts.qwiz.business.repository.UserRepository;
import com.github.lrssmeiksts.qwiz.business.repository.model.LeaderboardDAO;
import com.github.lrssmeiksts.qwiz.business.repository.model.UserDAO;
import com.github.lrssmeiksts.qwiz.business.service.UserService;
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
    private final LeaderboardRepository leaderboardRepository;

    @Autowired
    public UserServiceImpl (UserRepository userRepository, UserMapper userMapper, LeaderboardRepository leaderboardRepository){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.leaderboardRepository = leaderboardRepository;
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
            LeaderboardDAO userLeaderboardDAO = new LeaderboardDAO();
            userLeaderboardDAO.setTotalScore(0);
            userLeaderboardDAO.setQuizzesGuessed(0);
            leaderboardRepository.save(userLeaderboardDAO);
            log.debug("New leaderboard entry was created with ID: {}", userLeaderboardDAO.getId());

            UserDAO userDAO = userMapper.userToUserDAO(user);
            userDAO.setLeaderboardId(userLeaderboardDAO);
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
}
