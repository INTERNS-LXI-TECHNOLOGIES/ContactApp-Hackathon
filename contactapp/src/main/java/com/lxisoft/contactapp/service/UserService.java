package com.lxisoft.contactapp.service;

import com.lxisoft.contactapp.model.User;
import com.lxisoft.contactapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    @Autowired
    PasswordEncoder passwordencoder;

    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create operation
    public User createUser(User userInfo) {

        return userRepository.save(userInfo);
    }

    // Read operation (Retrieve all users)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Read operation (Retrieve a user by ID)
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    // Update operation
    public User updateUser(User userInfo) {
        // Check if the user exists before updating
        Optional<User> existingUserInfo = userRepository.findById(userInfo.getId());
        if (existingUserInfo.isPresent()) {
            // Update the existing user
            User updatedUserInfo = existingUserInfo.get();
            updatedUserInfo.setContactName(userInfo.getContactName());
            return userRepository.save(updatedUserInfo);
        } else {
            // Create a new user if the user does not exist
            return userRepository.save(userInfo);
        }
    }

    // Delete operation
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
