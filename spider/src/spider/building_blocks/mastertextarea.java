package spider.building_blocks;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class mastertextarea {
	private static JTextArea masterTextArea;

	public mastertextarea() {
		if (masterTextArea == null) {  // Prevents reinitialization
			Border bordertextarea = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
			masterTextArea = new JTextArea();
			masterTextArea.setFont(new Font("Arial", Font.PLAIN, 30));
			masterTextArea.setBorder(bordertextarea);
		}
	}

	public JTextArea masterTextArea() {
		return masterTextArea;
	}
	public JTextArea gettextinput() {
		return masterTextArea;
	}

	public void gettextoutput(String text) {
		masterTextArea.setText(text);
	}
}