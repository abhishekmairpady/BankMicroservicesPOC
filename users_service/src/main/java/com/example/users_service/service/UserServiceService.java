package com.example.users_service.service;

import com.example.users_service.dto.UserDto;
import com.example.users_service.exception.SVBException;
import com.example.users_service.mapper.UserMapper;
import com.example.users_service.repository.UserRepository;
import com.example.users_service.model.User;
import org.mapstruct.control.MappingControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceService {
    List<User> userList= Arrays.asList(new User(1,1,"firstUser","firstName","lastName","abc",123456,"abcd"));

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User adduser(UserDto user) {
        User userEntity= UserMapper.MAPPER.covertToEntity(user);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return  userRepository.save(userEntity);
    }

    public List<User> addusers(List<UserDto> userList) {
        List<User> updatedUserList= new ArrayList<>();
        userList.forEach(x-> {
            User user= UserMapper.MAPPER.covertToEntity(x);
            user.setPassword(passwordEncoder.encode(x.getPassword()));
            updatedUserList.add(user);
        });
//        User userEntity= UserMapper.MAPPER.covertToEntity(user);
//        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return  userRepository.saveAll(updatedUserList);
    }


    public List<User> getUsers() throws SVBException {
        List<User> allUsers= new ArrayList<>();
        userRepository.findAll().forEach(allUsers::add);
        return allUsers;
    }

    public User getUser(int userId) throws SVBException {
        Optional<User> optional = userRepository.findById(userId);
        User user= optional.orElseThrow(() -> new SVBException("Service.USER_NOT_FOUND"));
        return user;
    }

    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

    public List<User> getUsersByClientId(int clientId) throws SVBException {
        Optional<List<User>> optional= userRepository.findByClientId(clientId);
        List<User> allUsers=optional.orElseThrow(() -> new SVBException("Service.USER_NOT_FOUND"));
        return allUsers;
    }

}
