package com.megadiiiii.web.services;

import com.megadiiiii.web.dto.EventDto;

import java.util.List;

public interface EventService {
    void createEvent(Long id, EventDto eventDto);

    List<EventDto> findAllEvents();

    List<EventDto> findAllEventsStartTimeDesc();

    EventDto findByEventId(Long eventId);

    void updateEvent(EventDto eventDto);

    void deleteEvent(long eventId);
}
