package org.example.Spider.models.Learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class List_Maker {
	private static List<String> woorden;
	private static final Logger log = LoggerFactory.getLogger(List_Maker.class);


	public static List<String> getRandomWords(int count) {
		List<String> words = new ArrayList<>();
		String sql = "SELECT word FROM words ORDER BY RAND() LIMIT " + count;

		try (Connection conn = org.example.Spider.models.Learn.DBConnection.getConnection();
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				words.add(rs.getString("word"));
			}

		} catch (SQLException | IOException e) {
			log.error("Er trad een fout op tijdens database- of IO-operaties", e);
		}


		return words;
	}

	// Genereer de lijst als die nog niet bestaat
	public static List<String> getWoorden() {
		if (woorden == null) {
			woorden = List_Maker.getRandomWords(10);
		}
		return woorden;
	}
	// new list woorden (reset button)
	public static List<String> newWoords() {
		woorden = List_Maker.getRandomWords(10);
		return woorden;
	}
}
