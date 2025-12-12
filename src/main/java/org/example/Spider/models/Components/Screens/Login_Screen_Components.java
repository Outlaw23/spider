package org.example.Spider.models.Components.Screens;

import org.example.Spider.models.Models_Everywhere.MasterTextField;
import org.example.Spider.models.Models_Everywhere.MasterButton;
import org.example.Spider.models.Models_Everywhere.MasterLabel;
import org.example.Spider.models.Models_Everywhere.MasterPasswordField;

import javax.swing.*;

import static java.awt.Color.*;

public class Login_Screen_Components {

	public static JLabel userID() {
		MasterLabel userID = new MasterLabel("User ID:", white);
		return userID.getMasterLabel();
	}

	public static JLabel userPassword() {
		MasterLabel userPassword = new MasterLabel("User password:", white);
		return userPassword.getMasterLabel();
	}

	public static JLabel messageLabel() {
		MasterLabel messageLabel = new MasterLabel("Login please", white);
		return messageLabel.getMasterLabel();
	}

	public static JTextField ID() {
		MasterTextField ID = new MasterTextField("", black);
		return ID.getMasterTextFied();
	}

	public static JPasswordField password() {
		MasterPasswordField password = new MasterPasswordField();
		return password.getPasswordField();
	}

    public static JButton loginButton(JTextField ID, JPasswordField password, JLabel messageLabel) {
        MasterButton login = new MasterButton("login", "", gray);
        // Belangrijk: gebruik dezelfde instanties die op het scherm staan
        login.loginButtonActionListener(ID, password, messageLabel);
        return login.getMasterbutton();
    }
}
