package com.example.hotelManager.demo.service;

import com.example.hotelManager.demo.model.Role;
import com.example.hotelManager.demo.model.User;
import com.example.hotelManager.demo.repository.RoleRepository;
import com.example.hotelManager.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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

    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public void createUser(String username, String password, String roleName) {
        if (userRepository.findByUserName(username) != null) {
            throw new IllegalArgumentException("A user with the username " + username + " already exists.");
        } else {
            User user = new User();
            user.setUserName(username);
            user.setPassword(password);
            Role role = roleRepository.findByName(roleName);
            user.setRoles(Collections.singleton(role));
            userRepository.save(user);
        }
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public void updateUser(Long id, String username, String password) {
        User user = userRepository.findById(id).get();
        user.setUserName(username);
        user.setPassword(password);
//        Role role = roleRepository.findByName(roleName);
//        user.setRoles(Collections.singleton(role));
        userRepository.save(user);
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}