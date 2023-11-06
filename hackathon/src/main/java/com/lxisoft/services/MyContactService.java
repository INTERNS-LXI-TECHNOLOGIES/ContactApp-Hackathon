package com.lxisoft.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MyContactService {
    private final MyContactRepo myContactRepo;

    @Autowired
    public MyContactService(MyContactRepo myContactRepo) {
        this.myContactRepo = myContactRepo;
    }

    public MyContacts saveContact(MyContacts contact) {
        return myContactRepo.save(contact);
    }

    // Example method to retrieve all contacts
    public List<MyContacts> getAllContacts() {
        return myContactRepo.findAll();
    }
}
