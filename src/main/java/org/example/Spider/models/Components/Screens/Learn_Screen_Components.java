package org.example.Spider.models.Components.Screens;

import org.example.Spider.models.Models_Everywhere.MasterButton;
import org.example.Spider.models.Models_Everywhere.MasterTextArea;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Color.gray;



public class Learn_Screen_Components {

	public static int numberOpdracht = 0;
	public static List<JButton> opdrachten = new ArrayList<>();

	public static JButton opdrachten() {
		MasterButton opdracht  = new MasterButton("assignment " + numberOpdracht, "", gray);
		return opdracht.getMasterbutton();
	}

	public static JTextArea briefExplanation() {
		MasterTextArea briefExplanation = new MasterTextArea();
		briefExplanation.getBriefExplanation().setEditable(false);
		briefExplanation.getBriefExplanation().setLineWrap(true);
		briefExplanation.getBriefExplanation().setWrapStyleWord(true);
		briefExplanation.getBriefExplanation().setText("""
    Words Explanation (assignment 1)

    In this game, you try to guess words in the Hado language.

    Each attempt, you enter 10 words and press "Submit".

    Color feedback:
    - Green: correct letter in the correct position
    - Yellow: correct letter in the wrong position
    - Red: letter not in the word

    You have 6 attempts to guess all words correctly.
    """);

		return briefExplanation.getBriefExplanation();
	}


}
