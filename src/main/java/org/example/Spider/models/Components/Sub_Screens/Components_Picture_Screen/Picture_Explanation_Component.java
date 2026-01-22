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
			"coming soon",
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
	public static JButton startButtonPicture() {
		MasterButton Start = new MasterButton("Start", "pictureLearnScreen", gray);

		return Start.getMasterbutton();
	}

}
