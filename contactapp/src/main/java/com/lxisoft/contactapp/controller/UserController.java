package com.lxisoft.contactapp.controller;

import com.lxisoft.contactapp.model.User;
import com.lxisoft.contactapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/contactapp")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        userRepository.save(user);

        return "index";
    }

    @GetMapping("/contacts")
    public String listUsers(Model model) {
        List<User> listContacts = userRepository.findAll();
        model.addAttribute("listContacts", listContacts);

        return "contacts";
    }
}