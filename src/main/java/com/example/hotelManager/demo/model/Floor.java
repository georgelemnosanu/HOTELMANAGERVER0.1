package com.example.hotelManager.demo.model;


import com.example.hotelManager.demo.model.dto.FloorDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="floor")
@Data
@Getter
@Setter
@AllArgsConstructor
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Floor(Floor floor) {
    }

    public Floor(){

    }

    public Floor(Integer id, int roomNumber, CameraType cameraType, RoomStatus roomStatus) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.cameraType = cameraType;
        this.roomStatus = roomStatus;
        this.cameraTypeId=cameraTypeId;
        this.roomStatusId=roomStatusId;
    }

    public Floor(Integer id, int roomNumber,Integer cameraTypeId,Integer roomStatusId) {
       CameraType cameraType1= new CameraType();
        this.id = id;
        this.roomNumber = roomNumber;
        this.cameraTypeId=cameraTypeId;
        this.roomStatusId=roomStatusId;
    }

 public Floor(FloorDto floorDto){
        this.id= floorDto.getId();
        this.cameraTypeId=floorDto.getCameraTypeId();
        this.roomStatusId=floorDto.getRoomStatusId();
 }




    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    private int roomNumber;
    Integer cameraTypeId;
    Integer roomStatusId;



    @ManyToOne
    @JoinColumn(name = "cameratype_id" , referencedColumnName = "id")
    private CameraType cameraType;

   @ManyToOne
   @JoinColumn(name = "roomstatus_id" ,  referencedColumnName = "id")
   private RoomStatus roomStatus;


    public void setCameraType(Integer id) {
    }
}
