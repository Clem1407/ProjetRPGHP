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

import java.util.Objects;
import java.util.Scanner;

import static com.isep.hpah.core.PrettyText.*;

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
    private int damageplus;

    public Wizard(String name, Pet pet, Wand wand, House house, List<Spell> knownSpells,
                  int maxhealth, int currenthealth,
                  double resistance, int year, int damageplus) {
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
        this.damageplus = damageplus;

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
        while (true) { // boucle infinie jusqu'à ce qu'un choix valide soit fait
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose a spell to cast: ");
            int i = 1;
            for (Spell spell : knownSpells) {
                System.out.println(i + ". " + spell.getName());
                i++;
            }
            int choice = scanner.nextInt();
            if (choice < 1 || choice > knownSpells.size()) {
                System.out.println("Invalid choice. Please enter a valid choice.");
            } else {
                return knownSpells.get(choice - 1);
            }
        }
    }


    //Prends en compte l'accuracy 1 étant parfaite et 0 étant la pire
    public boolean rollAccuracy(double accuracy) {
        // On calcule la précision en fonction du niveau donné en argument
        double precision = 1 - (1 - accuracy) / 2;

        if (this.getHouse().getName().equals("Ravenclaw")) {
            precision += 0.1;
        }

        // On génère un nombre aléatoire entre 0 et 1 et on compare à la précision calculée
        return Math.random() < precision;
    }

    public void attack(AbstractEnemy enemy) {
        Spell spell = chooseSpell();
        if (damageplus > 0) {
            System.out.println("You do + " + damageplus + " damage");
        }
        if (rollAccuracy(spell.getAccuracy())) {
            System.out.println("You cast " + spell.getName() + "!");
            int damage = spell.getDamage() + damageplus;
            if (this.getHouse().getName().equals("Slytherin")) {
                damage += 5;
            }
            printHeading("ATTACK");
            int level = this.year;
            switch(level) {
                case 0:
                    enemy.takeDamage(damage);
                    System.out.println("You make an object levitates and it falls on the head of troll and did to him " + damage + " damage. \nIt only has " + enemy.getCurrenthealth() + " left!");
                    break;
                case 1:
                    enemy.takeDamage(damage);
                    System.out.println("You did " + damage + " damage to the enemy!\n It only has " + enemy.getCurrenthealth() + " left!");
                    break;
                case 2:
                    if (!Objects.equals(spell.getName(), "Expecto Patronum")) {
                        damage = 0;
                        enemy.takeDamage(damage);
                        System.out.println("You did " + damage + " to the enemy, this spell isn't effective on them...");
                    }
                    else {
                        enemy.takeDamage(damage);
                        System.out.println("Good job, you did " + damage + " damage to the Dementors! \nThey are running away !!!");
                    }
                    break;
                case 3:
                    if (!Objects.equals(spell.getName(), "Accio")) {
                        damage = 0;
                        enemy.takeDamage(damage);
                        System.out.println("You did " + damage + " to the enemy, this spell isn't effective on them...");

                    }
                    else {
                        enemy.takeDamage(damage);
                        System.out.println(" Good job you did " + damage + " damage to the enemy! \nContinue to bring them close to you, maybe you will be able to run away! ");
                    }
                    break;
                case 4:
                    if (Objects.equals(spell.getName(), "fireworks")) {
                    enemy.takeDamage(damage);
                    System.out.println("The party is starting now !! Explode her");
                    }
                    else {
                    enemy.takeDamage(damage);
                    System.out.println("You did " + damage + " damage to Dolores Jane Umbridge, but she still has " + enemy.getCurrenthealth() + " this doesn't seem very effective...");
                    }
                    break;
                case 5:
                    if (!Objects.equals(spell.getName(), "Sectumsempra")) {
                        damage = 0;
                        enemy.takeDamage(damage);
                        System.out.println("You did " + damage + " to the enemy, this spell isn't effective on them...");
                    }
                    else {
                        enemy.takeDamage(damage);
                        System.out.println("Well done you did " + damage + " to the enemy. \nIt only has " + enemy.getCurrenthealth() + " left ");
                    }
                    break;
                case 6:
                    enemy.takeDamage(damage);
                    System.out.println("You just did " + damage + " to the enemy. \nIt only has " + enemy.getCurrenthealth() + " left !");
                    break;
            }
        } else {
            System.out.println("You missed your spell!");
        }
    }

    public void defend(AbstractEnemy enemy) {
        printHeading("DEFEND");
        if (enemy.getCurrenthealth() > 0 && this.currenthealth > 0) {
            System.out.println("You defend yourself!");

            // On calcule la précision en fonction du niveau de défense de l'ennemi
            double accuracy = 1 - (1 - enemy.getAccuracy()) / 2;

            // On vérifie si l'ennemi réussit son attaque
            if (rollAccuracy(accuracy)) {
                //ajout d'un petit pourcentage que Voldemort puisse oneshot
                if (this.year == 6 && enemy.getName().equals("Lord Voldemort") && Math.random() < 0.01) {
                        this.currenthealth -= 1000;
                        System.out.println("OH noooooo it seems Voldemort used avada kedavra and touched you... " +
                                "\n You have been killed instantly... Try again");
                        System.exit(0);
                }
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
        printSeparator(100);
        int defeatedEnemies = 0;
        int numberofHits = 0;
        //va me permettre de faire en sorte qu'à partir d'un certain moment on a un sort ou sinon on peut s'enfuir
        while (defeatedEnemies < enemies.size() && this.currenthealth > 0) {
            if (this.year == 4 && numberofHits == 4) {
                this.learnSpell(Spell.getSpells().get(this.year-1)); // Ajoute le sort de l'année actuelle -1 car on a sauté une année
                System.out.println("Oh it seems you just learned a new spell... It is... ");
                this.getKnownSpells().get(this.year-1).getName();
            }
            if (this.year == 6 && numberofHits == 4) {
                this.learnSpell(ForbiddenSpell.getForbiddenSpells().get(7)); // Ajoute le sort de l'année actuelle
                System.out.println("Oh oh it seems that you just learned a new spell... It seems very powerful, it is... ");
                this.getKnownSpells().get(this.year).getName();
            }

            System.out.println("It's your turn now !");
            System.out.println("What do you want to do ? (1) Cast a spell, (2) drink a potion");

            if (this.year == 3) {
                System.out.println(" Ohhhh... It seems you also have an option to (3) run away ?");
            }

            if (this.year == 5 && this.getHouse().getName().equals("Slytherin")) {
                System.out.println(" Ohhhh... It seems that since you are member of the Slytherin house, you can also (3) join the Death Eaters ?");
            }

            int choice = scanner.nextInt();

            if (choice == 1) {
                if (enemies.size() > 1 && defeatedEnemies == 0) {
                    //Permet de laisser à l'utilisateur le choix de l'ennemi qu'il veut attaquer
                    for (AbstractEnemy enemy : enemies) {
                        printSeparator(100);
                        System.out.println("Which enemy do you want to attack? (1) for " + enemies.get(0).getName() + " or (2) for " + enemies.get(1).getName());
                        int enemyChoice = scanner.nextInt();
                        AbstractEnemy target = enemies.get(enemyChoice - 1);
                        attack(target);
                        printSeparator(100);
                        defend(target);
                        numberofHits++; //permet d'augmenter le nbr de coups portés
                        if (enemyChoice == 1 && this.getWand().getCore().getName().equals("Phoenix feather") && this.year == 6) {
                            endVoldemort();
                        }
                        printSeparator(100);
                        if (target.getCurrenthealth() <= 0) {
                            System.out.println("Well done, you defeated " +
                                    target.getName());
                            defeatedEnemies++; // permet de compter le nombre d'ennemi dans le niveau
                        }
                        if (defeatedEnemies == enemies.size()) {
                            break; // Sort de la boucle for si tous les ennemis sont vaincus
                        }
                        break;
                    }
                }
                else {
                    for (AbstractEnemy enemy : enemies) {
                        printSeparator(100);
                        attack(enemy);
                        printSeparator(100);
                        defend(enemy);
                        printSeparator(100);
                        if (this.year == 3 || this.year == 4) {
                            numberofHits++; //permet d'augmenter le nbr de coups portés
                        }
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
            }

            else if (choice == 2) {
                heal();
            }

            //permet de faire en sorte que l'utilisateur ait l'option fuir au niveau 3
            else if (choice == 3 && this.year == 3) {
                if (numberofHits >= 3) {
                    System.out.println("Well done, you ran away and won the level !!!");
                    this.year++;
                    printSeparator(100);
                    Level.runLevel(this.year, this); // Lance le niveau suivant
                }
                else {
                    System.out.println("You tried to run away but couldn't suceed...");
                }
            }

            //écrit un petit récit si l'utilisateur est un serpentard qui s'est allié avec les Mangemorts
            else if (choice == 3 && this.year == 5 && this.getHouse().getName().equals("Slytherin")) {
                printHeading("You're with the Death Eaters");
                System.out.println("You have made the fateful decision to join the Death Eaters, forever sealing your fate as a dark wizard.\n" +
                        "Your life will now be consumed by the pursuit of power and dominance over the wizarding world.\n" +
                        "You will be feared and hated by those who oppose your ideology, and revered and respected by those who share it.\n" +
                        "But know that the path you have chosen is one of darkness and cruelty, and that the end you seek may never justify the means.\n" +
                        "In the end, you may find yourself consumed by the very darkness you sought to wield, forever trapped in a cycle of destruction and despair.\n" +
                        "This is the end of your adventure, but know that your story is far from over. Your fate is now in your own hands, and only time will tell what kind of wizard you will become.\n" +
                        "I hope you had fun playing this game, and that it has given you a glimpse into the world of magic and wizardry. Thank you for playing!");
                System.exit(0);
            }
            else {
                System.out.println("Invalid choice!");
            }
        }
        if (defeatedEnemies == enemies.size()) {
                endlevel();
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

    private void endlevel() {
        Scanner scanner = new Scanner(System.in);
        printSeparator(100);
        this.year++; // Augmente l'année du sorcier
        if (this.year == 7) {
            clearConsole();
            printHeader("YOU FINISHED");
            System.out.println("Congratulations, wizard! You have completed all seven years at Hogwarts School of Witchcraft\n" +
                    " and Wizardry, and you have triumphed over all of the challenges that were thrown your way. You have\n" +
                    " proven yourself to be a skilled and powerful wizard, and your dedication and hard work have paid off.\n" +
                    " You can now proudly call yourself a graduate of the most prestigious wizarding school in the world.\n" +
                    " Well done!");
            System.exit(0);
        }
        System.out.println("You just finished your " + this.year + " year at Hogwards, good job !");
        System.out.println("You can now choose to get back some health or to do more damages, what do you want to do ? ");
        System.out.println("Do you want to add + 5 to your health (1) " + this.currenthealth + " or add + 2 to your damage (2) ");
        int bonus = scanner.nextInt();
        switch (bonus) {
            case 1 :
                currenthealth += 5;
                break;
            case 2 :
                damageplus += 2;
                break;
            default:
                System.out.println("Invalid choice!");
        }
        while (this.year < 3) {
            // va me permettre de modifier les sorts pour les Gryffondor
            if (this.getHouse().getName().equals("Gryffondor")) {
                this.learnSpell(Spell.getSpells().get(this.year)); // Ajoute le sort de l'année actuelle
                if (this.year == 2) {
                    System.out.println("Well done ! You have just learned a new spell, this spell is : " +
                    this.getKnownSpells().get(this.year + 1).getName());

                }
                if (this.year == 1) {
                    System.out.println("Well done ! You have just learned a new spell, this spell is : " +
                            this.getKnownSpells().get(this.year).getName());
                    this.learnSpell(ForbiddenSpell.getForbiddenSpells().get(6)); // Ajoute le sort de l'année actuelle
                    System.out.println("Since you are a Gryffondor ! You have also learned another spell which is :" +
                            this.getKnownSpells().get(2).getName());
                }
            }
            else {
                this.learnSpell(Spell.getSpells().get(this.year)); // Ajoute le sort de l'année actuelle
                System.out.println("Well done ! You have just learned a new spell, this spell is : " +
                        this.getKnownSpells().get(this.year).getName());
            }
            break;
        }
        while (this.year > 4 && this.year < 7) {
            this.learnSpell(Spell.getSpells().get(this.year-1)); // Ajoute le sort de l'année actuelle
            if (this.getHouse().getName().equals("Gryffondor")) {
                System.out.println("Well done ! You have just learned a new spell, this spell is : " +
                this.getKnownSpells().get(this.year).getName());
            }
            else {
                System.out.println("Well done ! You have just learned a new spell, this spell is : " +
                this.getKnownSpells().get(this.year - 1).getName());
            }
            break;
        }
        printSeparator(100);
        Level.runLevel(this.year, this); // Lance le niveau suivant
    }

    public void endVoldemort() {
        clearConsole();
        System.out.println("OHH you have the same core as Voldemort !!!! \n" +
                "In the wizarding world, there was a battle that would go down in history as one\n" +
                "of the most epic clashes of all time. It was the battle between the dark wizard Voldemort and the boy who lived,\n" +
                "Harry Potter. What made this particular fight so unique was that both of their wands contained the same core - a phoenix feather from Fawkes.\n" +
                "The two wizards stood at opposite ends of the battlefield, their eyes locked in a \n" +
                "fierce stare. Voldemort was determined to rid the world of Harry Potter once and for all, \n" +
                "and Harry knew that the fate of the wizarding world hung in the balance.\n" +
                "As the first spells were cast, it became clear that this was not going to be an easy fight. \n" +
                "Harry and Voldemort were evenly matched, each displaying incredible magical skill and strength.\n" +
                " The spells they cast ricocheted off each other, causing explosions and filling the air with smoke and debris.\n" +
                "The battle raged on, both sides taking heavy hits and delivering crushing blows. Harry's friends, Ron and Hermione, \n" +
                "were fighting alongside him, and the three of them worked together to create a shield that protected them \n" +
                "from Voldemort's most deadly spells.\n" +
                "In the end, it was Harry who emerged victorious. He used the power of love, \n" +
                "something that Voldemort could never understand, to channel the magic of their \n" +
                "twin wands and overpower the dark wizard. Voldemort's wand was destroyed, and \n" +
                "he was defeated once and for all.\n" +
                "As Harry stood, exhausted but triumphant, he looked down at his wand and felt \n" +
                "a sense of awe. The fact that his wand contained the same core as Voldemort's had \n" +
                "been a source of fear for him for so long, but now he saw it as a symbol of his own strength \n" +
                "and determination. Harry knew that he had truly earned the title of the boy who lived, and he \n" +
                "would always remember this battle as the one that proved he was worthy of it.");
        System.exit(0);
    }

}
