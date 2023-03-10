package com.isep.hpah.core.character;
import lombok.*;

@Getter @Setter
public class AbstractEnemy {
    private String name;
    private int health;
    private int damage;
    private double accuracy;
    private double resistance;
    private int number_of_enemies;

    public AbstractEnemy(String name, int health, int damage, double accuracy, double resistance, int number_of_enemies) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.accuracy = accuracy;
        this.resistance = resistance;
        this.number_of_enemies = number_of_enemies;
    }
}
