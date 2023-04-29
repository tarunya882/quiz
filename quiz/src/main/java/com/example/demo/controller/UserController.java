package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    UserService userService;



    @GetMapping("/users")
    public ModelAndView getAllUsers(Model model){
        model.addAttribute("users",userService.getAllUsers());
        return new ModelAndView("users");
    }

}




