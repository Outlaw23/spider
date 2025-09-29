package org.example.Spider.Screen_Learn_Hado.Sub_Screens.Explaining_The_Assignment;

import org.example.Spider.Controllers.Font_Resizer;
import org.example.Spider.models.Models_Everywhere.masterbutton;
import org.example.Spider.models.Models_Everywhere.masterlabel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static java.awt.Color.*;
import static java.awt.Color.gray;

public class Words_Explanation {

	public JPanel screenWordsExplanation() {

		// Create the main panel with BorderLayout
		JPanel panelMain = new JPanel();
		panelMain.setLayout(new BorderLayout());
		panelMain.setPreferredSize(new Dimension(1920, 1080));
		panelMain.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		panelMain.setBackground(new Color(255, 255, 255));

		// Create sub-panels for layout structure
		// Center panel
		JPanel panelMainCenter = new JPanel();
		panelMainCenter.setLayout(new BorderLayout());
		panelMainCenter.setPreferredSize(new Dimension(1920, 500));
		panelMainCenter.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
		panelMainCenter.setBackground(new Color(95, 102, 107));

		// North panel (top area)
		JPanel panelMainNorth = new JPanel();
		panelMainNorth.setLayout(new GridLayout(0, 10, 5, 0));
		panelMainNorth.setPreferredSize(new Dimension(1920, 50));
		panelMainNorth.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelMainNorth.setBackground(new Color(38, 66, 87));

		//panel start button
		JPanel panelStartButton = new JPanel();
		panelStartButton.setLayout(new GridLayout(0, 10, 5, 5));
		panelStartButton.setPreferredSize(new Dimension(1920, 60));
		panelStartButton.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelStartButton.setBackground(new Color(95, 102, 107));




		// Labels
		// Title label
		masterlabel titel = new masterlabel("Home", white);

		// Hado description text
		masterlabel hadoScreen = new masterlabel(
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

		// Buttons
		// Home button
		masterbutton home = new masterbutton("Home", "screenMain", gray);

		// Hado button
		masterbutton hado = new masterbutton("Hado", "screenHado", gray);

		// HadoR button
		masterbutton hadoR = new masterbutton("HadoR", "screenHadoR", gray);

		// Learn button
		masterbutton Learn = new masterbutton("Learn", "screenLearn", gray);

		//start button
		masterbutton Start = new masterbutton("Start", "wordsLearn", gray);

		// Add subpanels to the main panel
		panelMain.add(panelMainNorth, BorderLayout.NORTH);
		panelMain.add(panelMainCenter, BorderLayout.CENTER);

		// Add components to the north panel
		panelMainNorth.add(titel.getMasterLabel());
		panelMainNorth.add(home.getMasterbutton());
		panelMainNorth.add(hado.getMasterbutton());
		panelMainNorth.add(hadoR.getMasterbutton());
		panelMainNorth.add(Learn.getMasterbutton());

		// Add components to the center panel
		panelMainCenter.add(panelStartButton, BorderLayout.SOUTH);
		panelMainCenter.add(hadoScreen.getMasterLabel(), BorderLayout.NORTH);

		// Add components to the Start button panel
		panelStartButton.add(Start.getMasterbutton());

		// Components that will resize when the window is resized
		List<JComponent> resizableComponents = Arrays.asList(
				titel.getMasterLabel(),
				home.getMasterbutton(),
				hado.getMasterbutton(),
				hadoR.getMasterbutton(),
				Learn.getMasterbutton(),
				Start.getMasterbutton()
		);
		Font_Resizer.applyResizeLogic(panelMain, resizableComponents);

		// Return the main panel
		return panelMain;
	}

}
