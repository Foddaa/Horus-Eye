package com.example.demo.service;

import com.example.demo.model.LandMark;
import com.example.demo.model.realModel;
import com.example.demo.model.recognitionModel;
import com.example.demo.repository.LandMarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class LandMarkService {

    @Autowired
    LandMarkRepository landMarkRepository;
    public List<LandMark> gitAllLandMarks() {
        return landMarkRepository.findAll();
    }

    public List<LandMark> search(String name) {
        return landMarkRepository.findByNameContaining(name);
    }
    public LandMark getLandMarkById(int id) {
        return landMarkRepository.findById(id).get();
    }
}
