package com.megadiiiii.web.repository;

import com.megadiiiii.web.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("SELECT e FROM Event e ORDER BY e.startTime DESC")
    List<Event> findAllEventsDesc();
}
