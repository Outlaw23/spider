package org.example.Spider.models.Components.Screens;

import org.example.Spider.models.Models_Everywhere.masterbutton;
import org.example.Spider.models.Models_Everywhere.masterlabel;

import javax.swing.*;

import static java.awt.Color.gray;
import static java.awt.Color.white;

public class Words_Learn_Screen_Components {

	public static JLabel  op1Titel() {
		masterlabel op1Titel = new masterlabel("  guess words", white);
		return  op1Titel.getMasterLabel();
	}

	public static JLabel  word(String words) {
		masterlabel word = new masterlabel(words, white);
		return  word.getMasterLabel();
	}

	public static JButton back() {
		masterbutton Back = new masterbutton("Back", "wordsExplanation", gray);
		return   Back.getMasterbutton();
	}

	public static JButton reset() {
		masterbutton Reset = new masterbutton("reset", "", gray);
		return   Reset.getMasterbutton();
	}

	public static JButton submit() {
		masterbutton Submit = new masterbutton("Submit", "", gray);
		return   Submit.getMasterbutton();
	}

	public static JTextPane textPane () {
		JTextPane textPane = new JTextPane();
		return textPane;
	}
}
