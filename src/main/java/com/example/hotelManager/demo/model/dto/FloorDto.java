package com.example.hotelManager.demo.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class FloorDto {


   private Integer id;
   private int roomNumber;
   private Integer cameraTypeId;
   private Integer roomStatusId;


    public FloorDto(Integer id, int roomNumber, Integer cameraTypeId, Integer roomStatusId) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.cameraTypeId = cameraTypeId;
        this.roomStatusId = roomStatusId;
    }

    public FloorDto(int roomNumber, Integer cameraTypeId, Integer roomStatusId) {
        this.roomNumber = roomNumber;
        this.cameraTypeId = cameraTypeId;
        this.roomStatusId = roomStatusId;
    }
}
