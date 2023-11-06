package com.lxisoft.contactapp.contactapplication.controller;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.access.prepost.PreAuthorize;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import  com.lxisoft.contactapp.contactapplication.model.*;
import com.lxisoft.contactapp.contactapplication.service.DomainUserService;
import com.lxisoft.contactapp.contactapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/users")
// @OpenAPIDefinition(info = @Info(title = "User API", version = "1.0",
// description = "API for managing users"))
public class UserController {
    @Autowired
    private UserService userService;

    // @Autowired
    // private DomainUserService dservice;
    // @GetMapping("/welcome")
    // @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    // public ResponseEntity<String> welcome() {
    // return new ResponseEntity<>("Welcome home - this endpoint is not secure",
    // HttpStatus.OK);
    // }

    // Create user
    @GetMapping("/ok")
    @PreAuthorize("hasRole(ROLE_ADMIN)")
   public String oklo(){
    return "loginok" ;
   }
    
    // @PostMapping("/adduser")
    // public String createUser(@RequestBody User userInfo) {
    //     System.out.println(" inside the adduser");
    //     userService.createUser(userInfo);
        

    //     // DomainUser duser= new DomainUser();
    //     // duser.setUserName(userinfo.)
        



    //     return "hello";


    // }
    
}
