package org.example.Spider.models.Components.Sub_Screens.Components_Sentences_Screens;

import org.example.Spider.models.Models_Everywhere.MasterButton;
import org.example.Spider.models.Models_Everywhere.MasterLabel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Color.gray;
import static java.awt.Color.white;

/**
 * Provides reusable UI components for the
 * "Sentences Explanation" sub-screen.
 */
public class Sentences_Explanation_Component {

	/**
	 * List of input boxes used for sentence input during the game.
	 */
	public static List<JTextPane> inputBoxesList = new ArrayList<>();

	/**
	 * Index of the current sentence row.
	 */
	public static int rowIndex = 0;

	/**
	 * Index indicating the last sentence row.
	 */
	public static int rowEndindex = 0;

	/**
	 * Creates and returns a label containing the explanation
	 * and rules for the Sentences game.
	 *
	 * @return a formatted JLabel with sentence instructions
	 */
	public static JLabel ExplanationSentences() {
		MasterLabel explanation = new MasterLabel(
				"<html><font size=30>Sentence Explanation</font><br/>" +
						"<html><font size=6>" +
						"Build sentences using Hado words.<br/><br/>" +

						"At the top, words are shown like this:<br/>" +
						"word || word || word<br/><br/>" +

						"Each part is one sentence.<br/>" +
						"Do NOT type || in the text area.<br/><br/>" +

						"Inside a sentence, connect words using &.<br/>" +
						"You may type word&word or word & word (no quotation marks).<br/><br/>" +

						"Rules:<br/>" +
						"- 1 to 3 words per sentence<br/>" +
						"- Use & when there is more than one word<br/>" +
						"- Only type words and &<br/><br/>" +

						"Enter one sentence per line." +
						"</font></html>",
				white
		);
		return explanation.getMasterLabel();
	}

	/**
	 * Creates the Start button for the Sentences game.
	 * Initializes the game logic using the current input list and indices.
	 *
	 * @return a configured Start JButton
	 */
	public static JButton startButtonSentences() {
		MasterButton Start = new MasterButton("Start", "screenSentencesLearn", gray);

		// Initialize the Sentences game with required data
		Start.startSentences(inputBoxesList, rowIndex, rowEndindex);

		return Start.getMasterbutton();
	}

}
