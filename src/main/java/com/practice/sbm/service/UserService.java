package com.practice.sbm.service;

import com.practice.sbm.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO user);

    UserDTO getUserById(Long userId);

    List<UserDTO> getUsers();

    UserDTO updateUser(UserDTO userDTO);

    void deleteUser(Long id);
}
