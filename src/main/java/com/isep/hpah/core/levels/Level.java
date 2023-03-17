package com.isep.hpah.core.levels;
import com.isep.hpah.core.character.*;
import com.isep.hpah.core.*;

import java.util.Arrays;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

import com.isep.hpah.core.spells.Spell;
import lombok.*;

import static com.isep.hpah.core.PrettyText.printSeparator;

@Getter @Setter
public class Level extends AbstractLevel {
    private List<AbstractEnemy> enemies;

    public Level(int id, String name, String place, List<AbstractEnemy> enemies, String description) {
        super(id, name, place, enemies, description);
        this.enemies = enemies;
    }

    public static Level createLevel(int id) {
        Enemy enemy = new Enemy();
        Boss boss = new Boss();

        // list of enemies called from the classes Enemy and Boss
        AbstractEnemy Troll = enemy.getEnemies().get(0);
        AbstractEnemy Basilisk = enemy.getEnemies().get(1);
        AbstractEnemy Dementor = enemy.getEnemies().get(2);
        AbstractEnemy Death_Eaters = enemy.getEnemies().get(3);
        AbstractEnemy Peter_Pettigrew = boss.getBoss().get(0);
        AbstractEnemy Voldemort = boss.getBoss().get(1);
        AbstractEnemy Dolores = boss.getBoss().get(2);
        AbstractEnemy Bellatrix = boss.getBoss().get(3);


        List<Level> levels = new ArrayList<>();

        //Création des niveaux en utilisant la liste des enemies dans la classe Enemy et Boss
        levels.add(new Level(1, "The Philosopher’s Stone", "Toilets of the dungeon", Arrays.asList(Troll), "You have to face the evil Troll who is in the toilet next to the Dungeon. To defeat him\n" +
                "defeat him, you must lift objects and release them when they are above his head."));

        levels.add(new Level(2, "The Chamber of Secrets", "Chamber of secrets", Arrays.asList(Basilisk), "You are facing the terrible basilisk. If you are from Griffondor, " +
                "you can call upon the legendary sword of\n" +
                "Godric Gryffindor's legendary sword to strike him down. Otherwise, you'll have to rip out one of its fangs and use it to destroy\n" +
                "and use it to destroy Tom Jedusor's diary."));

        levels.add(new Level(3, "The Prisonner of Azkaban", "Lake of the Forbidden Forest", Arrays.asList(Dementor),
                "The Detractors are on the loose. They roam the streets, the countryside. Fortunately, you've\n" +
                        "heard about a spell to put them to flight... Expect... Expecta... Ah yes, Expectro Patronum.\n" +
                        "Your goal is to learn the spell, then use it to defeat the Destroyers."));

        levels.add(new Level(4, "The Goblet of Fire", "Little Hangleton's Cemetery", Arrays.asList(Voldemort, Peter_Pettigrew),
                "Unfortunately, you won the Three Wizards Tournament... and the right to die. You are in a cemetery\n" +
                        "in a graveyard, where Voldemort and Peter Pettigrew are also. Your only chance to escape is to\n" +
                        "to get close to the Portkey and lure him to you (Accio!). Don't worry, you'll see\n" +
                        "Voldemort"));

        levels.add(new Level(5, "The Order of the Phenix", "Hogwarts Examination Hall", Arrays.asList(Dolores),
                "It's time for the BUSE (Universal Certificate of Elementary Witchcraft)! Dolores Umbridge is watching over\n" +
                        "the grain. Your goal is to distract her until the fireworks are ready to be used."));

        levels.add(new Level(6, "The Half-Blood Prince", "Astronomy tower", Arrays.asList(Death_Eaters),
                "The Death Eaters are attacking Hogwarts. Are you ready to defend yourself? You must attack them\n" +
                        "from the front (Sectumsempra). If you are a Slytherin, you may decide to join the ranks of the\n" +
                        "Death Eaters."));

        levels.add(new Level(7, "The Deathly Hallows", "Poudlard", Arrays.asList(Voldemort, Bellatrix),
                        "Let's stop stalling and get to the root of the problem. You are facing Voldemort and\n" +
                        "Bellatrix Lestrange. Be careful, they can kill you with Avada Kedavra at once if you are not\n" +
                        "are not ready."));
        return levels.get(id);
    }

    public int getNumberOfEnemies() {
        return enemies.size();
    }

    public static void runLevel(int id, Wizard wizard) {
        Level level = Level.createLevel(id);
        int numberOfEnemies = level.getNumberOfEnemies();
        System.out.println("This is level number : " + Level.createLevel(id).getId() +
                "\nIt is : " + Level.createLevel(id).getName() + ", " + Level.createLevel(id).getDescription() +
                "\nand it takes place in : " + Level.createLevel(id).getPlace());
        if (numberOfEnemies == 1) {
            System.out.println("There is " + numberOfEnemies + " enemy" );
        }
        else if (numberOfEnemies > 1) {
            System.out.println("There is " + numberOfEnemies + " enemies");
        }
        //va permettre de faire ressortir les enemies sous forme de String et pas de tableau
        List<AbstractEnemy> enemies = Level.createLevel(id).getEnemies();
        for (AbstractEnemy enemy : enemies) {
            System.out.println(enemy.toString());
            printSeparator(100);
            wizard.startBattle(enemy);
        }
        wizard.setYear(wizard.getYear() + 1);
    }


}