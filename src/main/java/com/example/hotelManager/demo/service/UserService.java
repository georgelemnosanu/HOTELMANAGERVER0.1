package com.example.hotelManager.demo.service;

import com.example.hotelManager.demo.exception.UserAlreadyExistsException;
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
    @Autowired
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

    public void createUser(String userName, String password, String roleName) throws UserAlreadyExistsException {
        if (userRepository.existsByUserName(userName))
            throw new UserAlreadyExistsException("User already exists with username: " + userName);
        {
            if (userRepository.findByUserName(userName) != null) {
                throw new UserAlreadyExistsException("A user with the username " + userName + " already exists.");
            } else {
                User user = new User();
                user.setUserName(userName);
                user.setPassword(password);
                Role role = roleRepository.findByName(roleName);
                user.setRoles(Collections.singleton(role));
                userRepository.save(user);
            }
        }
    }

    public boolean existsByUserName(String userName) {
        return userRepository.existsByUserName(userName);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void updateUser(Long id, String username, String password) throws UserAlreadyExistsException {
        if (userRepository.existsByUserName(username))
            throw new UserAlreadyExistsException("User already exists with username: " + username);
        {
            if (userRepository.findByUserName(username) != null) {
                throw new UserAlreadyExistsException("A user with the username " + username + " already exists.");
            } else {
                User user = userRepository.findById(id).get();
                user.setUserName(username);
                user.setPassword(password);
//        Role role = roleRepository.findByName(roleName);
//        user.setRoles(Collections.singleton(role));
                userRepository.save(user);
            }
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    }
