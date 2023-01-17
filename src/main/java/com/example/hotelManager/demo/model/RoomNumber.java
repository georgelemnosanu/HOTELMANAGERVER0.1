package com.example.hotelManager.demo.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "room_number")
public class RoomNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;

    @ManyToMany(mappedBy = "roomNumbers")
    private Set<TaskList> taskLists;

    @ManyToOne
    private CameraType cameraType;

    public RoomNumber(Long id, Integer number, Set<TaskList> taskLists) {
        this.id = id;
        this.number = number;
        this.taskLists = taskLists;
    }

    public CameraType getCameraType() {
        return cameraType;
    }

    public RoomNumber(Long id, Integer number, Set<TaskList> taskLists, CameraType cameraType) {
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

    public Set<TaskList> getTaskLists() {
        return taskLists;
    }

    public void setTaskLists(Set<TaskList> taskLists) {
        this.taskLists = taskLists;
    }

    // constructor, getters, and setters
}