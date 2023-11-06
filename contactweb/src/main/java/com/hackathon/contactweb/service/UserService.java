package com.hackathon.contactweb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import  com.hackathon.contactweb.model.*;
import com.hackathon.contactweb.repo.UserRepo;
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
    public User createContact(User userInfo) {

        userInfo.setPassWord(passwordencoder.encode(userInfo.getPassWord()));
        
        return userInfoRepository.save(userInfo);
    }

    // Read operation (Retrieve all users)
    public List<User> getAllContacts() {
        return userInfoRepository.findAll();
    }

    // Read operation (Retrieve a user by ID)
    public Optional<User> getContactById (Long userId) {
        return userInfoRepository.findById(userId);
    }

    // Update operation
    public User updateContact(User userInfo) {
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
    public void deleteContact(Long userId) {
        userInfoRepository.deleteById(userId);
    }
}
