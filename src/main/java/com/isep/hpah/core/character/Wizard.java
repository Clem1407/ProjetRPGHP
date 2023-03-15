package com.isep.hpah.core.character;
import com.isep.hpah.core.House;
import com.isep.hpah.core.Pet;
import com.isep.hpah.core.potions.*;
import com.isep.hpah.core.Wand;
import com.isep.hpah.core.spells.Spell;
import java.util.List;
import java.util.ArrayList;
import lombok.*;
import java.util.Scanner;
@Getter @Setter
public class Wizard {
    private String name;
    private Pet pet;
    private Wand wand;
    private House house;
    private List<Spell> knownSpells;
    private List<Potion> potions;
    private int maxhealth;
    private int currenthealth;
    private double resistance;

    public Wizard(String name, Pet pet, Wand wand, House house, List<Spell> knownSpells,
                  List<Potion> potions, int maxhealth, int currenthealth,
                  double resistance, int year ) {
        this.name = name;
        this.pet = pet;
        this.wand = wand;
        this.house = house;
        this.knownSpells = new ArrayList<Spell>();
        this.potions = new ArrayList<>();
        this.maxhealth = maxhealth;
        this.currenthealth = currenthealth;
        this.resistance = resistance;
    }

    public List<Spell> getKnownSpells() {
        return knownSpells;
    }

    public void learnSpell(Spell spell) {
        knownSpells.add(spell);
    }

    public Spell chooseSpell() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a spell to cast: ");
        int i = 1;
        for (Spell spell : knownSpells) {
            System.out.println(i + ". " + spell.getName());
            i++;
        }
        int choice = scanner.nextInt();
        return knownSpells.get(choice - 1);
    }


    //Prends en compte l'accuracy 1 étant parfaite et 0 étant la pire
    public boolean rollAccuracy(double accuracy) {
        // On calcule la précision en fonction du niveau donné en argument
        double precision = 1 - (1 - accuracy) / 2;

        // On génère un nombre aléatoire entre 0 et 1 et on compare à la précision calculée
        return Math.random() < precision;
    }

    public void attack(AbstractEnemy enemy) {
        Spell spell = chooseSpell();
        if (rollAccuracy(spell.getAccuracy())) {
            System.out.println("You cast " + spell.getName() + "!");
            int damage = spell.getDamage();
            enemy.takeDamage(damage);
            System.out.println("You did " + damage + " damage to the enemy!, it only has " + enemy.getCurrenthealth() + " left!");
        } else {
            System.out.println("You missed your spell!");
        }
    }

    public void defend(AbstractEnemy enemy) {
        if (enemy.getCurrenthealth() > 0 && this.currenthealth > 0) {
            System.out.println("You defend yourself!");

            // On calcule la précision en fonction du niveau de défense de l'ennemi
            double accuracy = 1 - (1 - enemy.getAccuracy()) / 2;

            // On vérifie si l'ennemi réussit son attaque
            if (rollAccuracy(accuracy)) {
                System.out.println("The enemy attacked you and did " + enemy.getDamage() + " damage!");
                this.currenthealth -= enemy.getDamage(); //this permet d'indiquer que cette variable appartient à Wizard
                System.out.println("You have " + this.currenthealth + " health points left!");
            } else {
                System.out.println("The enemy missed its attack!");
            }
        }
        if (enemy.getCurrenthealth() <= 0) {
            System.out.println("Well done !!! You defeated " + enemy.getName() + " !");
        }
    }

    public void startBattle(AbstractEnemy enemy) {
        Scanner scanner = new Scanner(System.in);
        while (enemy.getCurrenthealth() > 0 && this.currenthealth > 0) {
            System.out.println("It's your turn now !");
            System.out.println("What do you want to do ? (1) Cast a spell, (2) drink a potion");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    attack(enemy);
                    defend(enemy);
                    break;
                case 2:
                    heal();
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
        if (this.currenthealth <= 0) {
            System.out.println(enemy.getName() + " defeated you !");
        }

    }

    public void heal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Here are all the potions");
        List<Potion> availablePotions = PotionRepository.getPotions();
        for (int i = 0; i < availablePotions.size(); i++) {
            System.out.println(i + 1 + ". " + availablePotions.get(i).getName() + " (+" + availablePotions.get(i).getHealthgain() + " health)");
        }
        System.out.print("Please choose the potion you want to use\n");
        int potionIndex = scanner.nextInt();
        if (potionIndex < 1 || potionIndex > availablePotions.size()) {
            System.out.println("This isn't a valid choice");
            return;
        }
        Potion chosenPotion = availablePotions.get(potionIndex - 1);
        if (chosenPotion.isUsed()) {
            System.out.println("This potion has already been used");
            return;
        }
        this.currenthealth += chosenPotion.getHealthgain();
        if (this.currenthealth > this.maxhealth) {
            this.currenthealth = this.maxhealth;
        }
        chosenPotion.setUsed(true);
        System.out.println("You used this potion " + chosenPotion.getName() + " which you now have " + this.currenthealth + " health");
    }

}
