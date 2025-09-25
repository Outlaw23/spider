package org.example.Spider.models.Models_Everywhere;


import org.example.Spider.Controllers.Screen_controller;
import org.example.Spider.models.Login.Login_Verification;
import org.example.Spider.models.hado_language.Hado_Translater;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class masterbutton {
	// Hado translator instance used for translation actions
	Hado_Translater hado = new Hado_Translater();
	Login_Verification login = new Login_Verification();

	// The actual JButton that will be styled and used
	private final JButton masterbutton = new JButton();

	// Border for the button
	Border borderbutton = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);

	// Constructor: creates a button with a name, panel name (for switching screens), and background color
	public masterbutton(String name, String panelname, Color coler) {
		masterbutton.setText(name); // set button text
		masterbutton.setFocusPainted(false); // remove focus border
		masterbutton.setFont(new Font("Arial", Font.PLAIN, 25)); // set font
		masterbutton.setForeground(Color.white); // text color
		masterbutton.setBackground(coler); // background color
		masterbutton.setOpaque(true); // ensures background color is visible
		masterbutton.setBorder(borderbutton); // set button border
		masterbutton.setPreferredSize(new Dimension(100, 35)); // set preferred size

		// Mouse hover effect
		masterbutton.addMouseListener(new MouseAdapter() {
			Color coler = masterbutton.getBackground(); // store original color

			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				coler = masterbutton.getBackground();
				masterbutton.setBackground(new Color(52, 53, 54)); // change color on hover
			}

			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				masterbutton.setBackground(coler); // revert to original color
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				// Optional: extra click behavior can go here
			}
		});

		// Switch a panel when the button is clicked
		masterbutton.addActionListener(e -> Screen_controller.showPanel(panelname));
	}

	// Returns the JButton so it can be added to panels
	public JButton getMasterbutton() {
		return masterbutton;
	}

	// Attach translation action: transforms input to output when button is clicked
	public void transletActionListener(mastertextarea input, mastertextarea output) {
		masterbutton.addActionListener(e -> hado.transform(input, output));
	}

	// Attach reverse translation action
	public void transletRActionListener(mastertextarea inputR, mastertextarea outputR) {
		masterbutton.addActionListener(e -> hado.transformR(inputR, outputR));
	}

	public void loginButtonActionListener(mastertextarea ID, masterpasswordfield password, masterlabel messageLabel) {
		masterbutton.addActionListener(e -> login.loginVerification(ID, password.getPasswordField(),messageLabel));

		}

	public void showPanelOpdrachten(String opdrachtPanelName) {
		masterbutton.addActionListener(e -> Screen_controller.showPanel(opdrachtPanelName));
	}

	public masterbutton setName (String name){
		masterbutton.setText(name);
		return this;
	}

	public masterbutton setPanelname(String panelname){
		masterbutton.setText(panelname);
		return this;
	}

	public void setEnabled(boolean b) {
		masterbutton.setEnabled(b);
	}

	public void showWords() {
		masterbutton.addActionListener(e ->hado.getWords());
	}


}

