package org.example.Spider.models.Components;

import org.example.Spider.models.Models_Everywhere.MasterButton;
import org.example.Spider.models.Models_Everywhere.MasterLabel;

import javax.swing.*;

import java.awt.*;

import static java.awt.Color.*;

public class Components_Everywhere {


	public static JLabel Title(String text) {
		MasterLabel titel = new MasterLabel(text, white);
		return titel.getMasterLabel();
	}

	public static JButton homeButton(Color color) {
		MasterButton home = new MasterButton("Home", "screenMain", color);
		return home.getMasterbutton();
	}

	public static JButton hadoButton(Color color) {
		MasterButton hado = new MasterButton("Hado", "screenHado", color);
		return hado.getMasterbutton();
	}

	public static JButton hadoRButton(Color color) {
		MasterButton hadoR = new MasterButton("HadoR", "screenHadoR", color);
		return hadoR.getMasterbutton();
	}

	public static JButton learnButton(Color color) {
		MasterButton learn = new MasterButton("Learn", "screenLearn", color);
		return learn.getMasterbutton();
	}

	public static JButton infoButton(Color color) {
		MasterButton info = new MasterButton("Info", "screenInfo", color);
		return info.getMasterbutton();
	}

}
