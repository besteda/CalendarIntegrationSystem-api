package com.tobeto.com.CalendarIntegrationSystem.services.dtos.requests.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddEventRequest {
    private int userId;

    private String title;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

}
