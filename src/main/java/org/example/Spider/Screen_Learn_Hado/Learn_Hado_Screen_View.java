package org.example.Spider.Screen_Learn_Hado;

import org.example.Spider.Controllers.Font_Resizer;
import org.example.Spider.models.Models_Everywhere.masterbutton;
import org.example.Spider.models.Models_Everywhere.masterlabel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Color.*;

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
		masterlabel titel = new masterlabel("Learn", white);
		
		// Buttons
		// Home button
		masterbutton home = new masterbutton("Home", "screenMain", gray);

		// Hado button
		masterbutton hado = new masterbutton("Hado", "screenHado", gray);

		// HadoR button
		masterbutton hadoR = new masterbutton("HadoR", "screenHadoR", gray);

		// Learn button
		masterbutton Learn = new masterbutton("Learn", "screenLearn", darkGray);

		//
		int numberOpdracht = 0;
		int panelNumberOpdracht = 0;
		List<masterbutton> opdrachten = new ArrayList<>();

		for (int i = 0; i < 25; i++) {
			numberOpdracht ++;
			panelNumberOpdracht ++;
			masterbutton opdracht  = new masterbutton("Opdracht " + numberOpdracht,
					"" , gray);
			opdrachten.add(opdracht);
			panelButtons.add(opdracht.getMasterbutton());
		}

//		opdrachten.get(0).setPanelname("OP_1");
		opdrachten.get(0).showPanelOpdrachten("wordsLearn");

		opdrachten.subList(1, 25).forEach(mb -> mb.setEnabled(false));

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
		List<JComponent> resizableComponents = new ArrayList<>();

		// vaste onderdelen
		resizableComponents.add(titel.getMasterLabel());
		resizableComponents.add(home.getMasterbutton());
		resizableComponents.add(hado.getMasterbutton());
		resizableComponents.add(hadoR.getMasterbutton());
		resizableComponents.add(Learn.getMasterbutton());
		for (masterbutton mb : opdrachten) {
			resizableComponents.add(mb.getMasterbutton());
		}
		Font_Resizer.applyResizeLogic(panelMain, resizableComponents);

		// Return the main panel
		return panelMain;
	}

}
