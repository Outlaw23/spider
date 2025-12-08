package org.example.Spider.models.Components.Screens;

import org.example.Spider.models.Models_Everywhere.masterbutton;
import org.example.Spider.models.Models_Everywhere.mastertextarea;

import javax.swing.*;

import static java.awt.Color.gray;

public class HadoR_Screen_Components {

	public static JTextArea intputR() {
		mastertextarea inputR = new mastertextarea();
		return inputR.gettextinputR();
	}

	public static JTextArea outputR() {
		mastertextarea outputR = new mastertextarea();
		return outputR.gettextoutputR();
	}

	public static JButton translateR() {
		masterbutton translateR = new masterbutton("Translate", "", gray);
		translateR.transletRActionListener(intputR(), outputR());
		return translateR.getMasterbutton();
	}
}
