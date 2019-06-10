package com.edgenda.bnc.skillsmanager.controller;

import com.edgenda.bnc.skillsmanager.model.Event;
import com.edgenda.bnc.skillsmanager.model.Invitation;
import com.edgenda.bnc.skillsmanager.service.EventService;
import com.edgenda.bnc.skillsmanager.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(path = "/events")
public class EventController {

    private final EventService eventService;
    private final InvitationService invitationService;

    @Autowired
    public EventController(EventService eventService, InvitationService invitationService) {
        this.eventService = eventService;
        this.invitationService = invitationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Event> getEvents() {
        return eventService.getAllEvents();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Event getEvent(@PathVariable Long id) { return eventService.getEventById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Event updateEvent(@PathVariable Long id, @RequestBody Event event) {
        return eventService.updateEvent(event);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }

    @RequestMapping(path = "/period",method = RequestMethod.GET)
    public List<Event> getEventsBetweenSpecificPeriod(@RequestParam Instant from, @RequestParam Instant to ) {
        return eventService.getEventsBetweenSpecificPeriod(from,to);
    }


/*
    @RequestMapping(path = "/{id}/invitation", method = RequestMethod.GET)
    public List<Invitation> getEventInvitation(@PathVariable Long id) {
        return eventService.getInvitationByEventId(id);
    }
*/


 /*   @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Event addGuestEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }*/

}
