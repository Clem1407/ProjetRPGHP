package com.isep.hpah.core.character;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractEnemyTest {

    @Test
    void takeDamage() {
        AbstractEnemy enemy = new DummyEnemy();
        int initialHealth = enemy.getCurrenthealth();
        int damage = 10;
        enemy.takeDamage(damage);
        assertEquals(initialHealth - damage, enemy.getCurrenthealth());
    }

    @Test
    void testToString() {
        AbstractEnemy enemy = new DummyEnemy();
        String expectedString = "You will have to fight against " + enemy.getName() + " which has a health of " + enemy.getMaxhealth() + "\n";
        assertEquals(expectedString, enemy.toString());
    }

    private class DummyEnemy extends AbstractEnemy {
        public DummyEnemy() {
            super("DummyEnemy", 100, 100, 10, 0.5);
        }
    }

    @Test
    void testGetName() {
        // Given
        AbstractEnemy enemy = new DummyEnemy();

        // When
        String name = enemy.getName();

        // Then
        assertEquals("DummyEnemy", name);
    }

    @Test
    void testGetMaxhealth() {
        // Given
        AbstractEnemy enemy = new DummyEnemy();

        // When
        int maxHealth = enemy.getMaxhealth();

        // Then
        assertEquals(100, maxHealth);
    }

    @Test
    void testGetCurrenthealth() {
        // Given
        AbstractEnemy enemy = new DummyEnemy();

        // When
        int currentHealth = enemy.getCurrenthealth();

        // Then
        assertEquals(100, currentHealth);
    }

    @Test
    void testGetDamage() {
        // Given
        AbstractEnemy enemy = new DummyEnemy();

        // When
        int damage = enemy.getDamage();

        // Then
        assertEquals(10, damage);
    }

    @Test
    void testGetAccuracy() {
        // Given
        AbstractEnemy enemy = new DummyEnemy();

        // When
        double accuracy = enemy.getAccuracy();

        // Then
        assertEquals(0.5, accuracy);
    }

    @Test
    void testSetName() {
        // Given
        AbstractEnemy enemy = new DummyEnemy();

        // When
        enemy.setName("NewEnemy");

        // Then
        assertEquals("NewEnemy", enemy.getName());
    }

    @Test
    void testSetMaxhealth() {
        // Given
        AbstractEnemy enemy = new DummyEnemy();

        // When
        enemy.setMaxhealth(200);

        // Then
        assertEquals(200, enemy.getMaxhealth());
    }

    @Test
    void testSetCurrenthealth() {
        // Given
        AbstractEnemy enemy = new DummyEnemy();

        // When
        enemy.setCurrenthealth(50);

        // Then
        assertEquals(50, enemy.getCurrenthealth());
    }

    @Test
    void testSetDamage() {
        // Given
        AbstractEnemy enemy = new DummyEnemy();

        // When
        enemy.setDamage(20);

        // Then
        assertEquals(20, enemy.getDamage());
    }

    @Test
    void testSetAccuracy() {
        // Given
        AbstractEnemy enemy = new DummyEnemy();

        // When
        enemy.setAccuracy(0.9);

        // Then
        assertEquals(0.9, enemy.getAccuracy());
    }
}