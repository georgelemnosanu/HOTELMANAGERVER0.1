package com.example.hotelManager.demo.service;

import com.example.hotelManager.demo.model.CameraType;
import com.example.hotelManager.demo.model.RoomType;
import com.example.hotelManager.demo.repository.RoomTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomTypeService {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    public List<RoomType> getAllRoomTypes() {
        return roomTypeRepository.findAll();
    }

    public RoomType getRoomTypeById(Long id) {
        return roomTypeRepository.findById(id).orElse(null);
    }

    public RoomType saveRoomType(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    public void deleteRoomType(Long id) {
        roomTypeRepository.deleteById(id);
    }
    public RoomType getDefaultRoomType() {
        //retrieve default camera type from repository or hardcoded
        Optional<RoomType> defaultRoomType = roomTypeRepository.findById(1L);
        if(defaultRoomType.isPresent()){
            return defaultRoomType.get();
        }
        throw new IllegalArgumentException("Default RoomType Type Not Found");
    }




}