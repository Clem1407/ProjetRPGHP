package com.isep.hpah.core;
import com.isep.hpah.core.character.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Level extends AbstractLevel {
    private List<AbstractLevel> level;

    public Level() {
        super(1, "The Philosopher’s Stone", "Toilets of the dungeon", enemy.getEnemy().get(0), "You have to face the evil Troll who is in the toilet next to the Dungeon. To defeat him\n" +
                "defeat him, you must lift objects and release them when they are above his head.");
        level = new ArrayList<>();
        //Création des niveaux en utilisant la liste des enemies dans la classe Enemy et Boss
        level.add(new Level(1, "The Philosopher’s Stone", "Toilets of the dungeon", enemy.getEnemy().get(0), "You have to face the evil Troll who is in the toilet next to the Dungeon. To defeat him\n" +
                "defeat him, you must lift objects and release them when they are above his head.");
    }
}