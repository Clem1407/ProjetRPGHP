package com.isep.hpah.core;
import com.isep.hpah.core.character.Wizard;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
public class SortingHat {
    private List<House> house;

    public SortingHat() {
        house = new ArrayList<>();
        house.add(new House("Gryffondor", "courage, bravery and determination", "Godric Gryffondor"));
        house.add(new House("Hufflepuff", "most humble of all the houses", "Helga Hufflepuff"));
        house.add(new House("Ravenclaw", "excellent wisdom, with and a skill for learning", "Rowena Ravenclaw"));
        house.add(new House("Slytherin", "ambitious, shrewd and possibly destined for greatness", "Salazar Slytherin"));
    }

    public void assignHouse(Wizard wizard) {
        Random random = new Random();
        int index = random.nextInt(house.size());
        House randomHouse = house.get(index);
        wizard.setHouse(randomHouse);
    }
}
