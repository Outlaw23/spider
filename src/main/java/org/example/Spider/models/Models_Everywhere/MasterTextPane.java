package org.example.Spider.models.Models_Everywhere;

import javax.swing.*;
import java.awt.*;

/**
 * A reusable JTextPane class with pre-configured font, text, and color styling.
 */
public class MasterTextPane {

	/** The underlying JTextPane that will be styled and returned */
	JTextPane masterTextPane = new JTextPane();

	/**
	 * Constructs a MasterTextPane with the specified text and text color.
	 *
	 * @param text  the initial text to display in the text pane
	 * @param coler the color of the text
	 */
	public MasterTextPane(String text, Color coler) {
		masterTextPane.setFont(new Font("Arial", Font.PLAIN, 30)); // set font and size
		masterTextPane.setText(text); // set text
		masterTextPane.setForeground(coler); // set text color
	}

	/**
	 * Returns the underlying JTextPane instance.
	 *
	 * @return the styled JTextPane
	 */
	public JTextPane getMasterTextPane() {
		return masterTextPane;
	}
}
