package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helper.Message;
import com.scm.helper.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    public String index(){
        return "redirect:/home";

    }
   
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
    public String register(org.springframework.ui.Model model) {
        UserForm userForm=new UserForm();
        model.addAttribute("userForm",userForm);

        return new String("register");
    }
    @RequestMapping(value="/do-register",method=RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm,BindingResult rBindingResult, HttpSession session){
        System.out.println(userForm);

        if(rBindingResult.hasErrors()){
            return "register";
        }

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        

        
        userService.saveUser(user);
        System.out.println("user save");

        Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();
        session.setAttribute("message",message);


        return "redirect:/register";
    }
}
