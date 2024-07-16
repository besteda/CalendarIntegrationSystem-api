package com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListTaskResponse {

    private int id;

    private String title;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private int userId;
}
