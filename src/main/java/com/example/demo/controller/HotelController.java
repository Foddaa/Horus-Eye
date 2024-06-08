package com.example.demo.controller;

import com.example.demo.model.Hotel;
import com.example.demo.model.Reservation;
import com.example.demo.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    HotelService hotelService;

    @GetMapping("/all")
    public List<Hotel> getAll(){
        return hotelService.gitAllHotels();
    }
    @PostMapping("/saveReservation")
    public void saveReservation(@RequestBody Reservation reservation) {
         hotelService.saveReservation(reservation);
    }
}
