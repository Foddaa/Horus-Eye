package com.example.demo.controller;

import com.example.demo.model.History;
import com.example.demo.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {
    @Autowired
    HistoryService historyService;

    @GetMapping("/getHistory")
    public List<History> getHistory(@RequestParam("email") String email){
        return historyService.getHistory(email);
    }
    @PostMapping("/saveHistory")
    public void saveHistory(@RequestParam String email,@RequestParam int landmarkId){
        historyService.createHistory(email,landmarkId);
    }
}
