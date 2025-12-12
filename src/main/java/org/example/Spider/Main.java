package org.example.Spider;

import org.example.Spider.Controllers.Screen_controller;
import org.example.Spider.models.Learn.List_Maker;

import java.util.List;

/**
 * Application entry point for Spider.
 * Starts the UI via {@link org.example.Spider.Controllers.Screen_controller#screenContoller()} and
 * prints a small word list for a quick dev check. (Concise docs, no big text blocks.)
 */
public class Main {

    /**
     * Starts the app UI and prints a small word list (dev check).
     *
     * @param args not used
     */
    static void main(@SuppressWarnings("unused") String[] args) {
        // Start UI
		Screen_controller.screenContoller();
        // Quick dev output: print fetched words
        List<String> words = List_Maker.getWoorden();
        IO.println(words);
        System.out.println();
    }
}
