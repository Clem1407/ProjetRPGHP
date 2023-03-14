package com.isep.hpah.core;
import com.isep.hpah.core.character.*;
import java.util.Random;
import com.isep.hpah.core.spells.*;
import com.isep.hpah.core.potions.*;
import com.isep.hpah.core.levels.*;


public class Battle {
    private static final Random random = new Random();

    public static void startBattle(Wizard wizard, AbstractEnemy enemy) {
        System.out.println("Un combat démarre entre " + wizard.getName() + " et " + enemy.getName() + " !");

        while (wizard.getCurrenthealth() > 0 && enemy.getCurrenthealth() > 0) {
            // Le sorcier attaque l'ennemi
            Spell spell = wizard.chooseSpell();
            int damage = spell.getDamage();
            double accuracy = wizard.getAccuracy();
            if (random.nextDouble() < accuracy) {
                enemy.takeDamage(damage);
                System.out.println(wizard.getName() + " utilise " + spell.getName() + " et inflige " + damage + " points de dégâts à " + enemy.getName() + " !");
            } else {
                System.out.println(wizard.getName() + " utilise " + spell.getName() + " mais rate " + enemy.getName() + " !");
            }

            if (enemy.getCurrenthealth() <= 0) {
                System.out.println(wizard.getName() + " remporte le combat !");
                return;
            }

            // L'ennemi attaque le sorcier
            int enemyDamage = enemy.getDamage();
            double enemyAccuracy = enemy.getAccuracy() * wizard.getResistance();
            if (random.nextDouble() < enemyAccuracy) {
                wizard.takeDamage(enemyDamage);
                System.out.println(enemy.getName() + " attaque " + wizard.getName() + " et inflige " + enemyDamage + " points de dégâts !");
            } else {
                System.out.println(enemy.getName() + " attaque " + wizard.getName() + " mais rate !");
            }

            if (wizard.getCurrenthealth() <= 0) {
                System.out.println(enemy.getName() + " remporte le combat !");
                return;
            }
        }
    }
}
