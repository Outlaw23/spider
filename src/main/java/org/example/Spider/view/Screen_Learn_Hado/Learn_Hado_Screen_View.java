package org.example.Spider.view.Screen_Learn_Hado;

import org.example.Spider.Controllers.Font_Resizer;
import org.example.Spider.Controllers.Screen_controller;
import org.example.Spider.Img.Img_Paths;
import org.example.Spider.models.Components.Components_Everywhere;
import org.example.Spider.models.Components.Screens.Learn_Screen_Components;
import org.example.Spider.models.Models_Everywhere.masterpanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Color.darkGray;
import static java.awt.Color.gray;
import static org.example.Spider.models.Components.Screens.Learn_Screen_Components.numberOpdracht;
import static org.example.Spider.models.Components.Screens.Learn_Screen_Components.opdrachten;

public class Learn_Hado_Screen_View {

	// Method to create and return the main screen JPanel
	public JPanel Learn_Hado_screen() {

		// Create the main panel with BorderLayout
		JPanel panelMain = new JPanel();
		panelMain.setLayout(new BorderLayout());
		panelMain.setPreferredSize(new Dimension(1920, 1080));
		panelMain.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		panelMain.setBackground(new Color(255, 255, 255));

		// Create sub-panels for layout structure
		// Center panel
		masterpanel panelMainCenter = new masterpanel(Img_Paths.Background_Spider);
		panelMainCenter.setLayout(new GridLayout(2, 0, 5, 5));
		panelMainCenter.setPreferredSize(new Dimension(1920, 500));
		panelMainCenter.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
		panelMainCenter.setBackground(new Color(95, 102, 107));

		// North panel (top area)
		masterpanel panelMainNorth = new masterpanel(Img_Paths.Background_Strip);
		panelMainNorth.setLayout(new GridLayout(0, 10, 5, 0));
		panelMainNorth.setPreferredSize(new Dimension(1920, 50));
		panelMainNorth.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelMainNorth.setBackground(new Color(38, 66, 87));

		// panel buttons
		JPanel panelButtons = new JPanel();
		panelButtons.setLayout(new GridLayout(5, 5, 5, 5));
		panelButtons.setPreferredSize(new Dimension(100, 50));
		panelButtons.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelButtons.setBackground(new Color(44, 55, 25, 89));

		// panel brief explanation
		JPanel panelBriefExplanation =  new JPanel();
		panelBriefExplanation.setLayout(new BorderLayout());
		panelBriefExplanation.setPreferredSize(new Dimension(100, 50));
		panelBriefExplanation.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelBriefExplanation.setBackground(new Color(44, 55, 25, 89));




		// Labels
		// Title label
		JLabel title = Components_Everywhere.Title("Learn");
		
		// Buttons
		// Home button
		JButton home = Components_Everywhere.homeButton(gray);

		// Hado button
		JButton hado = Components_Everywhere.hadoButton(gray);

		// HadoR button
		JButton hadoR = Components_Everywhere.hadoRButton(gray);

		// Learn button
		JButton learn = Components_Everywhere.learnButton(darkGray);

		// Info button
		JButton info = Components_Everywhere.infoButton(gray);

		//
 		JTextArea BriefExplanationArea = Learn_Screen_Components.briefExplanation();
		//
		for (int i = 0; i < 25; i++) {
			numberOpdracht ++;
			JButton opdracht = Learn_Screen_Components.opdrachten();
			opdrachten.add(opdracht);
			panelButtons.add(opdracht);
		}

		opdrachten.getFirst().addActionListener(_ -> Screen_controller.showPanel("screenWordsExplanation"));
		opdrachten.get(1).addActionListener(_ -> Screen_controller.showPanel("screenSentencesExplanation"));

		opdrachten.getFirst().setToolTipText(
				"<html><b><span style='font-size:15pt;'>Guess Words</span></b></html>"
		);
		opdrachten.get(1).setToolTipText(
				"<html><b><span style='font-size:15pt;'>place words</span></b></html>"
		);


		opdrachten.subList(2, 25).forEach(mb -> mb.setEnabled(false));

		// Add subpanels to the main panel
		panelMain.add(panelMainNorth, BorderLayout.NORTH);
		panelMain.add(panelMainCenter, BorderLayout.CENTER);

		// Add components to the north panel
		panelMainNorth.add(title);
		panelMainNorth.add(home);
		panelMainNorth.add(hado);
		panelMainNorth.add(hadoR);
		panelMainNorth.add(learn);
		panelMainNorth.add(info);


		// Add components to the center panel
		panelMainCenter.add(panelButtons);
		panelMainCenter.add(panelBriefExplanation);

		//
		panelBriefExplanation.add(new JScrollPane(BriefExplanationArea), BorderLayout.CENTER);

		// Components that will resize when the window is resized
		List<JComponent> resizableComponents = new ArrayList<>();

		// vaste onderdelen
		resizableComponents.add(title);
		resizableComponents.add(home);
		resizableComponents.add(hado);
		resizableComponents.add(hadoR);
		resizableComponents.add(learn);
		resizableComponents.add(info);
		resizableComponents.addAll(opdrachten);
		Font_Resizer.applyResizeLogic(panelMain, resizableComponents);

		// Return the main panel
		return panelMain;
	}

}
