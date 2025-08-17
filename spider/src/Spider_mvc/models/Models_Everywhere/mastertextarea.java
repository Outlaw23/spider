package Spider_mvc.models.Models_Everywhere;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class mastertextarea {
	private static JTextArea masterTextArea;
	private static JTextArea input;
	private static JTextArea output;

	public mastertextarea() {
		if (masterTextArea == null) {  // Prevents reinitialization
			Border bordertextarea = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
			masterTextArea = new JTextArea();
			masterTextArea.setFont(new Font("Arial", Font.PLAIN, 30));
			masterTextArea.setBorder(bordertextarea);
		}
		if  (input == null) {
			Border bordertextarea = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
			input = new JTextArea();
			input.setFont(new Font("Arial", Font.PLAIN, 25));
			input.setBorder(bordertextarea);

		}
		if  (output == null) {
			Border bordertextarea = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
			output = new JTextArea();
			output.setFont(new Font("Arial", Font.PLAIN, 25));
			output.setBorder(bordertextarea);
			output.setEditable(false);

		}

	}

	public JTextArea masterTextArea() {
		return masterTextArea;
	}
	public JTextArea gettextinput() {
		return input;
	}
	public JTextArea gettextoutput() {
		return output;
	}
}