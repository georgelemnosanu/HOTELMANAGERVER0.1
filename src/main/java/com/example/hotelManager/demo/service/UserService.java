package com.example.hotelManager.demo.service;

import com.example.hotelManager.demo.model.Role;
import com.example.hotelManager.demo.model.User;
import com.example.hotelManager.demo.repository.RoleRepository;
import com.example.hotelManager.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


    public User createUser(String userName, String password, String roleName) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        Role role = roleRepository.findByName(roleName);
        user.addRole(role);
        userRepository.save(user);
        return user;
    }
}