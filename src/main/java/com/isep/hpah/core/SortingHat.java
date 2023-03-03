package com.isep.hpah.core;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
public class SortingHat {
    private List<House> houses;

    public SortingHat() {
        houses = new ArrayList<>();
        houses.add(new House("Gryffondor", "This house represents courage, bravery and determination", "Godric Gryffondor"));
        houses.add(new House("Hufflepuff", "Hufflepuffs are just the most humble of all the houses", "Helga Hufflepuff"));
        houses.add(new House("Ravenclaw", "excellent wisdom, with and a skill for learning", "Rowena Ravenclaw"));
        houses.add(new House("Slytherin", "ambitious, shrewd and possibly destined for greatness", "Salazar Slytherin"));
    }

    public void assignHouse(Wizard wizard) {
        Random random = new Random();
        int index = random.nextInt(houses.size());
        House randomHouse = houses.get(index);
        wizard.setHouse(randomHouse);
    }
}
