package com.isep.hpah.core.potions;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PotionRepositoryTest {

    @Test
    void getPotions() {
        // Arrange
        PotionRepository potionRepository = new PotionRepository();

        // Act
        List<Potion> potions = potionRepository.getPotions();

        // Assert
        assertNotNull(potions);
        assertEquals(3, potions.size());
        assertEquals("Amortentia", potions.get(0).getName());
        assertEquals(20, potions.get(0).getHealthgain());
        assertFalse(potions.get(0).isUsed());
    }
}