package com.edgenda.bnc.skillsmanager.controller;


import com.edgenda.bnc.skillsmanager.model.Invitation;
import com.edgenda.bnc.skillsmanager.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/invitations")
public class InvitationController {

    private final InvitationService invitationService;

    @Autowired
    public InvitationController(InvitationService invitationService) {
        this.invitationService = invitationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Invitation> getAllInvitation(){
        return invitationService.getAllInvitation();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Invitation createInvitation(@RequestBody Invitation invitation){
        return invitationService.createInvitation(invitation);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void updateInvitation (@RequestBody Invitation invitation){
        invitationService.updateInvitation(invitation);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Invitation getInvitation(@PathVariable Long id){
        return invitationService.getInvitationById(id);
    }

    @RequestMapping(path = "/event/{eventId}", method = RequestMethod.GET)
    public List<Invitation> getInvitationsByEventId(@PathVariable Long eventId) {
        return invitationService.getAllInvitationsByEventId(eventId);
    }

    @RequestMapping(path = "/guest/{guestId}", method = RequestMethod.GET)
    public List<Invitation> getInvitationsByGuestId(@PathVariable Long guestId) {
        return invitationService.getAllInvitationsByGuestId(guestId);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteInvitation(@PathVariable long id){
        invitationService.deleteInvitation(id);
    }
}
