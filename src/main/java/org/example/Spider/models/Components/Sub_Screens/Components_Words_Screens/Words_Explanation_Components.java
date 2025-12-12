package org.example.Spider.models.Components.Sub_Screens.Components_Words_Screens;

import org.example.Spider.models.Models_Everywhere.MasterButton;
import org.example.Spider.models.Models_Everywhere.MasterLabel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Color.gray;
import static java.awt.Color.white;

public class Words_Explanation_Components {

	public static List<JTextPane> GuessList = new ArrayList<>();


	public  static JLabel ExplanationWords() {
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

	public static JButton startButtonWords() {
		MasterButton Start = new MasterButton("Start", "screenWordsLearn", gray);
		Start.start(GuessList);


		return Start.getMasterbutton();
	}




}
