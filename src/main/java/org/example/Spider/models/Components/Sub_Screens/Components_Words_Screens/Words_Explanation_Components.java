package org.example.Spider.models.Components.Sub_Screens.Components_Words_Screens;

import org.example.Spider.models.Models_Everywhere.MasterButton;
import org.example.Spider.models.Models_Everywhere.MasterLabel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Color.gray;
import static java.awt.Color.white;

/**
 * Provides reusable UI components for the
 * "Words Explanation" sub-screen.
 */
public class Words_Explanation_Components {

	/**
	 * Shared list of text panes used for word guesses
	 * during the Words learning game.
	 */
	public static List<JTextPane> GuessList = new ArrayList<>();

	/**
	 * Creates and returns the explanation label describing
	 * the rules and flow of the Words guessing game.
	 *
	 * @return a formatted JLabel containing the game explanation
	 */
	public static JLabel ExplanationWords() {
		MasterLabel explanation  = new MasterLabel(
				"<html><font size=30>Words explanation</font><br/>" +
						"<html><font size=6>" +
						"In this game, the player tries to guess words in the Hado language.<br/><br/>" +
						"First Attempt: The player enters 10 words in the first row as their initial guess.<br/><br/>" +
						"Submit Button: After entering the words, the player presses the \"Submit\" button.<br/><br/>" +
						"Feedback: Each word is checked:<br/>" +
						"- If a letter is in the word but in the wrong position, it turns yellow.<br/>" +
						"- If a letter is correct and in the right position, it turns green.<br/>" +
						"- If a letter is not in the word at all, it turns red.<br/><br/>" +
						"Next Attempts: The player continues guessing words in the following rows.<br/><br/>" +
						"Goal: The game continues until all the words are guessed correctly or the player uses all 6 attempts.<br/><br/>" +
						"Game Over: After 6 attempts, the game ends. There is no additional feedback beyond the colors.<br/><br/>" +
						"This is a simple guessing game that combines logic and trial-and-error to find the correct Hado words." +
						"</font></html>",
				white
		);
		return explanation.getMasterLabel();
	}

	/**
	 * Creates the start button for the Words game.
	 * Initializes the game using the shared GuessList.
	 *
	 * @return a configured Start JButton
	 */
	public static JButton startButtonWords() {
		MasterButton Start = new MasterButton("Start", "screenWordsLearn", gray);

		// Initialize the Words game with the current guess list
		Start.startWords(GuessList);

		return Start.getMasterbutton();
	}

}
