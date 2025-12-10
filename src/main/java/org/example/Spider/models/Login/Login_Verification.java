package org.example.Spider.models.Login;

import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.example.Spider.Controllers.Screen_controller;

import javax.swing.*;
import java.awt.*;

public class Login_Verification {
	// Create an instance of User_Data_Login to access stored user data
	User_Data_Login LoginData = new User_Data_Login();

	// Method to verify login credentials
	public void loginVerification(@MonotonicNonNull JTextField ID, JPasswordField Password, JLabel messageLabel) {

		// Get the user ID from the text field
		String userID = ID.getText();
		// Get the password entered by the user and convert it to a String
		String password = String.valueOf(Password.getPassword());
		System.out.println(String.valueOf(Password.getPassword()));



		// Check if the entered user ID exists in the user data
		if(LoginData.getUserData().containsKey(userID)) {
			// If user ID exists, check if the password matches
			if(LoginData.getUserData().get(userID).equals(password)) {
				// If the password is correct, set success message in green and navigate to main screen
				messageLabel.setForeground(Color.GREEN);
				messageLabel.setText("Welcome " + userID );
				Screen_controller.showPanel("screenMain");
			}
			else {
				// If the password is incorrect, set error message in red
				messageLabel.setForeground(Color.RED);
				messageLabel.setText("wrong password");
			}
			return;
		}

		// If the user ID does not exist, set error message in red
		messageLabel.setForeground(Color.red);
		messageLabel.setText("user does not exist");
	}
}
