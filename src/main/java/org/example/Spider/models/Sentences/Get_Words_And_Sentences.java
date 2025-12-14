package org.example.Spider.models.Sentences;

import org.example.Spider.models.hado_language.HadoLanguageMvc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Get_Words_And_Sentences {

	private final List<String> lines = new ArrayList<>();
	private int currentIndex = 0;

	private final List<String> currentWords = new ArrayList<>();
	private final List<String> currentSentences = new ArrayList<>();

	//
	public void load() {
		try (BufferedReader reader = new BufferedReader(
				new FileReader(Sentences_Paths.sentencesPath))) {

			String line;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}

			Collections.shuffle(lines);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	//
	public void readFive() {
		currentWords.clear();
		currentSentences.clear();

		for (int i = 0; i < 5; i++) {

			if (currentIndex >= lines.size()) {
				Collections.shuffle(lines);
				currentIndex = 0;
			}

			String rawLine = lines.get(currentIndex++);
			rawLine = rawLine.substring(rawLine.indexOf(". ") + 2);

			String[] parts = rawLine.split(" - ");
			String word = parts[0].trim();
			String sentence = parts[1].trim();

			if (sentence.endsWith(".")) {
				sentence = sentence.substring(0, sentence.length() - 1);
			}
			IO.println("[" + word + " || " + sentence + "]");
			StringBuilder hadoBuilder = new StringBuilder();
			for (char c : word.toCharArray()) {
				hadoBuilder.append(HadoLanguageMvc.hadoLanguagee(String.valueOf(c)));
			}

			currentWords.add(hadoBuilder.toString());
			currentSentences.add(sentence);
		}
	}

	public List<String> getCurrentWords() {
		return currentWords;
	}

	public List<String> getCurrentSentences() {
		return currentSentences;
	}
}
