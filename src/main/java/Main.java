import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import com.isep.hpah.core.*;
import com.isep.hpah.core.character.*;
import com.isep.hpah.core.spells.Spell;
import com.isep.hpah.core.potions.*;
import com.isep.hpah.core.levels.*;
import java.util.List;
import static com.isep.hpah.core.PrettyText.printSeparator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Demander le nom de l'utilisateur
        System.out.print("\nWelcome to Harry Potter at Home, the wizarding RPG. Do you have what it takes to be the greatest\n" +
                "wizards? Can you meet all the challenges? Let's get started!\n" +
                "Your goal is to complete your education at Hogwarts. Each year will be filled with challenges.\n" +
                "\nWhat's your name?\n");
        String name = scanner.nextLine();
        Core core = null;
        do {
            // Permet d'afficher la liste des baguettes magiques
            System.out.println("\nYou can choose between all these cores :");
            for (Core c : Core.values()) {
                System.out.println("- " + c.getName());
            }
            System.out.print("\nEnter the name of the core that you want\n");
            String coreName = scanner.nextLine();
            try {
                core = Core.valueOf(coreName.toUpperCase().replaceAll("\\s", "_"));
                //permet de remplacer les espaces par un tiret du bas puisque les élements dans les énum ne peuvent pas contenir d'espace
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Wand name. Please choose from the list.");
            }
        } while (core == null);

        // Saisir la longueur de la baguette magique
        System.out.print("\nEnter the size of your wand in cm: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        Pet pet = null;
        do {
            // Afficher la liste des animaux
            System.out.println("\nYou can choose between all these pets");
            for (Pet p : Pet.values()) {
                System.out.println("- " + p.getName());
            }
            System.out.print("\nWhich pet do you want ?\n");
            String petName = scanner.nextLine();
            try {
                pet = Pet.valueOf(petName.toUpperCase().replaceAll("\\s", "_"));
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid pet name. Please choose from the list.");
            }
        } while (pet == null);

        // Création de l'utilisateur avec ces choix
        Wizard wizard = new Wizard(name, pet, new Wand(core, size), null, new ArrayList<>(),  100, 100, 1, 0);

        // Assignation de la maison maison au hasard avec le chapeau magique
        SortingHat sortingHat = new SortingHat();
        sortingHat.assignHouse(wizard);

        //Appel la liste de potions
        PotionRepository potionRepository = new PotionRepository();
        List<Potion> potions = potionRepository.getPotions();

        // Ajouter le premier sort dès la création du sorcier
        wizard.learnSpell(Spell.getSpells().get(0));

        // Afficher les informations de l'utilisateur
        printSeparator(100);
        System.out.println("\nWelcome, " + wizard.getName() + " to the wizard world! \n" +
                "You have a " + wizard.getPet().getName() + " as a pet. \n" +
                "Your wand has a " + wizard.getWand().getCore().getName() + " core.\n" +
                "and it has a size of " + wizard.getWand().getSize() + "cm. \n" +
                "You have been sorted into the " + wizard.getHouse().getName() + " house! \n" +
                "which represents the " + wizard.getHouse().getDescription() + " and \n" +
                "was founded by " + wizard.getHouse().getFounder() + "\n" +
                "\nCongrats! you have learned the spell : " + wizard.getKnownSpells().get(0).getName() + "\n" +
                "\nThis is the list of your potions, but be careful you can only use each potions one time\n");
                for (Potion potion : potions) {
                System.out.println("- " + potion.getName() + " (+" + potion.getHealthgain() + " health)");
                }
        printSeparator(100);
        //Afficher le début du jeu, le premier niveau
        System.out.println("\nWelcome to your first year at Hogwarts School of Witchcraft and Wizardry! \n" +
                "You will face a variety of challenges and enemies throughout your education, and this is just the beginning. \n" +
                "Are you ready for your first challenge?\n");
        printSeparator(100);
        Level level = Level.createLevel(0);
        level.runLevel(0, wizard);
        printSeparator(100);
    }
}