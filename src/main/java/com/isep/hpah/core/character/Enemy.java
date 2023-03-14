package com.isep.hpah.core.character;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Enemy extends AbstractEnemy {
    private List<AbstractEnemy> enemies;

    public Enemy() {
        super("Troll", 45, 45, 3, 100, 1, 1);
        enemies = new ArrayList<>();
        enemies.add(new Enemy("Troll", 45, 45, 3, 0.7, 1, 1));
        enemies.add(new Enemy("Basilisk", 60, 60, 6, 0.9, 1, 1));
        enemies.add(new Enemy("Dementor", 30, 30, 3, 0.6, 1, 5));
        enemies.add(new Enemy("Death Eaters", 20, 20, 3, 0.8, 1, 10));
    }

    public Enemy(String name, int maxhealth, int currenthealth, int damage, double accuracy, double resistance, int number_of_enemies) {
        super(name, maxhealth, currenthealth, damage, accuracy, resistance, number_of_enemies);
    }


}