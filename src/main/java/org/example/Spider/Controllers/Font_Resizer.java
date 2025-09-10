package org.example.Spider.Controllers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;
public class Font_Resizer {
	public static void applyResizeLogic(JPanel panel, List<JComponent> components) {
		// Add a ComponentListener to detect when the panel is resized
		panel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				// Calculate a base font size based on the panel width
				int baseSize = panel.getWidth() / 50; // adjust a ratio as needed

				// Iterate through all specified components
				for (JComponent comp : components) {
					int size = baseSize;

					// If the component's name is "title", make the font size bigger
					if (comp.getName() != null && comp.getName().equals("title")) {
						size = baseSize * 2;
					}

					// Set the new font (Arial, plain, calculated size)
					comp.setFont(new Font("Arial", Font.PLAIN, size));
				}
			}
		});
	}
}

