package org.example.Spider.models.Learn;

import org.example.Spider.models.Components.Sub_Screens.Components_Words_Screens.Words_Learn_Components;
import org.example.Spider.models.hado_language.HadoLanguageMvc;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.util.List;

public class Screen_Reset_Worlds {

	public static void resetScreen(
			JPanel panelWords,
			List<String> woorden,
			List<JTextPane> guessList,
			JLabel title,
			JLabel op1Titel,
			JButton resetBtn,
			JButton submitBtn,
			JButton backBtn,
			JButton doneBtn,
			Check_Word checkWord
	) {
		// 1. Reset internal Check_Word values
		checkWord.fullResetState();

		// 2. Reset titles
		op1Titel.setText("Guess words");
		title.setText("Words");

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

		// 5. Reset all input fields
		for (JTextPane pane : guessList) {

			// tekst leegmaken
			pane.setText("");

			// pane toestaan om te typen
			pane.setEditable(true);

			// achtergrond resetten
			pane.setBackground(new Color(55, 64, 54));

			// foreground / karakterkleur resetten
			StyledDocument doc = pane.getStyledDocument();
			SimpleAttributeSet black = new SimpleAttributeSet();
			StyleConstants.setForeground(black, Color.BLACK);

			// hele document weer zwart
			doc.setCharacterAttributes(0, doc.getLength(), black, true);

			// nieuwe ingevoerde tekst wordt ook zwart
			pane.setCharacterAttributes(black, true);
		}

	}
}
