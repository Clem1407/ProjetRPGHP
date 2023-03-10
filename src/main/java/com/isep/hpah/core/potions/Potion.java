package com.isep.hpah.core.potions;
import java.util.ArrayList;
import java.util.List;
import lombok.*;
@Getter @Setter

public class Potion {
    private String name;
    private int healthgain;
    private boolean used; // Indique si la potion a été utilisé ou non

    public Potion(String name, int healthgain) {
        this.name = name;
        this.healthgain = healthgain;
        this.used = false; // Initialisation de used à false par défaut
    }

    public boolean isUsed() {
        return used;
    }

}
