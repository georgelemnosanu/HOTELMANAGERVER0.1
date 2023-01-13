package com.example.hotelManager.demo.controller;


import com.example.hotelManager.demo.model.Floor;
import com.example.hotelManager.demo.service.FloorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mvc/floor")
public class FloorControler {
public final FloorService floorService;
    @GetMapping("viewFloors")
    public String getAllAppointments(Model model){
        List<Floor> floorList= floorService.findAll();
        model.addAttribute("floor",floorList);
        return "floor/viewFloor";
    }

    @PostMapping(value="/submit")
    public String createFloor(@Valid @ModelAttribute("createFloor") Floor floor, BindingResult bindingResult, Model model){
        floorService.createFloor(floor);
        model.addAttribute("createFloor",floor);
        return "successFloor";
    }

    @GetMapping("/createFloor")
    public String showCreateForm(Model model){
        Floor floor = new Floor();
        model.addAttribute("createFloor",floor);
        return "floor/createFloor";
    }





}
