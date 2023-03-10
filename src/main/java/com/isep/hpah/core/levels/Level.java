package com.isep.hpah.core.levels;
import com.isep.hpah.core.character.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

import com.isep.hpah.core.spells.Spell;
import lombok.*;

@Getter @Setter
public class Level extends AbstractLevel {
    private List<AbstractLevel> level;


    public Level() {
        super(1, "The Philosopher’s Stone", "Toilets of the dungeon", null, "You have to face the evil Troll who is in the toilet next to the Dungeon. To defeat him\n" +
                "defeat him, you must lift objects and release them when they are above his head.");

        Enemy enemy = new Enemy();
        Boss boss = new Boss();

        //liste des enemies appelées de la classe Enemy
        AbstractEnemy Troll = enemy.getEnemies().get(0);
        AbstractEnemy Basilisk = enemy.getEnemies().get(1);
        AbstractEnemy Dementor = enemy.getEnemies().get(2);
        AbstractEnemy Peter_Pettigrew = enemy.getEnemies().get(3);
        AbstractEnemy Death_Eaters = enemy.getEnemies().get(4);
        AbstractEnemy Voldemort = boss.getBoss().get(0);
        AbstractEnemy Dolores = boss.getBoss().get(1);
        AbstractEnemy Bellatrix = boss.getBoss().get(2);

        level = new ArrayList<>();

        List<AbstractEnemy> enemiesLevel1 = new ArrayList<>();
        enemiesLevel1.add(Troll);
        //Création des niveaux en utilisant la liste des enemies dans la classe Enemy et Boss
        level.add(new AbstractLevel(1, "The Philosopher’s Stone", "Toilets of the dungeon", enemiesLevel1, "You have to face the evil Troll who is in the toilet next to the Dungeon. To defeat him\n" +
                "defeat him, you must lift objects and release them when they are above his head."));

        List<AbstractEnemy> enemiesLevel2 = new ArrayList<>();
        enemiesLevel2.add(Basilisk);
        level.add(new AbstractLevel(2, "The Chamber of Secrets", "Chamber of secrets", enemiesLevel2, "You are facing the terrible basilisk. If you are from Griffondor, " +
                "you can call upon the legendary sword of\n" +
                "Godric Gryffindor's legendary sword to strike him down. Otherwise, you'll have to rip out one of its fangs and use it to destroy\n" +
                "and use it to destroy Tom Jedusor's diary."));

        List<AbstractEnemy> enemiesLevel3 = new ArrayList<>();
        enemiesLevel3.add(Dementor);
        level.add(new AbstractLevel(3, "The Prisonner of Azkaban", "Lake of the Forbidden Forest", enemiesLevel3,
                "The Detractors are on the loose. They roam the streets, the countryside. Fortunately, you've\n" +
                        "heard about a spell to put them to flight... Expect... Expecta... Ah yes, Expectro Patronum.\n" +
                        "Your goal is to learn the spell, then use it to defeat the Destroyers."));

        List<AbstractEnemy> enemiesLevel4 = new ArrayList<>();
        enemiesLevel4.add(Voldemort);
        enemiesLevel4.add(Peter_Pettigrew);
        level.add(new AbstractLevel(4, "The Goblet of Fire", "Little Hangleton's Cemetery", enemiesLevel4,
                "Unfortunately, you won the Three Wizards Tournament... and the right to die. You are in a cemetery\n" +
                        "in a graveyard, where Voldemort and Peter Pettigrew are also. Your only chance to escape is to\n" +
                        "to get close to the Portkey and lure him to you (Accio!). Don't worry, you'll see\n" +
                        "Voldemort"));

        List<AbstractEnemy> enemiesLevel5 = new ArrayList<>();
        enemiesLevel5.add(Dolores);
        level.add(new AbstractLevel(5, "The Order of the Phenix", "Hogwarts Examination Hall", enemiesLevel5,
                "It's time for the BUSE (Universal Certificate of Elementary Witchcraft)! Dolores Umbridge is watching over\n" +
                        "the grain. Your goal is to distract her until the fireworks are ready to be used."));

        List<AbstractEnemy> enemiesLevel6 = new ArrayList<>();
        enemiesLevel6.add(Death_Eaters);
        level.add(new AbstractLevel(6, "The Half-Blood Prince", "Astronomy tower", enemiesLevel6,
                "The Death Eaters are attacking Hogwarts. Are you ready to defend yourself? You must attack them\n" +
                        "from the front (Sectumsempra). If you are a Slytherin, you may decide to join the ranks of the\n" +
                        "Death Eaters."));

        List<AbstractEnemy> enemiesLevel7 = new ArrayList<>();
        enemiesLevel7.add(Voldemort);
        enemiesLevel7.add(Bellatrix);
        level.add(new AbstractLevel(7, "The Deathly Hallows", "Poudlard", enemiesLevel7,
                        "Let's stop stalling and get to the root of the problem. You are facing Voldemort and\n" +
                        "Bellatrix Lestrange. Be careful, they can kill you with Avada Kedavra at once if you are not\n" +
                        "are not ready."));

    }

    public List<AbstractLevel> getLevels() {
        return level;
    }

    public void runLevel(Level level) {
        System.out.println("Hello, this is level number " + this.getId() + "which is called " + this.getName() +
                " \n this level takes place in " + this.getPlace() + " you have to fight against " + this.getEnemy() +
                " \n" + this.getDescription());
    }

}