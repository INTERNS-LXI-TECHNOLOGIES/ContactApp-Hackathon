package com.lxisoft.contactapp.repository;

import com.lxisoft.contactapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface UserRepository extends JpaRepository<User, Long> {
}
