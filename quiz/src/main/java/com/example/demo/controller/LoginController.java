package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){
        return "plain-login";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "access-denied";
    }

    @GetMapping("/signup")
    public String signUp(Model model){
        User user=new User();
        model.addAttribute("adduser",user);
        return "signUp";
    }

    @PostMapping("/addUser")
    public String addUser(@Valid @ModelAttribute("adduser") User user, BindingResult theBindingResult){
        String user1=userService.findUserName(user.getName());
        if(user1==null){
            if(theBindingResult.hasErrors())
                return "signUp";
            else {
                userService.createUser(user);
                return "user-confirmed";
            }
        }
        else {
            return "signUp";
        }
    }

}
