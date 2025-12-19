package org.example.Spider;

import org.example.Spider.Controllers.Screen_controller;
import org.example.Spider.models.Words.List_Maker;

import java.util.List;

/**
 * Main entry point for the Spider application.
 * Starts the UI and prints a small word list for a quick development check.
 */
public class Main {

    /**
     * Starts the application UI and prints a small word list (for dev check).
     *
     * @param args not used
     */
    static void main(@SuppressWarnings("unused") String[] args) {
        // Start UI
        Screen_controller.screenContoller();

        // Quick development output: fetch words
        List<String> words = List_Maker.getWoorden();

        // Print the words to the console
        IO.println(words);
    }
}
