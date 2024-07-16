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
public class GetByIdEventResponse {

    private int id;

    private String title;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String username;  //TODO:id'de olabilir
}
