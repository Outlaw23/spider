package org.example.Spider.models.Components.Screens;

import org.example.Spider.models.Models_Everywhere.MasterButton;
import org.example.Spider.models.Models_Everywhere.MasterTextArea;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Color.gray;

/**
 * Provides reusable UI components for the
 * Learn screen of the application.
 */
public class Learn_Screen_Components {

	/**
	 * Counter representing the current assignment number.
	 */
	public static int numberOpdracht = 0;

	/**
	 * List storing assignment buttons.
	 */
	public static List<JButton> opdrachten = new ArrayList<>();

	/**
	 * Creates a button for the current assignment number.
	 *
	 * @return a configured JButton representing an assignment
	 */
	public static JButton opdrachten() {
		MasterButton opdracht  = new MasterButton("assignment " + numberOpdracht, "", gray);
		return opdracht.getMasterbutton();
	}

	/**
	 * Creates a read-only text area containing a brief explanation
	 * of the Words learning game, including instructions and rules.
	 *
	 * @return a configured JTextArea with the explanation
	 */
	public static JTextArea briefExplanation() {
		MasterTextArea briefExplanation = new MasterTextArea();

		JTextArea textArea = briefExplanation.getBriefExplanation();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);

		textArea.setText("""
    Words Explanation (assignment 1)

    In this game, you try to guess words in the Hado language.

    Each attempt, you enter 10 words and press "Submit".

    Color feedback:
    - Green: correct letter in the correct position
    - Yellow: correct letter in the wrong position
    - Red: letter not in the word

    You have 6 attempts to guess all words correctly.
    """);

		return textArea;
	}
}
