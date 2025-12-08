package org.example.Spider.models.Components.Screens;

import org.example.Spider.models.Models_Everywhere.masterbutton;
import org.example.Spider.models.Models_Everywhere.masterlabel;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.gray;
import static java.awt.Color.white;



public class Words_Learn_Screen_Components {
	public static JButton backButton;
	public static JButton resetButton;
	public static JButton doneButton;
	public static JButton submitbutton;
	public static JLabel op1TitelLabel;

	public static JLabel op1Titel() {
		if (op1TitelLabel == null) {
			masterlabel label = new masterlabel("Guess words", Color.white);
			op1TitelLabel = label.getMasterLabel();
		}
		return op1TitelLabel;
	}

	public static JLabel  word(String words) {
		masterlabel word = new masterlabel(words, white);
		return  word.getMasterLabel();
	}

	public static JButton back() {
		if (backButton == null) {
			masterbutton Back = new masterbutton("Back", "screenWordsExplanation", gray);
			backButton = Back.getMasterbutton();
		}
		return backButton;
	}

	public static JButton reset() {
		if (resetButton == null) {
			masterbutton Reset = new masterbutton("reset", "", gray);
			resetButton = Reset.getMasterbutton();
		}
		return resetButton;
	}

	public static JButton done() {
		if (doneButton == null) {
			masterbutton Done = new masterbutton("Done", "", gray);
			doneButton = Done.getMasterbutton();
		}
		return doneButton;
	}



	public static JButton submit() {
		if (submitbutton == null) {
			masterbutton Submit = new masterbutton("Submit", "", gray);
			submitbutton = Submit.getMasterbutton();
		}

		return submitbutton;
	}

	public static JTextPane textPane () {
		JTextPane textPane = new JTextPane();
		return textPane;
	}
}
