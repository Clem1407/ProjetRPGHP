package com.isep.hpah.core.character;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Boss extends AbstractEnemy {
    private List<AbstractEnemy> boss;

    public Boss() {
        super("Voldemort", 100, 100, 15, 100);
        boss = new ArrayList<>();
        boss.add(new Boss("Petter Pettigrew",100, 100, 10, 1));
        boss.add(new Boss("Lord Voldemort",100, 100, 15, 1));
        boss.add(new Boss("Dolores Jane Umbridge",300, 300, 10, 0.9));
        boss.add(new Boss("Bellatrix Lestrange", 50, 50, 12, 0.8));

    }

    public Boss(String name, int maxhealth, int currenthealth, int damage, double accuracy) {
        super(name, maxhealth, currenthealth, damage, accuracy);
    }

}
