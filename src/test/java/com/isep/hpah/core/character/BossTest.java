package com.isep.hpah.core.character;
import java.util.List;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BossTest {

    @Test
    void getBoss() {
        Boss boss = new Boss();
        List<AbstractEnemy> bossList = boss.getBoss();
        assertNotNull(bossList);
        assertEquals(4, bossList.size());
    }

    @Test
    void setBoss() {
        Boss boss = new Boss();
        List<AbstractEnemy> newBossList = new ArrayList<>();
        newBossList.add(new Boss("Lucius Malfoy", 150, 150, 12, 0.7));
        newBossList.add(new Boss("Severus Snape", 200, 200, 15, 0.8));
        boss.setBoss(newBossList);
        assertEquals(newBossList, boss.getBoss());
    }
}