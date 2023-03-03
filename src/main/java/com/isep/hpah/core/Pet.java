package com.isep.hpah.core;

public enum Pet {
    OWL("OWL"),
    RAT("RAT"),
    CAT("CAT"),
    TOAD("TOAD"),
    DOG("DOG"),
    HIPPOGRIFF("HIPPOGRIFF"),
    SNAKE("SNAKE");

    private String name;
    Pet(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
