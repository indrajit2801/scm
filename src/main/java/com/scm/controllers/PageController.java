package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.services.UserService;

@Controller
public class PageController {

    @Autowired
    private UserService userService;
   
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
    public String processRegister(@ModelAttribute UserForm userForm){
        System.out.println(userForm);

        // userService
        // userForm --> user
        User user = User.builder()
        .name(userForm.getName())
        .email(userForm.getEmail())
        .password(userForm.getPassword())
        .about(userForm.getAbout())
        .phoneNumber(userForm.getPhoneNumber())
        .profilePic("data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBwgHBgkIBwgKCgkLDRYPDQwMDRsUFRAWIB0iIiAdHx8kKDQsJCYxJx8fLT0tMTU3Ojo6Iys/RD84QzQ5OjcBCgoKDQwNGg8PGjclHyU3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3N//AABEIAJQApgMBIgACEQEDEQH/xAAbAAEAAwEBAQEAAAAAAAAAAAAABQYHBAIDAf/EADkQAAICAQICBgcFCAMAAAAAAAABAgMEBREGURIhMUFxwRMiYYGRobFCUmLR4RQzU2NykpOyIyQy/8QAFgEBAQEAAAAAAAAAAAAAAAAAAAEC/8QAFhEBAQEAAAAAAAAAAAAAAAAAAAER/9oADAMBAAIRAxEAPwDUgAaZAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHi62uiuVl04whHtlJ7JFezeMMSqThiUzva+230Ivz+QFkBTY8aX9L1sGvb2WPf6Evp3FGBmyVdjljWPsVm3RfvXmBNgbcusAAAAAAAAAAAAAAAAAAAAPnkX1Y1Fl181CuEd5SfI+hUOOM+XSq0+D2W3pLOv+1eYELrWsX6pfvJuFEX/wAdS7F7XzZGgFQAAFk4Y16ePZDDzbHKiT2rsk+ut+PL6F3MkND4Wz5Z+lR9I97aX6Ob58n8PoRUwAAAAAAAAAAAAAAAAAABmvENrt1vMk/4jS8F1eRpRmevQ6Gs5sf50gOAAGkAAALRwHY45mVV3TrUtvan+pVyzcCR31DIn92rzRlV1AAAAAAAAAAAAAAAAAAAofGmK6NY9Kl6l8FLf2r1X9EXwjOINLWq4EqotK6D6VbfPl4MDNwe7a502Srti4Tg9pRkutM8FQAAULrwLjOvCvypLrtmox8I/q2VXS9Ou1LKjj0L+ue3VBc2aXi0V4mPXRStq64qKRB9QAAAAAAAAAAAAAAAAAAAAEdqujYepx3vratS2jbDql7+fvK5k8G5Kk/2bKqnHlYnF/LdFxutqoj077IVx5zkor5kdbxDpVT2lmQk/wACcvogqrrhHU29m8dLn6T9Duw+DZb9LMyk192mPb73+RKrijSW9vTy/wAcjpo1zTL3tXm1b8pvov5hHRhYWNgUKnEqVcO182+bfedB+RakulFpxfY11p+8/QoAAgAAAAAAAAAAAAAAEdrWrU6TjKdnr2z/AHdaf/r2+AHRn5uNgUO3KtUId3OXgu8qOpcW5N7lDBj+z19im+ub8kQedm5GfkSvyrHOb7F3RXJLuRzge7rbb5ud1krJPvm9zwAXEA+wAYOjDzcrCn0sXInV7Ivqfu7Cz6XxdGTVWp1qHK6HZ71+RUACNZrshbWrK5KcJLdST3TPRnGia3kaVdsm7MeT9epv5rkzQcTJpzMaGRjzUq5rdPyIr7AAAAAAAAAAAAAOfOy6sHEtyb36lcd9u9+zxZmuo512oZc8nIfrSeyS7Irkid421B25UMCt+pSulPbvk1uvgisgAAVKAAoAAAAABMcNaxLTMtV2v/q3NKf4X95eZDjt6iVY1vdPrXWgQPB+oPM050WPe3H2i3zi+zzRPEAAAAAAAAA82TjXXKyfZBOT8EeiN4itdOh5s11N19FPxe3mBneTfLJyLb5veVk3L4nyALEoACgAAAAAAAAACUiZ4SynjazXFvaFydbX0+aNCMpxbXRlU2r7FkZfBmrEUAAAAAAAAIbi97aBkbd7h/sgAM9ABYgACgAAAAAAAAAAPyXYzWoddcX7EASkegARQAAf/9k=")
        .build();
        userService.saveUser(user);
        System.out.println("user save");

        return "redirect:/register";
    }
}
