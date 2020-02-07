package com.auth0.trf.util;

public enum Roles {
    IELTS_ADMINISTRATOR("IELTS Administrator"),
    IELTS_SUPPORT("IELTS Support"),
    IELTS_USER("IELTS User"),
    RO_ADMINISTRATOR("RO Administrator");

    private String name;

    Roles(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
