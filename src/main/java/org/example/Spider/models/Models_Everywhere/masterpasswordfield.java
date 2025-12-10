package org.example.Spider.models.Models_Everywhere;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class masterpasswordfield {

	// JPasswordField instance for password input
	private final JPasswordField passwordField;

	// Constructor to initialize the password field with custom styling
	public masterpasswordfield() {
		// Create a dark gray border with thickness 3
		Border bordertextarea = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);

		// Initialize the password field
		passwordField = new JPasswordField();

		// Set font style and size for the password field
		passwordField.setFont(new Font("Arial", Font.PLAIN, 30));

		// Apply the custom border to the password field
		passwordField.setBorder(bordertextarea);
	}

	// Getter method to return the JPasswordField instance
	public JPasswordField getPasswordField() {
		return passwordField;
	}
}
