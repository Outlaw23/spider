package Spider_mvc.models.Models_Everywhere;

import javax.swing.*;
import java.awt.*;

public class masterlabel {
	JLabel masterLabel = new JLabel();
	public masterlabel(String text, Color coler) {
		masterLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		masterLabel.setText(text);
		masterLabel.setForeground(coler);
	}
	public JLabel getMasterLabel() {
		return masterLabel;
	}

}
