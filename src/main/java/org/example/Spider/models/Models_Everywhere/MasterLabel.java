package org.example.Spider.models.Models_Everywhere;

import javax.swing.*;
import java.awt.*;

/**
 * A reusable JLabel class with pre-configured font and color styling.
 */
public class MasterLabel {

	/** The underlying JLabel that will be styled and returned */
	JLabel masterLabel = new JLabel();

	/**
	 * Constructs a MasterLabel with the specified text and text color.
	 *
	 * @param text  the text to display on the label
	 * @param coler the color of the text
	 */
	public MasterLabel(String text, Color coler) {
		masterLabel.setFont(new Font("Arial", Font.PLAIN, 30)); // set font and size
		masterLabel.setText(text); // set label text
		masterLabel.setForeground(coler); // set text color
	}

	/**
	 * Returns the underlying JLabel so it can be added to panels.
	 *
	 * @return the styled JLabel
	 */
	public JLabel getMasterLabel() {
		return masterLabel;
	}
}
