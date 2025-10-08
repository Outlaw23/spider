package org.example.Spider;

import org.example.Spider.Controllers.Screen_controller;
import org.example.Spider.models.Learn.List_Maker;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		// The Entry point of the application
		// Calls the main method of Screen_controller to start the application
		Screen_controller.screenContoller();
		List<String> words = List_Maker.getWoorden();
		System.out.println(words);

	}
}
