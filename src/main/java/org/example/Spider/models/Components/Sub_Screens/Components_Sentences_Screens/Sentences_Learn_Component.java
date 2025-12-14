package org.example.Spider.models.Components.Sub_Screens.Components_Sentences_Screens;

import org.example.Spider.models.Components.Components_Everywhere;
import org.example.Spider.models.Models_Everywhere.MasterLabel;

import javax.swing.*;
import java.awt.*;

public class Sentences_Learn_Component {

	public static JLabel words () {
		MasterLabel words = new MasterLabel("", Color.white);
		return words.getMasterLabel();
	}

	public static JLabel Sentence(String Sentence) {
		return Components_Everywhere.Title(Sentence);
	}
}
