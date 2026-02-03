package org.example.Spider.view.Learn_Sub_Screens.Sentences_Screens;

import org.example.Spider.Controllers.Font_Resizer;
import org.example.Spider.Img.Img_Paths;
import org.example.Spider.models.Components.Sub_Screens.Components_Sentences_Screens.Sentences_Learn_Component;
import org.example.Spider.models.Models_Everywhere.MasterImagePanel;
import org.example.Spider.models.Models_Everywhere.MasterPanel;
import org.example.Spider.models.Sentences.Check_Sentences_Words;
import org.example.Spider.models.Sentences.Get_Words_And_Sentences;
import org.example.Spider.models.Sentences.Screen_Reset_Sentences;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.Spider.models.Components.Sub_Screens.Components_Sentences_Screens.Sentences_Explanation_Component.inputBoxesList;

/**
 * View class from the Sentences learning screen.
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
		MasterPanel panelMain = new MasterPanel("Sentences");
		panelMain.buttondisable();


		// =========================
		// Center panel with background
		// =========================
		MasterImagePanel panelMainCenter = new MasterImagePanel(Img_Paths.background_Spider_2);
		panelMainCenter.setLayout(new BorderLayout());
		panelMainCenter.setPreferredSize(new Dimension(1920, 500));
		panelMainCenter.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
		panelMainCenter.setBackground(new Color(95, 102, 107));


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
		JPanel panelInputBoxes = new JPanel(new GridLayout(11, 0, 5, 5));
		panelInputBoxes.setPreferredSize(new Dimension(400, 100));
		panelInputBoxes.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelInputBoxes.setBackground(new Color(95, 102, 107, 0));
		panelInputBoxes.setOpaque(false);

		// =========================
		// Bottom buttons panel
		// =========================
		JPanel panelButtons = new JPanel(new GridLayout(0, 10, 10, 0));
		panelButtons.setOpaque(false);

		JPanel panelButtonsWrapper = new JPanel(new BorderLayout());
		panelButtonsWrapper.setOpaque(false);



		// =========================
		// Instruction label
		// =========================
		JLabel words = Sentences_Learn_Component.words();
		JLabel score = Sentences_Learn_Component.scoreLabel();

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
						words,
						score,
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

		panelMain.add(panelMainCenter, BorderLayout.CENTER);



		panelMainCenter.add(panelText, BorderLayout.NORTH);
		panelMainCenter.add(panelSentenceAndWords, BorderLayout.CENTER);
		panelMainCenter.add(panelInputBoxes, BorderLayout.EAST);
		panelMainCenter.add(panelButtonsWrapper, BorderLayout.SOUTH);

		panelText.add(words);
		panelButtons.add(back);
		panelButtons.add(submit);
		panelButtons.add(done);

		panelButtonsWrapper.add(panelButtons, BorderLayout.CENTER);
		panelButtonsWrapper.add(score, BorderLayout.SOUTH);



		// =========================
		// Responsive font resizing
		// =========================
		List<JComponent> resizableComponents = new ArrayList<>();
		resizableComponents.add(words);
		resizableComponents.addAll(sentenceLabels);
		resizableComponents.addAll(inputBoxesList);
		resizableComponents.add(submit);
		resizableComponents.add(back);
		resizableComponents.add(done);
		resizableComponents.add(score);

		Font_Resizer.applyResizeLogic(panelMain, resizableComponents);

		// Return completed panel
		return panelMain;
	}
}
