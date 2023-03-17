package com.isep.hpah.core.character;
import lombok.*;

@Getter @Setter
public abstract class AbstractEnemy {
    private String name;
    private int maxhealth;
    private int currenthealth;
    private int damage;
    private double accuracy;
    private double resistance;
    private int number_of_enemies;

    public AbstractEnemy(String name, int maxhealth, int currenthealth, int damage, double accuracy, double resistance, int number_of_enemies) {
        this.name = name;
        this.maxhealth = maxhealth;
        this.currenthealth = currenthealth;
        this.damage = damage;
        this.accuracy = accuracy;
        this.resistance = resistance;
        this.number_of_enemies = number_of_enemies;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currenthealth = currentHealth;
    }

    public void takeDamage(int damage) {
        int healthAfterDamage = this.currenthealth - damage;
        this.currenthealth = Math.max(healthAfterDamage, 0);
    }

}
