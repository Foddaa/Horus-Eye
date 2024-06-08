package com.example.demo.service;

import com.example.demo.model.Hotel;
import com.example.demo.model.Reservation;
import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import java.util.List;

@Service
public class HotelService {
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    ReservationRepository reservationRepository;
    public List<Hotel> gitAllHotels(){
        return hotelRepository.findAll();}
    public void saveReservation(Reservation reservation){
        reservationRepository.save(reservation);
        sendReservation(reservation);

    }
    public void sendReservation(Reservation reservation){
        Hotel hotel=hotelRepository.findById(reservation.getHotelId()).get();
        SimpleMailMessage message = new SimpleMailMessage();
        float totalPrice=reservation.getPrice();
        message.setFrom("eyehorus458@gmail.com");
        message.setTo(reservation.getEmail());
        message.setSubject("Reservation Bill");
        message.setText(
                "Chick In Date : "+reservation.getCheckIN()+"\n"
                +"Chick Out Date : "+reservation.getCheckOut()+"\n"
                +"Total Cost : "+totalPrice*reservation.getDays()+"\n"
                +"Hotel Name : "+hotel.getName()+"\n"
                +"Hotel Location : "+hotel.getLocation()+"\n"
        );
        javaMailSender.send(message);
    }
}
