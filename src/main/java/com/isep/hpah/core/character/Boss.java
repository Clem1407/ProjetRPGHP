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
        boss.add(new AbstractEnemy("Lord Voldemort",100, 15, 100, 1, 1));
        boss.add(new AbstractEnemy("Dolores Jane Umbridge",50, 10, 100, 1, 1));
        boss.add(new AbstractEnemy("Bellatrix Lestrange", 50, 12, 100, 1, 1));

    }

}
