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
        super("Troll", 45, 3, 100, 1, 1);
        enemies = new ArrayList<>();
        enemies.add(new AbstractEnemy("Troll", 45, 3, 0.7, 1, 1));
        enemies.add(new AbstractEnemy("Basilisk", 60, 6, 0.9, 1, 1));
        enemies.add(new AbstractEnemy("Dementor", 30, 3, 0.6, 1, 5));
        enemies.add(new AbstractEnemy("Death Eaters", 20, 3, 0.8, 1, 10));
    }
}