package com.example.hotelManager.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="cameratype")
@RequiredArgsConstructor
@Data
public class CameraType {
    @Id
    @GeneratedValue
    private Integer id;

   private String cameraType;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCameraType() {
        return cameraType;
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
