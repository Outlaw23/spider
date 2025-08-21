package Spider.models.Models_Everywhere;

import javax.swing.*;
import java.awt.*;

public class masterlabel {
	// The actual JLabel that will be styled
	JLabel masterLabel = new JLabel();

	// Constructor: creates a new masterlabel with given text and color
	public masterlabel(String text, Color coler) {
		masterLabel.setFont(new Font("Arial", Font.PLAIN, 30)); // set font and size
		masterLabel.setText(text); // set label text
		masterLabel.setForeground(coler); // set text color
	}

	// Returns the JLabel so it can be added to panels
	public JLabel getMasterLabel() {
		return masterLabel;
	}
}

