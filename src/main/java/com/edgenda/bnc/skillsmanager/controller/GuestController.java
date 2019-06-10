package com.edgenda.bnc.skillsmanager.controller;


import com.edgenda.bnc.skillsmanager.model.Guest;
import com.edgenda.bnc.skillsmanager.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/guests")
public class GuestController {

    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService es) {
        this.guestService = es;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Guest> getAllGuest(){
        return guestService.getAllGuest();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Guest createGuest(@RequestBody Guest guest){
        return guestService.createGuest(guest);
    }

    @RequestMapping(path = "/id", method = RequestMethod.PUT)
    public void updateGuest (@RequestBody Guest guest){
        guestService.updateGuest(guest);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Guest getGuest(@PathVariable Long id){
        return guestService.getGuestById(id);
    }

    @GetMapping("/event/{eventid}")
    public ResponseEntity<List<Guest>> getAllGuestsForEvent(@PathVariable Long eventid) {
        List<Guest> guestList = guestService.getGuestsByEventId(eventid);
        return ResponseEntity.ok().body(guestList);
    }

    @PutMapping("{id}/accept/")
    public ResponseEntity<Void> acceptInvitation(@PathVariable Long id, @RequestParam Long invitationId) {
        guestService.acceptInvitation(id, invitationId);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(path = "/", method = RequestMethod.DELETE)
    public void deleteGuest(@PathVariable long id){
        guestService.deleteGuest(id);
    }

}
