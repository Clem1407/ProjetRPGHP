package com.isep.hpah.core.potions;
import java.util.ArrayList;
import java.util.List;
import lombok.*;
@Getter @Setter

public class Potion {
    private String name;
    private int healthgain;

    public Potion(String name, int healthgain) {
        this.name = name;
        this.healthgain = healthgain;
    }

}
