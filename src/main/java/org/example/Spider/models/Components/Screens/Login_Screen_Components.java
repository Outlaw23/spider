package org.example.Spider.models.Components.Screens;

import org.example.Spider.models.Models_Everywhere.MasterTextField;
import org.example.Spider.models.Models_Everywhere.MasterButton;
import org.example.Spider.models.Models_Everywhere.MasterLabel;
import org.example.Spider.models.Models_Everywhere.MasterPasswordField;

import javax.swing.*;

import static java.awt.Color.*;

/**
 * Provides reusable UI components for the
 * Login screen of the application.
 */
public class Login_Screen_Components {

	/**
	 * Creates a label for the User ID input field.
	 *
	 * @return a configured JLabel
	 */
	public static JLabel userID() {
		MasterLabel userID = new MasterLabel("User ID:", white);
		return userID.getMasterLabel();
	}

	/**
	 * Creates a label for the User Password input field.
	 *
	 * @return a configured JLabel
	 */
	public static JLabel userPassword() {
		MasterLabel userPassword = new MasterLabel("User password:", white);
		return userPassword.getMasterLabel();
	}

	/**
	 * Creates a label for displaying login messages or instructions.
	 *
	 * @return a configured JLabel
	 */
	public static JLabel messageLabel() {
		MasterLabel messageLabel = new MasterLabel("Login please", white);
		return messageLabel.getMasterLabel();
	}

	/**
	 * Creates a text field for entering the User ID.
	 *
	 * @return a configured JTextField
	 */
	public static JTextField ID() {
		MasterTextField ID = new MasterTextField("", black);
		return ID.getMasterTextFied();
	}

	/**
	 * Creates a password field for entering the User Password.
	 *
	 * @return a configured JPasswordField
	 */
	public static JPasswordField password() {
		MasterPasswordField password = new MasterPasswordField();
		return password.getPasswordField();
	}

	/**
	 * Creates a login button and attaches the action listener.
	 * The button uses the same ID, password, and messageLabel instances
	 * displayed on the screen.
	 *
	 * @param ID           the User ID input field
	 * @param password     the User Password input field
	 * @param messageLabel the label for displaying messages
	 * @return a configured JButton
	 */
	public static JButton loginButton(JTextField ID, JPasswordField password, JLabel messageLabel) {
		MasterButton login = new MasterButton("login", "", gray);

		// Attach the login action to the provided components
		login.loginButtonActionListener(ID, password, messageLabel);

		return login.getMasterbutton();
	}
}
