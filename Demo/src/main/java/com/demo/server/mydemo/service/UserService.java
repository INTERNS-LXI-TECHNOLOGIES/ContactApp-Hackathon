package com.demo.server.mydemo.service;

public class DomainUserService {

  private DomainRepo dRepo;

    public DomainUser createUser(DomainUser userInfo) {

        userInfo.setUserName(userInfo.getUserName());
        
        return dRepo.save(userInfo);
    }
    
}
