package com.megadiiiii.web.repository;

import com.megadiiiii.web.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
