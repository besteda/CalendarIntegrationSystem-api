package com.tobeto.com.CalendarIntegrationSystem.services.mappers;

import com.tobeto.com.CalendarIntegrationSystem.entities.Event;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.requests.event.AddEventRequest;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.requests.event.UpdateEventRequest;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.event.AddEventResponse;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.event.GetByIdEventResponse;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.event.ListEventResponse;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.event.UpdateEventResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EventMapper {

    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);


    @Mapping(target = "user.id",source = "userId")
Event eventToAddEventRequest(AddEventRequest request);
    @Mapping(target = "user.id",source = "userId")
Event eventToUpdateEventRequest(UpdateEventRequest request);
    @Mapping(target = "username",source = "user.id")
AddEventResponse addEventResponseToEvent(Event event);
    @Mapping(target = "userId",source = "user.id")
UpdateEventResponse updateEventResponseToEvent(Event event);
    @Mapping(target = "userId",source = "user.id")
ListEventResponse ListEventResponseToEvent(Event event);
    @Mapping(target = "username",source = "user.id")
GetByIdEventResponse getByIdEventResponseToEvent(Event event);

}
