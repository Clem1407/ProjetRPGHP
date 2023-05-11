package com.isep.hpah.core;
import com.isep.hpah.core.character.Wizard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SortingHatTest {

    @Test
    void assignHouse() {
        Core core = null;
        Pet pet = null;
        SortingHat hat = new SortingHat();
        Wizard wizard = new Wizard("Joseph", pet, new Wand(core, 10), null, new ArrayList<>(),  100, 100, 3, 0, 0);
        hat.assignHouse(wizard);
        assertNotNull(wizard.getHouse());
    }

}