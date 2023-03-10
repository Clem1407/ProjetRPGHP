package com.isep.hpah.core.character;
import com.isep.hpah.core.House;
import com.isep.hpah.core.Pet;
import com.isep.hpah.core.potions.*;
import com.isep.hpah.core.Wand;
import com.isep.hpah.core.spells.Spell;

import java.util.List;
import java.util.ArrayList;
import lombok.*;
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
        this.currenthealth = maxhealth;
        this.damage = damage;
        this.accuracy = accuracy;
        this.resistance = resistance;
    }

    public List<Spell> getKnownSpells() {
        return knownSpells;
    }

    public void learnSpell(Spell spell) {
        knownSpells.add(spell);
        System.out.println("You have learned the spell " + spell.getName() + "!");
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
