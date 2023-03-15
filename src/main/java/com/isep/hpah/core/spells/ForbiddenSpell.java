package com.isep.hpah.core.spells;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter @Setter

public class ForbiddenSpell extends AbstractSpell {
    private static final List<ForbiddenSpell> forbiddenspells = new ArrayList<>();

    public ForbiddenSpell(String name, String description, int damage, double accuracy) {
        super(name, description, damage, accuracy);
    }
    public static List<ForbiddenSpell> getForbiddenSpells() {
        return forbiddenspells;
    }
    static {
        forbiddenspells.add(new ForbiddenSpell(" Sword of Gryffindor", "The sword is known for its ability to imbue the wielder with courage and strength",
                40, 0.9));
        forbiddenspells.add(new ForbiddenSpell("avada kedavra", "used to instantly kill its target",
                1000, 0.8));
    }
}