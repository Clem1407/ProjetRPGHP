package com.isep.hpah.core.character;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {

    private Enemy enemy;

    @BeforeEach
    void setUp() {
        enemy = new Enemy();
    }

    @Test
    void getEnemies() {
        List<AbstractEnemy> expectedEnemies = new ArrayList<>();
        expectedEnemies.add(new Enemy("Troll", 45, 45, 5, 0.7));
        expectedEnemies.add(new Enemy("Basilisk", 60, 60, 6, 0.9));
        expectedEnemies.add(new Enemy("Dementor", 30, 30, 3, 0.6));
        expectedEnemies.add(new Enemy("Death Eaters", 20, 20, 3, 0.8));
        assertEquals(expectedEnemies, enemy.getEnemies(), "The list of enemies should match the expected list");
    }

    @Test
    void setEnemies() {
        List<AbstractEnemy> newEnemies = new ArrayList<>();
        newEnemies.add(new Enemy("Giant Spider", 50, 50, 7, 0.8));
        newEnemies.add(new Enemy("Werewolf", 40, 40, 5, 0.7));

        enemy.setEnemies(newEnemies);

        assertEquals(newEnemies, enemy.getEnemies(), "The list of enemies should match the newly set list");
    }
}