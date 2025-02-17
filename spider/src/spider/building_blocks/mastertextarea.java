package spider.building_blocks;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class mastertextarea {
	private static JTextArea masterTextArea;
	public JTextArea masterTextArea () {
		Border bordertextarea = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
		masterTextArea = new JTextArea();
		masterTextArea.setFont(new Font("Arial", Font.PLAIN, 30));
		masterTextArea.setBorder(bordertextarea);
		return masterTextArea;
	}

	public JTextArea getTextInput () {
		return masterTextArea;
	}

	public void setTextOutput (String text) {
		masterTextArea.setText(text);
	}
}
