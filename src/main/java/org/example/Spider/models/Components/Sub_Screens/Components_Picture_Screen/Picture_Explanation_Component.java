package org.example.Spider.models.Components.Sub_Screens.Components_Picture_Screen;

import org.example.Spider.models.Models_Everywhere.MasterButton;
import org.example.Spider.models.Models_Everywhere.MasterLabel;

import javax.swing.*;

import static java.awt.Color.gray;
import static java.awt.Color.white;

/**
 * Provides reusable UI components for the
 * "Sentences Explanation" sub-screen.
 */
public class Picture_Explanation_Component {

	/**
	 * Creates and returns a label containing the explanation
	 * and rules for the Sentences game.
	 *
	 * @return a formatted JLabel with sentence instructions
	 */
	public static JLabel ExplanationPicture() {
		MasterLabel explanation = new MasterLabel(
				"<html>" +
						"<font size='26'><b>Assignment 3</b></font><br/><br/>" +

						"This assignment has two phases and uses images.<br/><br/>" +

						"<b>Phase 1:</b><br/>" +
						"The user sees an image.<br/>" +
						"The user writes the objects from the image in Hado.<br/>" +
						"The user writes a short description in English.<br/><br/>" +


						"<b>Phase 2:</b><br/>" +
						"The application checks the answers.<br/>" +
						"The user chooses correct or incorrect based on how similar the descriptions are.<br/>" +
						"The final score is shown." +
						"</html>",white);

		return explanation.getMasterLabel();
	}

	/**
	 * Creates the Start button for the Sentences game.
	 * Initializes the game logic using the current input list and indices.
	 *
	 * @return a configured Start JButton
	 */
	public static JButton startButtonPicture() {
		MasterButton Start = new MasterButton("Start", "pictureLearnScreen", gray);

		return Start.getMasterbutton();
	}

}
