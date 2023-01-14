package com.example.hotelManager.demo.controller;


import com.example.hotelManager.demo.model.CameraType;
import com.example.hotelManager.demo.model.Floor;
import com.example.hotelManager.demo.model.RoomStatus;
import com.example.hotelManager.demo.model.dto.FloorDto;
import com.example.hotelManager.demo.repository.CameraTypeRepository;
import com.example.hotelManager.demo.repository.RoomStatusRepository;
import com.example.hotelManager.demo.service.FloorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mvc/floor")
public class FloorControler {
public final FloorService floorService;
public final CameraTypeRepository cameraTypeRepository;
public final RoomStatusRepository roomStatusRepository;

    @GetMapping("viewFloors")
    public String getAllAppointments(Model model){
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
        model.addAttribute("values", cameraTypes);
        model.addAttribute("roomvalues",roomStatuses);
        return "floor/createFloor";
    }




}
