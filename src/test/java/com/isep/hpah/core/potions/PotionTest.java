package com.isep.hpah.core.potions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PotionTest {

    @Test
    void isUsed() {
        Potion potion = new Potion("Health Potion", 10);
        assertFalse(potion.isUsed());
        potion.setUsed(true);
        assertTrue(potion.isUsed());
    }

    @Test
    void getName() {
        Potion potion = new Potion("Health Potion", 10);
        assertEquals("Health Potion", potion.getName());
    }

    @Test
    void getHealthgain() {
        Potion potion = new Potion("Health Potion", 10);
        assertEquals(10, potion.getHealthgain());
    }

    @Test
    void setName() {
        Potion potion = new Potion("Health Potion", 10);
        potion.setName("Mana Potion");
        assertEquals("Mana Potion", potion.getName());
    }

    @Test
    void setHealthgain() {
        Potion potion = new Potion("Health Potion", 10);
        potion.setHealthgain(5);
        assertEquals(5, potion.getHealthgain());
    }

    @Test
    void setUsed() {
        Potion potion = new Potion("Health Potion", 10);
        potion.setUsed(true);
        assertTrue(potion.isUsed());
    }
}