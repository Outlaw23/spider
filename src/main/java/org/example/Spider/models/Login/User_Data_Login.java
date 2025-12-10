package org.example.Spider.models.Login;

import java.util.HashMap;

public class User_Data_Login {

	// HashMap to store user credentials (username -> password)
	HashMap<String, String> userData = new HashMap<>();


	// Constructor to initialize user data with predefined usernames and passwords
	public User_Data_Login() {
		userData.put("Spider", "Code14");
		userData.put("Outlaw", "Code19");
		userData.put("Mandy", "Code24");
	}

	// Method to return the user data HashMap
	public HashMap<String, String> getUserData() {
		return userData;
	}
}
