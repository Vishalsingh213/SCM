package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller // This annotation is used to handle the request Whcih are coming from the UI or https.
public class PageController {
    
    @RequestMapping(value = "/home")        // Annotation is used to map the web request with specific method or class.If multiple @RequestMapping annotations are detected on the same element, a warning will be logged, and only the first mapping will be used. This also applies to composed @RequestMapping annotations such as @GetMapping, @PostMapping, etc.When applied to a class, it defines a base URL for all the handler methods in that class. This is useful for grouping related requests.
    public String home(Model model)
    {
        System.out.println("this is home page");
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
}
