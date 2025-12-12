package org.example.Spider.models.hado_language;


import org.example.Spider.models.Learn.List_Maker;
import org.example.Spider.models.Models_Everywhere.MasterLabel;

import javax.swing.*;
import java.util.List;

import static java.awt.Color.white;

public class Hado_Translater {

	// Transform input text from the "mastertextarea" into Hado language and put it in the output
	public void transform(JTextArea input, JTextArea output) {
		// Get text from input
		String text = input.getText();
		StringBuilder translator = new StringBuilder();

		// Translate each character using HadoLanguageMvc
		for (char c : text.toCharArray()) {
			translator.append(HadoLanguageMvc.hadoLanguagee(String.valueOf(c)));
		}

		// Set translated text in output
		output.setText(translator.toString());
	}

	// Transform input text from the "mastertextarea" from Hado language back to normal
	public void transformR(JTextArea inputR, JTextArea outputR) {
		// Get text from input
		String text = inputR.getText();
		StringBuilder translator = new StringBuilder();

		// Reverse-translate each character using HadoLanguageMvc
		for (char c : text.toCharArray()) {
			translator.append(HadoLanguageMvc.reverseHadoLanguage(String.valueOf(c)));
		}

		// Set translated text in output
		outputR.setText(translator.toString());
	}

	public void getWords(JPanel panelWords) {
		panelWords.removeAll();
		List<String> woorden = List_Maker.newWoords();

		for (String words : woorden) {
			MasterLabel word = new MasterLabel(words, white);

			StringBuilder wordlist = new StringBuilder();
			for (char c : words.toCharArray()) {
				wordlist.append(HadoLanguageMvc.hadoLanguagee(String.valueOf(c)));
			}

			word.getMasterLabel().setText(wordlist.toString());
			panelWords.add(word.getMasterLabel());
		}

		panelWords.revalidate();	
		panelWords.repaint();
	}

}