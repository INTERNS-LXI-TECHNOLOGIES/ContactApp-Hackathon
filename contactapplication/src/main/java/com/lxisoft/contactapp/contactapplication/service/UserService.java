package com.lxisoft.contactapp.contactapplication.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import  com.lxisoft.contactapp.contactapplication.model.*;
import com.lxisoft.contactapp.contactapplication.repo.UserRepo;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    PasswordEncoder passwordencoder;

        private final UserRepo userInfoRepository;


    @Autowired
    public UserService(UserRepo userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    // Create operation
    public User createUser(User userInfo) {

        userInfo.setPassWord(passwordencoder.encode(userInfo.getPassWord()));
        
        return userInfoRepository.save(userInfo);
    }

    // Read operation (Retrieve all users)
    public List<User> getAllUsers() {
        return userInfoRepository.findAll();
    }

    // Read operation (Retrieve a user by ID)
    public Optional<User> getUserById(Long userId) {
        return userInfoRepository.findById(userId);
    }

    // Update operation
    public User updateUser(User userInfo) {
        // Check if the user exists before updating
        Optional<User> existingUserInfo = userInfoRepository.findById(userInfo.getId());
        if (existingUserInfo.isPresent()) {
            // Update the existing user
            User updatedUserInfo = existingUserInfo.get();
            updatedUserInfo.setUserName(userInfo.getUserName());
            return userInfoRepository.save(updatedUserInfo);
        } else {
            // Create a new user if the user does not exist
            return userInfoRepository.save(userInfo);
        }
    }

    // Delete operation
    public void deleteUser(Long userId) {
        userInfoRepository.deleteById(userId);
    }
}
