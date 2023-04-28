package com.isep.hpah.core.character;
import com.isep.hpah.core.spells.Spell;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import com.isep.hpah.core.House;

import static org.junit.jupiter.api.Assertions.*;

class WizardTest {
    private Wizard wizard;

    @BeforeEach
    void setUp() {
        // Crée un objet Wizard avec des valeurs par défaut pour chaque test
        wizard = new Wizard("Harry", null, null, null, new ArrayList<>(),
                100, 100, 0.5, 1, 0);
    }
    @org.junit.jupiter.api.Test
    void getKnownSpells() {
    }

    @org.junit.jupiter.api.Test
    void learnSpell() {
        // Vérifie que la méthode learnSpell ajoute un sort à la liste des sorts connus
        Spell spell = new Spell("lalala", "Disarms your opponent", 10, 0.8);
        wizard.learnSpell(spell);
        assertTrue(wizard.getKnownSpells().contains(spell));
    }

    @org.junit.jupiter.api.Test
    void chooseSpell() {
        // Vérifie que la méthode chooseSpell retourne un sort valide à partir de la liste des sorts connus
        Spell spell1 = new Spell("Expelliarmus", "Disarms your opponent", 10,0.8);
        Spell spell2 = new Spell("Stupefy", "Stuns your opponent", 22,0.7);
        wizard.learnSpell(spell1);
        wizard.learnSpell(spell2);

        // Simule la saisie utilisateur en entrant 2 (le choix du deuxième sort dans la liste)
        System.setIn(new java.io.ByteArrayInputStream("2".getBytes()));

        Spell chosenSpell = wizard.chooseSpell();
        assertEquals(spell2, chosenSpell);
    }

    @org.junit.jupiter.api.Test
    void rollAccuracyReturnsTrueWhenAccuracyIsPerfect() {
        // Vérifie que la méthode rollAccuracy retourne true lorsque l'accuracy est de 1 (parfait)
        assertTrue(wizard.rollAccuracy(1.0));
    }

    @org.junit.jupiter.api.Test
    void rollAccuracyReturnsFalseWhenAccuracyIsZero() {
        // Vérifie que la méthode rollAccuracy retourne false lorsque l'accuracy est de 0 (pire)
        assertFalse(wizard.rollAccuracy(0.0));
    }

    @org.junit.jupiter.api.Test
    void rollAccuracyReturnsTrueWhenAccuracyIsIncreasedByRavenclawBonus() {
        // Vérifie que la méthode rollAccuracy ajoute 0.1 à la précision lorsque l'utilisateur appartient à la maison Ravenclaw
        wizard.setHouse(new House("Ravenclaw", "excellent wisdom, with and a skill for learning", "Rowena Ravenclaw"));
        assertTrue(wizard.rollAccuracy(0.8));
    }

    @org.junit.jupiter.api.Test
    void attack() {
    }

    @org.junit.jupiter.api.Test
    void defend() {
    }

    @org.junit.jupiter.api.Test
    void startBattle() {
    }

    @org.junit.jupiter.api.Test
    void heal() {
    }

    @org.junit.jupiter.api.Test
    void endVoldemort() {
    }

    @org.junit.jupiter.api.Test
    void getName() {
    }

    @org.junit.jupiter.api.Test
    void getPet() {
    }

    @org.junit.jupiter.api.Test
    void getWand() {
    }

    @org.junit.jupiter.api.Test
    void getHouse() {
    }

    @org.junit.jupiter.api.Test
    void getPotions() {
    }

    @org.junit.jupiter.api.Test
    void getMaxhealth() {
    }

    @org.junit.jupiter.api.Test
    void getCurrenthealth() {
    }

    @org.junit.jupiter.api.Test
    void getResistance() {
    }

    @org.junit.jupiter.api.Test
    void getYear() {
    }

    @org.junit.jupiter.api.Test
    void getDamageplus() {
    }

    @org.junit.jupiter.api.Test
    void setName() {
    }

    @org.junit.jupiter.api.Test
    void setPet() {
    }

    @org.junit.jupiter.api.Test
    void setWand() {
    }

    @org.junit.jupiter.api.Test
    void setHouse() {
    }

    @org.junit.jupiter.api.Test
    void setKnownSpells() {
    }

    @org.junit.jupiter.api.Test
    void setPotions() {
    }

    @org.junit.jupiter.api.Test
    void setMaxhealth() {
    }

    @org.junit.jupiter.api.Test
    void setCurrenthealth() {
    }

    @org.junit.jupiter.api.Test
    void setResistance() {
    }

    @org.junit.jupiter.api.Test
    void setYear() {
    }

    @org.junit.jupiter.api.Test
    void setDamageplus() {
    }
}