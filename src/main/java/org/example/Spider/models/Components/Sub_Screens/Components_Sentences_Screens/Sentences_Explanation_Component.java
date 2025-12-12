package org.example.Spider.models.Components.Sub_Screens.Components_Sentences_Screens;

import org.example.Spider.models.Models_Everywhere.MasterButton;
import org.example.Spider.models.Models_Everywhere.MasterLabel;

import javax.swing.*;

import static java.awt.Color.gray;
import static java.awt.Color.white;

public class Sentences_Explanation_Component {

		public  static JLabel ExplanationSentences() {
			MasterLabel explanation = new MasterLabel(
					"<html><font size=6>still to come</font></html>",
					white
			);
			return explanation.getMasterLabel();

		}

	public static JButton startButtonSentences() {
		MasterButton Start = new MasterButton("Start", "screenSentencesLearn", gray);


		return Start.getMasterbutton();
	}


}
