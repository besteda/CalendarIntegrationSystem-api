package com.tobeto.com.CalendarIntegrationSystem.services.concerts;

import com.tobeto.com.CalendarIntegrationSystem.core.utils.exceptions.types.BusinessException;
import com.tobeto.com.CalendarIntegrationSystem.entities.Task;
import com.tobeto.com.CalendarIntegrationSystem.repositories.TaskRepository;
import com.tobeto.com.CalendarIntegrationSystem.services.abstracts.TaskService;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.requests.task.AddTaskRequest;

import com.tobeto.com.CalendarIntegrationSystem.services.dtos.requests.task.UpdateTaskRequest;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.task.AddTaskResponse;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.task.GetByIdTaskResponse;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.task.ListTaskResponse;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.responses.task.UpdateTaskResponse;
import com.tobeto.com.CalendarIntegrationSystem.services.mappers.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public AddTaskResponse add(AddTaskRequest request) {
      Task task = TaskMapper.INSTANCE.taskToAddTaskRequest(request);
      Task saved = taskRepository.save(task);
      AddTaskResponse response = TaskMapper.INSTANCE.addTaskResponseToTask(saved);
      return response;
    }

    @Override
    public UpdateTaskResponse update(UpdateTaskRequest request) {
        Task task = TaskMapper.INSTANCE.taskToUpdateTaskRequest(request);
       Task saved = taskRepository.save(task);
        UpdateTaskResponse response = TaskMapper.INSTANCE.updateTaskResponseToTask(saved);
        return response;
    }

    @Override
    public void delete(int id) {
      Task finById = taskRepository.findById(id).orElseThrow(()->new BusinessException("id is not found"));
      taskRepository.delete(finById);
    }

    @Override
    public List<ListTaskResponse> getAll() {
       List<Task> taskList = taskRepository.findAll();
       List<ListTaskResponse> result = new ArrayList<>();
       for (Task task : taskList){
           ListTaskResponse dto = TaskMapper.INSTANCE.ListTaskResponseToTask(task);
           result.add(dto);
       }
       return result;
    }

    @Override
    public GetByIdTaskResponse getById(int id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.map(TaskMapper.INSTANCE::getByIdTaskResponseToTask).orElse(null);
    }
}
