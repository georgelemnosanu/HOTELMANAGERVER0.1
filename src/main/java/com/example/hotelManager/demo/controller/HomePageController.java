package com.example.hotelManager.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
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

    @GetMapping("/userError")
    public String userError(){
            return "userError";
    }


    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/default")
    public String succesPage(HttpServletRequest request){
        if(request.isUserInRole("ADMIN")){
            return "redirect:/";
        }
        else
            return "redirect:/indexUser";
    }

    @GetMapping("/indexUser")
    public String userHome(){
            return "indexUser";
    }

    @GetMapping("/userDeleteConfirm")
    public String deleteUserConfirmation(){
            return "userDeleteConfirm";
    }




}
