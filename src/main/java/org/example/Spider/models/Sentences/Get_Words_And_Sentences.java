package org.example.Spider.models.Sentences;

import org.example.Spider.models.hado_language.HadoLanguageMvc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Loads sentences and words from a file and provides shuffled sets for learning exercises.
 * Each call to {@link #readFive()} retrieves 10 new word-sentence pairs with corresponding Hado translations.
 */
public class Get_Words_And_Sentences {

	/** All lines read from the sentences file */
	private final List<String> lines = new ArrayList<>();

	/** Current index in the list for sequential reading */
	private int currentIndex = 0;

	/** Hado-translated words for the current set */
	private final List<String> currentWordsHado = new ArrayList<>();

	/** Original sentences for the current set */
	private final List<String> currentSentences = new ArrayList<>();

	/** Original words for the current set */
	private final List<String> currentWords = new ArrayList<>();

	/**
	 * Loads all lines from the sentences file and shuffles them.
	 * The file path is defined in {@link Sentences_Paths#sentencesPath}.
	 *
	 * @throws RuntimeException if the file cannot be read
	 */
	public void load() {
		try (BufferedReader reader = new BufferedReader(new FileReader(Sentences_Paths.sentencesPath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			Collections.shuffle(lines);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Reads the next 10 word-sentence pairs from the shuffled lines.
	 * Converts the words to Hado using {@link HadoLanguageMvc}.
	 * If the end of the list is reached, the lines are reshuffled and reading continues from the beginning.
	 */
	public void readFive() {
		currentWordsHado.clear();
		currentSentences.clear();
		currentWords.clear();

		for (int i = 0; i < 10; i++) {
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

			StringBuilder hadoBuilder = new StringBuilder();
			for (char c : word.toCharArray()) {
				hadoBuilder.append(HadoLanguageMvc.hadoLanguagee(String.valueOf(c)));
			}

			currentWordsHado.add(hadoBuilder.toString());
			currentWords.add(word);
			currentSentences.add(sentence);
		}
	}

	/**
	 * Returns the Hado-translated words for the current set.
	 *
	 * @return a list of words in Hado
	 */
	public List<String> getCurrentWordsHado() {
		return currentWordsHado;
	}

	/**
	 * Returns the original sentences for the current set.
	 *
	 * @return a list of sentences
	 */
	public List<String> getCurrentSentences() {
		return currentSentences;
	}

	/**
	 * Returns the original words for the current set.
	 *
	 * @return a list of words
	 */
	public List<String> getCurrentWords() {
		return currentWords;
	}
}
