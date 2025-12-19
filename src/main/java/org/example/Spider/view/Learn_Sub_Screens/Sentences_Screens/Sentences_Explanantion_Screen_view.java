package org.example.Spider.view.Learn_Sub_Screens.Sentences_Screens;

import org.example.Spider.Controllers.Font_Resizer;
import org.example.Spider.Img.Img_Paths;
import org.example.Spider.models.Components.Components_Everywhere;
import org.example.Spider.models.Components.Sub_Screens.Components_Sentences_Screens.Sentences_Explanation_Component;
import org.example.Spider.models.Models_Everywhere.masterpanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.awt.Color.gray;

/**
 * View class for the Sentences explanation screen.
 * <p>
 * This screen explains how sentence exercises work
 * and provides a start button to begin the activity.
 */
public class Sentences_Explanantion_Screen_view {

	// Holds sentence input rows (used later during learning)
	public static List<List<JTextPane>> rows = new ArrayList<>();

	/**
	 * Creates and returns the Sentences Explanation screen panel.
	 *
	 * @return fully constructed explanation JPanel
	 */
	public JPanel screenSentencesExplanation() {

		// =========================
		// Main container
		// =========================
		JPanel panelMain = new JPanel();
		panelMain.setLayout(new BorderLayout());
		panelMain.setPreferredSize(new Dimension(1920, 1080));
		panelMain.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		panelMain.setBackground(Color.WHITE);

		// =========================
		// Center panel with background
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
		// Start button panel
		// =========================
		JPanel panelStartButton = new JPanel(new GridLayout(0, 10, 5, 5));
		panelStartButton.setPreferredSize(new Dimension(1920, 60));
		panelStartButton.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelStartButton.setBackground(new Color(95, 102, 107, 0));

		// =========================
		// Labels
		// =========================
		JLabel title = Components_Everywhere.Title("Words");
		JLabel explanation = Sentences_Explanation_Component.ExplanationSentences();

		// =========================
		// Navigation buttons
		// =========================
		JButton home = Components_Everywhere.homeButton(gray);
		JButton hado = Components_Everywhere.hadoButton(gray);
		JButton hadoR = Components_Everywhere.hadoRButton(gray);
		JButton learn = Components_Everywhere.learnButton(gray);
		JButton info = Components_Everywhere.infoButton(gray);

		// =========================
		// Start button
		// =========================

		// Start button activates the sentence exercise
		JButton Start = Sentences_Explanation_Component.startButtonSentences();

		// =========================
		// Layout composition
		// =========================
		panelMain.add(panelMainNorth, BorderLayout.NORTH);
		panelMain.add(panelMainCenter, BorderLayout.CENTER);

		panelMainNorth.add(title);
		panelMainNorth.add(home);
		panelMainNorth.add(hado);
		panelMainNorth.add(hadoR);
		panelMainNorth.add(learn);
		panelMainNorth.add(info);

		panelMainCenter.add(explanation, BorderLayout.NORTH);
		panelMainCenter.add(panelStartButton, BorderLayout.SOUTH);

		panelStartButton.add(Start);

		// =========================
		// Responsive font resizing
		// =========================
		List<JComponent> resizableComponents = Arrays.asList(
				title,
				home,
				hado,
				hadoR,
				learn,
				Start,
				info,
				explanation
		);

		Font_Resizer.applyResizeLogic(panelMain, resizableComponents);

		// Return completed panel
		return panelMain;
	}
}
