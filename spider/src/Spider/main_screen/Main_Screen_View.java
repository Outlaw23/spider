package Spider.main_screen;


import Spider.Controllers.Font_Resizer;
import Spider.models.Models_Everywhere.masterbutton;
import Spider.models.Models_Everywhere.masterlabel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static java.awt.Color.*;

public class Main_Screen_View {

	// Method to create and return the main screen JPanel
	public JPanel screenMain() {

		// Create the main panel with BorderLayout
		JPanel panelMain = new JPanel();
		panelMain.setLayout(new BorderLayout());
		panelMain.setPreferredSize(new Dimension(1920, 1080));
		panelMain.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		panelMain.setBackground(new Color(255, 255, 255));

		// Create sub-panels for layout structure
		// Center panel
		JPanel panelMainCenter = new JPanel();
		panelMainCenter.setLayout(new GridLayout(6, 0, 5, 5));
		panelMainCenter.setPreferredSize(new Dimension(1920, 500));
		panelMainCenter.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
		panelMainCenter.setBackground(new Color(95, 102, 107));

		// North panel (top area)
		JPanel panelMainNorth = new JPanel();
		panelMainNorth.setLayout(new GridLayout(0, 10, 5, 0));
		panelMainNorth.setPreferredSize(new Dimension(1920, 50));
		panelMainNorth.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelMainNorth.setBackground(new Color(38, 66, 87));

		// Labels
		// Title label
		masterlabel titel = new masterlabel("home", white);

		// Hado description text
		masterlabel hadoScreen = new masterlabel(
				"<html><font size=30>Hado</font><br/>" +
						"At Hado I have a translator that converts your text to Hado text</html>",
				white
		);

		masterlabel hadoRScreen = new masterlabel(
				"<html><font size=30>HadoR</font><br/>" +
						"at hadoR I have a translator who converts that hado text to your text</html>",
				white
		);

		// Buttons
		// Home button
		masterbutton home = new masterbutton("Home", "screenMain", darkGray);

		// Hado button
		masterbutton hado = new masterbutton("Hado", "screenHado", gray);

		// HadoR (video) button
		masterbutton video = new masterbutton("HadoR", "screenHadoR", gray);

		// Add subpanels to the main panel
		panelMain.add(panelMainNorth, BorderLayout.NORTH);
		panelMain.add(panelMainCenter, BorderLayout.CENTER);

		// Add components to the north panel
		panelMainNorth.add(titel.getMasterLabel());
		panelMainNorth.add(home.getMasterbutton());
		panelMainNorth.add(hado.getMasterbutton());
		panelMainNorth.add(video.getMasterbutton());

		// Add components to the center panel
		panelMainCenter.add(hadoScreen.getMasterLabel());
		panelMainCenter.add(hadoRScreen.getMasterLabel());

		// Components that will resize when the window is resized
		List<JComponent> resizableComponents = Arrays.asList(
				titel.getMasterLabel(),
				home.getMasterbutton(),
				hado.getMasterbutton(),
				video.getMasterbutton()
		);
		Font_Resizer.applyResizeLogic(panelMain, resizableComponents);

		// Return the main panel
		return panelMain;
	}
}

