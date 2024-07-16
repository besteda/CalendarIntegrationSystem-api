package com.tobeto.com.CalendarIntegrationSystem.repositories;

import com.tobeto.com.CalendarIntegrationSystem.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer> {
}
