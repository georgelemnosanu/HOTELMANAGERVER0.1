package com.example.hotelManager.demo.service;

import com.example.hotelManager.demo.model.RoomNumber;
import com.example.hotelManager.demo.repository.RoomNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RoomNumberService {

    @Autowired
    RoomNumberRepository roomNumberRepository;

    public void saveRoomNumber(RoomNumber roomNumber) {
        roomNumberRepository.save(roomNumber);
    }

    public RoomNumber getRoomNumberById(Long id) {
        return roomNumberRepository.findById(id).orElse(null);
    }

//    public List<RoomNumber> getAllRoomNumbers() {
//        return roomNumberRepository.findAll();
//    }

    public void deleteRoomNumberById(Long id) {
        roomNumberRepository.deleteById(id);
    }

    public List<RoomNumber> getRoomNumbersByIds(List<Long> ids) {
        return roomNumberRepository.findAllById(ids);
    }


    public List<RoomNumber> getAllRoomNumbers(){
        List<RoomNumber> roomNumbers = roomNumberRepository.findAll();
        Collections.sort(roomNumbers, (r1, r2) -> r1.getNumber().compareTo(r2.getNumber()));
        return roomNumbers;
    }
}