package org.example.Spider.models.Components.Screens;

import org.example.Spider.models.Models_Everywhere.masterlabel;

import javax.swing.*;

import static java.awt.Color.white;

public class Main_Screen_Components {

	// labes
	public static JLabel hadoLabel() {
		masterlabel hadoScreen = new masterlabel(
				"<html><font size=30>Hado</font><br/>" +
						"At Hado I have a translator that converts your text to Hado text</html>",
				white
		);
		return hadoScreen.getMasterLabel();
	}

	public static JLabel hadoRLabel() {
		masterlabel hadoRScreen = new masterlabel(
				"<html><font size=30>HadoR</font><br/>" +
						"at hadoR I have a translator who converts that hado text to your text</html>",
				white
		);
		return hadoRScreen.getMasterLabel();
	}
}
