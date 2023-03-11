package com.isep.hpah.core.character;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Boss extends AbstractEnemy {
    private List<AbstractEnemy> boss;

    public Boss() {
        super("Voldemort", 100, 15, 100, 1, 1);
        boss = new ArrayList<>();
        boss.add(new Boss("Petter Pettigrew",100, 15, 1, 1, 1));
        boss.add(new Boss("Lord Voldemort",100, 15, 1, 1, 1));
        boss.add(new Boss("Dolores Jane Umbridge",50, 10, 0.9, 1, 1));
        boss.add(new Boss("Bellatrix Lestrange", 50, 12, 0.8, 1, 1));

    }

    public Boss(String name, int health, int damage, double accuracy, double resistance, int number_of_enemies) {
        super(name, health, damage, accuracy, resistance, number_of_enemies);
    }

}
