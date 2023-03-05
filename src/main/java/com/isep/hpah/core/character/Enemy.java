package com.isep.hpah.core.character;

public class Enemy {
    private String name;
    private int health;
    private int number_of_enemies;

    public Enemy(String name, int health, int number_of_enemies) {
        this.name = name;
        this.health = health;
        this.number_of_enemies = number_of_enemies;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getNumber_of_enemies() {
        return number_of_enemies;
    }
}
