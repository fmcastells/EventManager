package com.edgenda.bnc.skillsmanager.repository;

import com.edgenda.bnc.skillsmanager.model.Guest;
import com.edgenda.bnc.skillsmanager.model.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long>, CrudRepository<Guest, Long> {

    Optional<Guest> findById(Long id);

    @Query("SELECT guest FROM Guest guest JOIN guest.events events WHERE events.id = ?1")
    List<Guest> findByEventId(Long eventid);


    @Query("SELECT guest FROM Guest guest JOIN guest.invitations invitation WHERE invitation.guestId = ?1")
    List<Invitation> findInvitationByGuest(Long guestId);
}
