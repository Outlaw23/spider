package org.example.Spider.models.Models_Everywhere;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * A reusable JTextField class with pre-configured font, color, and border styling.
 */
public class MasterTextField {

	/** The underlying JTextField that will be styled and returned */
	JTextField masterTextFiedD;

	/**
	 * Constructs a MasterTextField with the specified text and text color.
	 *
	 * @param text  the initial text to display in the text field
	 * @param coler the color of the text
	 */
	public MasterTextField(String text, Color coler) {
		Border bordertextarea = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
		masterTextFiedD = new JTextField();
		masterTextFiedD.setEditable(true);
		masterTextFiedD.setText(text);
		masterTextFiedD.setFont(new Font("Arial", Font.PLAIN, 30));
		masterTextFiedD.setForeground(coler);
		masterTextFiedD.setOpaque(true);
		masterTextFiedD.setBorder(bordertextarea);
	}

	/**
	 * Returns the underlying JTextField instance.
	 *
	 * @return the styled JTextField
	 */
	public JTextField getMasterTextFied() {
		return masterTextFiedD;
	}
}
