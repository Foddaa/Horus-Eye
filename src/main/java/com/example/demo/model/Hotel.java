package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="hotels")
public class Hotel {
    @Id
    @Column(name="id")
    int id;
    @Column(name="name")
    String name;
    @Column(name="location")
    String location;
    @Column(name="image_url")
    String image_url;
    @Column(name="city")
    String city;
    @Column(name="price_per_night")
    String price_per_night;
    @Column(name="rating")
    String rating;
    @Column(name="specifications")
    String specifications;
}