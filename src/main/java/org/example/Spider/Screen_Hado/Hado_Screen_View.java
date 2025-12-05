package org.example.Spider.Screen_Hado;

import org.example.Spider.Controllers.Font_Resizer;
import org.example.Spider.models.Components.Components_Everywhere;
import org.example.Spider.models.Components.Screens.Hado_Screen_Components;
import org.example.Spider.models.Models_Everywhere.MasterPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static java.awt.Color.darkGray;
import static java.awt.Color.gray;

public class Hado_Screen_View {

	public JPanel screenHado() {

		// Create the main panel for the Hado screen
		JPanel panelHado = new JPanel();
		panelHado.setLayout(new BorderLayout());
		panelHado.setPreferredSize(new Dimension(1920, 1080));
		panelHado.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		panelHado.setBackground(new Color(255, 255, 255));

		// Sub-panels
		// Center panel
		MasterPanel panelHadoCenter = new MasterPanel
				("src/main/java/org/example/Spider/img/background_hado.jpeg");
		panelHadoCenter.setLayout(new BorderLayout());
		panelHadoCenter.setPreferredSize(new Dimension(1920, 500));
		panelHadoCenter.setBorder(BorderFactory.createEmptyBorder(5, 50, 50, 50));
		panelHadoCenter.setBackground(new Color(95, 102, 107));

		// North panel (top bar)
		MasterPanel panelHadoNorth = new MasterPanel
				("src/main/java/org/example/Spider/img/strip_background.jpeg");
		panelHadoNorth.setLayout(new GridLayout(0, 10, 5, 0));
		panelHadoNorth.setPreferredSize(new Dimension(1920, 50));
		panelHadoNorth.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelHadoNorth.setBackground(new Color(38, 66, 87));

		// Buttons panel (inside center)
		JPanel panelHadoButtons = new JPanel();
		panelHadoButtons.setLayout(new GridLayout(0, 9, 5, 0));
		panelHadoButtons.setPreferredSize(new Dimension(1920, 50));
		panelHadoButtons.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelHadoButtons.setBackground(new Color(95, 102, 107, 0));

		// Text area panel (inside center)
		JPanel panelHadoText = new JPanel();
		panelHadoText.setLayout(new GridLayout(2, 0, 15, 15));
		panelHadoText.setPreferredSize(new Dimension(1920, 50));
		panelHadoText.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelHadoText.setBackground(new Color(95, 102, 107, 0));

		// Labels
		// Title label
		JLabel title = Components_Everywhere.Title("Hado");

		// Buttons
		// Home button
		// Buttons
		// Home button
		JButton home = Components_Everywhere.homeButton(gray);
		// Hado button
		JButton hado = Components_Everywhere.hadoButton(darkGray);
		// HadoR button
		JButton hadoR = Components_Everywhere.hadoRButton(gray);
		//Learn button
		JButton learn = Components_Everywhere.learnbutton(gray);

		// Text areas
		// Input text area
		JTextArea input = Hado_Screen_Components.input();

		// Output text area
		JTextArea output = Hado_Screen_Components.output();

		// Translate button
		JButton translate = Hado_Screen_Components.translate();

		// Add action listener to translate input text to output


		// Add panels to main Hado panel
		panelHado.add(panelHadoNorth, BorderLayout.NORTH);
		panelHado.add(panelHadoCenter, BorderLayout.CENTER);

		// Add components to the north panel (top navigation)
		panelHadoNorth.add(title);
		panelHadoNorth.add(home);
		panelHadoNorth.add(hado);
		panelHadoNorth.add(hadoR);
		panelHadoNorth.add(learn);

		// Add subpanels to the center panel
		panelHadoCenter.add(panelHadoButtons, BorderLayout.NORTH);
		panelHadoCenter.add(panelHadoText, BorderLayout.CENTER);

		// Add button to the buttons panel
		panelHadoButtons.add(translate);

		// Add text areas inside scroll panes to the text panel
		panelHadoText.add(new JScrollPane(input));
		panelHadoText.add(new JScrollPane(output));

		// Add components for dynamic font resizing
		List<JComponent> resizableComponents = Arrays.asList(
				title,
				home,
				hado,
				hadoR,
				learn,
				translate,
				input,
				output
		);
		Font_Resizer.applyResizeLogic(panelHado, resizableComponents);

		// Return the completed panel
		return panelHado;
	}
}

