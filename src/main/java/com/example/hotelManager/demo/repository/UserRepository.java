package com.example.hotelManager.demo.repository;

import com.example.hotelManager.demo.model.Role;
import com.example.hotelManager.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String userName);

  boolean existsByUserName(String userName);


}
