package com.lxisoft.contactapp.contactapplication.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import  com.lxisoft.contactapp.contactapplication.model.*;;


public interface UserRepo extends JpaRepository<User,Long> {

    Optional<User> findByUserName(String username);


    
}
