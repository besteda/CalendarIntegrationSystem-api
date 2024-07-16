package com.tobeto.com.CalendarIntegrationSystem.controllers;

import com.tobeto.com.CalendarIntegrationSystem.services.abstracts.EventService;

import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.event.UpdateEventResponse;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.requests.event.UpdateEventRequest;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.event.AddEventResponse;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.requests.event.AddEventRequest;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.event.ListEventResponse;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.event.GetByIdEventResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/event")
public class EventsController {
    private final EventService eventService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public AddEventResponse add(@RequestBody AddEventRequest request){
        return eventService.add(request);
    }
    @PutMapping("/update")
    public UpdateEventResponse update(@RequestBody UpdateEventRequest request){
        return eventService.update(request);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id){
        eventService.delete(id);
    }
    @GetMapping("/getAll")
    public List<ListEventResponse> getAll(){
        return eventService.getAll();
    }
    @GetMapping("/getById/{id}")
    public GetByIdEventResponse getById(@PathVariable("id") int id){
        return eventService.getById(id);
    }
}
