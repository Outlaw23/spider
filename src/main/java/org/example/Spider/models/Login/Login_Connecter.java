package org.example.Spider.models.Login;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Login_Connecter {

	public static Connection getConnection() throws SQLException, IOException {
		Properties props = new Properties();

		// Load database configuration from "db.properties" file
		try (FileInputStream fis = new FileInputStream("db.properties")) {
			props.load(fis);
		}

		// Retrieve values for URL, username, and password from the properties file
		String url = props.getProperty("db.url");
		String user = props.getProperty("db.user");
		String password = props.getProperty("db.password");

		// Establish and return a JDBC connection using the loaded properties
		return DriverManager.getConnection(url, user, password);
	}
}
