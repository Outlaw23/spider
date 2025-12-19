package org.example.Spider.models.Sentences;

import org.example.Spider.models.Components.Sub_Screens.Components_Sentences_Screens.Sentences_Learn_Component;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.util.List;

import static org.example.Spider.models.Components.Sub_Screens.Components_Sentences_Screens.Sentences_Explanation_Component.inputBoxesList;

/**
 * Provides functionality to reset the Sentences screen.
 * Resets titles, buttons, words, sentences panel, and input boxes to their initial state.
 */
public class Screen_Reset_Sentences {

	/**
	 * Resets the Sentences screen components to their initial state.
	 *
	 * @param title                The title label of the screen.
	 * @param wordsLabel           The label showing the words to place in sentences.
	 * @param submitBtn            The submit button for sentence checking.
	 * @param backBtn              The back button.
	 * @param doneBtn              The done button.
	 * @param panelSentenceAndWords The panel containing sentence labels.
	 * @param panelInputBoxes       The panel containing input boxes for user input.
	 * @param checker               The {@link Check_Sentences_Words} instance handling checking logic.
	 * @param wordsHado             The Hado-translated words to place in the sentences.
	 * @param sentences             The original sentences to display.
	 */
	public static void resetScreen(
			JLabel title,
			JLabel wordsLabel,
			JButton submitBtn,
			JButton backBtn,
			JButton doneBtn,
			JPanel panelSentenceAndWords,
			JPanel panelInputBoxes,
			Check_Sentences_Words checker,
			List<String> wordsHado,
			List<String> sentences
	) {

		// 1. Reset internal checker state
		checker.fullResetState();

		// 2. Reset screen title
		title.setText("Sentences");

		// 3. Reset buttons state
		submitBtn.setEnabled(true);
		backBtn.setEnabled(true);
		doneBtn.setEnabled(false);

		// 4. Reset words instruction label
		wordsLabel.setText(
				"<html>Place these words in the sentences:<br>"
						+ String.join(" || ", wordsHado)
						+ "</html>"
		);

		// 5. Reset sentences panel
		panelSentenceAndWords.removeAll();
		for (String sentence : sentences) {
			JLabel sentenceLabel = Sentences_Learn_Component.Sentence(sentence);
			sentenceLabel.setText(sentence);
			panelSentenceAndWords.add(sentenceLabel);
		}
		panelSentenceAndWords.revalidate();
		panelSentenceAndWords.repaint();

		// 6. Reset input boxes
		panelInputBoxes.removeAll();
		inputBoxesList.clear();

		for (int i = 0; i < 10; i++) {
			JTextPane pane = Sentences_Learn_Component.InputBoxes();

			// Clear text
			pane.setText("");

			// Reset editable state
			pane.setEditable(true);
			pane.setEnabled(false);

			// Reset background color
			pane.setBackground(new Color(55, 64, 54));

			// Reset text color to black
			StyledDocument doc = pane.getStyledDocument();
			SimpleAttributeSet black = new SimpleAttributeSet();
			StyleConstants.setForeground(black, Color.BLACK);
			doc.setCharacterAttributes(0, doc.getLength(), black, true);
			pane.setCharacterAttributes(black, true);

			// Add to input boxes list and panel
			inputBoxesList.add(pane);
			panelInputBoxes.add(pane);
		}

		panelInputBoxes.revalidate();
		panelInputBoxes.repaint();
	}
}
