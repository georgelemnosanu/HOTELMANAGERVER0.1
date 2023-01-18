package com.example.hotelManager.demo.repository;

import com.example.hotelManager.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}

