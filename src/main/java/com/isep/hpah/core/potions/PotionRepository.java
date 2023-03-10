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
    }
}
