package org.example.Spider.models.hado_language;

import org.example.Spider.models.Words.List_Maker;
import org.example.Spider.models.Models_Everywhere.MasterLabel;

import javax.swing.*;
import java.util.List;

import static java.awt.Color.white;

/**
 * Provides methods for translating text to and from the Hado language,
 * as well as generating Hado-translated word lists for display.
 */
public class Hado_Translater {

	/**
	 * Transforms input text from a JTextArea into Hado language
	 * and sets the result in the output JTextArea.
	 *
	 * @param input  the JTextArea containing the original text
	 * @param output the JTextArea where the translated text will be displayed
	 */
	public void transform(JTextArea input, JTextArea output) {
		String text = input.getText();
		StringBuilder translator = new StringBuilder();

		for (char c : text.toCharArray()) {
			translator.append(HadoLanguageMvc.hadoLanguagee(String.valueOf(c)));
		}

		output.setText(translator.toString());
	}

	/**
	 * Transforms input text from a JTextArea in Hado language back to normal text
	 * and sets the result in the output JTextArea.
	 *
	 * @param inputR  the JTextArea containing Hado text
	 * @param outputR the JTextArea where the reverse-translated text will be displayed
	 */
	public void transformR(JTextArea inputR, JTextArea outputR) {
		String text = inputR.getText();
		StringBuilder translator = new StringBuilder();

		for (char c : text.toCharArray()) {
			translator.append(HadoLanguageMvc.reverseHadoLanguage(String.valueOf(c)));
		}

		outputR.setText(translator.toString());
	}

	/**
	 * Generates a list of Hado-translated words and adds them
	 * as labels to the provided panel.
	 *
	 * @param panelWords the JPanel where the translated words will be displayed
	 */
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
