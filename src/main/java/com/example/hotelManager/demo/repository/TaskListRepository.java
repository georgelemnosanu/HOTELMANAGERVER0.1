package com.example.hotelManager.demo.repository;

import com.example.hotelManager.demo.model.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface TaskListRepository extends JpaRepository<TaskList,Long> {
//    @Query(value = "SELECT tasklist FROM TaskList tasklist JOIN tasklist.roomNumbers roomnumber JOIN roomnumber.cameraType ORDER BY roomnumber.number ASC")

    @Query(value = "SELECT tasklist FROM TaskList tasklist JOIN tasklist.roomNumbers roomnumber JOIN roomnumber.cameraType JOIN roomnumber.roomType ORDER BY roomnumber.number ASC")
    List<TaskList> findAllWithCameraTypesAndRoomTypes();

    @Query("SELECT t FROM TaskList t WHERE t.date = :date")
    List<TaskList> findByDate(@Param("date") LocalDate date);


}
