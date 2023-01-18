package com.example.hotelManager.demo.controller;

import com.example.hotelManager.demo.model.Role;
import com.example.hotelManager.demo.model.TaskList;
import com.example.hotelManager.demo.model.User;
import com.example.hotelManager.demo.repository.RoleRepository;
import com.example.hotelManager.demo.repository.UserRepository;
import com.example.hotelManager.demo.service.RoleService;
import com.example.hotelManager.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;

@RequestMapping("/mvc/user")
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    RoleRepository roleRepository;






      @GetMapping("/createUser")
      public String createTaskList(Model model) {
          model.addAttribute("roles",roleRepository.findAll());
          model.addAttribute("user",new User());
          return "user/createUser";
      }


    @PostMapping(value="/submitUser")
    public String createUser(@ModelAttribute("user") User user,
                             @RequestParam("role") String role, Model model) {

        Role userRole = roleService.findByName(role);
        user.setRoles(Collections.singleton(userRole));
        userService.saveUser(user);
        return "redirect:/userCreated";
    }



}
