package com.edgenda.bnc.skillsmanager.model;

public enum EventStatus {

    ACTIVE("Active"),
    LIVE("Live"),
    CANCELLED("Cancelled");


    private String value;

    EventStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
