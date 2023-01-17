package com.example.hotelManager.demo.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "task_list")
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "task_list_room_number",
            joinColumns = @JoinColumn(name = "task_list_id"),
            inverseJoinColumns = @JoinColumn(name = "room_number_id"))
    private Set<RoomNumber> roomNumbers;


    public TaskList() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<RoomNumber> getRoomNumbers() {
        return roomNumbers;
    }

    public void setRoomNumbers(Set<RoomNumber> roomNumbers) {
        this.roomNumbers = roomNumbers;
    }
}