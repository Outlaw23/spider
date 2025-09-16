package org.example.Spider.Screen_Learn_Hado.Sub_Screens;

import org.example.Spider.Controllers.Font_Resizer;
import org.example.Spider.models.Models_Everywhere.masterbutton;
import org.example.Spider.models.Models_Everywhere.masterlabel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static java.awt.Color.*;
import static java.awt.Color.gray;

public class Words_Learn_Screen {
	// Method to create and return the main screen JPanel
	public JPanel Words_Learn_screen () {

		// Create the main panel with BorderLayout
		JPanel panelMain = new JPanel();
		panelMain.setLayout(new BorderLayout());
		panelMain.setPreferredSize(new Dimension(1920, 1080));
		panelMain.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		panelMain.setBackground(new Color(255, 255, 255));

		// Create sub-panels for layout structure
		// Center panel
		JPanel panelMainCenter = new JPanel();
		panelMainCenter.setLayout(new GridLayout(2, 0, 5, 5));
		panelMainCenter.setPreferredSize(new Dimension(1920, 500));
		panelMainCenter.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
		panelMainCenter.setBackground(new Color(95, 102, 107));

		// North panel (top area)
		JPanel panelMainNorth = new JPanel();
		panelMainNorth.setLayout(new GridLayout(0, 10, 5, 0));
		panelMainNorth.setPreferredSize(new Dimension(1920, 50));
		panelMainNorth.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelMainNorth.setBackground(new Color(38, 66, 87));

		// panel buttons
		JPanel panelButtons = new JPanel();
		panelButtons.setLayout(new GridLayout(5, 5, 5, 5));
		panelButtons.setPreferredSize(new Dimension(100, 50));
		panelButtons.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelButtons.setBackground(new Color(44, 55, 25));


		// Labels
		// Title label
		masterlabel titel = new masterlabel("Words", white);

		// Buttons
		// Home button
		masterbutton home = new masterbutton("Home", "screenMain", gray);

		// Hado button
		masterbutton hado = new masterbutton("Hado", "screenHado", gray);

		// HadoR button
		masterbutton hadoR = new masterbutton("HadoR", "screenHadoR", gray);

		// Learn button
		masterbutton Learn = new masterbutton("Learn", "screenLearn", gray);

		// Add subpanels to the main panel
		panelMain.add(panelMainNorth, BorderLayout.NORTH);
		panelMain.add(panelMainCenter, BorderLayout.CENTER);

		// Add components to the north panel
		panelMainNorth.add(titel.getMasterLabel());
		panelMainNorth.add(home.getMasterbutton());
		panelMainNorth.add(hado.getMasterbutton());
		panelMainNorth.add(hadoR.getMasterbutton());
		panelMainNorth.add(Learn.getMasterbutton());

		// Add components to the center panel
		panelMainCenter.add(panelButtons);

		// Components that will resize when the window is resized
		List<JComponent> resizableComponents = Arrays.asList(
				titel.getMasterLabel(),
				home.getMasterbutton(),
				hado.getMasterbutton(),
				hadoR.getMasterbutton(),
				Learn.getMasterbutton()
		);
		Font_Resizer.applyResizeLogic(panelMain, resizableComponents);

		// Return the main panel
		return panelMain;
	}
}
