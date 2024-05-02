package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
public class modelExample1 implements recognitionModel {
    @Override
    public String displayInfo(MultipartFile file) {
        return "Tutankhamun";
    }
}
