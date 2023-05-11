package com.isep.hpah.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrettyTextTest {

    @Test
    void clearConsole() {
        // This method only outputs text to console, so we can't really test it in a unit test.
        // We can just call it to make sure it doesn't throw any exceptions.
        PrettyText.clearConsole();
    }

    @Test
    void printSeparator() {
        // Test with n = 10
        String expected = "----------\n";
        assertEquals(expected, getConsoleOutput(() -> PrettyText.printSeparator(10)));

        // Test with n = 0
        expected = "\n";
        assertEquals(expected, getConsoleOutput(() -> PrettyText.printSeparator(0)));
    }

    @Test
    void printHeading() {
        // Test with a short title
        final String title = "Title";
        String expected = "------\n" + title + "\n------\n";
        assertEquals(expected, getConsoleOutput(() -> PrettyText.printHeading(title)));

        // Test with a long title
        final String title2 = "Very long title";
        expected = "----------------\n" + title2 + "\n----------------\n";
        assertEquals(expected, getConsoleOutput(() -> PrettyText.printHeading(title2)));
    }

    @Test
    void printHeader() {
        // Test with a short title
        final String title3 = "Title";
        String expected = "------\n" + title3 + "\n------\n";
        assertEquals(expected, getConsoleOutput(() -> PrettyText.printHeader(title3)));

        // Test with a long title
        final String title = "Very long title";
        expected = "----------------\n" + title + "\n----------------\n";
        assertEquals(expected, getConsoleOutput(() -> PrettyText.printHeader(title)));
    }

    // Helper method to capture console output
    private static String getConsoleOutput(Runnable runnable) {
        var out = new java.io.ByteArrayOutputStream();
        var oldOut = System.out;
        System.setOut(new java.io.PrintStream(out));
        runnable.run();
        System.setOut(oldOut);
        return out.toString();
    }
}