package com.example.hotelManager.demo.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="floor")
@Data
@Getter
@Setter
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Floor(Floor floor) {
    }

        @OneToMany(mappedBy = "floor", fetch = FetchType.EAGER,
           cascade = CascadeType.ALL)
        List<Date> dateList;
    public Floor(){

    }

    public Floor(Integer id, int roomNumber, CameraType cameraType, RoomStatus roomStatus) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.cameraType = cameraType;
        this.roomStatus = roomStatus;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    private int roomNumber;


    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "cameratype_id")
    private CameraType cameraType;

   @ManyToOne(fetch = FetchType.EAGER,optional = false)
   @JoinColumn(name = "roomstatus_id")
   private RoomStatus roomStatus;



}
