package com.example.demo.controller;

import com.example.demo.model.LandMark;
import com.example.demo.service.LandMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/landmark")
public class LandMarkController {
    @Autowired
    LandMarkService landMarkService;
    @GetMapping("/all")
    public List<LandMark> getAll(){
        return landMarkService.gitAllLandMarks();
    }
    @GetMapping("/search")
    public List<LandMark> search(@RequestParam String name){
        return landMarkService.search(name);
    }
}
