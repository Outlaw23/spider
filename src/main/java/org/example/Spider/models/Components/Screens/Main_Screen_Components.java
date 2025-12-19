package org.example.Spider.models.Components.Screens;

import org.example.Spider.models.Models_Everywhere.MasterLabel;

import javax.swing.*;

import static java.awt.Color.white;

/**
 * Provides reusable UI components for the
 * main screen of the application.
 */
public class Main_Screen_Components {

	/**
	 * Creates a label for the Hado screen with title and description.
	 *
	 * @return a formatted JLabel for the Hado screen
	 */
	public static JLabel hadoLabel() {
		MasterLabel hadoScreen = new MasterLabel(
				"<html><font size=30>Hado</font><br/>" +
						"At Hado I have a translator that converts your text to Hado text</html>",
				white
		);
		return hadoScreen.getMasterLabel();
	}

	/**
	 * Creates a label for the HadoR screen with title and description.
	 *
	 * @return a formatted JLabel for the HadoR screen
	 */
	public static JLabel hadoRLabel() {
		MasterLabel hadoRScreen = new MasterLabel(
				"<html><font size=30>HadoR</font><br/>" +
						"at hadoR I have a translator who converts that hado text to your text</html>",
				white
		);
		return hadoRScreen.getMasterLabel();
	}
}
