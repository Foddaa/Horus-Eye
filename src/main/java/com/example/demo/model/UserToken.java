package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="userToken")
public class UserToken {
    @Id
    @Column(name="email")     //email
    String email;
    @Column(name="code")      //verification code
    String code;
    @Column(name="firstName")   //first name
    String firstName;
    @Column(name="lastName")     //last name
    String lastName;
    @Column(name="country")     //country
    String country;
    @Column(name="phoneNumber")    //phone number
    String phoneNumber;
    @Column(name="birthDate")     //date of birth
    String birthDate;
    @Column(name="creationTime")    //creation time
    private LocalDateTime creationTime;
}
