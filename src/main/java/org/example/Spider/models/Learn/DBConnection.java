package org.example.Spider.models.Learn;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

	/**
	 * Geeft een JDBC Connection terug, geladen vanuit db.properties
	 */
	public static Connection getConnection() throws SQLException, IOException {
		Properties props = new Properties();

		// Laad database configuratie uit db.properties
		try (FileInputStream fis = new FileInputStream("db.properties")) {
			props.load(fis);
		}

		String url = props.getProperty("db.url");
		String user = props.getProperty("db.user");
		String password = props.getProperty("db.password");

		return DriverManager.getConnection(url, user, password);
	}
}
