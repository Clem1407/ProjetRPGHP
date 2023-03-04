package com.isep.hpah.core.character;
import com.isep.hpah.core.House;
import com.isep.hpah.core.Pet;
import com.isep.hpah.core.Wand;

import java.util.List;
public class Wizard {
    private String name;
    private Pet pet;
    private Wand wand;
    private House house;

    public Wizard(String name, Pet pet, Wand wand, House house) {
        this.name = name;
        this.pet = pet;
        this.wand = wand;
        this.house = house;
    }

    public String getName() {
        return name;
    }

    public Wand getWand() {
        return wand;
    }

    public Pet getPet() {
        return pet;
    }

    public House getHouse() {
        return house;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setWand(Wand wand) {
        this.wand = wand;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
