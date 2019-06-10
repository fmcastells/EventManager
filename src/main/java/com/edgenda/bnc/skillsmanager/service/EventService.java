package com.edgenda.bnc.skillsmanager.service;

import com.edgenda.bnc.skillsmanager.model.Event;
import com.edgenda.bnc.skillsmanager.model.EventStatus;
import com.edgenda.bnc.skillsmanager.model.Guest;
import com.edgenda.bnc.skillsmanager.model.Invitation;
import com.edgenda.bnc.skillsmanager.repository.EventRepository;
import com.edgenda.bnc.skillsmanager.repository.InvitationRepository;
import com.edgenda.bnc.skillsmanager.service.exception.InvalidDataException;
import com.edgenda.bnc.skillsmanager.service.exception.UnknownEventException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    @Transactional
    public Event createEvent(Event event){
        Assert.notNull(event, "Event cannot be null");
        event.setEventStatus(EventStatus.ACTIVE);
        return eventRepository.save(event);
    }

    @Transactional
    public Event updateEvent(Event event){
        Assert.notNull(event, "Event cannot be null");
        return eventRepository.save(event);
    }


    public Event getEventById(Long id){
        Assert.notNull(id, "Event ID cannot be null");
        return eventRepository.findById(id)
                .orElseThrow(() -> new UnknownEventException(id));
    }

/*    public List<Event> getEventsByGuestId(Long guestId) {
        Assert.notNull(guestId, "Guest ID cannot be null");
        return eventRepository.findByGuestId(guestId);
    }*/

/*    public List<Invitation> getInvitationByEventId(Long eventId) {
        Assert.notNull(eventId, "Event ID cannot be null");
        return eventRepository.findById(eventId).get().getInvitations();
    }*/

   /* public List<Event> getEventsByOrganizerId(Long organizerID) {
        Assert.notNull(organizerID, "Guest ID cannot be null");
        return eventRepository.findByOrganisateur(organizerID);
    }
*/
    @Transactional
    public void deleteEvent(Long id){
        Assert.notNull(id, "ID cannot be null");
        eventRepository.delete(id);
    }

    @Transactional
    public void deleteCancelledEvent(Long id){
        Assert.notNull(id, "ID cannot be null");
        Event event = eventRepository.getOne(id);
        if(Objects.nonNull(event)){
            eventRepository.delete(id);
        }
        throw new UnknownEventException(id);
    }

    public List<Event> getEventsBetweenSpecificPeriod(Instant from, Instant to){
            return eventRepository.findByStartDateGreaterThanEqualAndEndDateLessThanEqualAndEventStatus(from, to, EventStatus.ACTIVE);
    }

   /* public Event addEventToGuest(Long guestId, Long eventID){
        Guest existingGuest = guestService.getGuestById(guestId);
        Event existingEvent = getEventById(eventID);
        if(Objects.nonNull(existingGuest) && Objects.nonNull(existingEvent)){
            existingEvent.setGuests(Arrays.asList(existingGuest));
            return eventRepository.save(existingEvent);
        }
        return null;
    }*/
}
