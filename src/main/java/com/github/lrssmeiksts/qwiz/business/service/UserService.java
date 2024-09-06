package com.github.lrssmeiksts.qwiz.business.service;

import com.github.lrssmeiksts.qwiz.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(Long id);

    List<User> getAllUsers();
}
