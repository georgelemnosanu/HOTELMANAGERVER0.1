package com.example.hotelManager.demo.repository;

import com.example.hotelManager.demo.model.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomStatusRepository extends JpaRepository<RoomStatus,Integer> {
}
