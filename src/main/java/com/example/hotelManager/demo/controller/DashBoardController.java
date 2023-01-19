package com.example.hotelManager.demo.controller;

import com.example.hotelManager.demo.repository.RoleRepository;
import com.example.hotelManager.demo.service.RoleService;
import com.example.hotelManager.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mvc/dashboard")
public class DashBoardController {

    @Autowired
    UserService userService;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RoleService roleService;


    @GetMapping("/editUser")
    public String getAllUser(Model model){
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("roles",roleRepository.findAll());
        return "/dashboard/editUser";
    }


    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/mvc/user/dashboard";
    }


}
