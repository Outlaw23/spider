package org.example.Spider.models.Picture;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Check_Descriptoins {

	private static final Logger LOGGER =
			Logger.getLogger(Check_Descriptoins.class.getName());

	List<String> exampleList = new ArrayList<>();

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

			System.out.println(exampleList);

		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Failed to load Examples.json", e);
		}
	}

	public void descriptionCheck() {

	}





}
