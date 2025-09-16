package org.example.Spider.models.Login;

import org.example.Spider.Controllers.Screen_controller;
import org.example.Spider.models.Models_Everywhere.masterlabel;
import org.example.Spider.models.Models_Everywhere.mastertextarea;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login_Verification {

	/**
	 * Verifies the login of a user by comparing the entered ID and password
	 * with the credentials stored in the database.
	 */
	public void loginVerification(mastertextarea ID, JPasswordField Password, masterlabel messageLabel) {
		// Retrieve entered username and password
		String userID = ID.getID().getText();
		String password = String.valueOf(Password.getPassword());

		// SQL query to fetch the user's password
		String query = "SELECT password FROM users WHERE username = ?";

		// Try connecting to the database and execute the query
		try (Connection conn = Login_Connecter.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(query)) {

			// Set the username parameter in the SQL query
			stmt.setString(1, userID);
			ResultSet rs = stmt.executeQuery();

			// Check if the user exists
			if (rs.next()) {
				String dbPassword = rs.getString("password");

				// Compare entered password with password from the database
				if (dbPassword.equals(password)) { // later can be replaced with hash-check
					// Successful login
					messageLabel.getMasterLabel().setForeground(Color.GREEN);
					messageLabel.getMasterLabel().setText("Welcome " + userID);

					// Show the main screen
					Screen_controller.showPanel("screenMain");
				} else {
					// Wrong password
					messageLabel.getMasterLabel().setForeground(Color.RED);
					messageLabel.getMasterLabel().setText("wrong password");
				}
			} else {
				// User does not exist
				messageLabel.getMasterLabel().setForeground(Color.RED);
				messageLabel.getMasterLabel().setText("user does not exist");
			}

		} catch (Exception e) {
			// Error during database connection or query execution
			e.printStackTrace();
			messageLabel.getMasterLabel().setForeground(Color.RED);
			messageLabel.getMasterLabel().setText("Database error");
		}
	}
}
