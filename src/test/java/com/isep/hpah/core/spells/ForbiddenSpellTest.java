package com.isep.hpah.core.spells;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForbiddenSpellTest {

    @Test
    void getForbiddenSpells() {
        List<Spell> spells = ForbiddenSpell.getForbiddenSpells();
        assertNotNull(spells);
        assertFalse(spells.isEmpty());
        assertEquals(2, spells.size());
    }
}