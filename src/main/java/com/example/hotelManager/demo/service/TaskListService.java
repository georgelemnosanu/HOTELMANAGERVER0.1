package com.example.hotelManager.demo.service;

import com.example.hotelManager.demo.model.CameraType;
import com.example.hotelManager.demo.model.RoomNumber;
import com.example.hotelManager.demo.model.TaskList;
import com.example.hotelManager.demo.repository.CameraTypeRepository;
import com.example.hotelManager.demo.repository.TaskListRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
    public class TaskListService {

        @Autowired
        TaskListRepository taskListRepository;
        @Autowired
        CameraTypeRepository cameraTypeRepository;

        public void saveTaskList(TaskList taskList) {
            taskListRepository.save(taskList);
        }

        public TaskList getTaskListById(Long id) {
            return taskListRepository.findById(id).orElse(null);
        }

        public List<TaskList> getAllTaskLists() {
            return taskListRepository.findAll();
        }

        public void deleteTaskListById(Long id) {
            taskListRepository.deleteById(id);
        }

    @Transactional
    public void updateCameraTypes(Long taskListId, Map<Long, Long> cameraTypes) {
        TaskList taskList = taskListRepository.findById(taskListId).get();
        for (RoomNumber roomNumber : taskList.getRoomNumbers()) {
            Long cameraTypeId = cameraTypes.get(roomNumber.getId());
            CameraType cameraType = cameraTypeRepository.findById(cameraTypeId).get();
            roomNumber.setCameraType(cameraType);
        }
        taskListRepository.save(taskList);
    }


    public List<TaskList> getAllTaskListsWithCameraTypes() {
        List<TaskList> taskLists = taskListRepository.findAll();
        for (TaskList taskList : taskLists) {
            for (RoomNumber roomNumber : taskList.getRoomNumbers()) {
                CameraType cameraType = cameraTypeRepository.findById(roomNumber.getCameraType().getId()).get();
                roomNumber.setCameraType(cameraType);
            }
        }
        return taskLists;
    }


}


