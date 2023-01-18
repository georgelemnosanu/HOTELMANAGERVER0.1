package com.example.hotelManager.demo.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "room_number")
public class RoomNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;

    @ManyToMany(mappedBy = "roomNumbers")
    private List<TaskList> taskLists;

    @ManyToOne
    private CameraType cameraType;

    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;






    public RoomNumber(Long id, Integer number, List<TaskList> taskLists, CameraType cameraType, RoomType roomType) {
        this.id = id;
        this.number = number;
        this.taskLists = taskLists;
        this.cameraType = cameraType;
        this.roomType = roomType;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public RoomNumber(Long id, Integer number, List<TaskList> taskLists) {
        this.id = id;
        this.number = number;
        this.taskLists = taskLists;
    }

    public CameraType getCameraType() {
        return cameraType;
    }

    public RoomNumber(Long id, Integer number, List<TaskList> taskLists, CameraType cameraType) {
        this.id = id;
        this.number = number;
        this.taskLists = taskLists;
        this.cameraType = cameraType;
    }

    public void setCameraType(CameraType cameraType) {
        this.cameraType = cameraType;
    }

    public RoomNumber() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<TaskList> getTaskLists() {
        return taskLists;
    }

    public void setTaskLists(List<TaskList> taskLists) {
        this.taskLists = taskLists;
    }

    // constructor, getters, and setters
}