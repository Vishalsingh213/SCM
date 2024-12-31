package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class UserController {

    // user dashboard page
    @RequestMapping(value = "/dashboard")
    public String userDashboard() {
        return "user/dashboard";
    }

    @RequestMapping(value = "/profile")
    public String userProfile() {
        return "user/profile";
    }
    // user add contacts page 
    // @RequestMapping(value = "/dashboard")
    // public String requestMethodName() {
    //     return "user/dashboard";
    // }

    // user view contacts
    // user edit contacts
    // user delete contact
    // user delete contact
    // user search contact
}
