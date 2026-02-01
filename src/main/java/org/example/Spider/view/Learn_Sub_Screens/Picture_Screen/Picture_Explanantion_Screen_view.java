package org.example.Spider.view.Learn_Sub_Screens.Picture_Screen;

import org.example.Spider.Controllers.Font_Resizer;
import org.example.Spider.Img.Img_Paths;
import org.example.Spider.models.Components.Sub_Screens.Components_Picture_Screen.Picture_Explanation_Component;
import org.example.Spider.models.Models_Everywhere.MasterImagePanel;
import org.example.Spider.models.Models_Everywhere.MasterPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * View class for the Sentences explanation screen.
 * <p>
 * This screen explains how sentence exercises work
 * and provides a start button to begin the activity.
 */
public class Picture_Explanantion_Screen_view {

	// Holds sentence input rows (used later during learning)
	public static List<List<JTextPane>> rows = new ArrayList<>();

	/**
	 * Creates and returns the Sentences Explanation screen panel.
	 *
	 * @return fully constructed explanation JPanel
	 */
	public JPanel screenPictureExplanation() {

		// =========================
		// Main container
		// =========================
		MasterPanel panelMain = new MasterPanel("Picture");

		// =========================
		// Center panel with background
		// =========================
		MasterImagePanel panelMainCenter = new MasterImagePanel(Img_Paths.Background_Spider);
		panelMainCenter.setLayout(new BorderLayout());
		panelMainCenter.setPreferredSize(new Dimension(1920, 500));
		panelMainCenter.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
		panelMainCenter.setBackground(new Color(95, 102, 107));


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
		JLabel explanation = Picture_Explanation_Component.ExplanationPicture();


		// =========================
		// Start button
		// =========================

		// The start button activates the sentence exercise
		JButton Start = Picture_Explanation_Component.startButtonPicture();

		// =========================
		// Layout composition
		// =========================

		panelMain.add(panelMainCenter, BorderLayout.CENTER);


		panelMainCenter.add(explanation, BorderLayout.NORTH);
		panelMainCenter.add(panelStartButton, BorderLayout.SOUTH);

		panelStartButton.add(Start);


		// =========================
		// Responsive font resizing
		// =========================
		List<JComponent> resizableComponents = Arrays.asList(
				Start,
				explanation
		);

		Font_Resizer.applyResizeLogic(panelMain, resizableComponents);

		// Return completed panel
		return panelMain;
	}
}
