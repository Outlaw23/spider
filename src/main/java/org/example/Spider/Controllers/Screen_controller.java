
package org.example.Spider.Controllers;
// MainClass.java

import org.example.Spider.models.Login.User_Data_Login;
import org.example.Spider.view.Screen_Hado.Hado_Screen_View;
import org.example.Spider.view.Screen_HadoR.HadoR_Screen_View;
import org.example.Spider.view.Screen_Info.Info_Screen_View;
import org.example.Spider.view.Screen_Learn_Hado.Learn_Hado_Screen_View;
import org.example.Spider.view.Screen_Learn_Hado.Sub_Screens.Assignments.Words_Learn_Screen_View;
import org.example.Spider.view.Screen_Learn_Hado.Sub_Screens.Explaining_The_Assignment.Words_Explanation_View;
import org.example.Spider.view.Screen_Login.Login_Screen_View;
import org.example.Spider.view.Screen_Main.Main_Screen_View;

import javax.swing.*;
import java.awt.*;

public class Screen_controller {

	private static CardLayout cardLayout;
	private static JPanel mainPanel;

	public static void screenContoller() {
		User_Data_Login user = new User_Data_Login();

		// Create the main application window (JFrame)
		JFrame frame = new JFrame("Main Window");

		// Set the initial size and maximize the window
		frame.setSize(800, 400);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);

		// Close the application when the window is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Initialize CardLayout and the main panel
		cardLayout = new CardLayout();
		mainPanel = new JPanel(cardLayout);

		// Create instances of different views (screens)
		Login_Screen_View login_screen = new Login_Screen_View();
		Main_Screen_View view_main = new Main_Screen_View();
		Hado_Screen_View hado_screen = new Hado_Screen_View();
		HadoR_Screen_View video_screen = new HadoR_Screen_View();
		Learn_Hado_Screen_View learn_screen = new Learn_Hado_Screen_View();
		Words_Learn_Screen_View wordsLearnScreen =  new Words_Learn_Screen_View();
		Words_Explanation_View wordsExplanationScreen = new Words_Explanation_View();
		Info_Screen_View info_screen = new Info_Screen_View();

		// Add the views to the main panel with unique identifiers
		mainPanel.add(login_screen.Login_screen(user.getUserData()), "screenLogin");
		mainPanel.add(view_main.screenMain(), "screenMain");
		mainPanel.add(hado_screen.screenHado(), "screenHado");
		mainPanel.add(video_screen.screenHadoR(), "screenHadoR");
		mainPanel.add(learn_screen.Learn_Hado_screen(), "screenLearn");
		mainPanel.add(wordsLearnScreen.Words_Learn_screen(), "screenWordsLearn");
		mainPanel.add(wordsExplanationScreen.screenWordsExplanation(), "screenWordsExplanation");
		mainPanel.add(info_screen.screenInfo(), "screenInfo");

		// Show the initial screen
		cardLayout.show(mainPanel, "screenLogin");

		// Add the main panel to the frame
		frame.add(mainPanel);

		// Allow the window to be resizable and make it visible
		frame.setResizable(true);
		frame.setVisible(true);
	}

	public static void showPanel(String panelName) {
		// Switch to the specified panel using CardLayout
		cardLayout.show(mainPanel, panelName);
	}
}