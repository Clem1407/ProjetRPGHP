package com.isep.hpah.core;
import java.util.ArrayList;
import java.util.List;
public class Potion {
    private String name;
    private int healthgain;

    public Potion(String name, int healthgain) {
        this.name = name;
        this.healthgain = healthgain;
    }

    public String getName() {
        return name;
    }

    public int getHealthgain() {
        return healthgain;
    }
}
