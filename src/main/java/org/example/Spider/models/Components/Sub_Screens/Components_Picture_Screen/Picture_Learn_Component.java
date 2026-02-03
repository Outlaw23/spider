package org.example.Spider.models.Components.Sub_Screens.Components_Picture_Screen;

import org.example.Spider.models.Models_Everywhere.MasterButton;
import org.example.Spider.models.Models_Everywhere.MasterLabel;
import org.example.Spider.models.Models_Everywhere.MasterTextArea;
import org.example.Spider.models.Models_Everywhere.MasterTextPane;
import org.example.Spider.models.Picture.Img_Paths_Pictures;
import org.example.Spider.view.Learn_Sub_Screens.Picture_Screen.Picture_Learn_Screen_view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Picture_Learn_Component {

	private static JLabel pictureLabel;
	private static JTextPane answer;
	private static JButton submit;
	private static JTextArea description;
	private static JTextArea example;
	private static JButton goed;
	private static JButton fout;
	private static JTextPane answerExample;
	private static JLabel scoreLabel;
	private static JButton donePicture;

	public static JTextArea	description() {
		if (description == null) {
		MasterTextArea descriptions = new MasterTextArea();
		descriptions.getDescription().setText("Describe the picture");
		description = descriptions.getDescription();

		}
		return description;
	}

	public static JTextArea	example() {
		if (example == null) {
			MasterTextArea examples = new MasterTextArea();
			examples.getDescription().setText("");
			example = examples.getExample();

		}
		return example;
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

	public static JTextPane answerExample() {
		if (answerExample == null) {
			MasterTextPane Answer = new MasterTextPane("answerExample", Color.black);
			Border bordertextarea = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
			answerExample = Answer.getMasterTextPane();
			answerExample.setBorder(bordertextarea);
		}
		return answerExample;
	}

	public static JButton submit() {
		if (submit == null) {
			MasterButton submitbutton = new MasterButton("Submit", "", Color.gray);
			submit = submitbutton.getMasterbutton();
		}
		return submit;
	}

	public static JButton correct() {
		if (goed == null) {
			MasterButton correctbutton = new MasterButton("correct", "", Color.gray);
			goed = correctbutton.getMasterbutton();
		}
		return goed;
	}

	public static JButton incorrect() {
		if (fout == null) {
			MasterButton incorrectbutton = new MasterButton("incorrect", "", Color.gray);
			fout = incorrectbutton.getMasterbutton();
		}
		return fout;
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

	public static JLabel scorelabel() {
		if (scoreLabel == null) {
			MasterLabel score = new MasterLabel("", Color.white);
			scoreLabel = score.getMasterLabel();
		}
		return scoreLabel;
	}

	public static JButton donePicture(Picture_Learn_Screen_view view) {
		if ( donePicture == null) {
			MasterButton donebutton = new MasterButton("Done", "screenLearn", Color.gray);
			donePicture = donebutton.getMasterbutton();
			donebutton.getMasterbutton().addActionListener(_ -> view.initialize());
		}
		return donePicture;
	}
}
