package com.example.hotelManager.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomePageController {
        @GetMapping("/")
        public String homePage(Model model){
            model.addAttribute("message","Welcome Hotel Manager v1 ");
            return "index";
        }


    @GetMapping("/userCreated")
    public String create(Model model){
        model.addAttribute("message", "User created successfully!");
        return "userCreated";
    }

}
