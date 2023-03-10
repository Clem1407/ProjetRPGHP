package com.isep.hpah.core;

import lombok.Getter;
import lombok.Setter;

//création d'une classe niveau pour simplification du programme
@Getter  @Setter
public class AbstractLevel {
    private int id;
    private String name;
    private String place;
    private String enemy;
    private String description;

    public AbstractLevel(int id,String name, String place, String enemy, String description) {
        this.name = name;
        this.id = id;
        this.place = place;
        this.enemy = enemy;
        this.description = description;
    }

}