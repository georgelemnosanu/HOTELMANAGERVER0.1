package com.example.hotelManager.demo.repository;

import com.example.hotelManager.demo.model.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskListRepository extends JpaRepository<TaskList,Long> {
}
