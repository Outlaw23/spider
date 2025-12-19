package org.example.Spider.models.Components.Sub_Screens.Components_Sentences_Screens;

import org.example.Spider.models.Components.Components_Everywhere;
import org.example.Spider.models.Models_Everywhere.MasterButton;
import org.example.Spider.models.Models_Everywhere.MasterLabel;
import org.example.Spider.models.Models_Everywhere.MasterTextPane;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.gray;

/**
 * Provides reusable UI components for the
 * "Sentences Learn" sub-screen.
 */
public class Sentences_Learn_Component {

	/**
	 * Action and navigation buttons used on the Sentences Learn screen.
	 */
	public static JButton doneButton;
	public static JButton submitbutton;
	public static JButton backButton;

	/**
	 * Creates a label used to display words or feedback text.
	 *
	 * @return a configured JLabel
	 */
	public static JLabel words() {
		MasterLabel words = new MasterLabel("", Color.white);
		return words.getMasterLabel();
	}

	/**
	 * Creates a title label for displaying a sentence to be completed or learned.
	 *
	 * @param Sentence the sentence text to display
	 * @return a formatted title JLabel
	 */
	public static JLabel Sentence(String Sentence) {
		return Components_Everywhere.Title(Sentence);
	}

	/**
	 * Creates an input field for entering sentence answers.
	 *
	 * @return a configured JTextPane for user input
	 */
	public static JTextPane InputBoxes() {
		MasterTextPane inputBoxes = new MasterTextPane("", Color.black);
		return inputBoxes.getMasterTextPane();
	}

	/**
	 * Creates or returns the Submit button.
	 * Used to submit the entered sentence answer.
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
	 * Creates or returns the Back button.
	 * Navigates back to the previous explanation screen.
	 *
	 * @return the Back JButton
	 */
	public static JButton back() {
		if (backButton == null) {
			MasterButton Back = new MasterButton("Back", "screenSentencesExplanation", gray);
			backButton = Back.getMasterbutton();
		}
		return backButton;
	}

	/**
	 * Creates or returns the Done button.
	 * Navigates back to the Learn overview screen.
	 *
	 * @return the Done JButton
	 */
	public static JButton done() {
		if (doneButton == null) {
			MasterButton Done = new MasterButton("Done", "screenLearn", gray);
			doneButton = Done.getMasterbutton();
		}
		return doneButton;
	}

}
