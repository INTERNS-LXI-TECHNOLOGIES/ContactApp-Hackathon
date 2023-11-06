package com.demo.server.mydemo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import  com.demo.server.mydemo.model.*;


public interface UserRepo extends JpaRepository<User,Long> {

    Optional<User> findByUserName(String username);


    
}
