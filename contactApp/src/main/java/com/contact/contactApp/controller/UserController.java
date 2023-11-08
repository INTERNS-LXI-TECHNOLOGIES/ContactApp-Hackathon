package com.contact.contactApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

import com.contact.contactApp.model.UserDTO;
import com.contact.contactApp.model.UserDomain;
import com.contact.contactApp.service.UserService;

@Controller
@RequestMapping("/contactapp")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/signup")
    @ResponseBody
    public UserDomain createUser(@RequestBody UserDomain user){
        return userService.createUser(user);
    }

    @GetMapping("hello")
    @ResponseBody
    public String getHello(){
        return "Hello world";
    }
    @GetMapping("/contact/{username}")
    @ResponseBody
    public List<UserDTO> getContactByName(@PathVariable String username){
        return userService.getUserContact(username);
    }
    @GetMapping("/contact/all")
    @ResponseBody
    public List<UserDTO> getAllContact(){
        return userService.getAllContact();
    }
}
