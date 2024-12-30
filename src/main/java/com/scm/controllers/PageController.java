package com.scm.controllers;

import javax.naming.Binding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.entities.User;
import com.scm.entities.User.UserBuilder;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;



@Controller
public class PageController {
    
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/home")        // Annotation is used to map the web request with specific method or class.If multiple @RequestMapping annotations are detected on the same element, a warning will be logged, and only the first mapping will be used. This also applies to composed @RequestMapping annotations such as @GetMapping, @PostMapping, etc.When applied to a class, it defines a base URL for all the handler methods in that class. This is useful for grouping related requests.
    public String home(Model model)
    {
        // System.out.println("this is home page");
        model.addAttribute("name","vishal");
        model.addAttribute("youtube channel", "leet code");
        model.addAttribute("GitHub", "vishal21397");
        return "home";
    }


    //about route
    @RequestMapping("/about")
    public String aboutPage()
    {
        return "about";
    }
    //about services
    @RequestMapping("/services")
    public String servicesPage()
    {
        return "services";
    }

    @RequestMapping("/login")
    public String login()
    {
        return new String("login");
    }

    @RequestMapping("/register")
    public String signup()
    {
        return new String("register");
    }
    @RequestMapping("/contact")
    public String contact()
    {
        return new String("contact");
    }

    @GetMapping(value = "/register")
    public String register(Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        return "register";
    }
    
// processing register

    @RequestMapping(value = "/do-register", method=RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm ,BindingResult rBindingResult, HttpSession session) {   
        
        if(rBindingResult.hasErrors())
        {
            return "register";
        }
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        User savedUser = userService.saveUser(user);
        Message message = Message.builder().content("Registration Successful").type(MessageType.green).build(); 
        session.setAttribute("message",message);
        return "redirect:/register";
    }    
}
