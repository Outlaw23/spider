package org.example.Spider.view.Learn_Sub_Screens.Sentences_Screens;

import org.example.Spider.Controllers.Font_Resizer;
import org.example.Spider.Img.Img_Paths;
import org.example.Spider.models.Components.Components_Everywhere;
import org.example.Spider.models.Components.Sub_Screens.Components_Sentences_Screens.Sentences_Learn_Component;
import org.example.Spider.models.Models_Everywhere.masterpanel;
import org.example.Spider.models.Sentences.Get_Words_And_Sentences;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Color.darkGray;
import static java.awt.Color.gray;

public class Sentences_Learn_Screen_view {
	Get_Words_And_Sentences get_words_and_sentences = new Get_Words_And_Sentences();


	public JPanel screenSentencesLearn() {

		// Main container with BorderLayout
		JPanel panelMain = new JPanel();
		panelMain.setLayout(new BorderLayout());
		panelMain.setPreferredSize(new Dimension(1920, 1080));
		panelMain.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		panelMain.setBackground(new Color(255, 255, 255));

		// Sub-panels for layout structure
		// Center area with two rows for short descriptions
		masterpanel panelMainCenter = new masterpanel(Img_Paths.background_Spider_2);
		panelMainCenter.setLayout(new  BorderLayout());
		panelMainCenter.setPreferredSize(new Dimension(1920, 500));
		panelMainCenter.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
		panelMainCenter.setBackground(new Color(95, 102, 107));

		// North/top navigation area
		masterpanel panelMainNorth = new masterpanel(Img_Paths.Background_Strip);
		panelMainNorth.setLayout(new GridLayout(0, 10, 5, 0));
		panelMainNorth.setPreferredSize(new Dimension(1920, 50));
		panelMainNorth.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelMainNorth.setBackground(new Color(38, 66, 87));

		JPanel panelWords = new JPanel();
		panelWords.setLayout(new GridLayout(1, 0, 5, 0));
		panelWords.setPreferredSize(new Dimension(1920, 100));
		panelWords.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelWords.setBackground(new Color(95, 102, 107, 0));
		panelWords.setOpaque(false);

		JPanel panelSentences = new JPanel();
		panelSentences.setLayout(new GridLayout(5, 0, 5, 5));
		panelSentences.setPreferredSize(new Dimension(1920, 100));
		panelSentences.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelSentences.setBackground(new Color(38, 66, 87, 0));

		// Labels
		// Title label (screen heading)
		JLabel title = Components_Everywhere.Title("Sentences");

		// Buttons (top navigation)
		// Home button
		JButton home = Components_Everywhere.homeButton(darkGray);
		// Hado button
		JButton hado = Components_Everywhere.hadoButton(gray);
		// HadoR button
		JButton hadoR = Components_Everywhere.hadoRButton(gray);
		//Learn button
		JButton learn = Components_Everywhere.learnButton(gray);
		//Info button
		JButton info = Components_Everywhere.infoButton(gray);

		//
		JLabel words = Sentences_Learn_Component.words();
		get_words_and_sentences.load();
		get_words_and_sentences.readFive();
		List<String> word = get_words_and_sentences.getCurrentWords();
		words.setText("<html>Place these words in the sentences:<br>" + String.join(" || ", word) + "</html>");
		IO.println(String.join(" || ", word));

		List<JLabel> sentenceLabels = new ArrayList<>();

		List<String> sentences = get_words_and_sentences.getCurrentSentences();
		for (String sentence : sentences) {
			JLabel sentenceLabel = Sentences_Learn_Component.Sentence(sentence);
			sentenceLabel.setText(sentence);
			panelSentences.add(sentenceLabel);

			sentenceLabels.add(sentenceLabel);
		}

		// Compose layout: add subpanels to the main panel
		panelMain.add(panelMainNorth, BorderLayout.NORTH);
		panelMain.add(panelMainCenter, BorderLayout.CENTER);

		// Top bar contents
		panelMainNorth.add(title);
		panelMainNorth.add(home);
		panelMainNorth.add(hado);
		panelMainNorth.add(hadoR);
		panelMainNorth.add(learn);
		panelMainNorth.add(info);

		// Center content
		panelMainCenter.add(panelWords, BorderLayout.NORTH);
		panelMainCenter.add(panelSentences, BorderLayout.CENTER);

		//
		panelWords.add(words);

		// Components that will resize when the window is resized
		List<JComponent> resizableComponents = new ArrayList<>();

		// vaste onderdelen
		resizableComponents.add(title);
		resizableComponents.add(home);
		resizableComponents.add(hado);
		resizableComponents.add(hadoR);
		resizableComponents.add(learn);
		resizableComponents.add(info);
		resizableComponents.add(words);
		resizableComponents.addAll(sentenceLabels);
		Font_Resizer.applyResizeLogic(panelMain, resizableComponents);

		// Return the assembled main panel
		return panelMain;
	}

}
