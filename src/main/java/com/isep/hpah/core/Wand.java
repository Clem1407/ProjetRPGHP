package com.isep.hpah.core;
import lombok.*;
@Getter @Setter

public class Wand {
    private Core core;
    private int size;
    public Wand(Core core, int size) {
        this.core = core;
        this.size = size;
    }

}
