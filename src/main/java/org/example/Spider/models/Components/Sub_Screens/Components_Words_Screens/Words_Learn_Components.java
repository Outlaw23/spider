package org.example.Spider.models.Components.Sub_Screens.Components_Words_Screens;

import org.example.Spider.models.Components.Components_Everywhere;
import org.example.Spider.models.Models_Everywhere.MasterTextPane;
import org.example.Spider.models.Models_Everywhere.MasterButton;
import org.example.Spider.models.Models_Everywhere.MasterLabel;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.black;
import static java.awt.Color.gray;



public class Words_Learn_Components {
	public static JButton backButton;
	public static JButton resetButton;
	public static JButton doneButton;
	public static JButton submitbutton;
	public static JLabel op1TitelLabel;

	public static JLabel op1Titel() {
		if (op1TitelLabel == null) {
			MasterLabel label = new MasterLabel("Guess words", Color.white);
			op1TitelLabel = label.getMasterLabel();
		}
		return op1TitelLabel;
	}

	public static JLabel  word(String words) {
		return Components_Everywhere.Title(words);
	}

	public static JButton back() {
		if (backButton == null) {
			MasterButton Back = new MasterButton("Back", "screenWordsExplanation", gray);
			backButton = Back.getMasterbutton();
		}
		return backButton;
	}

	public static JButton reset() {
		if (resetButton == null) {
			MasterButton Reset = new MasterButton("reset", "", gray);
			resetButton = Reset.getMasterbutton();
		}
		return resetButton;
	}

	public static JButton done() {
		if (doneButton == null) {
			MasterButton Done = new MasterButton("Done", "", gray);
			doneButton = Done.getMasterbutton();
		}
		return doneButton;
	}



	public static JButton submit() {
		if (submitbutton == null) {
			MasterButton Submit = new MasterButton("Submit", "", gray);
			submitbutton = Submit.getMasterbutton();
		}

		return submitbutton;
	}

	public static JTextPane textPane () {
		MasterTextPane pane = new MasterTextPane("", black);
		return pane.getMasterTextPane();
	}
}
