package org.example.Spider.Screen_Login;

import org.example.Spider.Controllers.Font_Resizer;
import org.example.Spider.models.Models_Everywhere.masterbutton;
import org.example.Spider.models.Models_Everywhere.masterlabel;
import org.example.Spider.models.Models_Everywhere.masterpasswordfield;
import org.example.Spider.models.Models_Everywhere.mastertextarea;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static java.awt.Color.gray;
import static java.awt.Color.white;

public class Login_Screen {


	// Method to create and return the Login Screen panel
	public JPanel Login_screen(HashMap<String, String> userdata) {

		// Main panel setup
		JPanel panelMain = new JPanel();
		panelMain.setLayout(new BorderLayout());
		panelMain.setPreferredSize(new Dimension(1920, 1080));
		panelMain.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		panelMain.setBackground(new Color(255, 255, 255));

		// Center panel for login content
		JPanel panelMainCenter = new JPanel();
		panelMainCenter.setLayout(new GridLayout(1, 30, 0, 0));
		panelMainCenter.setPreferredSize(new Dimension(1920, 1080));
		panelMainCenter.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
		panelMainCenter.setBackground(new Color(95, 102, 107));

		// Top panel for title or navigation
		JPanel panelMainNorth = new JPanel();
		panelMainNorth.setLayout(new GridLayout(0, 10, 5, 0));
		panelMainNorth.setPreferredSize(new Dimension(1920, 50));
		panelMainNorth.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelMainNorth.setBackground(new Color(38, 66, 87));

		// Left panel for text labels
		JPanel panelText = new JPanel();
		panelText.setLayout(new GridLayout(8, 0, 10, 10));
		panelText.setPreferredSize(new Dimension(1920, 500));
		panelText.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 5));
		panelText.setBackground(new Color(95, 102, 107));

		// Right panel for input fields
		JPanel panelFields = new JPanel();
		panelFields.setLayout(new GridLayout(8, 0, 5, 45));
		panelFields.setPreferredSize(new Dimension(1920, 500));
		panelFields.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelFields.setBackground(new Color(95, 102, 107));

		// Title label
		masterlabel titel = new masterlabel("Login", white);

		// Labels for username and password
		masterlabel userID = new masterlabel("User ID:", white);
		masterlabel userPassword = new masterlabel("User password:", white);

		// Label for messages (e.g., login status)
		masterlabel messageLabel = new masterlabel("Login please", white);

		// Input fields for username and password
		mastertextarea ID = new mastertextarea();
		masterpasswordfield password = new masterpasswordfield();

		// Login button and its action listener
		masterbutton login = new masterbutton("login", "", gray);
		login.loginButtonActionListener(ID, password, messageLabel);

		// Adding panels to main layout
		panelMain.add(panelMainNorth, BorderLayout.NORTH);
		panelMain.add(panelMainCenter, BorderLayout.CENTER);

		// Adding title to top panel
		panelMainNorth.add(titel.getMasterLabel());

		// Adding left and right panels to center
		panelMainCenter.add(panelText);
		panelMainCenter.add(panelFields);

		// Adding labels to text panel
		panelText.add(userID.getMasterLabel());
		panelText.add(userPassword.getMasterLabel());
		panelText.add(messageLabel.getMasterLabel());

		// Adding input fields and button to fields panel
		panelFields.add(ID.getID());
		panelFields.add(password.getPasswordField());
		panelFields.add(login.getMasterbutton());

		// Make components resizable using Font_Resizer
		List<JComponent> resizableComponents = Arrays.asList(
				titel.getMasterLabel(),
				userID.getMasterLabel(),
				userPassword.getMasterLabel(),
				messageLabel.getMasterLabel(),
				ID.getID(),
				password.getPasswordField(),
				login.getMasterbutton()
		);
		Font_Resizer.applyResizeLogic(panelMain, resizableComponents);

		return panelMain;
	}
}
