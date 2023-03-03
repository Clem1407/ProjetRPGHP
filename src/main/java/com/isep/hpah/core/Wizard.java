package com.isep.hpah.core;
import java.util.List;
public class Wizard {
    private Pet pet;
    private Wand wand;
    private House house;

    public Wizard(Pet pet, Wand wand, House house) {
        this.pet = pet;
        this.wand = wand;
        this.house = house;
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
