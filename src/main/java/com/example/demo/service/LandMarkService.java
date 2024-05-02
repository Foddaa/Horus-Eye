package com.example.demo.service;

import com.example.demo.model.LandMark;
import com.example.demo.model.realModel;
import com.example.demo.model.recognitionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class LandMarkService {
    @Autowired
    LandMark landMark;
    public String displayInfo(MultipartFile file) {
        recognitionModel model=new realModel();
        return model.displayInfo(file);
    }
}
