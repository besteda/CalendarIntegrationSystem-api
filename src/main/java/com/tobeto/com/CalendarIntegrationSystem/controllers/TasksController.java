package com.tobeto.com.CalendarIntegrationSystem.controllers;

import com.tobeto.com.CalendarIntegrationSystem.services.abstracts.TaskService;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.requests.task.AddTaskRequest;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.requests.task.UpdateTaskRequest;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.task.AddTaskResponse;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.task.GetByIdTaskResponse;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.task.ListTaskResponse;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.task.UpdateTaskResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/task")
public class TasksController {

    private final TaskService taskService;

@PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public AddTaskResponse add(@RequestBody AddTaskRequest request){
    return taskService.add(request);
}
@PutMapping("/update")
    public UpdateTaskResponse update(@RequestBody UpdateTaskRequest request){
    return taskService.update(request);
}

@DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id){
    taskService.delete(id);
}

@GetMapping("/getAll")
    public List<ListTaskResponse> getAll(){
    return taskService.getAll();
}

@GetMapping("/getById/{id}")
    public GetByIdTaskResponse getById(@PathVariable("id") int id){
    return taskService.getById(id);
}
}
