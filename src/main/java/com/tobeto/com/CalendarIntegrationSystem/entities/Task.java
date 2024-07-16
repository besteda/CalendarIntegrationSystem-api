package com.tobeto.com.CalendarIntegrationSystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "tasks")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private LocalDateTime startDate;

    private LocalDateTime endDate;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
