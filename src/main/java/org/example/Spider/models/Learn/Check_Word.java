package org.example.Spider.models.Learn;

import org.example.Spider.models.Models_Everywhere.masterTextField;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Check_Word {

	public void checkWord(List<masterTextField> GuessList) {
		List<String> woorden = List_Of_Words.list_of_words_op1();

		for (int index = 0; index <= 54; index += 6) {

			String woord = woorden.get(0);
			String gok = GuessList.get(index).getMasterTextFiedD().getText();

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


			// resultaat tonen
			for (int i = 0; i < gok.length(); i++) {
				System.out.println(gok.charAt(i) + " -> " + kleuren[i]);
			}
			System.out.println("-------");
		}
	}
}