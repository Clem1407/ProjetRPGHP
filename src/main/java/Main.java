import java.util.Scanner;
import java.util.Random;
import com.isep.hpah.core.*;
import com.isep.hpah.core.character.*;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Demander le nom de l'utilisateur
        System.out.print("Welcome to Harry Potter at Home, the wizarding RPG. Do you have what it takes to be the greatest\n" +
                "wizards? Can you meet all the challenges? Let's get started!\n" +
                "Your goal is to complete your education at Hogwarts. Each year will be filled with challenges.\n" +
                "What's your name?\n");
        String name = scanner.nextLine();
        Core core = null;
        do {
            // Permet d'afficher la liste des baguettes magiques
            System.out.println("You can choose between all these wands :");
            for (Core c : Core.values()) {
                System.out.println("- " + c.getName());
            }
            System.out.print("Enter the name of the wand that you want\n");
            String coreName = scanner.nextLine();
            try {
                core = Core.valueOf(coreName.toUpperCase().replaceAll("\\s", "_"));
                //permet de remplacer les espaces par un tiret du bas puisque les élements dans les énum ne peuvent pas contenir d'espace
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Wand name. Please choose from the list.");
            }
        } while (core == null);

        // Saisir la longueur de la baguette magique
        System.out.print("Enter the size of your wand in cm: ");
        int size = scanner.nextInt();

        Pet pet = null;
        do {
            // Afficher la liste des animaux
            System.out.println("You can choose between all these pets");
            for (Pet p : Pet.values()) {
                System.out.println("- " + p.getName());
            }
            System.out.print("Which pet do you want ?\n");
            String petName = scanner.nextLine();
            try {
                pet = Pet.valueOf(petName.toUpperCase().replaceAll("\\s", "_"));
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid pet name. Please choose from the list.");
            }
        } while (pet == null);


        // Création de l'utilisateur avec ces choix
        Wizard wizard = new Wizard(name,pet, new Wand(core, size), null);

        // Assignation de la maison maison au hasard avec le chapeau magique
        SortingHat sortingHat = new SortingHat();
        sortingHat.assignHouse(wizard);

        // Afficher les informations de l'utilisateur
        System.out.println("Welcome, " + wizard.getName() + " to the wizard world! \n" +
                "You have a " + wizard.getPet().getName() + " as a pet. \n" +
                "Your wand has a " + wizard.getWand().getCore().getName() + " core.\n" +
                "and it has a size of " + wizard.getWand().getSize() + "cm. \n" +
                "You have been sorted into the " + wizard.getHouse().getName() + " house!");
    }
}