package com.example.hotelManager.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "task_list")
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDate date;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "task_list_room_number",
            joinColumns = @JoinColumn(name = "task_list_id"),
            inverseJoinColumns = @JoinColumn(name = "room_number_id"))
    private List<RoomNumber> roomNumbers;


    public TaskList(Long id, String title, LocalDate date, List<RoomNumber> roomNumbers) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.roomNumbers = roomNumbers;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

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

    public List<RoomNumber> getRoomNumbers() {
        return roomNumbers;
    }

    public void setRoomNumbers(List<RoomNumber> roomNumbers) {
        this.roomNumbers = roomNumbers;
    }


}