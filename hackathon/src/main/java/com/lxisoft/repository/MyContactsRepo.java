package com.lxisoft.repository;
import com.lxisoft.data.MyContacts;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MyContactRepo extends JpaRepository<MyContacts, Long> {

}


