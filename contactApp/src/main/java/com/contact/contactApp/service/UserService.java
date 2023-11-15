package com.contact.contactApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.contact.contactApp.exception.DuplicateEmailException;
import com.contact.contactApp.exception.DuplicatePhoneNumberException;
import com.contact.contactApp.exception.ValidationException;
import com.contact.contactApp.model.UserDTO;
import com.contact.contactApp.model.UserDomain;
import com.contact.contactApp.repo.UserDomainRepo;
import com.contact.contactApp.repo.UserInfoRepo;
import com.contact.contactApp.validation.UserValidator;
@Service
public class UserService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserDomainRepo userDomainRepo;
    @Autowired
    UserInfoRepo userInfoRepo;
    @Autowired
    private UserValidator userValidator;

    public UserDomain createUser(UserDomain user){
         Errors errors = new BeanPropertyBindingResult(user, "user");
        userValidator.validate(user, errors);

        if (errors.hasErrors()) {
            throw new ValidationException(errors.getAllErrors());
        }
        if(userDomainRepo.existsByemail(user.getEmail())){
            throw new DuplicateEmailException("Email already exists");
        }if(userDomainRepo.existsByPhoneNumber(user.getPhoneNumber())){
            throw new DuplicatePhoneNumberException("Phone number Already Registered");
        }
        
        //userInfoRepo.save(user.getUserInfo());
        user.getUserInfo().setPassword(passwordEncoder.encode(user.getUserInfo().getPassword()));
       
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
