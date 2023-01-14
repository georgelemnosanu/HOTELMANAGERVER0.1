package com.example.hotelManager.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name="roomstatus")
@RequiredArgsConstructor
public class RoomStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    String status;
    public void setId(Integer id) {
        this.id = id;
    }



    public RoomStatus(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    @Override
    public String toString() {
        return  status ;

    }



}
