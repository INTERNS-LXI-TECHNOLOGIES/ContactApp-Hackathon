package com.hackathon.contactweb.controller;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.hackathon.contactweb.model.User;
import com.hackathon.contactweb.model.UserDomain;
import com.hackathon.contactweb.service.UserDomainService;
import com.hackathon.contactweb.service.UserService;
import com.hackathon.contactweb.model.UserDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserDomainService userDomainService;

    @Autowired
    public UserController(UserService userService, UserDomainService userDomainService) {

        this.userService = userService;
        this.userDomainService = userDomainService;

    }

    // Create Operation: Create a new user
    @PostMapping("/createcontact")
    @PreAuthorize("hasRole(ROLE_ADMIN)")
    public String createUser(@RequestBody User user) {
        userService.createContact(user);
        UserDomain userD=user.getUserDomain();
        userDomainService.createUserDomain(userD);
        return "creationsucess";
    }

    // Read Operation: Retrieve all users
    // Read Operation: Retrieve all users with UserDomain details
    @GetMapping("/getallcontact")
    public List<UserDTO> getAllUsers() {
        List<User> users = userService.getAllContacts();
        return users.stream()
                .map(user -> {
                    UserDomain domain = user.getUserDomain();
                        UserDTO userDTO = new UserDTO();
                    if (domain != null) {
                        userDTO.setDomainUserName(domain.getUserName());
                        userDTO.setDomainUserPhoneNumber(domain.getPhoneNumber());
                        userDTO.setDomainUserEmailAddress(domain.getEmailAddress());
                    }
                    return userDTO;
                })
                .collect(Collectors.toList());
    }

    // // commented bacause this requirement is not provided in the readme
    // @GetMapping("/{userId}")
    // public ResponseEntity<User> getUserById(@PathVariable Long userId) {
    // Optional<User> user = userService.getContactById(userId);
    // return user.map(ResponseEntity::ok).orElseGet(() ->
    // ResponseEntity.notFound().build());
    // }

    // Update Operation: Update an existing user
    // Update Operation: Update an existing user
    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateContact(user);
        return "redirect:/users/all"; // Redirect to the "all" view
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteContact(userId);
    }
}
