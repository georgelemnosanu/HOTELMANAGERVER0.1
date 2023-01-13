package com.example.hotelManager.demo.service;

import com.example.hotelManager.demo.model.Floor;
import com.example.hotelManager.demo.repository.CameraTypeRepository;
import com.example.hotelManager.demo.repository.FloorRepository;
import com.example.hotelManager.demo.repository.RoomStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FloorService {

    private final FloorRepository floorRepository;
    private final RoomStatusRepository roomStatusRepository;

    private final CameraTypeRepository cameraTypeRepository;
    public void createFloor(Floor floor){
      floorRepository.save(floor);
    }
    public List<Floor> findAll() {
        return floorRepository.findAll()
                .stream().toList();
    }


}
