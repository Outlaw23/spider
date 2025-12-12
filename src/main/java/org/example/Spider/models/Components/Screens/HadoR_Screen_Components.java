package org.example.Spider.models.Components.Screens;

import org.example.Spider.models.Models_Everywhere.MasterButton;
import org.example.Spider.models.Models_Everywhere.MasterTextArea;

import javax.swing.*;

import static java.awt.Color.gray;

public class HadoR_Screen_Components {

	public static JTextArea intputR() {
		MasterTextArea inputR = new MasterTextArea();
		return inputR.gettextinputR();
	}

	public static JTextArea outputR() {
		MasterTextArea outputR = new MasterTextArea();
		return outputR.gettextoutputR();
	}

	public static JButton translateR() {
		MasterButton translateR = new MasterButton("Translate", "", gray);
		translateR.transletRActionListener(intputR(), outputR());
		return translateR.getMasterbutton();
	}
}
