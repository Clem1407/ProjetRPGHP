package com.isep.hpah.core;

import lombok.Getter;
import lombok.Setter;

//création d'une classe niveau pour simplification du programme
@Getter  @Setter
public class Level {
    private int id;
    private String place;
    private String enemy;
    private String description;

    public Level(int id, String place, String enemy, String description) {
        this.id = id;
        this.place = place;
        this.enemy = enemy;
        this.description = description;
    }

}
