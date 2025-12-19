package org.example.Spider.models.Components.Screens;

import org.example.Spider.models.Models_Everywhere.MasterButton;
import org.example.Spider.models.Models_Everywhere.MasterTextArea;

import javax.swing.*;

import static java.awt.Color.gray;

/**
 * Provides reusable UI components for the
 * HadoR screen of the application.
 */
public class HadoR_Screen_Components {

	/**
	 * Creates a text area for entering HadoR input.
	 *
	 * @return a configured JTextArea for input
	 */
	public static JTextArea intputR() {
		MasterTextArea inputR = new MasterTextArea();
		return inputR.gettextinputR();
	}

	/**
	 * Creates a text area for displaying HadoR output.
	 *
	 * @return a configured JTextArea for output
	 */
	public static JTextArea outputR() {
		MasterTextArea outputR = new MasterTextArea();
		return outputR.gettextoutputR();
	}

	/**
	 * Creates a Translate button for HadoR conversion.
	 * Attaches an action listener that takes input from intputR()
	 * and displays the result in outputR().
	 *
	 * @return a configured JButton for translation
	 */
	public static JButton translateR() {
		MasterButton translateR = new MasterButton("Translate", "", gray);

		// Attach action listener for translating text from inputR to outputR
		translateR.transletRActionListener(intputR(), outputR());

		return translateR.getMasterbutton();
	}
}
