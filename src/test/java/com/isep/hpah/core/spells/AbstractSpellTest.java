package com.isep.hpah.core.spells;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractSpellTest {

    @Test
    void testGetName() {
        AbstractSpell spell = new MockSpell("Test Spell", "A test spell", 20, 0.8);
        assertEquals("Test Spell", spell.getName());
    }

    @Test
    void testGetDescription() {
        AbstractSpell spell = new MockSpell("Test Spell", "A test spell", 20, 0.8);
        assertEquals("A test spell", spell.getDescription());
    }

    @Test
    void testGetDamage() {
        AbstractSpell spell = new MockSpell("Test Spell", "A test spell", 20, 0.8);
        assertEquals(20, spell.getDamage());
    }

    @Test
    void testGetAccuracy() {
        AbstractSpell spell = new MockSpell("Test Spell", "A test spell", 20, 0.8);
        assertEquals(0.8, spell.getAccuracy());
    }

    @Test
    void testSetName() {
        AbstractSpell spell = new MockSpell("Test Spell", "A test spell", 20, 0.8);
        spell.setName("New Spell Name");
        assertEquals("New Spell Name", spell.getName());
    }

    @Test
    void testSetDescription() {
        AbstractSpell spell = new MockSpell("Test Spell", "A test spell", 20, 0.8);
        spell.setDescription("New Spell Description");
        assertEquals("New Spell Description", spell.getDescription());
    }

    @Test
    void testSetDamage() {
        AbstractSpell spell = new MockSpell("Test Spell", "A test spell", 20, 0.8);
        spell.setDamage(30);
        assertEquals(30, spell.getDamage());
    }

    @Test
    void testSetAccuracy() {
        AbstractSpell spell = new MockSpell("Test Spell", "A test spell", 20, 0.8);
        spell.setAccuracy(0.9);
        assertEquals(0.9, spell.getAccuracy());
    }

    // Test class to use for testing AbstractSpell
    private static class MockSpell extends AbstractSpell {
        public MockSpell(String name, String description, int damage, double accuracy) {
            super(name, description, damage, accuracy);
        }
    }
}