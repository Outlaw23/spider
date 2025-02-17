package spider.building_blocks.screenHadoBuild.textArea_hado;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class text_input {
	private static JTextArea textInput;
	public JTextArea textInput () {
		Border bordertextarea = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
		textInput = new JTextArea();
		textInput.setFont(new Font("Arial", Font.PLAIN, 30));
		textInput.setBorder(bordertextarea);
		return textInput;
	}

	public JTextArea getTextInput () {
		return textInput;

	}
}
