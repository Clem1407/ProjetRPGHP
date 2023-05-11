package com.isep.hpah.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoreTest {

    @Test
    void getName() {
        assertEquals("Phoenix feather", Core.PHOENIX_FEATHER.getName());
    }

    @Test
    void setName() {
        Core.PHOENIX_FEATHER.setName("new name");
        assertEquals("new name", Core.PHOENIX_FEATHER.getName());
    }
}