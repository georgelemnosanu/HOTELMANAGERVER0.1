package com.example.hotelManager.demo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
////@RequiredArgsConstructor
//@RequestMapping("/mvc/floor")
//public class FloorControler {
//public final FloorService floorService;
//public final FloorRepository floorRepository;
//public final CameraTypeRepository cameraTypeRepository;
//public final RoomStatusRepository roomStatusRepository;
//public final RoomNumberService roomNumberService;
//
//    @GetMapping("viewFloors")
//    public String getAllAppointments(Model model){
//        Floor floor = new Floor();
//        List<CameraType> cameraTypes = cameraTypeRepository.findAll();
//        List<RoomStatus> roomStatuses= roomStatusRepository.findAll();
//        model.addAttribute("createFloor",floor);
//        model.addAttribute("roomType", cameraTypes);
//        model.addAttribute("roomStatus",roomStatuses);
//        List<Floor> floorList= floorService.findAll();
//        model.addAttribute("floor",floorList);
//        return "floor/viewFloor";
//    }
//
//    @PostMapping("/submit")
//    public String submitTaskList(@ModelAttribute("floor") Floor taskList, Model model) {
//        floorService.saveTaskList(taskList);
//        return "successFloor";
//    }
//
//    @GetMapping("/createFloor")
//    public String showCreateForm(Model model){
//        model.addAttribute("taskList", new Floor());
//        model.addAttribute("roomNumber", roomNumberService.getAllNumbers());
//        return "floor/createFloor";
//    }
//
//
//    @GetMapping("/editFloor/{id}")
//    public String getAllFloorsToEdit(@PathVariable(name = "id") Integer id,Model model){
//        List<CameraType> cameraTypes = cameraTypeRepository.findAll();
//        List<RoomStatus> roomStatuses= roomStatusRepository.findAll();
//        model.addAttribute("editFloor",floorRepository.findById(id));
//        model.addAttribute("roomType", cameraTypes);
//        model.addAttribute("roomStatus",roomStatuses);
//        List<Floor> floorList= floorService.findAll();
//        model.addAttribute("floor",floorList);
//        return "floor/editFloor";
//    }
//
//
//
////        @PostMapping(value="/update/{id}")
////    public String updateFloor(@PathVariable(name = "id") Integer id,@Valid Floor floor,BindingResult bindingResult,Model model){
////       model.addAttribute("editFloor",floor);
////       floorService.updateFloor(id,floor);
////       return "successFloor";
////    }
//
//
//


//
//}
