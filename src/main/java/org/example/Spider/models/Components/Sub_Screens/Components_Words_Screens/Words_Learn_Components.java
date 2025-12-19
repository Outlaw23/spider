package org.example.Spider.models.Components.Sub_Screens.Components_Words_Screens;

import org.example.Spider.models.Components.Components_Everywhere;
import org.example.Spider.models.Models_Everywhere.MasterTextPane;
import org.example.Spider.models.Models_Everywhere.MasterButton;
import org.example.Spider.models.Models_Everywhere.MasterLabel;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.black;
import static java.awt.Color.gray;

/**
 * Provides reusable UI components for the
 * "Words Learn" sub-screen.
 */
public class Words_Learn_Components {

	/**
	 * Navigation and action buttons used on the Words Learn screen.
	 */
	public static JButton backButton;
	public static JButton resetButton;
	public static JButton doneButton;
	public static JButton submitbutton;

	/**
	 * Title label displayed at the top of the screen.
	 */
	public static JLabel op1TitelLabel;

	/**
	 * Returns the title label for the Words Learn screen.
	 * The label is created once and reused.
	 *
	 * @return the title JLabel
	 */
	public static JLabel op1Titel() {
		if (op1TitelLabel == null) {
			MasterLabel label = new MasterLabel("Guess words", Color.white);
			op1TitelLabel = label.getMasterLabel();
		}
		return op1TitelLabel;
	}

	/**
	 * Creates a standardized title label for a given word.
	 *
	 * @param words the text to display
	 * @return a configured JLabel
	 */
	public static JLabel word(String words) {
		return Components_Everywhere.Title(words);
	}

	/**
	 * Creates or returns the Back button.
	 * Navigates back to the Words Explanation screen.
	 *
	 * @return the Back JButton
	 */
	public static JButton back() {
		if (backButton == null) {
			MasterButton Back = new MasterButton("Back", "screenWordsExplanation", gray);
			backButton = Back.getMasterbutton();
		}
		return backButton;
	}

	/**
	 * Creates or returns the Reset button.
	 * Intended to reset the current word guesses.
	 *
	 * @return the Reset JButton
	 */
	public static JButton reset() {
		if (resetButton == null) {
			MasterButton Reset = new MasterButton("reset", "", gray);
			resetButton = Reset.getMasterbutton();
		}
		return resetButton;
	}

	/**
	 * Creates or returns the Done button.
	 * Intended to finish the Words learning session.
	 *
	 * @return the Done JButton
	 */
	public static JButton done() {
		if (doneButton == null) {
			MasterButton Done = new MasterButton("Done", "", gray);
			doneButton = Done.getMasterbutton();
		}
		return doneButton;
	}

	/**
	 * Creates or returns the Submit button.
	 * Used to submit the current word guess.
	 *
	 * @return the Submit JButton
	 */
	public static JButton submit() {
		if (submitbutton == null) {
			MasterButton Submit = new MasterButton("Submit", "", gray);
			submitbutton = Submit.getMasterbutton();
		}
		return submitbutton;
	}

	/**
	 * Creates a text input field for entering a word guess.
	 *
	 * @return a configured JTextPane
	 */
	public static JTextPane textPane() {
		MasterTextPane pane = new MasterTextPane("", black);
		return pane.getMasterTextPane();
	}
}
