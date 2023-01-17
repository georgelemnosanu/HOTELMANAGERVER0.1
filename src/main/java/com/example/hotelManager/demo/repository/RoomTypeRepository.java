package com.example.hotelManager.demo.repository;

import com.example.hotelManager.demo.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType,Long> {
}
