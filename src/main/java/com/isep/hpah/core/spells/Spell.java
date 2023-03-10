package com.isep.hpah.core.spells;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter @Setter
public class Spell extends AbstractSpell {
    private static final List<Spell> spells = new ArrayList<>();

    public Spell(String name, String description, int damage) {
        super(name, description, damage);
    }

    public static List<Spell> getSpells() {
        return spells;
    }

    static {
        spells.add(new Spell("Wingardium Leviosa", "allows the caster to levitate an object or person.", 5));
        spells.add(new Spell("Accio", "summon broomstick and summon various other objects", 10));
        spells.add(new Spell("Expecto Patronum", " the spell takes the form of an animal that is unique to each wizard, reflecting their personality and innermost thoughts", 40));
        spells.add(new Spell("fireworks", "type of explosive pyrotechnic device that is commonly used for entertainment or celebratory purposes", 100));
        spells.add(new Spell("Sectumsempra", "capable of causing severe physical harm to its target", 25));
        spells.add(new Spell("expelliarmus", "used to disarm an opponent by causing their wand to fly out of their hand", 30));
    }
}

