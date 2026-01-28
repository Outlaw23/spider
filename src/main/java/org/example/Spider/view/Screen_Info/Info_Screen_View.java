package org.example.Spider.view.Screen_Info;

import org.example.Spider.Controllers.Font_Resizer;
import org.example.Spider.Img.Img_Paths;
import org.example.Spider.models.Components.Screens.Info_Screen_Components;
import org.example.Spider.models.Models_Everywhere.MasterImagePanel;
import org.example.Spider.models.Models_Everywhere.MasterPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * View class responsible for building the Info screen UI.
 * This class only handles layout and visual components.
 */
public class Info_Screen_View {

	/**
	 * Creates and returns the Info screen panel.
	 *
	 * @return fully constructed Info screen JPanel
	 */
	public JPanel screenInfo() {

		// =========================
		// Main container panel
		// =========================
		MasterPanel panelMain = new MasterPanel("Info");


		// =========================
		// Center panel with background image
		// Displays information text
		// =========================
		MasterImagePanel panelMainCenter = new MasterImagePanel(Img_Paths.Background_Spider);
		panelMainCenter.setLayout(new BorderLayout());
		panelMainCenter.setPreferredSize(new Dimension(1920, 500));
		panelMainCenter.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
		panelMainCenter.setBackground(new Color(95, 102, 107));


		// =========================
		// UI Components
		// =========================

		// Screen title


		// Main information text label
		JLabel infoText = Info_Screen_Components.infoLabel();


		// =========================
		// Layout composition
		// =========================

		// Add subpanels to main container
		panelMain.add(panelMainCenter, BorderLayout.CENTER);

		// Add components to the top navigation bar

		// Add information text to the center panel
		panelMainCenter.add(infoText, BorderLayout.NORTH);

		// =========================
		// Responsive font resizing
		// =========================
		List<JComponent> resizableComponents = List.of(
				infoText
		);

		// Apply automatic font resize logic
		Font_Resizer.applyResizeLogic(panelMain, resizableComponents);

		// Return fully built Info screen
		return panelMain;
	}
}
