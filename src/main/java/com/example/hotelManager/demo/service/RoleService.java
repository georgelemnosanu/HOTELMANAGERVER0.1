package com.example.hotelManager.demo.service;

import com.example.hotelManager.demo.model.Role;
import com.example.hotelManager.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}