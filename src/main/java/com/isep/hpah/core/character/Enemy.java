package com.isep.hpah.core.character;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Enemy extends AbstractEnemy {
    private List<AbstractEnemy> enemies;

    public Enemy() {
        super("Troll", 45, 3, 100, 1, 1);
        enemies = new ArrayList<>();
        enemies.add(new AbstractEnemy("Troll", 45, 3, 100, 1, 1));
        enemies.add(new AbstractEnemy("Basilisk", 60, 6, 100, 1, 1));
        enemies.add(new AbstractEnemy("Dementor", 30, 3, 100, 1, 5));
        enemies.add(new AbstractEnemy("Peter Pettigrew", 40, 5, 100, 1, 1));
        enemies.add(new AbstractEnemy("Death Eaters", 20, 3, 100, 1, 10));
    }

}
