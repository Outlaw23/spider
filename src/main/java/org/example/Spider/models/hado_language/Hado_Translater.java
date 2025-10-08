	package org.example.Spider.models.hado_language;


	import org.example.Spider.models.Learn.List_Maker;
	import org.example.Spider.models.Models_Everywhere.masterlabel;
	import org.example.Spider.models.Models_Everywhere.mastertextarea;

	import javax.swing.*;
	import java.util.ArrayList;
	import java.util.List;

	import static java.awt.Color.white;

	public class Hado_Translater {

		// Transform input text from the "mastertextarea" into Hado language and put it in the output
		public void transform(mastertextarea input, mastertextarea output) {
			// Get text from input
			String text = input.gettextinput().getText();
			StringBuilder translator = new StringBuilder();

			// Translate each character using HadoLanguageMvc
			for (char c : text.toCharArray()) {
				translator.append(HadoLanguageMvc.hadoLanguagee(String.valueOf(c)));
			}

			// Set translated text in output
			output.gettextoutput().setText(translator.toString());
		}

		// Transform input text from the "mastertextarea" from Hado language back to normal
		public void transformR(mastertextarea inputR, mastertextarea outputR) {
			// Get text from input
			String text = inputR.gettextinputR().getText();
			StringBuilder translator = new StringBuilder();

			// Reverse-translate each character using HadoLanguageMvc
			for (char c : text.toCharArray()) {
				translator.append(HadoLanguageMvc.reverseHadoLanguage(String.valueOf(c)));
			}

			// Set translated text in output
			outputR.gettextoutputR().setText(translator.toString());
		}

		public void getWords(JPanel panelWords) {
			panelWords.removeAll();
			List<String> woorden = List_Maker.newWoords();
			List<masterlabel> wordList = new ArrayList<>();
			masterlabel word = null;
			System.out.println(woorden);
			for (String words : woorden) {
				word = new masterlabel(words, white);
				StringBuilder wordlist = new StringBuilder();
				for (char c : words.toCharArray()) {
					wordlist.append(HadoLanguageMvc.hadoLanguagee(String.valueOf(c)));
					wordList.add(word);
				}
				word.getMasterLabel().setText(wordlist.toString());
				panelWords.add(word.getMasterLabel());

			}
			panelWords.revalidate();
			panelWords.repaint();
		}
	}
