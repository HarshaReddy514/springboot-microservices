package com.practice.sbm.service;

import com.practice.sbm.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUserById(Long userId);

    List<User> getUsers();

    User updateUser(User user);

    void deleteUser(Long id);
}
