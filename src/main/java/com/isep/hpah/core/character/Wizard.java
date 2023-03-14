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
    private int damage;
    private double accuracy;
    private double resistance;

    public Wizard(String name, Pet pet, Wand wand, House house, List<Spell> knownSpells,
                  List<Potion> potions, int maxhealth, int currenthealth, int damage, double accuracy,
                  double resistance, int year ) {
        this.name = name;
        this.pet = pet;
        this.wand = wand;
        this.house = house;
        this.knownSpells = new ArrayList<Spell>();
        this.potions = new ArrayList<>();
        this.maxhealth = maxhealth;
        this.currenthealth = currenthealth;
        this.damage = damage;
        this.accuracy = accuracy;
        this.resistance = resistance;
    }

    public List<Spell> getKnownSpells() {
        return knownSpells;
    }

    public void learnSpell(Spell spell) {
        knownSpells.add(spell);
    }

    public void takeDamage(int damage) {
        int healthAfterDamage = this.currenthealth - damage;
        this.currenthealth = Math.max(healthAfterDamage, 0);
    }

    public Spell chooseSpell() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a spell to cast:");
        int i = 1;
        for (Spell spell : knownSpells) {
            System.out.println(i + ". " + spell.getName());
            i++;
        }
        int choice = scanner.nextInt();
        return knownSpells.get(choice - 1);
    }


    public void attack(AbstractEnemy enemy, Spell spell) {
        if (!knownSpells.contains(spell)) {
            System.out.println("Cannot cast unknown spell " + spell.getName());
            return;
        }
        double accuracyRoll = Math.random();
        if (accuracyRoll > accuracy) {
            System.out.println(name + " missed the attack!");
            return;
        }
        int damageRoll = (int) Math.round((damage + spell.getDamage()) * (1 - enemy.getResistance()));
        enemy.takeDamage(damageRoll);
        System.out.println(name + " cast " + spell.getName() + " and dealt " + damageRoll + " damage to " + enemy.getName() + "!");
    }

    public void defend(int damageTaken) {
        int damageReduction = (int) Math.round(damageTaken * resistance);
        currenthealth -= (damageTaken - damageReduction);
        if (currenthealth <= 0) {
            System.out.println(name + " has been defeated!");
        } else {
            System.out.println(name + " took " + damageTaken + " damage, reduced by " + damageReduction + " due to resistance. Current health: " + currenthealth + "/" + maxhealth);
        }
    }

    public void increaseMaxHealth(int amount) {
        this.maxhealth += amount;
    }

    public void increaseDamage(int amount) {
        this.damage += amount;
    }

    public void heal(int amount, Potion potion) {
        if (potion.isUsed()) {
            System.out.println("This potion has already been used!");
        } else {
            potion.setUsed(true);
            this.currenthealth = Math.min(this.currenthealth + amount, this.maxhealth);
        }
    }

    public void usePotion(Potion potion, Wizard wizard) {
        if (potion.isUsed()) {
            System.out.println("This potion has already been used!");
        } else {
            wizard.heal(potion.getHealthgain(), potion);
        }
    }
}
