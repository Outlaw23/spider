package org.example.Spider.models.Words;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Utility class to provide a JDBC Connection using properties from db.properties.
 */
public class DBConnection {

	/**
	 * Returns a JDBC Connection using the configuration from db.properties.
	 * <p>
	 * The db.properties file should contain:
	 * <ul>
	 *     <li>db.url = jdbc:... (JDBC URL)</li>
	 *     <li>db.user = database username</li>
	 *     <li>db.password = database password</li>
	 * </ul>
	 *
	 * @return a live JDBC {@link Connection}
	 * @throws SQLException if a database access error occurs
	 * @throws IOException  if there is an error reading db.properties
	 */
	public static Connection getConnection() throws SQLException, IOException {
		Properties props = new Properties();

		// Load database configuration from db.properties
		try (FileInputStream fis = new FileInputStream("db.properties")) {
			props.load(fis);
		}

		String url = props.getProperty("db.url");
		String user = props.getProperty("db.user");
		String password = props.getProperty("db.password");

		// Establish and return the connection
		return DriverManager.getConnection(url, user, password);
	}
}
