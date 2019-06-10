package com.edgenda.bnc.skillsmanager.model;

public enum InvitationStatus {

    CREATED("Created"),
    SENT("Sent"),
    APPROVED("Approved"),
    REJECTED("Rejected");

    private String value;

    InvitationStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
