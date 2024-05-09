package com.practice.sbm.service.impl;

import com.practice.sbm.dto.UserDTO;
import com.practice.sbm.entity.User;
import com.practice.sbm.exception.EmailAlreadyExistsException;
import com.practice.sbm.exception.ResourceNotFoundException;
import com.practice.sbm.repository.UserRepository;
import com.practice.sbm.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        //convert UserDTO into User JPA Entity
        //User user = UserMapper.mapToUser(userDTO);
        Optional<User> optionalUser = userRepository.findByEmail(userDTO.getEmail());

        if(optionalUser.isPresent()){
            throw new EmailAlreadyExistsException("Email already exists");
        }

        User user = modelMapper.map(userDTO, User.class);

        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId)
        );
        // add isPresent check and throw user not found exception
        //UserDTO userDTO = UserMapper.mapToUserDTO(optionalUser.get());
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(UserDTO user){
        //Add isPresent check and throw user not found exception
        User existingUser = userRepository.findById(user.getId()).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", user.getId())
        );
        existingUser.setFirst_name(user.getFirst_name());
        existingUser.setLast_name(user.getLast_name());
        existingUser.setEmail(user.getEmail());
        return modelMapper.map(userRepository.save(existingUser), UserDTO.class);
    }

    @Override
    public void deleteUser(Long id) {
        User existingUser = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );

        userRepository.deleteById(id);
    }

}
