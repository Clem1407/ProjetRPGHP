package com.isep.hpah.core;
//création d'une classe niveau pour simplification du programme
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

    public int getID() {
        return id;
    }

    public String getPlace() {
        return place;
    }

    public String getEnemy() {
        return enemy;
    }

    public String getDescription() {
        return description;
    }
}
