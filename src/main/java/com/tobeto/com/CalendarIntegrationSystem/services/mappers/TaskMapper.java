package com.tobeto.com.CalendarIntegrationSystem.services.mappers;

import com.tobeto.com.CalendarIntegrationSystem.entities.Task;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.requests.event.UpdateEventRequest;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.requests.task.AddTaskRequest;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.requests.task.UpdateTaskRequest;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.task.AddTaskResponse;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.task.GetByIdTaskResponse;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.task.ListTaskResponse;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.task.UpdateTaskResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);


      @Mapping(target = "user.id",source = "userId")
    Task taskToAddTaskRequest(AddTaskRequest request);
      @Mapping(target = "user.id",source = "userId")
    Task taskToUpdateTaskRequest(UpdateTaskRequest request);
      @Mapping(target = "username",source = "user.id")
    AddTaskResponse addTaskResponseToTask(Task task);
      @Mapping(target = "userId",source = "user.id")
    UpdateTaskResponse updateTaskResponseToTask(Task task);
      @Mapping(target = "userId",source = "user.id")
    ListTaskResponse ListTaskResponseToTask(Task task);
      @Mapping(target = "username",source = "user.id")
    GetByIdTaskResponse getByIdTaskResponseToTask(Task task);
}
