package org.example.Spider.models.Words;

import org.example.Spider.models.Components.Sub_Screens.Components_Words_Screens.Words_Learn_Components;
import org.example.Spider.models.hado_language.HadoLanguageMvc;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.util.List;

/**
 * Utility class to reset the Words screen to its initial state.
 */
public class Screen_Reset_Worlds {

	/**
	 * Resets the Words screen: clears inputs, resets titles, buttons, and displayed words.
	 *
	 * @param panelWords   the panel displaying the Hado words
	 * @param guessList    the list of JTextPane input fields
	 * @param op1Titel     secondary title JLabel
	 * @param resetBtn     reset JButton
	 * @param submitBtn    submit JButton
	 * @param backBtn      back JButton
	 * @param doneBtn      done JButton
	 * @param checkWord    Check_Word instance to reset the internal state
	 */
	public static void resetScreen(
			JPanel panelWords,
			List<JTextPane> guessList,
			JLabel op1Titel,
			JButton resetBtn,
			JButton submitBtn,
			JButton backBtn,
			JButton doneBtn,
			Check_Word checkWord
	) {
		// 🎲 NIEUWE woorden automatisch
		List<String> woorden = List_Maker.newWoords();

		// 1. Reset internal state
		checkWord.fullResetState();

		// 2. Reset titles
		op1Titel.setText("Guess words");

		// 3. Reset buttons
		resetBtn.setEnabled(true);
		submitBtn.setEnabled(true);
		backBtn.setEnabled(true);
		doneBtn.setEnabled(false);

		// 4. Reset words panel
		panelWords.removeAll();
		for (String wordStr : woorden) {
			JLabel word = Words_Learn_Components.word(wordStr);

			StringBuilder hadoWord = new StringBuilder();
			for (char c : wordStr.toCharArray()) {
				hadoWord.append(HadoLanguageMvc.hadoLanguagee(String.valueOf(c)));
			}

			word.setText(hadoWord.toString());
			panelWords.add(word);
		}

		panelWords.revalidate();
		panelWords.repaint();

		// 5. Reset input fields
		for (JTextPane pane : guessList) {
			pane.setText("");
			pane.setEditable(true);
			pane.setBackground(new Color(55, 64, 54));

			StyledDocument doc = pane.getStyledDocument();
			SimpleAttributeSet black = new SimpleAttributeSet();
			StyleConstants.setForeground(black, Color.BLACK);
			doc.setCharacterAttributes(0, doc.getLength(), black, true);
			pane.setCharacterAttributes(black, true);
		}
	}

}
