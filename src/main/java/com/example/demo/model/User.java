package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="user")
public class User {
    @Id
    @Column(name="email")
    String email;
    @Column(name="firstName")
    String firstName;
    @Column(name="lastName")
    String lastName;
    @Column(name="password")
    String password;
    @Column(name="birthDate")
    String birthDate;
    @Column(name="country")
    String country;
    @Column(name="phoneNumber")
    String phoneNumber;


}