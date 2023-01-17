package com.example.hotelManager.demo.service;

import com.example.hotelManager.demo.model.CameraType;
import com.example.hotelManager.demo.model.RoomNumber;
import com.example.hotelManager.demo.repository.CameraTypeRepository;
import com.example.hotelManager.demo.repository.RoomNumberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CameraTypeService {

    private final CameraTypeRepository cameraTypeRepository;

   private final RoomNumberRepository roomNumberRepository;

    public List<CameraType> getAllCameraTypes() {
        return cameraTypeRepository.findAll();
    }

    public CameraType getCameraTypeById(Long id) {
        return cameraTypeRepository.findById(id).orElse(null);
    }



    public CameraType getDefaultCameraType() {
        //retrieve default camera type from repository or hardcoded
        Optional<CameraType> defaultCameraType = cameraTypeRepository.findById(1L);
        if(defaultCameraType.isPresent()){
            return defaultCameraType.get();
        }
        throw new IllegalArgumentException("Default Camera Type Not Found");
    }

}