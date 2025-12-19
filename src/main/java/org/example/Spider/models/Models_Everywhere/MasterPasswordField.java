package org.example.Spider.models.Models_Everywhere;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * A reusable JPasswordField class with pre-configured font and border styling.
 */
public class MasterPasswordField {

	/** The underlying JPasswordField used for password input */
	private final JPasswordField passwordField;

	/**
	 * Constructs a MasterPasswordField with custom font and border styling.
	 */
	public MasterPasswordField() {
		// Create a dark gray border with thickness 3
		Border bordertextarea = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);

		// Initialize the password field
		passwordField = new JPasswordField();

		// Set font style and size for the password field
		passwordField.setFont(new Font("Arial", Font.PLAIN, 30));

		// Apply the custom border to the password field
		passwordField.setBorder(bordertextarea);
	}

	/**
	 * Returns the underlying JPasswordField instance.
	 *
	 * @return the styled JPasswordField
	 */
	public JPasswordField getPasswordField() {
		return passwordField;
	}
}
