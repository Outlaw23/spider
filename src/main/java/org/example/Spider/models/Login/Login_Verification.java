package org.example.Spider.models.Login;

import org.example.Spider.Controllers.Screen_controller;
import org.example.Spider.models.Models_Everywhere.masterlabel;
import org.example.Spider.models.Models_Everywhere.mastertextarea;

import javax.swing.*;
import java.awt.*;

public class Login_Verification {
	// Create an instance of User_Data_Login to access stored user data
	User_Data_Login LoginData = new User_Data_Login();

	// Method to verify login credentials
	public void loginVerification(mastertextarea ID, JPasswordField Password, masterlabel messageLabel) {

		// Get the user ID from the text field
		String userID = ID.getID().getText();
		// Get the password entered by the user and convert it to a String
		String password = String.valueOf(Password.getPassword());

		// Check if the entered user ID exists in the user data
		if(LoginData.getUserData().containsKey(userID)) {
			// If user ID exists, check if the password matches
			if(LoginData.getUserData().get(userID).equals(password)) {
				// If the password is correct, set success message in green and navigate to main screen
				messageLabel.getMasterLabel().setForeground(Color.GREEN);
				messageLabel.getMasterLabel().setText("Welcome " + userID );
				Screen_controller.showPanel("screenMain");
			}
			else {
				// If the password is incorrect, set error message in red
				messageLabel.getMasterLabel().setForeground(Color.RED);
				messageLabel.getMasterLabel().setText("wrong password");
			}
			return;
		}

		// If the user ID does not exist, set error message in red
		messageLabel.getMasterLabel().setForeground(Color.red);
		messageLabel.getMasterLabel().setText("user does not exist");
	}
}
