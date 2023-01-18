package com.example.hotelManager.demo.controller;

import com.example.hotelManager.demo.repository.RoleRepository;
import com.example.hotelManager.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mvc/dashboard")
public class DashBoardController {

    @Autowired
    UserService userService;

    @Autowired
    RoleRepository roleRepository;


    @GetMapping("/editUser")
    public String getAllUser(Model model){
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("roles",roleRepository.findAll());
        return "/dashboard/editUser";
    }


}
