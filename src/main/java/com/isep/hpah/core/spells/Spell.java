package com.isep.hpah.core.spells;

public class Spell {
    private String name;
    private String description;
    private int damage;

    public Spell(String name, String description, int damage) {
        this.name = name;
        this.description = description;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDamage() {
        return damage;
    }
}
