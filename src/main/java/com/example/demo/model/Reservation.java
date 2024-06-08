package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="Reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;
    @Column(name="hotel_id")
    int hotelId;
    @Column(name="email")
    String email;
    @Column(name="room")
    String room;
    @Column(name="price")
    float price;
    @Column(name="check_in")
    String checkOut;
    @Column(name="check_out")
    String checkIN ;
    @Column(name="days")
    int days;
}
