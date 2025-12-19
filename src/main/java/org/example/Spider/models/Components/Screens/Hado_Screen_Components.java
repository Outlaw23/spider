package org.example.Spider.models.Components.Screens;

import org.example.Spider.models.Models_Everywhere.MasterButton;
import org.example.Spider.models.Models_Everywhere.MasterTextArea;

import javax.swing.*;

import static java.awt.Color.gray;

/**
 * Provides reusable UI components for the
 * Hado screen of the application.
 */
public class Hado_Screen_Components {

	/**
	 * Creates a text area for entering Hado input.
	 *
	 * @return a configured JTextArea for input
	 */
	public static JTextArea input() {
		MasterTextArea input = new MasterTextArea();
		return input.gettextinput();
	}

	/**
	 * Creates a text area for displaying Hado output.
	 *
	 * @return a configured JTextArea for output
	 */
	public static JTextArea output() {
		MasterTextArea output = new MasterTextArea();
		return output.gettextoutput();
	}

	/**
	 * Creates a Translate button for Hado conversion.
	 * Attaches an action listener that takes input from input()
	 * and displays the result in output().
	 *
	 * @return a configured JButton for translation
	 */
	public static JButton translate() {
		MasterButton translate = new MasterButton("Translate", "", gray);

		// Attach action listener for translating text from input to output
		translate.transletActionListener(input(), output());

		return translate.getMasterbutton();
	}
}
