package com.hackathon.contactweb.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.hackathon.contactweb.model.UserDomain;

public interface UserDomainRepo extends JpaRepository<UserDomain, Long> {


}

