package com.isep.hpah.core.levels;
import com.isep.hpah.core.character.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import lombok.*;

import static com.isep.hpah.core.PrettyText.clearConsole;
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
                "you must lift objects and release them when they are above his head."));

        levels.add(new Level(2, "The Chamber of Secrets", "Chamber of secrets", Arrays.asList(Basilisk), "You are facing the terrible basilisk. If you are from Griffondor, " +
                "you can call upon the legendary sword of\n" +
                "Godric Gryffindor's legendary sword to strike him down. Otherwise, you'll have to rip out one of its fangs and use it to destroy\n" +
                "and use it to destroy Tom Jedusor's diary."));

        levels.add(new Level(3, "The Prisonner of Azkaban", "Lake of the Forbidden Forest", Arrays.asList(Dementor),
                "The Detractors are on the loose. They roam the streets, the countryside. Fortunately, you've\n" +
                        "heard about a spell to put them to flight... Expect... Expecta... Ah yes, Expectro Patronum.\n" +
                        "Your goal is to learn the spell, then use it to defeat the Destroyers."));

        // Ajouter les informations sur Voldemort et Peter Pettigrew dans la description du niveau 4
        levels.add(new Level(4, "The Goblet of Fire", "Little Hangleton's Cemetery", Arrays.asList(Voldemort, Peter_Pettigrew),
                "\nYou are facing Voldemort and Peter Pettigrew, two of the most dangerous wizards alive. \nVoldemort has " +
                        Voldemort.getMaxhealth() + " health points and Peter Pettigrew has " + Peter_Pettigrew.getMaxhealth() + " health points. " +
                        "\nYour only chance to escape is to get close to the Portkey and lure him to you (Accio!). Don't worry, you'll see\n" +
                        "Voldemort"));

        levels.add(new Level(5, "The Order of the Phenix", "Hogwarts Examination Hall", Arrays.asList(Dolores),
                "It's time for the BUSE (Universal Certificate of Elementary Witchcraft)! Dolores Umbridge is watching over\n" +
                        "the grain. Your goal is to distract her until the fireworks are ready to be used."));

        levels.add(new Level(6, "The Half-Blood Prince", "Astronomy tower", Arrays.asList(Death_Eaters),
                "The Death Eaters are attacking Hogwarts. Are you ready to defend yourself? You must attack them\n" +
                        "from the front (Sectumsempra). If you are a Slytherin, you may decide to join the ranks of the\n" +
                        "Death Eaters."));

        levels.add(new Level(7, "The Deathly Hallows", "Poudlard", Arrays.asList(Voldemort, Bellatrix),
                        "Let's stop stalling and get to the root of the problem. You are facing Voldemort which has a health of " + Voldemort.getMaxhealth() + " and\n" +
                        "Bellatrix Lestrange which has a health of " + Bellatrix.getMaxhealth() + ". Be careful, they can kill you with Avada Kedavra at once if you are not\n" +
                        "are not ready."));
        return levels.get(id);
    }

    public int getNumberOfEnemies() {
        return enemies.size();
    }


    public static void runLevel(int id, Wizard wizard) {
        Scanner scanner = new Scanner(System.in);
        Level level = Level.createLevel(id);
        int numberOfEnemies = level.getNumberOfEnemies();
        System.out.println("\nThis is level number : " + Level.createLevel(id).getId() +
                "\nIt is : " + Level.createLevel(id).getName() + ", " + Level.createLevel(id).getDescription() +
                "\nand it takes place in : " + Level.createLevel(id).getPlace());
        if (numberOfEnemies == 1) {
            System.out.println("There is " + numberOfEnemies + " enemy" );
        }
        else if (numberOfEnemies > 1) {
            System.out.println("There is " + numberOfEnemies + " enemies\n");
        }
        //va permettre de faire ressortir les enemies sous forme de String et pas de tableau
        List<AbstractEnemy> enemies = Level.createLevel(id).getEnemies();
        for (AbstractEnemy enemy : enemies) {
            if (numberOfEnemies == 1) {
                System.out.println(enemy.toString());
            }
            printSeparator(100);
            System.out.println("\nIf you're ready to start the fight, press enter");
            scanner.nextLine();
            clearConsole();
            if (wizard.getHouse().getName().equals("Ravenclaw")) {
                System.out.println("Since you are a member of Ravenclaw, you are more precise"); }
            if (wizard.getHouse().getName().equals("Slytherin")) {
                System.out.println("Since you are a member of Slytherin, you do + 5 damage"); }
            if (wizard.getHouse().getName().equals("Gryffondor")) {
                System.out.println("Since you are a member of Gryffondor, you have a much better resistance");
            }
            if (wizard.getHouse().getName().equals("Hufflepuff")) {
                System.out.println("Since you are a member of Hufflepuff, the potions will heal you more");
            }
            wizard.startBattle(enemies);
        }
    }


}