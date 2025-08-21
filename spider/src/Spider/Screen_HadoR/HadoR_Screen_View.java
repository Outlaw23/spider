package Spider.Screen_HadoR;


import Spider.Controllers.Font_Resizer;
import Spider.models.Models_Everywhere.masterbutton;
import Spider.models.Models_Everywhere.masterlabel;
import Spider.models.Models_Everywhere.mastertextarea;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static java.awt.Color.*;

public class HadoR_Screen_View {

	// Method to create and return the HadoR screen JPanel
	public JPanel screenHadoR() {

		// Create the main panel for the HadoR screen
		JPanel panelHado = new JPanel();
		panelHado.setLayout(new BorderLayout());
		panelHado.setPreferredSize(new Dimension(1920, 1080));
		panelHado.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		panelHado.setBackground(new Color(255, 255, 255));

		// Sub-panels
		// Center panel
		JPanel panelHadoCenter = new JPanel();
		panelHadoCenter.setLayout(new BorderLayout());
		panelHadoCenter.setPreferredSize(new Dimension(1920, 500));
		panelHadoCenter.setBorder(BorderFactory.createEmptyBorder(5, 50, 50, 50));
		panelHadoCenter.setBackground(new Color(95, 102, 107));

		// North panel (top bar)
		JPanel panelHadoNorth = new JPanel();
		panelHadoNorth.setLayout(new GridLayout(0, 10, 5, 0));
		panelHadoNorth.setPreferredSize(new Dimension(1920, 50));
		panelHadoNorth.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelHadoNorth.setBackground(new Color(38, 66, 87));

		// Buttons panel (inside center)
		JPanel panelHadoButtons = new JPanel();
		panelHadoButtons.setLayout(new GridLayout(0, 9, 5, 0));
		panelHadoButtons.setPreferredSize(new Dimension(1920, 50));
		panelHadoButtons.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelHadoButtons.setBackground(new Color(95, 102, 107));

		// Text area panel (inside center)
		JPanel panelHadoText = new JPanel();
		panelHadoText.setLayout(new GridLayout(2, 0, 15, 15));
		panelHadoText.setPreferredSize(new Dimension(1920, 50));
		panelHadoText.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelHadoText.setBackground(new Color(95, 102, 107));

		// Labels
		// Title label
		masterlabel titel = new masterlabel("hado", white);

		// Buttons
		// Home button
		masterbutton home = new masterbutton("Home", "screenMain", gray);

		// Hado button
		masterbutton hado = new masterbutton("Hado", "screenHado", gray);

		// HadoR (video) button
		masterbutton video = new masterbutton("HadoR", "screenVideo", darkGray);

		// Text areas
		// Input text area
		mastertextarea inputR = new mastertextarea();

		// Output text area
		mastertextarea outputR = new mastertextarea();

		// Translate button for HadoR
		masterbutton translateR = new masterbutton("translateR", "", gray);

		// Add action listener to translate input text to output
		translateR.transletRActionListener(inputR, outputR);

		// Add panels to the main HadoR panel
		panelHado.add(panelHadoNorth, BorderLayout.NORTH);
		panelHado.add(panelHadoCenter, BorderLayout.CENTER);

		// Add components to the north panel (navigation bar)
		panelHadoNorth.add(titel.getMasterLabel());
		panelHadoNorth.add(home.getMasterbutton());
		panelHadoNorth.add(hado.getMasterbutton());
		panelHadoNorth.add(video.getMasterbutton());

		// Add subpanels to the center panel
		panelHadoCenter.add(panelHadoButtons, BorderLayout.NORTH);
		panelHadoCenter.add(panelHadoText, BorderLayout.CENTER);

		// Add button to the buttons panel
		panelHadoButtons.add(translateR.getMasterbutton());

		// Add text areas inside scroll panes to the text panel
		panelHadoText.add(new JScrollPane(inputR.gettextinputR()));
		panelHadoText.add(new JScrollPane(outputR.gettextoutputR()));

		// Add components for dynamic font resizing
		List<JComponent> resizableComponents = Arrays.asList(
				titel.getMasterLabel(),
				home.getMasterbutton(),
				hado.getMasterbutton(),
				video.getMasterbutton(),
				translateR.getMasterbutton(),
				inputR.gettextinputR(),
				outputR.gettextoutputR()
		);
		Font_Resizer.applyResizeLogic(panelHado, resizableComponents);

		// Return the completed panel
		return panelHado;
	}
}
