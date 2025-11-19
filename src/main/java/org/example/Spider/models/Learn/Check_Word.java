package org.example.Spider.models.Learn;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Check_Word {
	int rowIndex = 0;
	int rowEndindex = 54;
	public void checkWord(List<JTextPane> GuessList) {
		int wordIndex = -1;

		for (int index = rowIndex; index <= rowEndindex; index += 6) {
			List<String> woorden = List_Maker.getWoorden();
			wordIndex++;
			if (wordIndex >= woorden.size()) break; // veiligheidscheck
			String woord = woorden.get(wordIndex);

			JTextPane mtf = GuessList.get(index);
			JTextPane pane = mtf; // JTextPane
			String gok = pane.getText();

			String[] kleuren = new String[gok.length()];
			Map<Character, Integer> letterCount = new HashMap<>();

			// Tel hoe vaak elke letter in het woord voorkomt
			for (char c : woord.toCharArray()) {
				letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
			}

			// Stap 1: groen eerst
			for (int i = 0; i < gok.length(); i++) {
				if (i < woord.length() && gok.charAt(i) == woord.charAt(i)) {
					kleuren[i] = "Groen";
					letterCount.put(gok.charAt(i), letterCount.get(gok.charAt(i)) - 1);
				}
			}

			// Stap 2: geel of rood
			for (int i = 0; i < gok.length(); i++) {
				if (kleuren[i] != null) continue; // al groen
				char c = gok.charAt(i);
				if (letterCount.getOrDefault(c, 0) > 0) {
					kleuren[i] = "Geel";
					letterCount.put(c, letterCount.get(c) - 1);
				} else {
					kleuren[i] = "Rood";
				}
			}

			// Resultaat tonen in JTextPane
			StyledDocument doc = pane.getStyledDocument();
			pane.setText(""); // reset tekst
			for (int i = 0; i < gok.length(); i++) {
				SimpleAttributeSet attr = new SimpleAttributeSet();
				switch (kleuren[i]) {
					case "Groen" -> StyleConstants.setForeground(attr, Color.GREEN);
					case "Geel" -> StyleConstants.setForeground(attr, Color.YELLOW.darker());
					case "Rood" -> StyleConstants.setForeground(attr, Color.RED);
				}
				try {
					doc.insertString(doc.getLength(), String.valueOf(gok.charAt(i)), attr);
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
			}

			// Optioneel: console output voor debug
			for (int i = 0; i < gok.length(); i++) {
				System.out.println(gok.charAt(i) + " -> " + kleuren[i]);
			}
			System.out.println("-------");
			GuessList.get(index).setEditable(false);
			GuessList.get(index).setBackground(new Color(189, 189, 189));

		}
		rowIndex++;
		rowEndindex++;
		System.out.println(rowIndex);
		System.out.println(rowEndindex);
		RowsTrue(GuessList);
	}

	public void RowsTrue (List<JTextPane> guessList) {
		for  (int index = rowIndex; index <= rowEndindex; index += 6) {
			guessList.get(index).setBackground(Color.white);
			guessList.get(index).setEditable(true);
		}
		

	}
}
