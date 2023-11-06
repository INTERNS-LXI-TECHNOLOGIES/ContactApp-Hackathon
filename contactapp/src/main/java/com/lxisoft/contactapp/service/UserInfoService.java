package com.lxisoft.contactapp.service;

import com.lxisoft.contactapp.model.User;
import com.lxisoft.contactapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserInfoService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userInfo = userRepository.findByUserName(username);


        if (!userInfo.isPresent()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        //return new UserInfoUserDetails(userInfo.get());
        return null;
    }
}
