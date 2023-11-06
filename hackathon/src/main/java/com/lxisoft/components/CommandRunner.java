package com.lxisoft.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.lxisoft.data.MyContacts;
import com.lxisoft.services.MyContactService;
@Component
public class CommandRunner implements CommandLineRunner {
    @Autowired
    private MyContactService MyContactsService;

    @Override
    public void run(String... args) throws Exception {
        MyContact myContact= new MyContact();
        MyContact.setName("Nimmy");
        MyContactService.saveContact(myContact);
        MyContact.setPhoneNumber("7736282172");
        MyContactService.saveContact(myContact);
        MyContact.setEmail("nimmyjosephvtj@gmail.com");
        MyContactService.saveContact(myContact);
    }
}


