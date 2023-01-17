package com.example.hotelManager.demo.controller;

import com.example.hotelManager.demo.model.TaskList;
import com.example.hotelManager.demo.service.RoomNumberService;
import com.example.hotelManager.demo.service.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

@RequestMapping("/mvc/floor")
@Controller
public class TaskListController {
    @Autowired
    TaskListService taskListService;

    @Autowired
    RoomNumberService roomNumberService;

    @GetMapping("/createFloor")
    public String createTaskList(Model model) {
        model.addAttribute("taskList", new TaskList());
        model.addAttribute("roomNumbers", roomNumberService.getAllRoomNumbers());
        return "floor/createFloor";
    }

    @PostMapping(value="/submit")
    public String submitTaskList(@ModelAttribute("taskList") TaskList taskList, @RequestParam("roomNumbers") List<Long> roomNumberIds, Model model) {
        taskList.setRoomNumbers(new HashSet<>(roomNumberService.getRoomNumbersByIds(roomNumberIds)));
        taskListService.saveTaskList(taskList);
        return "successFloor";
    }

    @GetMapping("/viewFloor")
    public String viewAllTaskLists(Model model) {
        List<TaskList> taskLists = taskListService.getAllTaskListsWithCameraTypes();
        model.addAttribute("taskLists", taskLists);
        return "floor/viewFloor";
    }

    @PostMapping("/tasklists/{id}/camera-types")
    public String updateCameraTypes(@PathVariable Long id, @RequestParam Map<Long, Long> cameraTypes) {
        taskListService.updateCameraTypes(id, cameraTypes);
        return "redirect:/tasklists/" + id;
    }


}