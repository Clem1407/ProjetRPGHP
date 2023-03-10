package com.isep.hpah.core.potions;
import java.util.ArrayList;
import java.util.List;
public class PotionRepository {
    private List<Potion> potions;
    public PotionRepository() {
        potions = new ArrayList<>();
        potions.add(new Potion("Amortentia", 20));
        potions.add(new Potion("Armadillo Bile Mixture", 35));
        potions.add(new Potion("Vitamix", 50));
        for (Potion potion : potions) {
            potion.setUsed(false);
        }
    }

    //permet d'exposer la liste des potions en tant qu'un attribut publique
    //de la classe et de permettre aux autres classes d'accéder à cette liste via cette méthode

    public List<Potion> getPotions() {
        return potions;
    }
}
