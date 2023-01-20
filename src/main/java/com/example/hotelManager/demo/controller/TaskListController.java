package com.example.hotelManager.demo.controller;


import com.example.hotelManager.demo.config.MyUserDetails;
import com.example.hotelManager.demo.model.*;
import com.example.hotelManager.demo.service.*;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
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

    @Autowired
    CameraTypeService cameraTypeService;

    @Autowired
    RoomTypeService roomTypeService;

    @Autowired
    UserService userService;


    @GetMapping("/createFloor")
    public String createTaskList(Model model) {
        model.addAttribute("taskList", new TaskList());
        model.addAttribute("roomNumbers", roomNumberService.getAllRoomNumbers());
        model.addAttribute("chosenDate", LocalDate.now());
        model.addAttribute("users", userService.getAllUsers());
        return "floor/createFloor";
    }

    @PostMapping(value="/submit")
    public String submitTaskList(@ModelAttribute("taskList") TaskList taskList, Model model, @RequestParam("userId") Long userId) {
        User user = userService.getUserById(userId);
        taskList.setUser(user);
        for (RoomNumber roomNumber : taskList.getRoomNumbers()) {
            roomNumber.setCameraType(cameraTypeService.getDefaultCameraType());
            roomNumber.setRoomType(roomTypeService.getDefaultRoomType());
        }
        taskListService.createTaskList(taskList);
        return "redirect:/mvc/floor/viewFloor";
    }

    @GetMapping("/viewFloor")
    public String viewAllTaskLists(Model model) {
        model.addAttribute("cameraTypes", cameraTypeService.getAllCameraTypes());
        model.addAttribute("roomTypes",roomTypeService.getAllRoomTypes());
        model.addAttribute("taskLists", taskListService.findAllWithRoomNumbersAndCameraTypes());
        return "floor/viewFloor";
    }


    @GetMapping("/userTaskLists")
    public String getMyTaskLists(Model model, Authentication authentication) {
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        User user = myUserDetails.getUser();
        List<TaskList> taskLists = taskListService.getTaskListsByUserId(user.getId());
        model.addAttribute("roomTypes",roomTypeService.getAllRoomTypes());
        model.addAttribute("cameraTypes",cameraTypeService.getAllCameraTypes());
        model.addAttribute("taskLists", taskLists);

        return "floor/userTaskLists";
    }

    @PostMapping("/editUser")
    public String updateByUserId(@RequestParam("roomNumberId") Long roomNumberId,@RequestParam("roomTypeId") Long roomTypeId) {
        RoomNumber roomNumber = roomNumberService.getRoomNumberById(roomNumberId);
        RoomType roomType = roomTypeService.getRoomTypeById(roomTypeId);
        roomNumber.setRoomType(roomType);
        roomNumberService.saveRoomNumber(roomNumber);
        return "redirect:/mvc/floor/userTaskLists";
    }


    @PostMapping("/tasklistsByDate")
    public String viewTasklistsByDate(@RequestParam("date") LocalDate date, Model model) {
        List<TaskList> tasklists = taskListService.getTaskListsByDate(date);
        model.addAttribute("tasklists", tasklists);
        model.addAttribute("chosenDate", date);
        return "floor/tasklistsByDate";
    }


    @PostMapping("/edit")
    public String update(@RequestParam("roomNumberId") Long roomNumberId, @RequestParam("cameraTypeId") Long cameraTypeId ,@RequestParam("roomTypeId") Long roomTypeId) {
        RoomNumber roomNumber = roomNumberService.getRoomNumberById(roomNumberId);
        CameraType cameraType = cameraTypeService.getCameraTypeById(cameraTypeId);
        RoomType roomType = roomTypeService.getRoomTypeById(roomTypeId);
        roomNumber.setCameraType(cameraType);
        roomNumber.setRoomType(roomType);
        roomNumberService.saveRoomNumber(roomNumber);
        return "redirect:/mvc/floor/viewFloor";
    }


//    @PostMapping("/tasklists/{id}/camera-types")
//    public String updateCameraTypes(@PathVariable Long id, @RequestParam Map<Long, Long> cameraTypes) {
//        taskListService.updateCameraTypes(id, cameraTypes);
//        return "redirect:/tasklists/" + id;
//    }
//




}