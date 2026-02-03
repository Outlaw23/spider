package org.example.Spider.Controllers;

import org.example.Spider.models.Components.Sub_Screens.Components_Picture_Screen.Picture_Learn_Component;
import org.example.Spider.models.Components.Sub_Screens.Components_Sentences_Screens.Sentences_Learn_Component;
import org.example.Spider.models.Components.Sub_Screens.Components_Words_Screens.Words_Learn_Components;
import org.example.Spider.view.Learn_Sub_Screens.Picture_Screen.Picture_Learn_Screen_view;

import javax.swing.*;
import java.awt.*;

import static org.example.Spider.models.Picture.Check_Descriptoins.correctCount;
import static org.example.Spider.models.Sentences.Check_Sentences_Words.scoreSentences;
import static org.example.Spider.models.Words.Check_Word.scoreWords;
import static org.example.Spider.view.Learn_Sub_Screens.Picture_Screen.Picture_Learn_Screen_view.panelMainCenterPicture;

public class Score_Controller {


	public void showScorepicture(Picture_Learn_Screen_view view) {
		int totalCount = 20;
		int percentage = (correctCount * 100) / totalCount;
		panelMainCenterPicture.removeAll();
		panelMainCenterPicture.setLayout(new BorderLayout());

		JLabel scoren = Picture_Learn_Component.scorelabel();
		scoren.setText("<html>\n" +
				"<span style='font-size:100px;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Score " + percentage + "%</span><br/>" +
				"    </html>");
		JButton donebutton = Picture_Learn_Component.donePicture(view);


		panelMainCenterPicture.add(scoren, BorderLayout.CENTER);
		panelMainCenterPicture.add(donebutton, BorderLayout.SOUTH);

		panelMainCenterPicture.revalidate();
		panelMainCenterPicture.repaint();
	}

	public void showScoreWords() {
		int totalCount = 10;
		int percentage = (scoreWords * 100) / totalCount;
		System.out.println(percentage);
		Words_Learn_Components.op1Titel().setText("score " + percentage + "%");
	}

	public void showScoreSentence() {
		int totalCount = 10;
		int percentage = (int) ((scoreSentences / (double) totalCount) * 100);

		JLabel label = Sentences_Learn_Component.scoreLabel();
		label.setText("score " + percentage + "%");
		label.setVisible(true);

		label.revalidate();
		label.repaint();
	}


}
