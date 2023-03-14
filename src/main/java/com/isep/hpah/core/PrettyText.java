package com.isep.hpah.core;

public class PrettyText {
    //function to clear console (technically skipping / doing empty lines)
    public static void clearConsole() {
        for (int i = 0; i < 100; i++)
            System.out.println();
    }

    //function for separator
    public static void printSeparator(int n) {
        for (int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }

    //function to print a heading
    public static void printHeading(String title) {
        printSeparator(title.length());
        System.out.println(title);
        printSeparator(title.length());
    }

    public static void printHeader(String title){
        clearConsole();
        printSeparator(title.length());
        System.out.println(title);
        printSeparator(title.length());
    }
}
