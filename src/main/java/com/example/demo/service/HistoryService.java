package com.example.demo.service;

import com.example.demo.model.History;
import com.example.demo.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HistoryService {
    @Autowired
    HistoryRepository historyRepository;
    public List<History> getHistory(String email){
        return historyRepository.findAllByEmail(email);
    }
    public void createHistory(String email ,int landMarkId){
        History history=new History(email,landMarkId, LocalDateTime.now());
        saveHistory(history);
    }
    public void saveHistory(History history){
        historyRepository.save(history);
    }
}
