package com.hackathon.contactweb.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import  com.hackathon.contactweb.model.*;
import com.hackathon.contactweb.repo.UserRepo;

@Component
public class UserInfoUserDetailService implements UserDetailsService {
    @Autowired
    UserRepo userInfoRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userInfo = userInfoRepo.findByUserName(username);
        

        if (!userInfo.isPresent()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    
        return new UserInfoUserDetails(userInfo.get());
    }

     
    }
    


    

