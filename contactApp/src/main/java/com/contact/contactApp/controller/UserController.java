package com.contact.contactApp.controller;

//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import com.contact.contactApp.exception.DuplicateEmailException;
import com.contact.contactApp.exception.DuplicatePhoneNumberException;
import com.contact.contactApp.exception.ValidationException;
import com.contact.contactApp.model.UserDomain;
import com.contact.contactApp.model.UserInfo;
import com.contact.contactApp.service.UserService;
//import org.slf4j.Logger;
@Controller
@RequestMapping("/contactapp")
public class UserController {
    @Autowired
    UserService userService;

	//private static final Logger logger = LoggerFactory.getLogger(UserController.class);



    @PostMapping("/signup")
    // @ResponseBody
    public String createUser(@ModelAttribute UserDomain user,Model model){
        String response=null;
        try{
         model.addAttribute("addedUser",userService.createUser(user));
         response="success";
        }catch(DuplicateEmailException e){
          model.addAttribute("erroremail", e.getMessage());
          response= "signup";
        }catch(DuplicatePhoneNumberException e){
            model.addAttribute("errornumber", e.getMessage());
            response="signup";
        }catch(ValidationException e){
            model.addAttribute("errorname", e.getErrors());
            response="signup";
        }
        return response;
    }

    @GetMapping("hello")
    @ResponseBody
    public String getHello(){
        return "Hello world";
    }
    @GetMapping("/contact/{username}")
    // @ResponseBody
    public String getContactByName(@PathVariable String username,Model model){
        model.addAttribute("users", userService.getUserContact(username));
        return "userlist";
    }
    @GetMapping("/contact/all")
    //@ResponseBody
    public String getAllContact(Model model){
        model.addAttribute("allusers",userService.getAllContact());
        return "allusers";
    }
    @GetMapping("/get/signup")
    public String getSignupPage(Model model){
        //UserDomain userDomain = new UserDomain(new UserInfo());
    model.addAttribute("userDomain", UserDomain.builder().userInfo(new UserInfo()).build());

       return "signup";
    }
}
