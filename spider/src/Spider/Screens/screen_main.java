package Spider.Screens;
// imports

import Spider.Components.masterbutton;
import Spider.Components.masterlabel;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.*;

public class screen_main {
	// Method to create and return a JPanel
	public JPanel screenMain() {

		// Create a new JPanel
		JPanel panelMain = new JPanel();
		panelMain.setLayout(new BorderLayout());
		panelMain.setPreferredSize(new Dimension(1920, 1080));
		panelMain.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		panelMain.setBackground(new Color(255, 255, 255));

		// sub panels
		// panel Center
		JPanel panelMainCenter = new JPanel();
		panelMainCenter.setLayout(new GridLayout(6,0,5,5));
		panelMainCenter.setPreferredSize(new Dimension(1920, 500));
		panelMainCenter.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
		panelMainCenter.setBackground(new Color(95, 102, 107));

		// panel North
		JPanel panelMainNorth = new JPanel();
		panelMainNorth.setLayout(new GridLayout(0,10,5,0));
		panelMainNorth.setPreferredSize(new Dimension(1920, 50));
		panelMainNorth.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelMainNorth.setBackground(new Color(38, 66, 87));

		//labels

		// label title
		masterlabel titel = new masterlabel("home", white);

		// hado text
		masterlabel hadotext = new masterlabel( "<html><font size=30>Hado</font><br/>bij hado heb een translater die die jou text "
				+"omzet naar hado text</html>", white);

		// buttons

		// button home
		masterbutton home = new masterbutton("home","screenMain", darkGray);

		// button hado
		masterbutton hado = new masterbutton("hado","screenHado",gray);

		// button screen video
		masterbutton video = new masterbutton("video","screenVideo",gray);

		// Add panels main screen
		panelMain.add(panelMainNorth, BorderLayout.NORTH);
		panelMain.add(panelMainCenter, BorderLayout.CENTER);

		// add  o the panel north
		panelMainNorth.add(titel.getMasterLabel());
		panelMainNorth.add(home.getMasterbutton());
		panelMainNorth.add(hado.getMasterbutton());
		panelMainNorth.add(video.getMasterbutton());

		// add to panel center
		panelMainCenter.add(hadotext.getMasterLabel());

		// Return the panel to be added to the JFrame
		return panelMain;  
	}
}
