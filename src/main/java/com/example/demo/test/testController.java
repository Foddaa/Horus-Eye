package com.example.demo.test;

import com.example.demo.model.LandMark;
import com.example.demo.service.LandMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/test")
@RestController
public class testController {
    @Autowired
    LandMarkService landMarkService;

}
