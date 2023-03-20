package com.isep.hpah.core.character;
import com.isep.hpah.core.House;
import com.isep.hpah.core.Pet;
import com.isep.hpah.core.potions.*;
import com.isep.hpah.core.Wand;
import com.isep.hpah.core.spells.ForbiddenSpell;
import com.isep.hpah.core.spells.Spell;
import com.isep.hpah.core.levels.Level;
import java.util.List;
import java.util.ArrayList;
import lombok.*;
import java.util.Scanner;

import static com.isep.hpah.core.PrettyText.printSeparator;

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
    private int year;

    public Wizard(String name, Pet pet, Wand wand, House house, List<Spell> knownSpells,
                  int maxhealth, int currenthealth,
                  double resistance, int year) {
        this.name = name;
        this.pet = pet;
        this.wand = wand;
        this.house = house;
        this.knownSpells = new ArrayList<>();
        this.potions = new ArrayList<>();
        this.maxhealth = maxhealth;
        this.currenthealth = currenthealth;
        this.resistance = resistance;
        this.year = year;

        PotionRepository potionRepository = new PotionRepository();
        List<Potion> availablePotions = potionRepository.getPotions();
        this.potions.addAll(availablePotions);
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

        if (this.getHouse().getName().equals("Ravenclaw")) {
            precision += 0.1;
            System.out.println("Since you are a member of Ravenclaw, you are more precise");
        }

        // On génère un nombre aléatoire entre 0 et 1 et on compare à la précision calculée
        return Math.random() < precision;
    }

    public void attack(AbstractEnemy enemy) {
        Spell spell = chooseSpell();
        if (rollAccuracy(spell.getAccuracy())) {
            System.out.println("You cast " + spell.getName() + "!");
            int damage = spell.getDamage();
            if (this.getHouse().getName().equals("Slytherin")) {
                damage += 5;
                System.out.println("Since you are a member of Slytherin, you do + 5 damage");
            }
            int level = this.year;
            switch(level) {
                case 0:
                    enemy.takeDamage(damage);
                    System.out.println("You make an object levitates and it falls on the head of troll and did to him " + damage + " damage it only has " + enemy.getCurrenthealth() + " left!");
                    break;
                case 1:
                    enemy.takeDamage(damage);
                    System.out.println("You did " + damage + " damage to the enemy!, it only has " + enemy.getCurrenthealth() + " left!");
                    break;
                case 2:
                    if (spell.getName() != "Expecto Patronum") {
                        damage = 0;
                        enemy.takeDamage(damage);
                        System.out.println("You did " + damage + " to the enemy, this spell isn't effective on them...");
                    }
                    else {
                        enemy.takeDamage(damage);
                        System.out.println("Good job, you did " + damage + " damage to the Dementors!, They are running away ");
                    }
                    break;
                case 3:
                    if (spell.getName() != "Accio") {
                        damage = 0;
                        enemy.takeDamage(damage);
                        System.out.println("You did " + damage + " to the enemy, this spell isn't effective on them...");

                    }
                    else {
                        enemy.takeDamage(damage);
                        System.out.println(" Good job you did " + damage + " damage to the enemy! Continue to bring them close to you, maybe you will be able to run away! ");
                    }
                    break;
                case 4:
                    enemy.takeDamage(damage);
                    System.out.println("You did " + damage + " damage to Dolores Jane Umbridge, but she still has " + enemy.getCurrenthealth() + " this doesn't seem very effective..." );
                    break;
                case 5:
                    if (spell.getName() != "Sectumsempra") {
                        damage = 0;
                        enemy.takeDamage(damage);
                        System.out.println("You did " + damage + " to the enemy, this spell isn't effective on them...");
                    }
                    else {
                        enemy.takeDamage(damage);
                        System.out.println("Well done you did " + damage + " to the enemies, they only have " + enemy.getCurrenthealth() + " left ");
                    }
                    break;
                case 6:
                    enemy.takeDamage(damage);
                    System.out.println("You just did " + damage + " to the enemy, it only has " + enemy.getCurrenthealth() + " left !");
                    break;
            }
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
                if (this.getHouse().getName().equals("Gryffondor")) {
                    this.currenthealth += this.resistance;
                    System.out.println("Since you are a member of Gryffondor, with your resistance, you're able to gain back " + getResistance() + " health points");
                }
                System.out.println("You have " + this.currenthealth + " health points left!");
            } else {
                System.out.println("The enemy missed its attack!");
            }
        }
    }

    public void startBattle(List<AbstractEnemy> enemies) {
        Scanner scanner = new Scanner(System.in);
        int defeatedEnemies = 0;
        while (defeatedEnemies < enemies.size() && this.currenthealth > 0) {
            System.out.println("It's your turn now !");
            System.out.println("What do you want to do ? (1) Cast a spell, (2) drink a potion");
            int choice = scanner.nextInt();
            if (choice == 1) {
                for (AbstractEnemy enemy : enemies) {
                    attack(enemy);
                    defend(enemy);
                    if (enemy.getCurrenthealth() <= 0) {
                        System.out.println("Well done, you defeated " +
                                enemy.getName());
                        defeatedEnemies++; // permet de compter le nombre d'ennemi dans le niveau
                    }
                    if (defeatedEnemies == enemies.size()) {
                        break; // Sort de la boucle for si tous les ennemis sont vaincus
                    }
                }
            }
            else if (choice == 2) {
                heal();
            }
            else {
                System.out.println("Invalid choice!");
            }
        }
        if (defeatedEnemies == enemies.size()) {
                printSeparator(100);
                this.year++; // Augmente l'année du sorcier
                System.out.println("You just finished your " + this.year + " year at Hogwards, good job !");
                this.learnSpell(Spell.getSpells().get(this.year)); // Ajoute le sort de l'année actuelle
                System.out.println("Well done ! You have just learned a new spell, this spell is : " +
                        this.getKnownSpells().get(this.year).getName());
                if (this.getHouse().getName().equals("Gryffondor") && this.year == 1) {
                    this.learnSpell(ForbiddenSpell.getForbiddenSpells().get(6)); // Ajoute le sort de l'année actuelle
                    System.out.println("Since you are a Gryffondor ! You have also learned another spell which is " +
                         this.getKnownSpells().get(2).getName());
                }
                printSeparator(100);
                Level.runLevel(this.year, this); // Lance le niveau suivant
        }
        if (this.currenthealth <= 0) {
            System.out.println("You were defeated by the enemies!");
        }
    }

    public void heal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Here are all your potions:");
        for (int i = 0; i < potions.size(); i++) {
            Potion potion = potions.get(i);
            System.out.println(i + 1 + ". " + potion.getName() + " (+" + potion.getHealthgain() + " health)");
        }
        System.out.print("Please choose the potion you want to use\n");
        int potionIndex = scanner.nextInt();
        if (potionIndex < 1 || potionIndex > potions.size()) {
            System.out.println("This isn't a valid choice");
            return;
        }
        Potion chosenPotion = potions.get(potionIndex - 1);
        if (chosenPotion.isUsed()) {
            System.out.println("This potion has already been used");
            return;
        }
        int healthGain = chosenPotion.getHealthgain();
        if (this.getHouse().getName().equals("Hufflepuff")) {
            healthGain += 10; // Permet de prendre l'exception si le membre est de la maison Hufflepuff
            System.out.println("Since you are a member of Hufflepuff, you gain + 10 more points of health !");
        }
        this.currenthealth += healthGain;
        if (this.currenthealth > this.maxhealth) {
            this.currenthealth = this.maxhealth;
        }
        chosenPotion.setUsed(true);
        System.out.println("You used the potion " + chosenPotion.getName() + " and now have " + this.currenthealth + " health");
    }

}
