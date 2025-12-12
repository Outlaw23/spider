package org.example.Spider.models.Models_Everywhere;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MasterTextField {
	JTextField masterTextFiedD;

	public MasterTextField(String text, Color coler) {
		Border bordertextarea = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
		masterTextFiedD = new JTextField();
		masterTextFiedD.setEditable(true);
		masterTextFiedD.setText(text);
		masterTextFiedD.setFont(new Font("Arial", Font.PLAIN, 30));
		masterTextFiedD.setForeground(coler);
		masterTextFiedD.setOpaque(true);
		masterTextFiedD.setBorder(bordertextarea);
	}

	public JTextField getMasterTextFied() {
		return masterTextFiedD;
	}




}
