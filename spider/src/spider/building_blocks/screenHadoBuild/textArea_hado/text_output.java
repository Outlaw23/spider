package spider.building_blocks.screenHadoBuild.textArea_hado;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class text_output {
	private static JTextArea textOutput;
	public JTextArea textOutput () {
		Border bordertextarea = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
		textOutput = new JTextArea();
		textOutput.setFont(new Font("Arial", Font.PLAIN, 30));
		textOutput.setBorder(bordertextarea);
		textOutput.setEditable(false);
		return textOutput;
	}

	public void setTextOutput (String text) {
		textOutput.setText(text);
	}
}
