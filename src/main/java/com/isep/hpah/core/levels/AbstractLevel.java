package com.isep.hpah.core.levels;
import java.util.List;
import com.isep.hpah.core.character.AbstractEnemy;
import lombok.Getter;
import lombok.Setter;

//création d'une classe AbstractLevel pour simplification du programme
@Getter  @Setter
public class AbstractLevel {
    private int id;
    private String name;
    private String place;
    private List<AbstractEnemy> enemy;
    private String description;

    public AbstractLevel(int id,String name, String place, List<AbstractEnemy> enemy, String description) {
        this.name = name;
        this.id = id;
        this.place = place;
        this.enemy = enemy;
        this.description = description;
    }

}