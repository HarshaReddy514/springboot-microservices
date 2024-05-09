package com.practice.sbm.mapper;

import com.practice.sbm.dto.UserDTO;
import com.practice.sbm.entity.User;

public class UserMapper {

    //convert user to userDto
    public static UserDTO mapToUserDTO(User user){
        return new UserDTO(user.getId(),
                user.getFirst_name(),
                user.getLast_name(),
                user.getEmail());
    }

    //convert user to userDto
    public static User mapToUser(UserDTO userDTO){
        return new User(userDTO.getId(),
                userDTO.getFirst_name(),
                userDTO.getLast_name(),
                userDTO.getEmail());
    }
}
