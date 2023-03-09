package com.isep.hpah.core.spells;
import lombok.*;
@Getter @Setter

public class Spell {
    private String name;
    private String description;
    private int damage;

    public Spell(String name, String description, int damage) {
        this.name = name;
        this.description = description;
        this.damage = damage;
    }

}
