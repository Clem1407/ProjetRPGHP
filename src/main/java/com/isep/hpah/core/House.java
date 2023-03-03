package com.isep.hpah.core;

public class House {
    private String name; //permet de retourner le nom de la maison
    private String description; //sa description
    private String founder; //son fondateur

    public House(String name, String description, String founder) {
        this.name = name;
        this.description = description;
        this.founder = founder;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getFounder() {
        return founder;
    }
}
