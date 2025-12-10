package org.example.Spider.models.Models_Everywhere;


import org.example.Spider.Controllers.Screen_controller;
import org.example.Spider.models.Learn.Check_Word;
import org.example.Spider.models.Login.Login_Verification;
import org.example.Spider.models.hado_language.Hado_Translater;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class masterbutton {
	// Hado translator instance used for translation actions
	Hado_Translater hado = new Hado_Translater();
	Login_Verification login = new Login_Verification();
	Check_Word check = new Check_Word();

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
		masterbutton.addActionListener(_ -> Screen_controller.showPanel(panelname));
	}

	// Returns the JButton so it can be added to panels
	public JButton getMasterbutton() {
		return masterbutton;
	}

	// Attach translation action: transforms input to output when button is clicked
	public void transletActionListener(JTextArea input, JTextArea output) {
		masterbutton.addActionListener(_ -> hado.transform(input, output));
	}

	// Attach reverse translation action
	public void transletRActionListener(JTextArea inputR, JTextArea outputR) {
		masterbutton.addActionListener(_ -> hado.transformR(inputR, outputR));
	}

	public void loginButtonActionListener(JTextField ID, JPasswordField password, JLabel messageLabel) {
		masterbutton.addActionListener(_ -> login.loginVerification(ID, password, messageLabel));


	}

	public void start(List<JTextPane> guess) {
		masterbutton.addActionListener(_ -> check.RowsTrue(guess));

	}
}

