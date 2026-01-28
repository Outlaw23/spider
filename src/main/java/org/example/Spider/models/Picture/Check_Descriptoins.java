package org.example.Spider.models.Picture;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Spider.models.Components.Sub_Screens.Components_Picture_Screen.Picture_Learn_Component;
import org.example.Spider.models.hado_language.HadoLanguageMvc;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.example.Spider.view.Learn_Sub_Screens.Picture_Screen.Picture_Learn_Screen_view.*;

public class Check_Descriptoins {

	public static JTextArea example = Picture_Learn_Component.example();
	public static JButton fout = Picture_Learn_Component.fout();
	public static JTextPane answer = Picture_Learn_Component.answer();
	private static final Logger LOGGER =
			Logger.getLogger(Check_Descriptoins.class.getName());

	List<String> exampleList = new ArrayList<>();
	List<String> hadoList = new ArrayList<>();
	int checkCounter = 0;
	int numberExample = 0;
	int correctCount = 0;

	public void exampleText() {

		ObjectMapper mapper = new ObjectMapper();

		try (InputStream is = getClass()
				.getClassLoader()
				.getResourceAsStream("Examples.json")) {

			if (is == null) {
				throw new RuntimeException("Examples.json not found");
			}

			JsonNode root = mapper.readTree(is);
			JsonNode descriptions = root.get("descriptions");

			exampleList.clear();

			descriptions.fields().forEachRemaining(entry ->
					exampleList.add(entry.getValue().asText())
			);

		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Failed to load Examples.json", e);
		}
	}

	public void descriptionCheckLayout() {
		exampleText();

		panelPicture.removeAll();
		Panelsumbit.removeAll();

		example.setText(exampleList.getFirst());
		panelPicture.add(new JScrollPane(example), BorderLayout.CENTER);
		panelPicture.add(PanelAnswerExample, BorderLayout.NORTH);
		panelPicture.add(panelbutton, BorderLayout.SOUTH);

		Panelsumbit.add(fout, BorderLayout.CENTER);

		panelPicture.revalidate();
		Panelsumbit.revalidate();
		panelPicture.repaint();
		Panelsumbit.repaint();
	}

	public void descriptionCheck(boolean isCorrect) {
		getHadoList();
		exampleText();
		checkCounter++;
		numberExample++;
		if (isCorrect) {
			correctCount++;
		}

		if (checkCounter < exampleList.size()) {
			example.setText(exampleList.get(checkCounter));
			Picture_Learn_Component.answerExample().setText(hadoList.get(checkCounter));
			questionReaderExample();
		} else {
			System.out.println("test");
			//showScore();
		}
	}

	public void questionReaderExample() {
		String save_text_file_path_reader =
				"src/main/java/org/example/Spider/models/Picture/TxtFiles/PictureQuestion" + numberExample +".txt";
		try (BufferedReader reader = new BufferedReader(new FileReader(save_text_file_path_reader))) {

			//
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line).append("\n");
			}

			//
			String[] parts = sb.toString().split("---");

			//
			if (parts.length > 0) {
				Picture_Learn_Component.answer().setText(parts[0].trim());
			}


			if (parts.length > 1) {
				Picture_Learn_Component.description().setText(parts[1].trim());
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static final ObjectMapper mapper = new ObjectMapper();

	public void getHadoList() {


		try (InputStream is = Check_Descriptoins.class
				.getClassLoader()
				.getResourceAsStream("words.json")) {

			if (is == null) {
				throw new RuntimeException("words.json not found");
			}

			JsonNode root = mapper.readTree(is);

			if (!root.isObject()) {
				throw new RuntimeException("words.json must be a JSON object");
			}

			root.fields().forEachRemaining(entry -> {
				String normalText = entry.getValue().asText();

				StringBuilder hado = new StringBuilder();
				for (char c : normalText.toCharArray()) {
					hado.append(
							HadoLanguageMvc.hadoLanguagee(String.valueOf(c))
					);
				}

				hadoList.add(hado.toString());
			});
			Picture_Learn_Component.answerExample().setText(hadoList.getFirst());
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Failed to load Hado word list", e);
		}
	}
}
