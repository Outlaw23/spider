package org.example.Spider.view.Screen_Login;

import org.example.Spider.Controllers.Font_Resizer;
import org.example.Spider.Img.Img_Paths;
import org.example.Spider.models.Components.Components_Everywhere;
import org.example.Spider.models.Components.Screens.Login_Screen_Components;
import org.example.Spider.models.Models_Everywhere.masterpanel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * View class responsible for building the Login Screen UI.
 * This class only creates and lays out Swing components.
 */
public class Login_Screen_View extends javax.swing.JPanel {

	/**
	 * Creates and returns the Login Screen panel.
	 *
	 * @param userdata user-related data (currently unused)
	 * @return fully constructed Login screen JPanel
	 */
	public JPanel Login_screen(@SuppressWarnings("unused") HashMap<String, String> userdata) {

		// =========================
		// Main container panel
		// =========================
		JPanel panelMain = new JPanel();
		panelMain.setLayout(new BorderLayout());
		panelMain.setPreferredSize(new Dimension(1920, 1080));
		panelMain.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		panelMain.setBackground(new Color(255, 255, 255));

		// =========================
		// Center panel with background image
		// Holds the login form content
		// =========================
		masterpanel panelMainCenter = new masterpanel(Img_Paths.Background_Spider);
		panelMainCenter.setLayout(new GridLayout(0, 4, 0, 0));
		panelMainCenter.setPreferredSize(new Dimension(1920, 1080));
		panelMainCenter.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
		panelMainCenter.setBackground(new Color(95, 102, 107));

		// =========================
		// Top navigation / title bar
		// =========================
		masterpanel panelMainNorth = new masterpanel(Img_Paths.Background_Strip);
		panelMainNorth.setLayout(new GridLayout(0, 10, 5, 0));
		panelMainNorth.setPreferredSize(new Dimension(1920, 50));
		panelMainNorth.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelMainNorth.setBackground(new Color(38, 66, 87));

		// =========================
		// Left panel for labels
		// =========================
		JPanel panelText = new JPanel();
		panelText.setLayout(new GridLayout(8, 0, 10, 10));
		panelText.setPreferredSize(new Dimension(1920, 500));
		panelText.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 5));
		panelText.setBackground(new Color(95, 102, 107, 0));
		panelText.setOpaque(false);

		// =========================
		// Right panel for input fields
		// =========================
		JPanel panelFields = new JPanel();
		panelFields.setLayout(new GridLayout(8, 0, 5, 45));
		panelFields.setPreferredSize(new Dimension(1920, 500));
		panelFields.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelFields.setBackground(new Color(95, 102, 107, 0));
		panelFields.setOpaque(false);

		// =========================
		// UI Components
		// =========================

		// Screen title
		JLabel title = Components_Everywhere.Title("Login");

		// Labels for user credentials
		JLabel userID = Login_Screen_Components.userID();
		JLabel userPassword = Login_Screen_Components.userPassword();

		// Message label for login feedback (errors / success)
		JLabel messageLabel = Login_Screen_Components.messageLabel();

		// Input fields for user credentials
		JTextField ID = Login_Screen_Components.ID();
		JPasswordField password = Login_Screen_Components.password();

		// Login button with action logic attached
		// Uses the same input field and message label instances
		JButton login = Login_Screen_Components.loginButton(ID, password, messageLabel);

		// =========================
		// Layout composition
		// =========================

		// Add top and center panels to main container
		panelMain.add(panelMainNorth, BorderLayout.NORTH);
		panelMain.add(panelMainCenter, BorderLayout.CENTER);

		// Add title to top bar
		panelMainNorth.add(title);

		// Add label and field panels to center panel
		panelMainCenter.add(panelText);
		panelMainCenter.add(panelFields);

		// Add labels to left panel
		panelText.add(userID);
		panelText.add(userPassword);
		panelText.add(messageLabel);

		// Add input fields and button to right panel
		panelFields.add(ID);
		panelFields.add(password);
		panelFields.add(login);

		// =========================
		// Responsive font resizing
		// =========================
		List<JComponent> resizableComponents = Arrays.asList(
				title,
				userID,
				userPassword,
				messageLabel,
				ID,
				password,
				login
		);

		// Apply automatic font resizing logic
		Font_Resizer.applyResizeLogic(panelMain, resizableComponents);

		// Return fully built login screen
		return panelMain;
	}
}
