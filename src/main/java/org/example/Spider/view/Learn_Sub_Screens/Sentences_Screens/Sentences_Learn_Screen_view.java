package org.example.Spider.view.Learn_Sub_Screens.Sentences_Screens;

import org.example.Spider.Controllers.Font_Resizer;
import org.example.Spider.Img.Img_Paths;
import org.example.Spider.models.Components.Components_Everywhere;
import org.example.Spider.models.Components.Sub_Screens.Components_Sentences_Screens.Sentences_Learn_Component;
import org.example.Spider.models.Models_Everywhere.masterpanel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static java.awt.Color.darkGray;
import static java.awt.Color.gray;

public class Sentences_Learn_Screen_view {

	public JPanel screenSentencesLearn() {

		// Main container with BorderLayout
		JPanel panelMain = new JPanel();
		panelMain.setLayout(new BorderLayout());
		panelMain.setPreferredSize(new Dimension(1920, 1080));
		panelMain.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		panelMain.setBackground(new Color(255, 255, 255));

		// Sub-panels for layout structure
		// Center area with two rows for short descriptions
		masterpanel panelMainCenter = new masterpanel(Img_Paths.background_Spider_2);
		panelMainCenter.setLayout(new GridLayout(6, 0, 5, 5));
		panelMainCenter.setPreferredSize(new Dimension(1920, 500));
		panelMainCenter.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
		panelMainCenter.setBackground(new Color(95, 102, 107));

		// North/top navigation area
		masterpanel panelMainNorth = new masterpanel(Img_Paths.Background_Strip);
		panelMainNorth.setLayout(new GridLayout(0, 10, 5, 0));
		panelMainNorth.setPreferredSize(new Dimension(1920, 50));
		panelMainNorth.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelMainNorth.setBackground(new Color(38, 66, 87));

		JPanel panelWords = new JPanel();
		panelWords.setLayout(new GridLayout(0, 5, 5, 0));
		panelWords.setPreferredSize(new Dimension(1920, 500));
		panelWords.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelWords.setBackground(new Color(95, 102, 107, 0));
		panelWords.setOpaque(false);

		// Labels
		// Title label (screen heading)
		JLabel title = Components_Everywhere.Title("Sentences");

		// Buttons (top navigation)
		// Home button
		JButton home = Components_Everywhere.homeButton(darkGray);
		// Hado button
		JButton hado = Components_Everywhere.hadoButton(gray);
		// HadoR button
		JButton hadoR = Components_Everywhere.hadoRButton(gray);
		//Learn button
		JButton learn = Components_Everywhere.learnButton(gray);
		//Info button
		JButton info = Components_Everywhere.infoButton(gray);

		//
		JLabel words = Sentences_Learn_Component.words();


		// Compose layout: add subpanels to the main panel
		panelMain.add(panelMainNorth, BorderLayout.NORTH);
		panelMain.add(panelMainCenter, BorderLayout.CENTER);

		// Top bar contents
		panelMainNorth.add(title);
		panelMainNorth.add(home);
		panelMainNorth.add(hado);
		panelMainNorth.add(hadoR);
		panelMainNorth.add(learn);
		panelMainNorth.add(info);

		// Center content
		panelMainCenter.add(panelWords, BorderLayout.NORTH);

		//
		panelWords.add(words);

		// Components that will resize when the window is resized
		List<JComponent> resizableComponents = Arrays.asList(
				title,
				home,
				hado,
				hadoR,
				learn,
				info
		);
		Font_Resizer.applyResizeLogic(panelMain, resizableComponents);

		// Return the assembled main panel
		return panelMain;
	}

}
