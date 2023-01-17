package com.example.hotelManager.demo.repository;

import com.example.hotelManager.demo.model.RoomNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomNumberRepository extends JpaRepository<RoomNumber,Long> {
}
