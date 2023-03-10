package com.isep.hpah.core;

import lombok.Getter;
import lombok.Setter;

public enum Core {
    PHOENIX_FEATHER("Phoenix feather"),
    DRAGON_HEARTSTRING("Dragon heartstring"),
    UNICORN_TAIL_HAIR("Unicorn tail hair"),
    VEELA_HAIR("Veela hair"),
    THESTRAL_TAIL_HAIR("Thestral tail hair"),
    TROLL_WHISKER("Troll whisker");
    @Getter @Setter
    private String name;
    Core(String name) {
        this.name = name;
    }

}

