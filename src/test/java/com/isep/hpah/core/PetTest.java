package com.isep.hpah.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    @Test
    void getName() {
        Pet pet = Pet.OWL;
        assertEquals("OWL", pet.getName());
    }

    @Test
    void setName() {
        Pet pet = Pet.RAT;
        pet.setName("NEW_NAME");
        assertEquals("NEW_NAME", pet.getName());
    }

    @Test
    void values() {
        Pet[] pets = Pet.values();
        assertEquals(7, pets.length);
        assertArrayEquals(new Pet[] {Pet.OWL, Pet.RAT, Pet.CAT, Pet.TOAD, Pet.DOG, Pet.HIPPOGRIFF, Pet.SNAKE}, pets);
    }

    @Test
    void valueOf() {
        Pet pet = Pet.valueOf("OWL");
        assertEquals(Pet.OWL, pet);

        assertThrows(IllegalArgumentException.class, () -> {
            Pet pet2 = Pet.valueOf("INVALID_PET");
        });
    }
}