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
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userEmail;
    private int landMarkId;
    private LocalDateTime date;
    public History( String userEmail, int landMarkId, LocalDateTime date) {
        this.userEmail = userEmail;
        this.landMarkId = landMarkId;
        this.date = date;
    }
}
