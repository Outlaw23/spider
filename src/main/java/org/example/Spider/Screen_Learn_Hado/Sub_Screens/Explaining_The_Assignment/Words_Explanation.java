package org.example.Spider.Screen_Learn_Hado.Sub_Screens.Explaining_The_Assignment;

import org.example.Spider.Controllers.Font_Resizer;
import org.example.Spider.models.Components.Components_Everywhere;
import org.example.Spider.models.Components.Screens.Words_Explanation_Screen_Components;
import org.example.Spider.models.Models_Everywhere.MasterPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static java.awt.Color.gray;

public class Words_Explanation {


	public JPanel screenWordsExplanation() {

		// Create the main panel with BorderLayout
		JPanel panelMain = new JPanel();
		panelMain.setLayout(new BorderLayout());
		panelMain.setPreferredSize(new Dimension(1920, 1080));
		panelMain.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		panelMain.setBackground(new Color(255, 255, 255));

		// Create sub-panels for layout structure
		// Center panel
		MasterPanel panelMainCenter = new MasterPanel
				("src/main/java/org/example/Spider/img/background_spider.jpeg");
		panelMainCenter.setLayout(new BorderLayout());
		panelMainCenter.setPreferredSize(new Dimension(1920, 500));
		panelMainCenter.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
		panelMainCenter.setBackground(new Color(95, 102, 107));

		// North panel (top area)
		MasterPanel panelMainNorth = new MasterPanel
				("src/main/java/org/example/Spider/img/strip_background.jpeg");
		panelMainNorth.setLayout(new GridLayout(0, 10, 5, 0));
		panelMainNorth.setPreferredSize(new Dimension(1920, 50));
		panelMainNorth.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelMainNorth.setBackground(new Color(38, 66, 87));

		//panel start button
		JPanel panelStartButton = new JPanel();
		panelStartButton.setLayout(new GridLayout(0, 10, 5, 5));
		panelStartButton.setPreferredSize(new Dimension(1920, 60));
		panelStartButton.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelStartButton.setBackground(new Color(95, 102, 107, 0));




		// Labels
		// Title label
		JLabel title = Components_Everywhere.Title("Words");

		// Hado description text
		JLabel explanation = Words_Explanation_Screen_Components.Explanation();

		// Buttons
		// Home button
		JButton home = Components_Everywhere.homeButton(gray);

		// Hado button
		JButton hado = Components_Everywhere.hadoButton(gray);

		// HadoR button
		JButton hadoR =  Components_Everywhere.hadoRButton(gray);

		// Learn button
		JButton learn = Components_Everywhere.learnbutton(gray);

		//start button
		JButton Start = Words_Explanation_Screen_Components.startButton();



		// Add subpanels to the main panel
		panelMain.add(panelMainNorth, BorderLayout.NORTH);
		panelMain.add(panelMainCenter, BorderLayout.CENTER);

		// Add components to the north panel
		panelMainNorth.add(title);
		panelMainNorth.add(home);
		panelMainNorth.add(hado);
		panelMainNorth.add(hadoR);
		panelMainNorth.add(learn);

		// Add components to the center panel
		panelMainCenter.add(panelStartButton, BorderLayout.SOUTH);
		panelMainCenter.add(explanation, BorderLayout.NORTH);

		// Add components to the Start button panel
		panelStartButton.add(Start);


		// Components that will resize when the window is resized
		List<JComponent> resizableComponents = Arrays.asList(
				title,
				home,
				hado,
				hadoR,
				learn,
				Start
		);
		Font_Resizer.applyResizeLogic(panelMain, resizableComponents);

		// Return the main panel
		return panelMain;
	}

}
