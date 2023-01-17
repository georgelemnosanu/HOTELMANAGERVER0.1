package com.example.hotelManager.demo.repository;

import com.example.hotelManager.demo.model.CameraType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CameraTypeRepository extends JpaRepository<CameraType, Long> {

}