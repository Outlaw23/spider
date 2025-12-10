package org.example.Spider.models.Models_Everywhere;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class mastertextarea {
	// Static JTextArea instances to avoid multiple initializations
	private static JTextArea masterTextArea;
	private static JTextArea input;
	private static JTextArea output;
	private static JTextArea inputR;
	private static JTextArea outputR;
	private static JTextArea ID;
	private static JTextArea password;


	// Constructor: initializes text areas if they haven't been created yet
	public mastertextarea() {
		if (masterTextArea == null) {  // Prevents reinitialization
			Border bordertextarea = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
			masterTextArea = new JTextArea();
			masterTextArea.setFont(new Font("Arial", Font.PLAIN, 30)); // set font
			masterTextArea.setBorder(bordertextarea); // add border
		}

		if (input == null) { // input text area
			Border bordertextarea = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
			input = new JTextArea();
			input.setFont(new Font("Arial", Font.PLAIN, 25));
			input.setBorder(bordertextarea);
		}

		if (output == null) { // output text area (read-only)
			Border bordertextarea = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
			output = new JTextArea();
			output.setFont(new Font("Arial", Font.PLAIN, 25));
			output.setBorder(bordertextarea);
			output.setEditable(false); // output cannot be edited
		}

		if (inputR == null) { // reverse input text area
			Border bordertextarea = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
			inputR = new JTextArea();
			inputR.setFont(new Font("Arial", Font.PLAIN, 25));
			inputR.setBorder(bordertextarea);
		}

		if (outputR == null) { // reverse output text area (read-only)
			Border bordertextarea = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
			outputR = new JTextArea();
			outputR.setFont(new Font("Arial", Font.PLAIN, 25));
			outputR.setBorder(bordertextarea);
			outputR.setEditable(false);
		}
		if (ID == null) {
			Border bordertextarea = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
			ID = new JTextArea();
			ID.setFont(new Font("Arial", Font.PLAIN, 25));
			ID.setBorder(bordertextarea);
		}
		if (password == null) {
			Border bordertextarea = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
			password = new JTextArea();
			password.setFont(new Font("Arial", Font.PLAIN, 25));
			password.setBorder(bordertextarea);
		}
	}



	// Returns the input text area
	public JTextArea gettextinput() {
		return input;
	}

	// Returns the output text area
	public JTextArea gettextoutput() {
		return output;
	}

	// Returns the reverse input text area
	public JTextArea gettextinputR() {
		return inputR;
	}

	// Returns the reverse output text area
	public JTextArea gettextoutputR() {
		return outputR;
	}
}
