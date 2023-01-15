package com.example.hotelManager.demo.controller;


import com.example.hotelManager.demo.model.CameraType;
import com.example.hotelManager.demo.model.Floor;
import com.example.hotelManager.demo.model.RoomStatus;
import com.example.hotelManager.demo.repository.CameraTypeRepository;
import com.example.hotelManager.demo.repository.FloorRepository;
import com.example.hotelManager.demo.repository.RoomStatusRepository;
import com.example.hotelManager.demo.service.FloorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mvc/floor")
public class FloorControler {
public final FloorService floorService;
public final FloorRepository floorRepository;
public final CameraTypeRepository cameraTypeRepository;
public final RoomStatusRepository roomStatusRepository;

    @GetMapping("viewFloors")
    public String getAllAppointments(Model model){
        Floor floor = new Floor();
        List<CameraType> cameraTypes = cameraTypeRepository.findAll();
        List<RoomStatus> roomStatuses= roomStatusRepository.findAll();
        model.addAttribute("createFloor",floor);
        model.addAttribute("roomType", cameraTypes);
        model.addAttribute("roomStatus",roomStatuses);
        List<Floor> floorList= floorService.findAll();
        model.addAttribute("floor",floorList);
        return "floor/viewFloor";
    }

//      @PostMapping(value="{id}/submit")
//    public String createFloor(@Valid Floor floor, BindingResult bindingResult, Model model){
//          model.addAttribute("createFloor",floor);
//         floorService.createFloor(floor);
//        return "successFloor";
//    }

    @PostMapping(value="/submit")
    public String createFloor(@Valid Floor floor,BindingResult bindingResult){
        floorService.createFloor(floor);
        return "successFloor";
    }


    @GetMapping("/createFloor")
    public String showCreateForm(Model model){
        Floor floor = new Floor();
        List<CameraType> cameraTypes = cameraTypeRepository.findAll();
        List<RoomStatus> roomStatuses= roomStatusRepository.findAll();
        model.addAttribute("createFloor",floor);
        model.addAttribute("roomType", cameraTypes);
        model.addAttribute("roomStatus",roomStatuses);
        return "floor/createFloor";
    }


    @GetMapping("/editFloor/{id}")
    public String getAllFloorsToEdit(@PathVariable(name = "id") Integer id,Model model){
        List<CameraType> cameraTypes = cameraTypeRepository.findAll();
        List<RoomStatus> roomStatuses= roomStatusRepository.findAll();
        model.addAttribute("editFloor",floorRepository.findById(id));
        model.addAttribute("roomType", cameraTypes);
        model.addAttribute("roomStatus",roomStatuses);
        List<Floor> floorList= floorService.findAll();
        model.addAttribute("floor",floorList);
        return "floor/editFloor";
    }



        @PostMapping(value="/update/{id}")
    public String updateFloor(@PathVariable(name = "id") Integer id,@Valid Floor floor,BindingResult bindingResult,Model model){
       model.addAttribute("editFloor",floor);
       floorService.updateFloor(id,floor);
       return "successFloor";
    }






}
