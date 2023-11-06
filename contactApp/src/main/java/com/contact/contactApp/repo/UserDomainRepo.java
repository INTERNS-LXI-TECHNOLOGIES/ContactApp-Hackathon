package com.contact.contactApp.repo;

import org.springframework.data.repository.CrudRepository;

import com.contact.contactApp.model.UserDomain;
public interface UserDomainRepo extends CrudRepository<UserDomain,Long>{
    
}
