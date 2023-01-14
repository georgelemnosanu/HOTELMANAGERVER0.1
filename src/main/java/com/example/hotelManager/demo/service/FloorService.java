package com.example.hotelManager.demo.service;

import com.example.hotelManager.demo.model.CameraType;
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
        //.getCameraType().cameraTypeRepository.findById(floor.getCameraTypeId()).orElseThrow(()->new RuntimeException()).getId();
        //Integer id = cameraTypeRepository.findById(floor.getCameraTypeId()).orElseThrow(() -> new RuntimeException()).getId();
        //floor1.setCameraType(id);

        //floor1.setCameraType(cameraTypeRepository.findById(floor.getCameraTypeId()).orElseThrow(()->new RuntimeException()).setId());
        //floor1.setCameraType(cameraTypeRepository.findById(floor.getCameraTypeId()).orElseThrow(()->new RuntimeException()).getId());
       //floor1.setRoomStatusId(roomStatusRepository.findById(floor.getRoomStatusId()).orElseThrow(()->new RuntimeException()).getId());
       floorRepository.save(floor);
    }
    public List<Floor> findAll() {
        List<Floor> floorList = floorRepository.findAll()
                .stream().toList();
        return floorList;
    }

    public List<CameraType> allCamera(){
        List<CameraType> cameraTypes = cameraTypeRepository.findAll().stream().toList();
        return cameraTypes;
    }




}
