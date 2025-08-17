package Spider_mvc.Controllers;
// MainClass.java

import Spider_mvc.Screen_Hado.Hado_Screen_View;
import Spider_mvc.Screen_Video.Video_Screen_View;
import Spider_mvc.main_screen.Main_Screen_View;

import javax.swing.*;
import java.awt.*;

public class Screen_controller {
	private static CardLayout cardLayout;
	private static JPanel mainPanel;

	public static void main() {

		// Create a new JFrame (Main Window)
		JFrame frame = new JFrame("Main Window");


		// Set the frame size
		frame.setSize(800,400);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);

		// Specify what happens when the window is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cardLayout = new CardLayout();
		mainPanel = new JPanel(cardLayout);

		// Create an instance of OtherClass and add its component to the frame
		Main_Screen_View view_main = new Main_Screen_View();
		Hado_Screen_View hado_screen = new Hado_Screen_View();
		Video_Screen_View video_screen = new Video_Screen_View();
		mainPanel.add(view_main.screenMain(), "screenMain");
		mainPanel.add(hado_screen.screenHado(), "screenHado");
		mainPanel.add(video_screen.screenVideo(), "screenVideo");
		cardLayout.show(mainPanel, "screenmain");
		frame.add(mainPanel);
		frame.setResizable(true);
		frame.setVisible(true);

	}

	public static void showPanel(String panelname) {
		cardLayout.show(mainPanel, panelname);
	}

}
