package com.github.lrssmeiksts.qwiz.business.service.impl;

import com.github.lrssmeiksts.qwiz.business.mappers.UserMapper;
import com.github.lrssmeiksts.qwiz.business.repository.UserRepository;
import com.github.lrssmeiksts.qwiz.business.service.UserService;
import com.github.lrssmeiksts.qwiz.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl (UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Optional<User> getUserByid(Long id) {
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
}
