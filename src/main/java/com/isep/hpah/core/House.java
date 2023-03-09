package com.isep.hpah.core;
import lombok.*;
@Getter @Setter
public class House {
    private String name; //permet de retourner le nom de la maison
    private String description; //sa description
    private String founder; //son fondateur

    public House(String name, String description, String founder) {
        this.name = name;
        this.description = description;
        this.founder = founder;
    }

}
