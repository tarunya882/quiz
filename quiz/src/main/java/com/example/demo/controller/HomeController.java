
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView home(){
        return new ModelAndView("homepage");
    }

    @GetMapping("/user")
    public ModelAndView user(){
        return new ModelAndView("user");
    }

    @GetMapping("/admin")
    public ModelAndView admin(){
        return new ModelAndView("admin");
    }

}


