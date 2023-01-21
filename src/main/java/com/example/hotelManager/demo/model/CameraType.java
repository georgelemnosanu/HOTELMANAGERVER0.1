package com.example.hotelManager.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CameraType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public CameraType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CameraType() {
    }

    @Override
    public String toString() {
        return name ;
    }
}