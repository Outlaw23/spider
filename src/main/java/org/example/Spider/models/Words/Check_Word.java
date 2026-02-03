package org.example.Spider.models.Words;

import org.example.Spider.Controllers.Score_Controller;
import org.example.Spider.models.Components.Sub_Screens.Components_Words_Screens.Words_Learn_Components;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Handles the checking of guessed words against the correct words.
 * Highlights letters in green, yellow, or red depending on correctness.
 */
public class Check_Word {
	public static int scoreWords = 0;

	/** Index of the current row being checked. */
	int rowIndex = 0;

	/** Index of the end row for the current check window. */
	int rowEndindex = 54;

	/** Tracks the number of checks performed. */
	int checkindex = 0;

	/** Logger instance for debug and error logging. */
	private static final Logger log = LoggerFactory.getLogger(Check_Word.class);

	/**
	 * Checks the user's guesses against the correct words.
	 * Colors letters in green (correct), yellow (wrong position), or red (incorrect).
	 *
	 * @param GuessList list of JTextPane components containing the user's guesses
	 */
	public void checkWord(List<JTextPane> GuessList) {
		int wordIndex = -1;

		Words_Learn_Components.reset().setEnabled(false);
		Words_Learn_Components.back().setEnabled(false);

		// Iterate over rows (1 woord per rij)
		for (int index = rowIndex; index <= rowEndindex; index += 6) {
			List<String> woorden = List_Maker.getWoorden();
			wordIndex++;

			if (wordIndex >= woorden.size()) break;

			String woord = woorden.get(wordIndex);
			JTextPane pane = GuessList.get(index);
			String gok = pane.getText();

			String[] kleuren = new String[gok.length()];
			Map<Character, Integer> letterCount = new HashMap<>();

			// Letterfrequentie van het juiste woord
			for (char c : woord.toCharArray()) {
				letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
			}

			// 🟩 Stap 1: groen (juiste letter + positie)
			for (int i = 0; i < gok.length(); i++) {
				if (i < woord.length() && gok.charAt(i) == woord.charAt(i)) {
					kleuren[i] = "Groen";
					letterCount.put(gok.charAt(i), letterCount.get(gok.charAt(i)) - 1);
				}
			}

			// 🟨🟥 Stap 2: geel of rood
			for (int i = 0; i < gok.length(); i++) {
				if (kleuren[i] != null) continue;

				char c = gok.charAt(i);
				if (letterCount.getOrDefault(c, 0) > 0) {
					kleuren[i] = "Geel";
					letterCount.put(c, letterCount.get(c) - 1);
				} else {
					kleuren[i] = "Rood";
				}
			}

			// ✅ SCORE: alleen als het hele woord klopt
			if (gok.equals(woord)) {
				scoreWords++;
			}

			// Resultaat tonen in JTextPane
			StyledDocument doc = pane.getStyledDocument();
			pane.setText("");

			for (int i = 0; i < gok.length(); i++) {
				SimpleAttributeSet attr = new SimpleAttributeSet();
				switch (kleuren[i]) {
					case "Groen" -> StyleConstants.setForeground(attr, Color.GREEN);
					case "Geel" -> StyleConstants.setForeground(attr, Color.YELLOW.darker());
					case "Rood" -> StyleConstants.setForeground(attr, Color.RED);
				}

				try {
					doc.insertString(doc.getLength(),
							String.valueOf(gok.charAt(i)), attr);
				} catch (BadLocationException e) {
					log.error("Error inserting text in JTextPane", e);
				}
			}

			// Debug output
			for (int i = 0; i < gok.length(); i++) {
				IO.println(gok.charAt(i) + " -> " + kleuren[i]);
			}
			IO.println("-------");

			// Lock deze rij
			pane.setEditable(false);
			pane.setBackground(new Color(189, 189, 189));

			// Volgende rij activeren of spel beëindigen
			if (rowEndindex <= 58) {
				if (index == rowEndindex) {
					rowIndex++;
					rowEndindex++;
				}
			} else {
				Score_Controller score_controller = new Score_Controller();
				score_controller.showScoreWords();
				Words_Learn_Components.submit().setEnabled(false);
				Words_Learn_Components.done().setEnabled(true);
				checkindex++;
			}
		}

		RowsTrue(GuessList);
	}
	/**
	 * Enables the next row of JTextPane for input.
	 *
	 * @param guessList list of JTextPane components
	 */
	public void RowsTrue(List<JTextPane> guessList) {
		for (int index = rowIndex; index <= rowEndindex; index += 6) {
			guessList.get(index).setBackground(Color.white);
			guessList.get(index).setEditable(true);
			if (checkindex == 10) {
				guessList.get(index).setBackground(new Color(189, 189, 189));
				guessList.get(index).setEditable(false);
			}
		}
	}

	/**
	 * Resets all internal counters and indices to the initial state.
	 */
	public void fullResetState() {
		rowIndex = 0;
		rowEndindex = 54;
		checkindex = 0;
	}
}
