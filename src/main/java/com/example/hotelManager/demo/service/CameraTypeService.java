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

    public void updateCameraTypes(Map<Long, Long> cameraTypes) {
        cameraTypes.forEach((roomNumberId, cameraTypeId) -> {
            CameraType cameraType = cameraTypeRepository.findById(cameraTypeId).orElse(null);
            if (cameraType != null) {
                RoomNumber roomNumber = roomNumberRepository.findById(roomNumberId).orElse(null);
                if (roomNumber != null) {
                    roomNumber.setCameraType(cameraType);
                    roomNumberRepository.save(roomNumber);
                }
            }
        });
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