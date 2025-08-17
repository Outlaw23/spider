package Spider_mvc.Controllers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

public class Font_Resizer {
	public static void applyResizeLogic(JPanel panel, List<JComponent> components) {
		panel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int baseSize = panel.getWidth() / 50; // verhouding aanpassen

				for (JComponent comp : components) {
					int size = baseSize;

					// voorbeeld: titels groter maken
					if (comp.getName() != null && comp.getName().equals("title")) {
						size = baseSize * 2;
					}

					comp.setFont(new Font("Arial", Font.PLAIN, size));
				}
			}
		});
	}
}
