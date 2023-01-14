package com.example.hotelManager.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="cameratype")
@RequiredArgsConstructor
@Data
public class CameraType {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "camera_type", nullable = false)
    private String cameraType;


    public int setId() {
        this.id = id;
        return 0;
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
