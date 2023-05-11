package com.isep.hpah.core.levels;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.isep.hpah.core.character.AbstractEnemy;

class AbstractLevelTest {

    private AbstractLevel level;
    private int id = 1;
    private String name = "Test Level";
    private String place = "Test Place";
    private List<AbstractEnemy> enemies = new ArrayList<>();
    private String description = "Test Description";

    @BeforeEach
    void setUp() {
        level = new AbstractLevel(id, name, place, enemies, description) {
            // Une classe anonyme pour tester la classe abstraite
        };
    }

    @Test
    void testGetters() {
        assertEquals(id, level.getId());
        assertEquals(name, level.getName());
        assertEquals(place, level.getPlace());
        assertEquals(enemies, level.getEnemies());
        assertEquals(description, level.getDescription());
    }

    @Test
    void testSetters() {
        int newId = 2;
        String newName = "New Test Level";
        String newPlace = "New Test Place";
        List<AbstractEnemy> newEnemies = new ArrayList<>();
        String newDescription = "New Test Description";

        level.setId(newId);
        level.setName(newName);
        level.setPlace(newPlace);
        level.setEnemies(newEnemies);
        level.setDescription(newDescription);

        assertEquals(newId, level.getId());
        assertEquals(newName, level.getName());
        assertEquals(newPlace, level.getPlace());
        assertEquals(newEnemies, level.getEnemies());
        assertEquals(newDescription, level.getDescription());
    }
}