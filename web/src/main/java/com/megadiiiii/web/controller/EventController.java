package com.megadiiiii.web.controller;

import com.megadiiiii.web.dto.ClubDto;
import com.megadiiiii.web.dto.EventDto;
import com.megadiiiii.web.models.Event;
import com.megadiiiii.web.services.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller

public class EventController {
    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public String events(Model model) {
        List<EventDto> events = eventService.findAllEventsStartTimeDesc();
        model.addAttribute("events", events);
        return "events-list";
    }

    @GetMapping("/events/{clubId}/new")
    public String createNewEvent(@PathVariable Long clubId, Model model) {
        Event event = new Event();
        model.addAttribute("event", event);
        model.addAttribute("clubId", clubId);
        return "events-create";
    }

    @PostMapping("/events/{clubId}")
    public String createEvent(@PathVariable Long clubId, EventDto eventDto, Model model) {
        eventService.createEvent(clubId, eventDto);
        return "redirect:/clubs/" + clubId;
    }

    @GetMapping("/events/{eventId}/edit")
    public String editEventForm(@PathVariable("eventId") long eventId, Model model) {
        EventDto event = eventService.findByEventId(eventId);
        model.addAttribute("event", event);
        return "events-edit";
    }

    @GetMapping("/events/{eventId}")
    public String viewEvent(@PathVariable("eventId") long eventId, Model model) {
        EventDto event = eventService.findByEventId(eventId);
        model.addAttribute("event", event);
//        model.addAttribute("club")
        return "events-details";
    }

    @PostMapping("/events/{eventId}/edit")
    public String updateEvent(@PathVariable("eventId") Long eventId,
                              @Valid @ModelAttribute("event") EventDto event,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("event", event);
            return "events-edit";
        }
        EventDto eventDto = eventService.findByEventId(eventId);
        event.setId(eventId);
        event.setClub(eventDto.getClub());
        eventService.updateEvent(event);
        return "redirect:/clubs";
    }

    @GetMapping("/events/{eventId}/delete")
    public String deleteEvent(@PathVariable("eventId") long eventId, Model model) {
        Long clubId = eventService.findByEventId(eventId).getClub().getId();
        eventService.deleteEvent(eventId);
        return "redirect:/clubs/" + clubId;
    }
}