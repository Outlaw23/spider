package org.example.Spider.models.Components.Sub_Screens.Components_Picture_Screen;

import org.example.Spider.models.Models_Everywhere.MasterButton;
import org.example.Spider.models.Models_Everywhere.MasterLabel;
import org.example.Spider.models.Models_Everywhere.MasterTextArea;
import org.example.Spider.models.Models_Everywhere.MasterTextPane;
import org.example.Spider.models.Picture.Img_Paths_Pictures;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Picture_Learn_Component {

	private static JLabel pictureLabel;
	private static JTextPane answer;
	private static JButton submit;
	private static JTextArea description;

	public static JTextArea	description() {
		if (description == null) {
		MasterTextArea descriptions = new MasterTextArea();
		descriptions.getDescription().setText("Describe the picture");
		description = descriptions.getDescription();

		}
		return description;
	}

	public static JTextPane answer() {
		if (answer == null) {
			MasterTextPane Answer = new MasterTextPane("Enter the answer here", Color.black);
			Border bordertextarea = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
			answer = Answer.getMasterTextPane();
			answer.setBorder(bordertextarea);
		}
		return answer;
	}

	public static JButton submit() {
		if (submit == null) {
			MasterButton submitbutton = new MasterButton("Submit", "", Color.gray);
			submit = submitbutton.getMasterbutton();
		}
		return submit;
	}

	public static JLabel picture() {
		if (pictureLabel == null) {
			MasterLabel picture = new MasterLabel("", Color.white);
			picture.getMasterLabel().setIcon(new ImageIcon(Img_Paths_Pictures.book));
			pictureLabel = picture.getMasterLabel();
		}
		return pictureLabel;
	}

	public static void setImage(String path) {
		pictureLabel.setIcon(new ImageIcon(path));
	}
}
