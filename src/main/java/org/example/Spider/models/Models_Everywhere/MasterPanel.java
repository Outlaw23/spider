package org.example.Spider.models.Models_Everywhere;

import org.example.Spider.Controllers.Font_Resizer;
import org.example.Spider.Img.Img_Paths;
import org.example.Spider.models.Components.Components_Everywhere;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static java.awt.Color.gray;

/**
 * A custom JPanel that displays a background image stretched to fit the panel size.
 */
public class MasterPanel extends JPanel {
	/**
	 * Constructs a masterpanel with the specified image path.
	 *
	 *
	 */
	public MasterPanel(String titleDesc) {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(1920, 1080));
		this.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		this.setBackground(new Color(255, 255, 255));


		// Img_Paths.Background_Strip
		// North/top navigation area
		MasterImagePanel panelMainNorth = new MasterImagePanel(Img_Paths.Background_Strip);
		panelMainNorth.setLayout(new BorderLayout());
		panelMainNorth.setPreferredSize(new Dimension(1920, 50));
		panelMainNorth.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
		panelMainNorth.setBackground(new Color(38, 66, 87,0));

		JPanel panelMainNavigation = new JPanel();
		panelMainNavigation.setLayout(new GridLayout(0, 10, 5, 0));
		panelMainNavigation.setPreferredSize(new Dimension(1300, 50));
		panelMainNavigation.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelMainNavigation.setBackground(new Color(38, 66, 87,0));

		// Buttons (top navigation)
		JLabel title = Components_Everywhere.Title(titleDesc);
		// Home button
		JButton home = Components_Everywhere.homeButton(gray);
		// Hado button
		JButton hado = Components_Everywhere.hadoButton(gray);
		// HadoR button
		JButton hadoR = Components_Everywhere.hadoRButton(gray);
		//Learn button
		JButton learn = Components_Everywhere.learnButton(gray);
		//Info button
		JButton info = Components_Everywhere.infoButton(gray);

		// Compose layout: add subpanels to the main panel
		this.add(panelMainNorth, BorderLayout.NORTH);
		// Top bar contents
		panelMainNorth.add(title, BorderLayout.WEST);
		panelMainNorth.add(panelMainNavigation, BorderLayout.EAST);
		panelMainNavigation.add(home);
		panelMainNavigation.add(hado);
		panelMainNavigation.add(hadoR);
		panelMainNavigation.add(learn);
		panelMainNavigation.add(info);

		// Components that will resize when the window is resized
		List<JComponent> resizableComponents = Arrays.asList(
				home,
				hado,
				hadoR,
				learn,
				info
		);
		Font_Resizer.applyResizeLogic(this, resizableComponents);

	}
}
