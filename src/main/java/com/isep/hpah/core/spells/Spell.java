package com.isep.hpah.core.spells;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter @Setter

public class Spell extends AbstractSpell {
    private List<AbstractSpell> spells;
    public Spell() {
        super("Wingardium Leviosa", "allows the caster to levitate an object or person.",
                5);
        spells = new ArrayList<>();
        spells.add(new AbstractSpell("Wingardium Leviosa", "allows the caster to levitate an object or person.",
                5));
        spells.add(new AbstractSpell("Accio", "summon broomstick and summon various other objects",
                10));
        spells.add(new AbstractSpell("Expecto Patronum", " the spell takes the form of an animal that is unique to each wizard, reflecting their personality and innermost thoughts",
                40));
        spells.add(new AbstractSpell("fireworks", "type of explosive pyrotechnic device that is commonly used for entertainment or celebratory purposes",
                100));
        spells.add(new AbstractSpell("Sectumsempra", "capable of causing severe physical harm to its target",
                25));
        spells.add(new AbstractSpell(" expelliarmus", " used to disarm an opponent by causing their wand to fly out of their hand",
                30));

    }
}
