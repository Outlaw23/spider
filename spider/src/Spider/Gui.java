package Spider;
// MainClass.java

import Spider.Screens.screen_hado;
import Spider.Screens.screen_main;
import Spider.Screens.screen_video;

import javax.swing.*;
import java.awt.*;

public class Gui {
	private static CardLayout cardLayout;
	private static JPanel mainPanel;

	public static void main(String[] args) {

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
		screen_main screenmain = new screen_main();
		screen_hado screenhado = new screen_hado();
		screen_video screenvideo = new screen_video();
		mainPanel.add(screenmain.screenMain(), "screenMain");
		mainPanel.add(screenhado.screenHado(), "screenHado");
		mainPanel.add(screenvideo.screenVideo(), "screenVideo");
		cardLayout.show(mainPanel, "screenmain");
		frame.add(mainPanel);
		frame.setResizable(true);
		frame.setVisible(true);

	}

	public static void showPanel(String panelname) {
		cardLayout.show(mainPanel, panelname);
	}

}
