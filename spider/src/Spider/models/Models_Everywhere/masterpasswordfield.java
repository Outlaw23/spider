package Spider.models.Models_Everywhere;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class masterpasswordfield {
	JPasswordField passwordField  = new JPasswordField();

	public masterpasswordfield() {
			Border bordertextarea = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
			passwordField = new JPasswordField();
			passwordField.setFont(new Font("Arial", Font.PLAIN, 30)); // set font
			passwordField.setBorder(bordertextarea); // add border
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}
}
