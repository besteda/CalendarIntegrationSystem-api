package com.tobeto.com.CalendarIntegrationSystem.repositories;

import com.tobeto.com.CalendarIntegrationSystem.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
