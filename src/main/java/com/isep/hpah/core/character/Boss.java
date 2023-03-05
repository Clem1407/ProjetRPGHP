package com.isep.hpah.core.character;

public class Boss {
    private String name;
    private int health;

    public Boss(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
}
