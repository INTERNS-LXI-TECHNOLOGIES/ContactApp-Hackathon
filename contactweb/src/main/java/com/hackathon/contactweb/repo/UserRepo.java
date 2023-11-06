package com.hackathon.contactweb.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import  com.hackathon.contactweb.model.*;


public interface UserRepo extends JpaRepository<User,Long> {

    Optional<User> findByUserName(String username);


    
}
