package com.isep.hpah.core.character;
import lombok.*;

import java.util.Map;

@Getter @Setter
public abstract class AbstractEnemy {
    private String name;
    private int maxhealth;
    private int currenthealth;
    private int damage;
    private double accuracy;

    public AbstractEnemy(String name, int maxhealth, int currenthealth, int damage, double accuracy) {
        this.name = name;
        this.maxhealth = maxhealth;
        this.currenthealth = currenthealth;
        this.damage = damage;
        this.accuracy = accuracy;
    }

    public void takeDamage(int damage) {
        int healthAfterDamage = this.currenthealth - damage;
        this.currenthealth = Math.max(healthAfterDamage, 0);
    }

    @Override
    public String toString() {
        return "You will have to fight against " + name + " which has a health of " + maxhealth + "\n";
    }

}
