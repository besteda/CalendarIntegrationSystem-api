package com.tobeto.com.CalendarIntegrationSystem.services.abstracts;

import com.tobeto.com.CalendarIntegrationSystem.services.dtos.requests.task.AddTaskRequest;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.requests.task.UpdateTaskRequest;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.task.AddTaskResponse;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.task.GetByIdTaskResponse;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.task.ListTaskResponse;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.task.UpdateTaskResponse;

import java.util.List;

public interface TaskService {
    AddTaskResponse add(AddTaskRequest request);

    UpdateTaskResponse update(UpdateTaskRequest request);

    void delete(int id);

    List<ListTaskResponse> getAll();

    GetByIdTaskResponse getById(int id);
}
