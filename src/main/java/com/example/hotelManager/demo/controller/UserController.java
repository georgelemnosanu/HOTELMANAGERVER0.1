package com.example.hotelManager.demo.controller;

import com.example.hotelManager.demo.exception.UserAlreadyExistsException;
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

    @Autowired
    UserRepository userRepository;



      @GetMapping("/createUser")
      public String createUser(Model model) {
          model.addAttribute("roles",roleRepository.findAll());
          model.addAttribute("user",new User());
          return "user/createUser";
      }


//    @PostMapping(value="/submitUser")
//    public String createUser(@ModelAttribute("user") User user,
//                             @RequestParam("role") String role, Model model) {
//
//        Role userRole = roleService.findByName(role);
//        user.setRoles(Collections.singleton(userRole));
//        userService.saveUser(user);
//        return "redirect:/userCreated";
//    }

//    @PostMapping(value="/submitUser")
//    public String createUser(@RequestParam("username") String username,
//                             @RequestParam("password") String password,
//                             @RequestParam("role") String role) {
//          userService.createUser(username,password,role);
//        return "redirect:/userCreated";
//    }

//    @PostMapping(value="/submitUser")
//    public String createUser(@RequestParam("username") String userName,
//                             @RequestParam("password") String password,
//                             @RequestParam("role") String role,Model model) {
//        if(userService.existsByUserName(userName)){
//            model.addAttribute("error","User already exist");
//            return "redirect:/error";
//        }
//        userService.createUser(userName,password,role);
//        return "redirect:/userCreated";
//    }

    @PostMapping(value="/submitUser")
    public String createUser(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             @RequestParam("role") String role,
                             Model model) {
        try{
            userService.createUser(username,password,role);
        } catch(UserAlreadyExistsException e) {
            model.addAttribute("errorMessage", "A user with this username already exists");
            return "redirect:/error";
        }
        return "redirect:/userCreated";
    }


    @GetMapping("/editUser")
    public String getAllUser(Model model){
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("roles",roleRepository.findAll());
        return "/user/editUser";
    }


    @GetMapping("/edit/{id}")
    public String getEditUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("roles", roleRepository.findAll());
        return "user/edit";
    }

//    @PostMapping("/edit")
//    public String postEditUser(@RequestParam("id") Long id,
//                               @RequestParam("username") String username,
//                               @RequestParam("password") String password,
//                               @RequestParam("role") String role) {
//        userService.updateUser(id, username, password, role);
//        return "redirect:/userCreated";
//    }


    @PostMapping("/edit")
    public String postEditUser(@RequestParam("id") Long id,
                               @RequestParam("username") String username,
                               @RequestParam("password") String password,
              Model model) throws UserAlreadyExistsException {
        try{
            userService.updateUser(id, username, password);
        } catch(UserAlreadyExistsException e) {
            model.addAttribute("errorMessage", "A user with this username already exists");
            return "redirect:/error";
        }
//        userService.updateUser(id, username, password);
        return "redirect:/mvc/user/editUser";
    }


//    @GetMapping("/delete/{id}")
//    public String deleteUser(@PathVariable("id") Long id) {
//        userService.deleteUser(id);
//        return "redirect:/mvc/user/editUser";
//    }



}
