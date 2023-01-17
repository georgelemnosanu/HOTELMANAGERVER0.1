package com.example.hotelManager.demo.repository;

import com.example.hotelManager.demo.model.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskListRepository extends JpaRepository<TaskList,Long> {
    @Query(value = "SELECT tasklist FROM TaskList tasklist JOIN tasklist.roomNumbers roomnumber JOIN roomnumber.cameraType cameraType ORDER BY roomnumber.number ASC")
    List<TaskList> findAllWithRoomNumbersAndCameraTypes();
}
