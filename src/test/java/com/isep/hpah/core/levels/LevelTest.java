package com.isep.hpah.core.levels;

import com.isep.hpah.core.character.AbstractEnemy;
import com.isep.hpah.core.character.Enemy;
import com.isep.hpah.core.character.Boss;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LevelTest {

    private Level level;
    private AbstractEnemy enemy1;
    private AbstractEnemy enemy2;

    @BeforeEach
    void setUp() {
        enemy1 = new Enemy();
        enemy2 = new Boss();
        level = new Level(1, "The Philosopher’s Stone", "Toilets of the dungeon",
                Arrays.asList(enemy1, enemy2), "Test Description");
    }

    @Test
    void createLevel_withValidId_returnLevel() {
        Level level = Level.createLevel(1);
        assertEquals("The Philosopher’s Stone", level.getName());
        assertEquals("Toilets of the dungeon", level.getPlace());
        assertEquals(1, level.getId());
        assertEquals(1, level.getNumberOfEnemies());
    }

    @Test
    void getNumberOfEnemies_withMultipleEnemies_returnNumberOfEnemies() {
        assertEquals(2, level.getNumberOfEnemies());
    }

    @Test
    void getEnemies_withMultipleEnemies_returnEnemiesList() {
        List<AbstractEnemy> enemies = level.getEnemies();
        assertEquals(enemy1, enemies.get(0));
        assertEquals(enemy2, enemies.get(1));
    }

    @Test
    void getDescription_withValidDescription_returnDescription() {
        assertEquals("Test Description", level.getDescription());
    }
}