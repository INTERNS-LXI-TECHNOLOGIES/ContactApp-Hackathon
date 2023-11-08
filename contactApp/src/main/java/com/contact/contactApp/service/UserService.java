package com.contact.contactApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.contact.contactApp.model.UserDTO;
import com.contact.contactApp.model.UserDomain;
import com.contact.contactApp.repo.UserDomainRepo;
import com.contact.contactApp.repo.UserInfoRepo;
@Service
public class UserService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserDomainRepo userDomainRepo;
    @Autowired
    UserInfoRepo userInfoRepo;

    public UserDomain createUser(UserDomain user){
        //userInfoRepo.save(user.getUserInfo());
        user.getUserInfo().setPassWord(passwordEncoder.encode(user.getUserInfo().getPassword()));
        return userDomainRepo.save(user);
    }

    public List<UserDTO> getUserContact(String username){
        // Iterable<UserDomain> userIterable = userDomainRepo.findAll();
        // List<UserDomain> userList = StreamSupport.stream(userIterable.spliterator(), false)
        //                             .collect(Collectors.toList());
        //     return userList;

        List<UserDomain> userList = userDomainRepo.findByName(username);

        List<UserDTO> userDTOs = userList.stream()
                        .map(UserDomain::getUserDTO)
                        .collect(Collectors.toList());

            return userDTOs;


       
    }

    public List<UserDTO> getAllContact(){
        Iterable<UserDomain> userIterable = userDomainRepo.findAll();
        List<UserDTO> userList = StreamSupport.stream(userIterable.spliterator(), false)
                                 .map(UserDomain::getUserDTO)
                                    .collect(Collectors.toList());

          return userList;
    }
}
