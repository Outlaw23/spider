package org.example.Spider.models.Components.Screens;

import org.example.Spider.models.Models_Everywhere.masterTextField;
import org.example.Spider.models.Models_Everywhere.masterbutton;
import org.example.Spider.models.Models_Everywhere.masterlabel;
import org.example.Spider.models.Models_Everywhere.masterpasswordfield;

import javax.swing.*;

import static java.awt.Color.*;

public class Login_Screen_Components {

	public static JLabel userID() {
		masterlabel userID = new masterlabel("User ID:", white);
		return userID.getMasterLabel();
	}

	public static JLabel userPassword() {
		masterlabel userPassword = new masterlabel("User password:", white);
		return userPassword.getMasterLabel();
	}

	public static JLabel messageLabel() {
		masterlabel messageLabel = new masterlabel("Login please", white);
		return messageLabel.getMasterLabel();
	}

	public static JTextField ID() {
		masterTextField ID = new masterTextField("", black);
		return ID.getMasterTextFied();
	}

	public static JPasswordField password() {
		masterpasswordfield password = new masterpasswordfield();
		return password.getPasswordField();
	}

    public static JButton loginButton(JTextField ID, JPasswordField password, JLabel messageLabel) {
        masterbutton login = new masterbutton("login", "", gray);
        // Belangrijk: gebruik dezelfde instanties die op het scherm staan
        login.loginButtonActionListener(ID, password, messageLabel);
        return login.getMasterbutton();
    }
}
