package org.example.Spider.view.Screen_HadoR;

import org.example.Spider.Controllers.Font_Resizer;
import org.example.Spider.Img.Img_Paths;
import org.example.Spider.models.Components.Screens.HadoR_Screen_Components;
import org.example.Spider.models.Models_Everywhere.MasterImagePanel;
import org.example.Spider.models.Models_Everywhere.MasterPanel;
import org.example.Spider.models.Models_Everywhere.MasterScrollPane;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 * View the class responsible for building the HadoR screen UI.
 * This screen allows users to translate text using HadoR logic.
 */
public class HadoR_Screen_View {

	/**
	 * Creates and returns the HadoR screen panel.
	 *
	 * @return fully constructed HadoR JPanel
	 */
	public JPanel screenHadoR() {

		// =========================
		// Main container panel
		// =========================
		MasterPanel panelMain = new MasterPanel("HadoR");


		// =========================
		// Center panel with background image
		// Contains buttons and text areas
		// =========================
		MasterImagePanel panelHadoCenter = new MasterImagePanel(Img_Paths.background_Spider_2);
		panelHadoCenter.setLayout(new BorderLayout());
		panelHadoCenter.setPreferredSize(new Dimension(1920, 500));
		panelHadoCenter.setBorder(BorderFactory.createEmptyBorder(5, 50, 50, 50));
		panelHadoCenter.setBackground(new Color(95, 102, 107));



		// =========================
		// Buttons panel (inside center panel)
		// =========================
		JPanel panelHadoButtons = new JPanel();
		panelHadoButtons.setLayout(new GridLayout(0, 9, 5, 0));
		panelHadoButtons.setPreferredSize(new Dimension(1920, 50));
		panelHadoButtons.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelHadoButtons.setBackground(new Color(95, 102, 107, 0));

		// =========================
		// Text area panel (inside center panel)
		// =========================
		JPanel panelHadoText = new JPanel();
		panelHadoText.setLayout(new GridLayout(2, 0, 15, 15));
		panelHadoText.setPreferredSize(new Dimension(1920, 50));
		panelHadoText.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelHadoText.setBackground(new Color(95, 102, 107, 0));

		// =========================
		// UI Components
		// =========================

		// Text input area for HadoR translation
		JTextArea inputR = HadoR_Screen_Components.intputR();

		// Text output area for a translated result
		JTextArea outputR = HadoR_Screen_Components.outputR();

		// Translate button
		JButton translateR = HadoR_Screen_Components.translateR();

		// =========================
		// Layout composition
		// =========================

		// Add main subpanels

		panelMain.add(panelHadoCenter, BorderLayout.CENTER);

		// Add navigation components

		// Add center subpanels
		panelHadoCenter.add(panelHadoButtons, BorderLayout.NORTH);
		panelHadoCenter.add(panelHadoText, BorderLayout.CENTER);

		// Add translate button
		panelHadoButtons.add(translateR);

		// Add scrollable text areas
		MasterScrollPane masterScroll = new MasterScrollPane(inputR);
		MasterScrollPane masterScroll1 = new MasterScrollPane(outputR);
		panelHadoText.add(masterScroll.getScrollPane());
		panelHadoText.add(masterScroll1.getScrollPane());

		// =========================
		// Responsive font resizing
		// =========================
		List<JComponent> resizableComponents = Arrays.asList(
				translateR,
				inputR,
				outputR
		);

		// Apply automatic font resize logic
		Font_Resizer.applyResizeLogic(panelMain, resizableComponents);

		// Return a fully built HadoR screen
		return panelMain;
	}
}
