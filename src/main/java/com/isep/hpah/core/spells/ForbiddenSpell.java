package com.isep.hpah.core.spells;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter @Setter

public class ForbiddenSpell extends AbstractSpell {
    private List<AbstractSpell> forbiddenspells;

    public ForbiddenSpell() {
        super(" Sword of Gryffindor", "The sword is known for its ability to imbue the wielder with courage and strength",
                40);
        forbiddenspells = new ArrayList<>();
        forbiddenspells.add(new AbstractSpell(" Sword of Gryffindor", "The sword is known for its ability to imbue the wielder with courage and strength",
                40));
        forbiddenspells.add(new AbstractSpell("avada kedavra", "used to instantly kill its target",
                1000));
    }
}