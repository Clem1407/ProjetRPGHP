package com.isep.hpah.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseTest {

    @Test
    void getName() {
        House house = new House("Gryffindor", "Values bravery, daring, nerve, and chivalry", "Godric Gryffindor");
        assertEquals("Gryffindor", house.getName());
    }

    @Test
    void getDescription() {
        House house = new House("Hufflepuff", "Values hard work, patience, justice, and loyalty", "Helga Hufflepuff");
        assertEquals("Values hard work, patience, justice, and loyalty", house.getDescription());
    }

    @Test
    void getFounder() {
        House house = new House("Slytherin", "Values ambition, cunning, leadership, and resourcefulness", "Salazar Slytherin");
        assertEquals("Salazar Slytherin", house.getFounder());
    }

    @Test
    void setName() {
        House house = new House("Ravenclaw", "Values intelligence, creativity, learning, and wit", "Rowena Ravenclaw");
        house.setName("New name");
        assertEquals("New name", house.getName());
    }

    @Test
    void setDescription() {
        House house = new House("Gryffindor", "Values bravery, daring, nerve, and chivalry", "Godric Gryffindor");
        house.setDescription("New description");
        assertEquals("New description", house.getDescription());
    }

    @Test
    void setFounder() {
        House house = new House("Slytherin", "Values ambition, cunning, leadership, and resourcefulness", "Salazar Slytherin");
        house.setFounder("New founder");
        assertEquals("New founder", house.getFounder());
    }
}