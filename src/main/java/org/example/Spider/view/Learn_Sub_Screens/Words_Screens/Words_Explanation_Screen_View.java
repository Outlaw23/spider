package org.example.Spider.view.Learn_Sub_Screens.Words_Screens;

import org.example.Spider.Controllers.Font_Resizer;
import org.example.Spider.Img.Img_Paths;
import org.example.Spider.models.Components.Components_Everywhere;
import org.example.Spider.models.Components.Sub_Screens.Components_Words_Screens.Words_Explanation_Components;
import org.example.Spider.models.Models_Everywhere.masterpanel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static java.awt.Color.gray;

/**
 * View class responsible for displaying the explanation screen
 * for the Words learning section.
 * <p>
 * This screen introduces the user to how the Words exercise works
 * before starting the actual learning activity.
 */
public class Words_Explanation_Screen_View {

	/**
	 * Creates and returns the Words Explanation screen panel.
	 *
	 * @return fully constructed Words Explanation JPanel
	 */
	public JPanel screenWordsExplanation() {

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
		// Start button container
		// =========================
		JPanel panelStartButton = new JPanel();
		panelStartButton.setLayout(new GridLayout(0, 10, 5, 5));
		panelStartButton.setPreferredSize(new Dimension(1920, 60));
		panelStartButton.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelStartButton.setBackground(new Color(95, 102, 107, 0));

		// =========================
		// UI Components
		// =========================

		// Screen title
		JLabel title = Components_Everywhere.Title("Words");

		// Explanation text describing the Words exercise
		JLabel explanation = Words_Explanation_Components.ExplanationWords();

		// =========================
		// Navigation buttons
		// =========================
		JButton home = Components_Everywhere.homeButton(gray);
		JButton hado = Components_Everywhere.hadoButton(gray);
		JButton hadoR = Components_Everywhere.hadoRButton(gray);
		JButton learn = Components_Everywhere.learnButton(gray);
		JButton info = Components_Everywhere.infoButton(gray);

		// Start exercise button
		JButton Start = Words_Explanation_Components.startButtonWords();

		// =========================
		// Layout composition
		// =========================
		panelMain.add(panelMainNorth, BorderLayout.NORTH);
		panelMain.add(panelMainCenter, BorderLayout.CENTER);

		// Top navigation bar components
		panelMainNorth.add(title);
		panelMainNorth.add(home);
		panelMainNorth.add(hado);
		panelMainNorth.add(hadoR);
		panelMainNorth.add(learn);
		panelMainNorth.add(info);

		// Center panel components
		panelMainCenter.add(panelStartButton, BorderLayout.SOUTH);
		panelMainCenter.add(explanation, BorderLayout.NORTH);

		// Start button placement
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

		// Return fully built explanation screen
		return panelMain;
	}
}
