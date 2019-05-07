package com.edgenda.bnc.skillsmanager.model;

import com.edgenda.bnc.skillsmanager.model.Guest;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @ManyToMany
    @JoinTable(name = "GUEST_LIST")
    private List<Guest> guests;

    public Event() {
    }

    public Event(Long id, String name, String description, List<Guest> guests) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.guests = guests;
    }

    @PersistenceConstructor
    public Event(String name, String description, List<Guest> guests) {
        this.name = name;
        this.description = description;
        this.guests = guests;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Guest> getGuests() {
        return guests;
    }
}