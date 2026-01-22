package org.example.Spider.models.Sentences;

import org.example.Spider.models.Components.Sub_Screens.Components_Sentences_Screens.Sentences_Learn_Component;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.example.Spider.models.Components.Sub_Screens.Components_Sentences_Screens.Sentences_Explanation_Component.rowEndindex;
import static org.example.Spider.models.Components.Sub_Screens.Components_Sentences_Screens.Sentences_Explanation_Component.rowIndex;

/**
 * Handles the logic for checking sentence inputs in the learning screens.
 * Validates user-entered sentences against correct variants and updates colors for feedback.
 */
public class Check_Sentences_Words {

	/** Logger for error reporting */
	private static final Logger LOGGER = Logger.getLogger(Check_Sentences_Words.class.getName());

	/** Tracks the current checked row index */
	int checkindex = -1;

	/** Tracks which row should be locked (made read-only) */
	int rowOff = 0;

	/**
	 * Checks user-entered sentences in the JTextPanes against the correct sentence variants.
	 * Colors words green if correct and red if incorrect. Advances rows as needed.
	 *
	 * @param inputBoxesList    the list of JTextPanes representing sentence input rows
	 * @param correcteWoordenLijsten the correct sentences for each row
	 */
	public void checkSentenceWords(List<JTextPane> inputBoxesList, List<List<String>> correcteWoordenLijsten) {
		int start = rowIndex;
		int end = rowEndindex;

		if (end < start) {
			end = start;
		}

		// Force processing only one row at a time
		if (end > start) {
			end = start;
		}

		for (int index = start; index <= end; index++) {
			JTextPane pane = inputBoxesList.get(index);
			List<String> correcteWoorden = index < correcteWoordenLijsten.size() ? correcteWoordenLijsten.get(index) : new ArrayList<>();

			String input = pane.getText().trim();
			StyledDocument doc = pane.getStyledDocument();

			try {
				doc.remove(0, doc.getLength());
			} catch (BadLocationException e) {
				LOGGER.log(Level.SEVERE, "Error while modifying document", e);
			}

			// Split input by "&" to handle multiple words
			String[] ingevoerdeWoorden = input.split("&");

			// Collect all correct words in a set for fast lookup
			Set<String> alleCorrecteWoorden = new HashSet<>();
			for (String variant : correcteWoorden) {
				if (variant == null) continue;
				String[] woordenVariant = variant.split("&");
				for (String w : woordenVariant) {
					String cleaned = w.trim().toLowerCase();
					if (!cleaned.isEmpty()) alleCorrecteWoorden.add(cleaned);
				}
			}

			// Validate each entered word
			for (int j = 0; j < ingevoerdeWoorden.length; j++) {
				String ingevoerd = ingevoerdeWoorden[j].trim();
				if (ingevoerd.isEmpty()) continue;

				boolean juist = alleCorrecteWoorden.contains(ingevoerd.toLowerCase());

				SimpleAttributeSet attr = new SimpleAttributeSet();
				StyleConstants.setForeground(attr, juist ? Color.GREEN : Color.RED);

				try {
					doc.insertString(doc.getLength(), ingevoerd, attr);
					if (j < ingevoerdeWoorden.length - 1) {
						doc.insertString(doc.getLength(), " & ", null);
					}
				} catch (BadLocationException e) {
					LOGGER.log(Level.SEVERE, "Error while modifying document", e);
				}
			}
		}

		// Advance row indices
		rowIndex++;
		rowEndindex = rowIndex;
		checkindex++;

		// Lock processed rows and enable the next row
		if (rowEndindex <= 9) {
			if (checkindex == rowOff) {
				JTextPane paneOFF = inputBoxesList.get(rowOff);
				paneOFF.setEditable(false);
				paneOFF.setBackground(new Color(189, 189, 189));
				Sentences_Learn_Component.back().setEnabled(false);
				rowOff++;
			}

			if (rowIndex >= 0 && rowIndex < inputBoxesList.size()) {
				RowsTrueSentences(inputBoxesList, rowIndex, rowIndex);
			}

		} else {
			JTextPane paneOFF = inputBoxesList.get(rowOff);
			Sentences_Learn_Component.submit().setEnabled(false);
			Sentences_Learn_Component.done().setEnabled(true);
			checkindex++;
			paneOFF.setBackground(new Color(189, 189, 189));
			paneOFF.setEditable(false);
		}
	}

	/**
	 * Makes the specified range of JTextPanes editable and focused for user input.
	 *
	 * @param inputBoxesList the list of JTextPanes
	 * @param start          the start index (inclusive)
	 * @param end            the end index (inclusive)
	 */
	public void RowsTrueSentences(List<JTextPane> inputBoxesList, int start, int end) {
		for (int index = start; index <= end; index++) {
			JTextPane pane = inputBoxesList.get(index);
			pane.setBackground(Color.white);
			pane.setEnabled(true);
			pane.setEditable(true);
			pane.requestFocusInWindow();
		}
	}

	/**
	 * Resets the state of all rows and buttons in the sentence learning screen.
	 * Makes all rows editable from the first, resets internal counters, and re-enables buttons.
	 */
	public void fullResetState() {
		checkindex = -1;
		rowOff = 0;
		rowIndex = 0;
		rowEndindex = 0;

		Sentences_Learn_Component.submit().setEnabled(true);
		Sentences_Learn_Component.done().setEnabled(false);
		Sentences_Learn_Component.back().setEnabled(true);
	}
}
