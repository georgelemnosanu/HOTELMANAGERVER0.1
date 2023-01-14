package com.example.hotelManager.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
@Entity
@Table(name="cameratype")
@RequiredArgsConstructor
public class CameraType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "camera_type", nullable = false)
    private String cameraType;


    public void setId(Integer id) {
        this.id = id;
    }

    public void setCameraType(String cameraType) {
        this.cameraType = cameraType;
    }

    public CameraType(Integer id, String cameraType) {
        this.id = id;
        this.cameraType = cameraType;
    }

    @Override
    public String toString() {
        return cameraType;

    }
}
