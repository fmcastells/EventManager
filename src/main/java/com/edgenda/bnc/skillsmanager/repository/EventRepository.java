package com.edgenda.bnc.skillsmanager.repository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.edgenda.bnc.skillsmanager.model.Event;

import com.edgenda.bnc.skillsmanager.model.EventStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>, CrudRepository<Event, Long> {

    Optional<Event> findById(Long id);

    @Query("SELECT event FROM Event event WHERE event.startDate between :from and :to")
    List<Event> findByPeriod(@Param("from") Instant from, @Param("to") Instant to);

    List<Event> findByStartDateGreaterThanEqualAndEndDateLessThanEqualAndEventStatus(Instant startDate, Instant endDate, EventStatus eventStatus);
}
