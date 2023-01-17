package com.example.hotelManager.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Entity
@Getter
@Setter
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    public RoomType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public RoomType() {
    }
}
