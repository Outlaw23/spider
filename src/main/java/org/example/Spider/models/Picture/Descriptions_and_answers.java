package org.example.Spider.models.Picture;

import org.example.Spider.models.Components.Sub_Screens.Components_Picture_Screen.Picture_Learn_Component;

import java.io.*;

public class Descriptions_and_answers {
	private int num = 0;
	private static final int Max = 9;

	public void descriptions() {
		questionsaver();

		if (num < Max) {
			num++;
		}

		questionReader();
		System.out.println("Now at question " + num);
	}

	public void questionReader() {
		String save_text_file_path_reader =
				"src/main/java/org/example/Spider/models/Picture/TxtFiles/PictureQuestion" + num +".txt";
		try (BufferedReader reader = new BufferedReader(new FileReader(save_text_file_path_reader))) {

			// Hele file inlezen
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line).append("\n");
			}

			// Split op ---
			String[] parts = sb.toString().split("---");

			// Eerste deel in Oriënteer1
			if (parts.length > 0) {
				Picture_Learn_Component.answer().setText(parts[0].trim());
			}

			// Tweede deel in Oriënteer2
			if (parts.length > 1) {
				Picture_Learn_Component.description().setText(parts[1].trim());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println(num);
	}

	public void questionsaver() {
		String path = "src/main/java/org/example/Spider/models/Picture/TxtFiles/PictureQuestion" + num + ".txt";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {

			writer.write(Picture_Learn_Component.answer().getText());
			writer.write("\n---\n");
			writer.write(Picture_Learn_Component.description().getText());

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
