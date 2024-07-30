package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {
   
    @RequestMapping("/home")
    public String home(){
        System.out.println("home page");
         return "home";
    }

    @RequestMapping("/about")
    public String aboutPage(){
        System.out.println("about page");
         return "about";
    }

    @RequestMapping("/service")
    public String servicesPage(){
        System.out.println("services page");
         return "services";
    }

    @GetMapping("/contact")
    public String contact() {
        return new String("contact");
    }
    
    @GetMapping("/login")
    public String login() {
        return new String("login");
    }

    @GetMapping("/register")
    public String register() {
        return new String("register");
    }
}
