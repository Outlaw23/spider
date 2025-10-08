package org.example.Spider.models.Models_Everywhere;

import javax.swing.*;
import java.awt.*;

public class masterTextPane {
	// The actual JLabel that will be styled
	JTextPane masterTextPane = new JTextPane();

	// Constructor: creates a new masterlabel with given text and color
	public masterTextPane(String text, Color coler) {
		masterTextPane.setFont(new Font("Arial", Font.PLAIN, 30)); // set font and size
		masterTextPane.setText(text); // set label text
		masterTextPane.setForeground(coler); // set text color
	}

	// Returns the JLabel so it can be added to panels
	public JTextPane getMasterTextPane() {
		return masterTextPane;
	}
}
