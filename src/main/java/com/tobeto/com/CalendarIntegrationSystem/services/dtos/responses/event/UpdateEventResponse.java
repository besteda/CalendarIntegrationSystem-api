package com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEventResponse {

    private int id;

    private int userId;

    private String title;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
