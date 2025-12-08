package org.example.Spider.models.Components.Screens;

import org.example.Spider.models.Models_Everywhere.masterbutton;
import org.example.Spider.models.Models_Everywhere.masterlabel;
import org.example.Spider.models.Models_Everywhere.masterpasswordfield;
import org.example.Spider.models.Models_Everywhere.mastertextarea;

import javax.swing.*;

import static java.awt.Color.gray;
import static java.awt.Color.white;

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

	public static JTextArea ID() {
		mastertextarea ID = new mastertextarea();
		return ID.getID();
	}

	public static JPasswordField password() {
		masterpasswordfield password = new masterpasswordfield();
		return password.getPasswordField();
	}

    public static JButton loginButton(JTextArea ID, JPasswordField password, JLabel messageLabel) {
        masterbutton login = new masterbutton("login", "", gray);
        // Belangrijk: gebruik dezelfde instanties die op het scherm staan
        login.loginButtonActionListener(ID, password, messageLabel);
        return login.getMasterbutton();
    }
}
