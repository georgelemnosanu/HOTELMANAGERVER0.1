package com.example.hotelManager.demo.controller;

import com.example.hotelManager.demo.model.CameraType;
import com.example.hotelManager.demo.model.RoomNumber;
import com.example.hotelManager.demo.model.RoomType;
import com.example.hotelManager.demo.model.TaskList;
import com.example.hotelManager.demo.service.CameraTypeService;
import com.example.hotelManager.demo.service.RoomNumberService;
import com.example.hotelManager.demo.service.RoomTypeService;
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

    @Autowired
    CameraTypeService cameraTypeService;

    @Autowired
    RoomTypeService roomTypeService;

    @GetMapping("/createFloor")
    public String createTaskList(Model model) {
        model.addAttribute("taskList", new TaskList());
        model.addAttribute("roomNumbers", roomNumberService.getAllRoomNumbers());
        return "floor/createFloor";
    }

    @PostMapping(value="/submit")
    public String submitTaskList(@ModelAttribute("taskList") TaskList taskList, @RequestParam("roomNumbers") List<Long> roomNumberIds, Model model) {
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