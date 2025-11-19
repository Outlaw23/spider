package org.example.Spider.models.Components.Screens;

import org.example.Spider.models.Models_Everywhere.masterbutton;
import org.example.Spider.models.Models_Everywhere.mastertextarea;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.gray;

public class Hado_Screen_Components {
	public static JTextArea input() {
		mastertextarea input = new mastertextarea();
		return input.gettextinput();
	}

	public static JTextArea output() {
		mastertextarea output = new mastertextarea();
		return output.gettextoutput();
	}

	public  static JButton translate() {
		masterbutton translate = new masterbutton("Translate", "", gray);
		translate.transletActionListener(input(),output());
		return translate.getMasterbutton();
	}
}
