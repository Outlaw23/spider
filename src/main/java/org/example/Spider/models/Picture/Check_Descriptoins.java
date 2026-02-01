package org.example.Spider.models.Picture;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Spider.Controllers.Score_Controller;
import org.example.Spider.models.Components.Sub_Screens.Components_Picture_Screen.Picture_Learn_Component;
import org.example.Spider.models.Models_Everywhere.MasterScrollPane;
import org.example.Spider.models.hado_language.HadoLanguageMvc;

import javax.swing.*;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
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
	private static boolean wordloop = false;
	private boolean alreadyCounted = false;

	List<String> exampleList = new ArrayList<>();
	List<String> hadoList = new ArrayList<>();
	public int checkCounter = 0;
	public int numberExample = 0;
	public static int correctCount = 0;

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
		MasterScrollPane masterScroll = new MasterScrollPane(example);
		panelPicture.add(masterScroll.getScrollPane(), BorderLayout.CENTER);
		panelPicture.add(PanelAnswerExample, BorderLayout.NORTH);
		panelPicture.add(panelbutton, BorderLayout.SOUTH);

		Panelsumbit.add(fout, BorderLayout.CENTER);

		panelPicture.revalidate();
		Panelsumbit.revalidate();
		panelPicture.repaint();
		Panelsumbit.repaint();
	}

	public void descriptionCheck() {
		Score_Controller scoreController = new Score_Controller();
		getHadoList();
		exampleText();
		checkCounter++;
		numberExample++;


		if (checkCounter < exampleList.size()) {
			example.setText(exampleList.get(checkCounter));
			Picture_Learn_Component.answerExample().setText(hadoList.get(numberExample));
			questionReaderExample();
			checkerWord();
		} else {
			System.out.println("end");
			wordloop = false;
			scoreController.showScorepicture(panel);
		}
		System.out.println(correctCount + " correct");
		System.out.println(checkCounter + " checked");
		System.out.println(numberExample + " example");
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
			Picture_Learn_Component.answerExample().setText(hadoList.get(checkCounter));
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Failed to load Hado word list", e);
		}
	}

	public void checkAnswer() {

		StyledDocument doc = answer.getStyledDocument();
		Style style = answer.addStyle("kleur", null);

		if (answer.getText().equals(hadoList.get(checkCounter))) {

			StyleConstants.setForeground(style, Color.GREEN);

			if (!alreadyCounted) {
				correctCount++;
				alreadyCounted = true;
			}

		} else {
			StyleConstants.setForeground(style, Color.RED);
			alreadyCounted = false; // reset als het fout is
		}

		doc.setCharacterAttributes(
				0,
				doc.getLength(),
				style,
				false
		);
	}

	public void answerCorrect() {
		correctCount++;
	}

	public void checkerWord() {
		wordloop = true;

		Timer timer = new Timer(300, e -> {
			if (!wordloop) {
				((Timer) e.getSource()).stop();
				return;
			}
			checkAnswer();
		});

		timer.start();
	}

	public void reset() {
		correctCount = 0;
		checkCounter = 0;
		numberExample = 0;
		exampleList.clear();
		hadoList.clear();


	}
}
