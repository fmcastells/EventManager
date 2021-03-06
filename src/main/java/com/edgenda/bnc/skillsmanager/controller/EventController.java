package com.edgenda.bnc.skillsmanager.controller;

import com.edgenda.bnc.skillsmanager.model.Event;
import com.edgenda.bnc.skillsmanager.model.Invitation;
import com.edgenda.bnc.skillsmanager.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/events")
public class EventController {

    private final EventService es;

    @Autowired
    public EventController(EventService es) {
        this.es = es;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Event> getEvents() {
        return es.getAllEvents();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Event getEvent(@PathVariable Long id) { return es.getEventById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Event createEvent(@RequestBody Event event) {
        return es.createEvent(event);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Event updateEvent(@PathVariable Long id, @RequestBody Event event) {
        return es.updateEvent(event);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteEvent(@PathVariable Long id) {
        es.deleteEvent(id);
    }

    @RequestMapping(path = "/{id}/guest", method = RequestMethod.GET)
    public List<Event> getEventGuest(@PathVariable Long id) {
        return es.getEventsByGuestId(id);
    }

    @RequestMapping(path = "/{id}/invitation", method = RequestMethod.GET)
    public List<Invitation> getEventInvitation(@PathVariable Long id) {
        return es.getInvitationByEventId(id);
    }

//    @RequestMapping(method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    public Event addGuestEvent(@RequestBody Event event) {
//        return es.createEvent(event);
//    }
    @RequestMapping(path = "/period",method = RequestMethod.GET)
    public List<Event> getEventsBetweenSpecificPeriod(@RequestParam String startdate ) {
        return es.getEventsBetweenSpecificPeriod(startdate);
}
}
