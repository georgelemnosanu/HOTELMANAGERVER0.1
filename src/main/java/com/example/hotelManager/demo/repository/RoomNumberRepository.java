package com.example.hotelManager.demo.repository;

import com.example.hotelManager.demo.model.RoomNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomNumberRepository extends JpaRepository<RoomNumber,Long> {
}
