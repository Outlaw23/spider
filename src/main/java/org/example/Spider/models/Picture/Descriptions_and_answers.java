package org.example.Spider.models.Picture;

import org.example.Spider.models.Components.Sub_Screens.Components_Picture_Screen.Picture_Learn_Component;

import java.io.*;

public class Descriptions_and_answers {
	private int  numberDescriptons = 0;
	Check_Descriptoins checkDescriptoins = new Check_Descriptoins();

	public void descriptions() {
		questionsaver();


		int max = 9;
		if (numberDescriptons < max) {
			numberDescriptons++;
		} else {
			checkDescriptoins.descriptionCheckLayout();
			checkDescriptoins.questionReaderExample();
			checkDescriptoins.getHadoList();
			checkDescriptoins.checkAnswer();


			return;
		}

		questionReader();
		System.out.println("Now at question " + numberDescriptons);
	}

	public void questionReader() {
		String save_text_file_path_reader =
				"src/main/java/org/example/Spider/models/Picture/TxtFiles/PictureQuestion.txt";
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

			//
			if (parts.length > 1) {
				Picture_Learn_Component.description().setText(parts[1].trim());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println(numberDescriptons);
	}

	public void questionsaver() {
		String path = "src/main/java/org/example/Spider/models/Picture/TxtFiles/PictureQuestion" + numberDescriptons + ".txt";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {

			writer.write(Picture_Learn_Component.answer().getText());
			writer.write("\n---\n");
			writer.write(Picture_Learn_Component.description().getText());

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}


}
