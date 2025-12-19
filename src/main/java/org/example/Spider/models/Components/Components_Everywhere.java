package org.example.Spider.models.Components;

import org.example.Spider.models.Models_Everywhere.MasterButton;
import org.example.Spider.models.Models_Everywhere.MasterLabel;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.*;

/**
 * Utility class providing commonly used UI components
 * that are shared across multiple screens.
 */
public class Components_Everywhere {

	/**
	 * Creates a standardized title label with default styling.
	 *
	 * @param text the text to display as the title
	 * @return a configured JLabel instance
	 */
	public static JLabel Title(String text) {
		MasterLabel titel = new MasterLabel(text, white);
		return titel.getMasterLabel();
	}

	/**
	 * Creates a navigation button that redirects to the main screen.
	 *
	 * @param color the background color of the button
	 * @return a configured Home JButton
	 */
	public static JButton homeButton(Color color) {
		MasterButton home = new MasterButton("Home", "screenMain", color);
		return home.getMasterbutton();
	}

	/**
	 * Creates a navigation button that redirects to the Hado screen.
	 *
	 * @param color the background color of the button
	 * @return a configured Hado JButton
	 */
	public static JButton hadoButton(Color color) {
		MasterButton hado = new MasterButton("Hado", "screenHado", color);
		return hado.getMasterbutton();
	}

	/**
	 * Creates a navigation button that redirects to the HadoR screen.
	 *
	 * @param color the background color of the button
	 * @return a configured HadoR JButton
	 */
	public static JButton hadoRButton(Color color) {
		MasterButton hadoR = new MasterButton("HadoR", "screenHadoR", color);
		return hadoR.getMasterbutton();
	}

	/**
	 * Creates a navigation button that redirects to the Learn screen.
	 *
	 * @param color the background color of the button
	 * @return a configured Learn JButton
	 */
	public static JButton learnButton(Color color) {
		MasterButton learn = new MasterButton("Learn", "screenLearn", color);
		return learn.getMasterbutton();
	}

	/**
	 * Creates a navigation button that redirects to the Info screen.
	 *
	 * @param color the background color of the button
	 * @return a configured Info JButton
	 */
	public static JButton infoButton(Color color) {
		MasterButton info = new MasterButton("Info", "screenInfo", color);
		return info.getMasterbutton();
	}

}
