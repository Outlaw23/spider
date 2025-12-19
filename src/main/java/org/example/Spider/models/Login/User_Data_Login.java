package org.example.Spider.models.Login;

import java.util.HashMap;

/**
 * Stores predefined user login credentials and provides access to them.
 */
public class User_Data_Login {

	/** HashMap to store user credentials (username -> password) */
	HashMap<String, String> userData = new HashMap<>();

	/**
	 * Constructor initializes the user data with predefined usernames and passwords.
	 */
	public User_Data_Login() {
		userData.put("Spider", "Code14");
		userData.put("Outlaw", "Code19");
		userData.put("Mandy", "Code24");
	}

	/**
	 * Returns the stored user credentials.
	 *
	 * @return a HashMap containing usernames as keys and passwords as values
	 */
	public HashMap<String, String> getUserData() {
		return userData;
	}
}
