package com.isep.hpah.core.spells;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter @Setter

public class ForbiddenSpell extends AbstractSpell {
    private static final List<Spell> spells = Spell.getSpells();

    public ForbiddenSpell(String name, String description, int damage, double accuracy) {
        super(name, description, damage, accuracy);
    }

    public static List<Spell> getForbiddenSpells() {
        return spells;
    }
    static {
        spells.add(new Spell(" Sword of Gryffindor", "The sword is known for its ability to imbue the wielder with courage and strength", 40, 0.9));
        spells.add(new Spell("avada kedavra", "used to instantly kill its target", 1000, 0.1));
    }
}