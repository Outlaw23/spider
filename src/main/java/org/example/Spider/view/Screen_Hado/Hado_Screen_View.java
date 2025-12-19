package org.example.Spider.view.Screen_Hado;

import org.example.Spider.Controllers.Font_Resizer;
import org.example.Spider.Img.Img_Paths;
import org.example.Spider.models.Components.Components_Everywhere;
import org.example.Spider.models.Components.Screens.Hado_Screen_Components;
import org.example.Spider.models.Models_Everywhere.masterpanel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static java.awt.Color.darkGray;
import static java.awt.Color.gray;

/**
 * View class responsible for building the Hado screen UI.
 * This screen allows users to translate text using Hado logic.
 */
public class Hado_Screen_View {

	/**
	 * Creates and returns the Hado screen panel.
	 *
	 * @return fully constructed Hado JPanel
	 */
	public JPanel screenHado() {

		// =========================
		// Main container panel
		// =========================
		JPanel panelHado = new JPanel();
		panelHado.setLayout(new BorderLayout());
		panelHado.setPreferredSize(new Dimension(1920, 1080));
		panelHado.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		panelHado.setBackground(new Color(255, 255, 255));

		// =========================
		// Center panel with background image
		// Contains buttons and text areas
		// =========================
		masterpanel panelHadoCenter = new masterpanel(Img_Paths.background_Spider_2);
		panelHadoCenter.setLayout(new BorderLayout());
		panelHadoCenter.setPreferredSize(new Dimension(1920, 500));
		panelHadoCenter.setBorder(BorderFactory.createEmptyBorder(5, 50, 50, 50));
		panelHadoCenter.setBackground(new Color(95, 102, 107));

		// =========================
		// Top navigation bar
		// =========================
		masterpanel panelHadoNorth = new masterpanel(Img_Paths.Background_Strip);
		panelHadoNorth.setLayout(new GridLayout(0, 10, 5, 0));
		panelHadoNorth.setPreferredSize(new Dimension(1920, 50));
		panelHadoNorth.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelHadoNorth.setBackground(new Color(38, 66, 87));

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

		// Screen title
		JLabel title = Components_Everywhere.Title("Hado");

		// Navigation buttons
		JButton home = Components_Everywhere.homeButton(gray);
		JButton hado = Components_Everywhere.hadoButton(darkGray);
		JButton hadoR = Components_Everywhere.hadoRButton(gray);
		JButton learn = Components_Everywhere.learnButton(gray);
		JButton info = Components_Everywhere.infoButton(gray);

		// Text input area
		JTextArea input = Hado_Screen_Components.input();

		// Text output area
		JTextArea output = Hado_Screen_Components.output();

		// Translate button
		JButton translate = Hado_Screen_Components.translate();

		// =========================
		// Layout composition
		// =========================

		// Add main subpanels
		panelHado.add(panelHadoNorth, BorderLayout.NORTH);
		panelHado.add(panelHadoCenter, BorderLayout.CENTER);

		// Add navigation components
		panelHadoNorth.add(title);
		panelHadoNorth.add(home);
		panelHadoNorth.add(hado);
		panelHadoNorth.add(hadoR);
		panelHadoNorth.add(learn);
		panelHadoNorth.add(info);

		// Add center subpanels
		panelHadoCenter.add(panelHadoButtons, BorderLayout.NORTH);
		panelHadoCenter.add(panelHadoText, BorderLayout.CENTER);

		// Add translate button
		panelHadoButtons.add(translate);

		// Add scrollable text areas
		panelHadoText.add(new JScrollPane(input));
		panelHadoText.add(new JScrollPane(output));

		// =========================
		// Responsive font resizing
		// =========================
		List<JComponent> resizableComponents = Arrays.asList(
				title,
				home,
				hado,
				hadoR,
				learn,
				translate,
				input,
				output,
				info
		);

		// Apply automatic font resize logic
		Font_Resizer.applyResizeLogic(panelHado, resizableComponents);

		// Return fully built Hado screen
		return panelHado;
	}
}
