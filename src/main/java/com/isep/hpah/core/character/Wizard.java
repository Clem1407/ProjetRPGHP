package com.isep.hpah.core.character;
import com.isep.hpah.core.House;
import com.isep.hpah.core.Pet;
import com.isep.hpah.core.Potion;
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

    public Wizard(String name, Pet pet, Wand wand, House house) {
        this.name = name;
        this.pet = pet;
        this.wand = wand;
        this.house = house;
        this.knownSpells = new ArrayList<>();
        this.potions = new ArrayList<>();
        this.maxhealth = 100;
        this.currenthealth = maxhealth;
        this.damage = 2;
    }

    /*public Spell() {
        if (getHouse().getName() == "Gryffondor") {
            knownSpells.add(new Spell("Sword of Gryffondor","blablabla",10));
        }
    }*/
}
