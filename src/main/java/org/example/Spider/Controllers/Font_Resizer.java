package org.example.Spider.Controllers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

/**
 * Utility class responsible for dynamically resizing fonts
 * based on the size of a given JPanel.
 */
public class Font_Resizer {

	/**
	 * Applies font resize logic to a panel and its components.
	 * Font sizes are recalculated whenever the panel is resized.
	 *
	 * @param panel      the JPanel to observe for resize events
	 * @param components a list of Swing components whose fonts should be resized
	 */
	public static void applyResizeLogic(JPanel panel, List<JComponent> components) {

		// Add a listener to detect when the panel size changes
		panel.addComponentListener(new ComponentAdapter() {

			/**
			 * Triggered whenever the panel is resized.
			 *
			 * @param e resize event
			 */
			@Override
			public void componentResized(ComponentEvent e) {

				// Calculate a base font size relative to the panel width
				int baseSize = panel.getWidth() / 50; // Adjust ratio if needed

				// Loop through all provided components
				for (JComponent comp : components) {
					int size = baseSize;

					// If the component is marked as a title, increase its font size
					if (comp.getName() != null && comp.getName().equals("title")) {
						size = baseSize * 2;
					}

					// Apply the calculated font to the component
					comp.setFont(new Font("Arial", Font.PLAIN, size));
				}
			}
		});
	}
}
