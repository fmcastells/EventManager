package com.edgenda.bnc.skillsmanager.service;

import com.edgenda.bnc.skillsmanager.model.Guest;
import com.edgenda.bnc.skillsmanager.model.Invitation;
import com.edgenda.bnc.skillsmanager.model.InvitationStatus;
import com.edgenda.bnc.skillsmanager.repository.GuestRepository;
import com.edgenda.bnc.skillsmanager.repository.InvitationRepository;
import com.edgenda.bnc.skillsmanager.service.exception.UnknownGuestException;
import com.edgenda.bnc.skillsmanager.service.exception.UnknownInvitationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private InvitationRepository invitationRepository;

    @Autowired
    private EventService eventService;

    public List<Guest> getAllGuest() {
        return guestRepository.findAll();
    }

    public Guest createGuest(Guest guest) {
        Assert.notNull(guest, "Guest cannot be null");
        return guestRepository.save(guest);
    }

    public void updateGuest(Guest guest) {
        Assert.notNull(guest, "Guest cannot be null");
        guestRepository.save(guest);
    }

    public Guest getGuestById(Long id){
        Assert.notNull(id, "Guest Id cannot be null");
        return guestRepository.findById(id)
                .orElseThrow(() -> new UnknownGuestException(id));
    }

    public void deleteGuest(Long id){
        Assert.notNull(id, "Id cannot be null");
        guestRepository.delete(id);
    }

    public List<Guest> getGuestsByEventId(Long eventId) {
        List<Guest> guestList = new ArrayList<>();
        List<Invitation> invitationList = invitationRepository.findAllByEvent_IdAndInvitationStatus(eventId, InvitationStatus.APPROVED);
        invitationList.forEach(invitation -> {
            if(invitation.getGuest() != null){
                guestList.add(invitation.getGuest());
            }
        });
        return guestList;
    }

    public void acceptInvitation(Long id, Long invitationId) {
        Invitation invitation;
        Optional<Invitation> savedInvitation = invitationRepository.findById(invitationId);
        if(!savedInvitation.isPresent()){
            throw new UnknownInvitationException(invitationId);
        } else {
            invitation = savedInvitation.get();
            if(invitation.getGuest().getId() != id){
                throw new UnknownGuestException(invitation.getGuest().getId());
            }

        }
        invitation.setInvitationStatus(InvitationStatus.APPROVED);
        invitationRepository.save(invitation);

    }

}
