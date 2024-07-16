package com.tobeto.com.CalendarIntegrationSystem.services.concerts;

import com.tobeto.com.CalendarIntegrationSystem.core.utils.exceptions.types.BusinessException;
import com.tobeto.com.CalendarIntegrationSystem.entities.Event;
import com.tobeto.com.CalendarIntegrationSystem.repositories.EventRepository;
import com.tobeto.com.CalendarIntegrationSystem.services.abstracts.EventService;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.requests.event.AddEventRequest;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.requests.event.UpdateEventRequest;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.event.AddEventResponse;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.event.GetByIdEventResponse;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.event.ListEventResponse;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.event.UpdateEventResponse;
import com.tobeto.com.CalendarIntegrationSystem.services.mappers.EventMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public AddEventResponse add(AddEventRequest request) {
        Event event = EventMapper.INSTANCE.eventToAddEventRequest(request);
        Event saved = eventRepository.save(event);

        AddEventResponse response = EventMapper.INSTANCE.addEventResponseToEvent(saved);
        return response;
    }

    @Override
    public UpdateEventResponse update(UpdateEventRequest request) {
        Event event = EventMapper.INSTANCE.eventToUpdateEventRequest(request);
        Event updated = eventRepository.save(event);
        UpdateEventResponse response = EventMapper.INSTANCE.updateEventResponseToEvent(updated);
        return response;
    }

    @Override
    public void delete(int id) {
        Event findById = eventRepository.findById(id).orElseThrow(()-> new BusinessException("id is not found"));
        eventRepository.delete(findById);

    }

    @Override
    public List<ListEventResponse> getAll() {
        List<Event> eventList = eventRepository.findAll();
        List<ListEventResponse> result = new ArrayList<>();
        for (Event event : eventList){
            ListEventResponse dto = EventMapper.INSTANCE.ListEventResponseToEvent(event);
            result.add(dto);
        }
        return result;
    }

    @Override
    public GetByIdEventResponse getById(int id) {
        Optional<Event> event = eventRepository.findById(id);
        return event.map(EventMapper.INSTANCE::getByIdEventResponseToEvent).orElse(null);

    }
}
