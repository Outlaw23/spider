package org.example.Spider.models.Models_Everywhere;

import javax.swing.*;
import java.awt.*;

public class masterTextField {
	JTextField masterTextFiedD;

	public masterTextField(String text, Color coler) {
		masterTextFiedD = new JTextField();
		masterTextFiedD.setEditable(true);
		masterTextFiedD.setText(text);
		masterTextFiedD.setFont(new Font("Arial", Font.PLAIN, 30));
		masterTextFiedD.setForeground(coler);
		masterTextFiedD.setOpaque(true);
	};

	public JTextField getMasterTextFiedD() {
		return masterTextFiedD;
	}




}
