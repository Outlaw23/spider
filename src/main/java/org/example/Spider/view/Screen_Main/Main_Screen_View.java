package org.example.Spider.view.Screen_Main;


import org.example.Spider.Controllers.Font_Resizer;
import org.example.Spider.Img.Img_Paths;
import org.example.Spider.models.Components.Screens.Main_Screen_Components;
import org.example.Spider.models.Models_Everywhere.MasterImagePanel;
import org.example.Spider.models.Models_Everywhere.MasterPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 * Builds the application's Home/Main screen.
 * <p>
 * This view assembles a top navigation bar (Home, Hado, HadoR, Learn) and a center
 * area with brief descriptions for the Hado and HadoR sections. Fonts are made
 * responsive via {@link org.example.Spider.Controllers.Font_Resizer}.
 * </p>
 */
public class Main_Screen_View {

	/**
	 * Creates and returns the Main screen panel.
	 *
	 * @return a fully constructed {@link JPanel} for the Home screen
	 */
	public JPanel screenMain() {

		// Main container with BorderLayout
		MasterPanel panelMain = new MasterPanel("home");


		// Sub-panels for layout structure
		// Center area with two rows for short descriptions
		MasterImagePanel panelMainCenter = new MasterImagePanel(Img_Paths.Background_Spider);
		panelMainCenter.setLayout(new GridLayout(6, 0, 5, 5));
		panelMainCenter.setPreferredSize(new Dimension(1920, 500));
		panelMainCenter.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
		panelMainCenter.setBackground(new Color(95, 102, 107));

		// Labels
		// Title label (screen heading)

		// Hado description text
		JLabel hadoScreen = Main_Screen_Components.hadoLabel();
		JLabel hadoRScreen = Main_Screen_Components.hadoRLabel();


		// Hado button

		panelMain.add(panelMainCenter, BorderLayout.CENTER);

		// Center content (short descriptions)
		panelMainCenter.add(hadoScreen);
		panelMainCenter.add(hadoRScreen);

		// Components that will resize when the window is resized
		List<JComponent> resizableComponents = Arrays.asList(
				hadoScreen,
				hadoRScreen
		);
		Font_Resizer.applyResizeLogic(panelMain, resizableComponents);

		// Return the assembled main panel
		return panelMain;
	}
}

