package org.example.Spider.view.Learn_Sub_Screens.Sentences_Screens;

import org.example.Spider.Controllers.Font_Resizer;
import org.example.Spider.Img.Img_Paths;
import org.example.Spider.models.Components.Components_Everywhere;
import org.example.Spider.models.Components.Sub_Screens.Components_Sentences_Screens.Sentences_Learn_Component;
import org.example.Spider.models.Models_Everywhere.masterpanel;
import org.example.Spider.models.Sentences.Check_Sentences_Words;
import org.example.Spider.models.Sentences.Get_Words_And_Sentences;
import org.example.Spider.models.Sentences.Screen_Reset_Sentences;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Color.gray;
import static org.example.Spider.models.Components.Sub_Screens.Components_Sentences_Screens.Sentences_Explanation_Component.inputBoxesList;

/**
 * View class for the Sentences learning screen.
 * <p>
 * This screen allows the user to place given Hado words
 * into sentence structures and validate their answers.
 */
public class Sentences_Learn_Screen_view {

	// Data provider for words and sentences
	Get_Words_And_Sentences get_words_and_sentences = new Get_Words_And_Sentences();

	/**
	 * Creates and returns the Sentences Learn screen panel.
	 *
	 * @return fully constructed Sentences Learn JPanel
	 */
	public JPanel screenSentencesLearn() {

		// =========================
		// Main container
		// =========================
		JPanel panelMain = new JPanel();
		panelMain.setLayout(new BorderLayout());
		panelMain.setPreferredSize(new Dimension(1920, 1080));
		panelMain.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		panelMain.setBackground(Color.WHITE);

		// =========================
		// Center panel with background
		// =========================
		masterpanel panelMainCenter = new masterpanel(Img_Paths.background_Spider_2);
		panelMainCenter.setLayout(new BorderLayout());
		panelMainCenter.setPreferredSize(new Dimension(1920, 500));
		panelMainCenter.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
		panelMainCenter.setBackground(new Color(95, 102, 107));

		// =========================
		// Top navigation bar
		// =========================
		masterpanel panelMainNorth = new masterpanel(Img_Paths.Background_Strip);
		panelMainNorth.setLayout(new GridLayout(0, 10, 5, 0));
		panelMainNorth.setPreferredSize(new Dimension(1920, 50));
		panelMainNorth.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelMainNorth.setBackground(new Color(38, 66, 87));

		// =========================
		// Instruction text panel
		// =========================
		JPanel panelText = new JPanel(new GridLayout(1, 0, 5, 0));
		panelText.setPreferredSize(new Dimension(1920, 150));
		panelText.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelText.setBackground(new Color(95, 102, 107, 0));
		panelText.setOpaque(false);

		// =========================
		// Sentence & word display panel
		// =========================
		JPanel panelSentenceAndWords = new JPanel(new GridLayout(10, 0, 5, 0));
		panelSentenceAndWords.setPreferredSize(new Dimension(1920, 100));
		panelSentenceAndWords.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelSentenceAndWords.setBackground(new Color(38, 66, 87, 0));

		// =========================
		// Input boxes panel
		// =========================
		JPanel panelInputBoxes = new JPanel(new GridLayout(10, 0, 5, 5));
		panelInputBoxes.setPreferredSize(new Dimension(400, 100));
		panelInputBoxes.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelInputBoxes.setBackground(new Color(95, 102, 107, 0));

		// =========================
		// Bottom buttons panel
		// =========================
		JPanel panelButtons = new JPanel(new GridLayout(0, 10, 5, 0));
		panelButtons.setPreferredSize(new Dimension(100, 50));
		panelButtons.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelButtons.setBackground(new Color(38, 66, 87, 0));

		// =========================
		// Title and navigation buttons
		// =========================
		JLabel title = Components_Everywhere.Title("Sentences");

		JButton home = Components_Everywhere.homeButton(gray);
		JButton hado = Components_Everywhere.hadoButton(gray);
		JButton hadoR = Components_Everywhere.hadoRButton(gray);
		JButton learn = Components_Everywhere.learnButton(gray);
		JButton info = Components_Everywhere.infoButton(gray);

		// Disable navigation during exercise
		home.setEnabled(false);
		hado.setEnabled(false);
		hadoR.setEnabled(false);
		learn.setEnabled(false);
		info.setEnabled(false);

		// =========================
		// Instruction label
		// =========================
		JLabel words = Sentences_Learn_Component.words();

		get_words_and_sentences.load();
		get_words_and_sentences.readFive();

		List<String> word = get_words_and_sentences.getCurrentWords();
		List<String> wordHado = get_words_and_sentences.getCurrentWordsHado();

		words.setText("<html>Place these words in the sentences:<br>"
				+ String.join(" || ", wordHado) + "</html>");

		// =========================
		// Sentence labels
		// =========================
		List<JLabel> sentenceLabels = new ArrayList<>();
		List<String> sentences = get_words_and_sentences.getCurrentSentences();

		for (String sentence : sentences) {
			JLabel sentenceLabel = Sentences_Learn_Component.Sentence(sentence);
			sentenceLabel.setText(sentence);
			panelSentenceAndWords.add(sentenceLabel);
			sentenceLabels.add(sentenceLabel);
		}

		// =========================
		// Input boxes
		// =========================
		for (int i = 0; i < 10; i++) {
			JTextPane inputBox = Sentences_Learn_Component.InputBoxes();
			inputBoxesList.add(inputBox);
			panelInputBoxes.add(inputBox);
			inputBox.setEnabled(false);
			inputBox.setBackground(new Color(55, 64, 54));
		}

		// =========================
		// Sentence checker setup
		// =========================
		Check_Sentences_Words checker = new Check_Sentences_Words();
		List<List<String>> correcteWoordenLijsten = new ArrayList<>();

		for (int i = 0; i < inputBoxesList.size(); i++) {
			correcteWoordenLijsten.add(word);
		}

		// =========================
		// Action buttons
		// =========================
		JButton submit = Sentences_Learn_Component.submit();
		submit.addActionListener(_ ->
				checker.checkSentenceWords(inputBoxesList, correcteWoordenLijsten));

		JButton back = Sentences_Learn_Component.back();

		JButton done = Sentences_Learn_Component.done();
		done.setEnabled(false);
		done.addActionListener(_ ->
				Screen_Reset_Sentences.resetScreen(
						title,
						words,
						submit,
						back,
						done,
						panelSentenceAndWords,
						panelInputBoxes,
						checker,
						wordHado,
						sentences
				));

		// =========================
		// Layout composition
		// =========================
		panelMain.add(panelMainNorth, BorderLayout.NORTH);
		panelMain.add(panelMainCenter, BorderLayout.CENTER);

		panelMainNorth.add(title);
		panelMainNorth.add(home);
		panelMainNorth.add(hado);
		panelMainNorth.add(hadoR);
		panelMainNorth.add(learn);
		panelMainNorth.add(info);

		panelMainCenter.add(panelText, BorderLayout.NORTH);
		panelMainCenter.add(panelSentenceAndWords, BorderLayout.CENTER);
		panelMainCenter.add(panelInputBoxes, BorderLayout.EAST);
		panelMainCenter.add(panelButtons, BorderLayout.SOUTH);

		panelText.add(words);
		panelButtons.add(back);
		panelButtons.add(submit);
		panelButtons.add(done);

		// =========================
		// Responsive font resizing
		// =========================
		List<JComponent> resizableComponents = new ArrayList<>();
		resizableComponents.add(title);
		resizableComponents.add(home);
		resizableComponents.add(hado);
		resizableComponents.add(hadoR);
		resizableComponents.add(learn);
		resizableComponents.add(info);
		resizableComponents.add(words);
		resizableComponents.addAll(sentenceLabels);
		resizableComponents.addAll(inputBoxesList);
		resizableComponents.add(submit);
		resizableComponents.add(back);
		resizableComponents.add(done);

		Font_Resizer.applyResizeLogic(panelMain, resizableComponents);

		// Return completed panel
		return panelMain;
	}
}
