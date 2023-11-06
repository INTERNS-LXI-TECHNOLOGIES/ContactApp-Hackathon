package com.contact.contactApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.contact.contactApp.model.UserDomain;
import com.contact.contactApp.repo.UserDomainRepo;
@Service
public class UserService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserDomainRepo userDomainRepo;

    public UserDomain createUser(UserDomain user){
        user.getUserInfo().setPassWord(passwordEncoder.encode(user.getUserInfo().getPassword()));
        return userDomainRepo.save(user);
    }
}
