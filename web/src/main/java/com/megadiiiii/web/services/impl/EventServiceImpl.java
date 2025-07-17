package com.megadiiiii.web.services.impl;

import com.megadiiiii.web.dto.ClubDto;
import com.megadiiiii.web.dto.EventDto;
import com.megadiiiii.web.models.Club;
import com.megadiiiii.web.models.Event;
import com.megadiiiii.web.repository.ClubRepository;
import com.megadiiiii.web.repository.EventRepository;
import com.megadiiiii.web.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.megadiiiii.web.mapper.ClubMapper.mapToClub;
import static com.megadiiiii.web.mapper.ClubMapper.mapToClubDto;
import static com.megadiiiii.web.mapper.EventMapper.mapToEvent;
import static com.megadiiiii.web.mapper.EventMapper.mapToEventDto;

@Service
public class EventServiceImpl implements EventService {
    private ClubRepository clubRepository;
    private EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(ClubRepository clubRepository, EventRepository eventRepository) {
        this.clubRepository = clubRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public void createEvent(Long clubId, EventDto eventDto) {
        Club club = clubRepository.findById(clubId).get();
        Event event = mapToEvent(eventDto);
        event.setClub(club);
        eventRepository.save(event);
    }

    @Override
    public List<EventDto> findAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(event -> mapToEventDto(event)).collect(Collectors.toList());
    }

    @Override
    public EventDto findByEventId(Long eventId) {
        Event event = eventRepository.findById(eventId).get();
        return mapToEventDto(event);
    }

    @Override
    public void updateEvent (EventDto eventDto) {
        Event event = mapToEvent(eventDto);
        eventRepository.save(event);
    }

}

