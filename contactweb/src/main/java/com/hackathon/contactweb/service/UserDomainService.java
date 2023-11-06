package com.hackathon.contactweb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hackathon.contactweb.model.UserDomain;
import com.hackathon.contactweb.repo.UserDomainRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserDomainService {

    private final UserDomainRepo userDomainRepo;

    @Autowired
    public UserDomainService(UserDomainRepo userDomainRepo) {
        this.userDomainRepo = userDomainRepo;
    }

    public UserDomain createUserDomain(UserDomain userDomain) {
        return userDomainRepo.save(userDomain);
    }

    public List<UserDomain> getAllUserDomains() {
        return userDomainRepo.findAll();
    }

    public Optional<UserDomain> getUserDomainById(Long userDomainId) {
        return userDomainRepo.findById(userDomainId);
    }

    public UserDomain updateUserDomain(UserDomain userDomain) {
        Optional<UserDomain> existingUserDomain = userDomainRepo.findById(userDomain.getId());
        if (existingUserDomain.isPresent()) {
            UserDomain updatedUserDomain = existingUserDomain.get();
            updatedUserDomain.setUserName(userDomain.getUserName());
            updatedUserDomain.setPhoneNumber(userDomain.getPhoneNumber());
            updatedUserDomain.setEmailAddress(userDomain.getEmailAddress());
            return userDomainRepo.save(updatedUserDomain);
        } else {
            return userDomainRepo.save(userDomain);
        }
    }

    public void deleteUserDomain(Long userDomainId) {
        userDomainRepo.deleteById(userDomainId);
    }
}

