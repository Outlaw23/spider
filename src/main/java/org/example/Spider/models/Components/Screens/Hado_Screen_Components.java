package org.example.Spider.models.Components.Screens;

import org.example.Spider.models.Models_Everywhere.MasterButton;
import org.example.Spider.models.Models_Everywhere.MasterTextArea;

import javax.swing.*;

import static java.awt.Color.gray;

public class Hado_Screen_Components {
	public static JTextArea input() {
		MasterTextArea input = new MasterTextArea();
		return input.gettextinput();
	}

	public static JTextArea output() {
		MasterTextArea output = new MasterTextArea();
		return output.gettextoutput();
	}

	public  static JButton translate() {
		MasterButton translate = new MasterButton("Translate", "", gray);
		translate.transletActionListener(input(),output());
		return translate.getMasterbutton();
	}
}
