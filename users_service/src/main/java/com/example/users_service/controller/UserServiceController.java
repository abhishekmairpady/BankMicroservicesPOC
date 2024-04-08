package com.example.users_service.controller;

import com.example.users_service.dto.UserDto;
import com.example.users_service.exception.SVBException;
import com.example.users_service.model.User;
import com.example.users_service.service.UserServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/userService")
public class UserServiceController {

    @Autowired
    UserServiceService userServiceService;

    @PostMapping("/addUser")
    public ResponseEntity<User> adduser(@RequestBody UserDto user){
        return new ResponseEntity<>(userServiceService.adduser(user),HttpStatus.OK);
    }

    @PostMapping("/addUsers")
    public ResponseEntity<List<User>> adduser(@RequestBody List<UserDto> userList){
//        List<User> addedUserList= new ArrayList<>();
//        userList.forEach(x-> {
//            User addedUser=userServiceService.adduser(x);
//            addedUserList.add(addedUser);
//        });
        return new ResponseEntity<>(userServiceService.addusers(userList),HttpStatus.OK);
    }


    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUsers() throws SVBException {
        return new ResponseEntity<>(userServiceService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/getUser/{userId}")
    public ResponseEntity<User> getUser(@PathVariable int userId) throws SVBException {
        return new ResponseEntity<>(userServiceService.getUser(userId),HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable int userId){
        userServiceService.deleteUser(userId);
        return new ResponseEntity<>("Deleted Users ",HttpStatus.OK);
    }

    @GetMapping("/getClientAndUserDetails/{clientId}")
    public List<User> getUsersByClientId(@PathVariable int clientId) throws SVBException {
        return  userServiceService.getUsersByClientId(clientId);
    }

}
