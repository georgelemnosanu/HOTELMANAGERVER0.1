package com.example.hotelManager.demo.repository;

import com.example.hotelManager.demo.model.CameraType;
import com.example.hotelManager.demo.model.Floor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CameraTypeRepository extends JpaRepository<CameraType,Integer> {


}