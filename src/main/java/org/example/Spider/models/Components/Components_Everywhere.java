package org.example.Spider.models.Components;

import org.example.Spider.models.Models_Everywhere.masterbutton;
import org.example.Spider.models.Models_Everywhere.masterlabel;

import javax.swing.*;

import java.awt.*;

import static java.awt.Color.*;

public class Components_Everywhere {


	public static JLabel Title(String text) {
		masterlabel titel = new masterlabel(text, white);
		return titel.getMasterLabel();
	}

	public static JButton homeButton(Color color) {
		masterbutton home = new masterbutton("Home", "screenMain", color);
		return home.getMasterbutton();
	}

	public static JButton hadoButton(Color color) {
		masterbutton hado = new masterbutton("Hado", "screenHado", color);
		return hado.getMasterbutton();
	}

	public static JButton hadoRButton(Color color) {
		masterbutton hadoR = new masterbutton("HadoR", "screenHadoR", color);
		return hadoR.getMasterbutton();
	}

	public static JButton learnButton(Color color) {
		masterbutton learn = new masterbutton("Learn", "screenLearn", color);
		return learn.getMasterbutton();
	}

	public static JButton infoButton(Color color) {
		masterbutton info = new masterbutton("Info", "screenInfo", color);
		return info.getMasterbutton();
	}

}
