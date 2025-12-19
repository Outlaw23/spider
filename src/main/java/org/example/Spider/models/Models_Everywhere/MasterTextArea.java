package org.example.Spider.models.Models_Everywhere;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * A reusable class for multiple pre-configured JTextAreas used throughout the application.
 * Provides standardized fonts, borders, and read-only settings for output areas.
 */
public class MasterTextArea {

	/** Static JTextArea instances to avoid multiple initializations */
	private static JTextArea masterTextArea;
	private static JTextArea input;
	private static JTextArea output;
	private static JTextArea inputR;
	private static JTextArea outputR;
	private static JTextArea ID;
	private static JTextArea password;
	private static JTextArea briefExplanation;

	/**
	 * Constructor initializes all text areas if they haven't been created yet.
	 * Ensures consistent font, border, and editable settings for each type of text area.
	 */
	public MasterTextArea() {
		if (masterTextArea == null) {
			Border bordertextarea = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
			masterTextArea = new JTextArea();
			masterTextArea.setFont(new Font("Arial", Font.PLAIN, 30));
			masterTextArea.setBorder(bordertextarea);
		}

		if (input == null) {
			Border bordertextarea = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
			input = new JTextArea();
			input.setFont(new Font("Arial", Font.PLAIN, 25));
			input.setBorder(bordertextarea);
		}

		if (output == null) {
			Border bordertextarea = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
			output = new JTextArea();
			output.setFont(new Font("Arial", Font.PLAIN, 25));
			output.setBorder(bordertextarea);
			output.setEditable(false);
		}

		if (inputR == null) {
			Border bordertextarea = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
			inputR = new JTextArea();
			inputR.setFont(new Font("Arial", Font.PLAIN, 25));
			inputR.setBorder(bordertextarea);
		}

		if (outputR == null) {
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

		if (briefExplanation == null) {
			Border bordertextarea = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
			briefExplanation = new JTextArea();
			briefExplanation.setFont(new Font("Arial", Font.PLAIN, 25));
			briefExplanation.setBorder(bordertextarea);
		}
	}

	/**
	 * Returns the input JTextArea.
	 *
	 * @return the input JTextArea
	 */
	public JTextArea gettextinput() {
		return input;
	}

	/**
	 * Returns the output JTextArea (read-only).
	 *
	 * @return the output JTextArea
	 */
	public JTextArea gettextoutput() {
		return output;
	}

	/**
	 * Returns the reverse input JTextArea.
	 *
	 * @return the reverse input JTextArea
	 */
	public JTextArea gettextinputR() {
		return inputR;
	}

	/**
	 * Returns the reverse output JTextArea (read-only).
	 *
	 * @return the reverse output JTextArea
	 */
	public JTextArea gettextoutputR() {
		return outputR;
	}

	/**
	 * Returns the brief explanation JTextArea.
	 *
	 * @return the brief explanation JTextArea
	 */
	public JTextArea getBriefExplanation() {
		return briefExplanation;
	}
}
