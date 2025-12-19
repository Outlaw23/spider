package org.example.Spider.view.Screen_Info;

import org.example.Spider.Controllers.Font_Resizer;
import org.example.Spider.Img.Img_Paths;
import org.example.Spider.models.Components.Components_Everywhere;
import org.example.Spider.models.Components.Screens.Info_Screen_Components;
import org.example.Spider.models.Models_Everywhere.masterpanel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static java.awt.Color.darkGray;
import static java.awt.Color.gray;

/**
 * View class responsible for building the Info screen UI.
 * This class only handles layout and visual components.
 */
public class Info_Screen_View {

	/**
	 * Creates and returns the Info screen panel.
	 *
	 * @return fully constructed Info screen JPanel
	 */
	public JPanel screenInfo() {

		// =========================
		// Main container panel
		// =========================
		JPanel panelMain = new JPanel();
		panelMain.setLayout(new BorderLayout());
		panelMain.setPreferredSize(new Dimension(1920, 1080));
		panelMain.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		panelMain.setBackground(new Color(255, 255, 255));

		// =========================
		// Center panel with background image
		// Displays information text
		// =========================
		masterpanel panelMainCenter = new masterpanel(Img_Paths.Background_Spider);
		panelMainCenter.setLayout(new BorderLayout());
		panelMainCenter.setPreferredSize(new Dimension(1920, 500));
		panelMainCenter.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
		panelMainCenter.setBackground(new Color(95, 102, 107));

		// =========================
		// Top navigation bar
		// =========================
		masterpanel panelMainNorth = new masterpanel(Img_Paths.Background_Strip);
		panelMainNorth.setLayout(new GridLayout(0, 10, 5, 0));
		panelMainNorth.setPreferredSize(new Dimension(1920, 50));
		panelMainNorth.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelMainNorth.setBackground(new Color(38, 66, 87));

		// =========================
		// UI Components
		// =========================

		// Screen title
		JLabel title = Components_Everywhere.Title("Info");

		// Main information text label
		JLabel infoText = Info_Screen_Components.infoLabel();

		// Navigation buttons
		JButton home = Components_Everywhere.homeButton(gray);
		JButton hado = Components_Everywhere.hadoButton(gray);
		JButton hadoR = Components_Everywhere.hadoRButton(gray);
		JButton learn = Components_Everywhere.learnButton(gray);
		JButton info = Components_Everywhere.infoButton(darkGray);

		// =========================
		// Layout composition
		// =========================

		// Add subpanels to main container
		panelMain.add(panelMainNorth, BorderLayout.NORTH);
		panelMain.add(panelMainCenter, BorderLayout.CENTER);

		// Add components to the top navigation bar
		panelMainNorth.add(title);
		panelMainNorth.add(home);
		panelMainNorth.add(hado);
		panelMainNorth.add(hadoR);
		panelMainNorth.add(learn);
		panelMainNorth.add(info);

		// Add information text to the center panel
		panelMainCenter.add(infoText, BorderLayout.NORTH);

		// =========================
		// Responsive font resizing
		// =========================
		List<JComponent> resizableComponents = Arrays.asList(
				title,
				infoText,
				home,
				hado,
				hadoR,
				learn,
				info
		);

		// Apply automatic font resize logic
		Font_Resizer.applyResizeLogic(panelMain, resizableComponents);

		// Return fully built Info screen
		return panelMain;
	}
}
