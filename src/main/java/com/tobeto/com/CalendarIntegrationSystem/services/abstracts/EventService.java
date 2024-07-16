package com.tobeto.com.CalendarIntegrationSystem.services.abstracts;



import com.tobeto.com.CalendarIntegrationSystem.services.dtos.requests.event.AddEventRequest;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.requests.event.UpdateEventRequest;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.event.AddEventResponse;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.event.GetByIdEventResponse;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.event.ListEventResponse;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.event.UpdateEventResponse;

import java.util.List;

public interface EventService {
    AddEventResponse add(AddEventRequest request);

    UpdateEventResponse update(UpdateEventRequest request);

    void delete(int id);

    List<ListEventResponse> getAll();

    GetByIdEventResponse getById(int id);
}
