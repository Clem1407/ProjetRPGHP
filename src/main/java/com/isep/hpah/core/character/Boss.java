package com.isep.hpah.core.character;
import lombok.*;
@Getter @Setter
public class Boss {
    private String name;
    private int health;

    public Boss(String name, int health) {
        this.name = name;
        this.health = health;
    }

}
