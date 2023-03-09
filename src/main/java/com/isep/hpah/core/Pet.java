package com.isep.hpah.core;

import lombok.Getter;
import lombok.Setter;

public enum Pet {
    OWL("OWL"),
    RAT("RAT"),
    CAT("CAT"),
    TOAD("TOAD"),
    DOG("DOG"),
    HIPPOGRIFF("HIPPOGRIFF"),
    SNAKE("SNAKE");
    @Getter @Setter
    private String name;
    Pet(String name) {
        this.name = name;
    }
}
