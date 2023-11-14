package com.contact.contactApp.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.contact.contactApp.model.UserDomain;
public interface UserDomainRepo extends CrudRepository<UserDomain,Long>{
    List<UserDomain> findByName(String userName);
    boolean existsByemail(String email);
    boolean existsByPhoneNumber(String number);
}
