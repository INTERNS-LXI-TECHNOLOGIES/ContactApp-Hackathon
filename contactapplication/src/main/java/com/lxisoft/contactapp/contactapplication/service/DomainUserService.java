package com.lxisoft.contactapp.contactapplication.service;

import com.lxisoft.contactapp.contactapplication.model.DomainUser;
import  com.lxisoft.contactapp.contactapplication.repo.DomainRepo;

public class DomainUserService {

  private DomainRepo dRepo;

    public DomainUser createUser(DomainUser userInfo) {

        userInfo.setUserName(userInfo.getUserName());
        
        return dRepo.save(userInfo);
    }
    
}
