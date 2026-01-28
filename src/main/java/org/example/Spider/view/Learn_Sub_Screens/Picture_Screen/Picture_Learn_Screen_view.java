package org.example.Spider.view.Learn_Sub_Screens.Picture_Screen;

import org.example.Spider.Controllers.Font_Resizer;
import org.example.Spider.Controllers.Picture.PictureSlideShow;
import org.example.Spider.Img.Img_Paths;
import org.example.Spider.models.Components.Sub_Screens.Components_Picture_Screen.Picture_Learn_Component;
import org.example.Spider.models.Models_Everywhere.MasterImagePanel;
import org.example.Spider.models.Models_Everywhere.MasterPanel;
import org.example.Spider.models.Picture.Check_Descriptoins;
import org.example.Spider.models.Picture.Descriptions_and_answers;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.Spider.models.Picture.Check_Descriptoins.example;
import static org.example.Spider.models.Picture.Check_Descriptoins.fout;

/**
 * View class from the Sentences learning screen.
 * <p>
 * This screen allows the user to place given Hado words
 * into sentence structures and validate their answers.
 */
public class Picture_Learn_Screen_view {
	/**
	 * Creates and returns the Sentences Learn screen panel.
	 *
	 */

	public static JPanel panelPicture = new JPanel();
	public static JPanel panelbutton = new JPanel();
	public static JPanel Panelsumbit = new JPanel();
	public static JPanel PanelAnswerExample = new JPanel();
	public static MasterImagePanel panelMainCenterPicture = new MasterImagePanel(Img_Paths.background_Spider_2);
	public JPanel picture_Learn_Screen_view() {

		// =========================
		// Main container
		// =========================
		MasterPanel panelMain = new MasterPanel("Picture");

		// =========================
		// Center panel with background
		// =========================
		panelMainCenterPicture.setLayout(new GridLayout(0,2,5,5));
		panelMainCenterPicture.setPreferredSize(new Dimension(1920, 500));
		panelMainCenterPicture.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
		panelMainCenterPicture.setBackground(new Color(95, 102, 107));

		//
		panelPicture.setLayout(new BorderLayout());
		panelPicture.setPreferredSize(new Dimension(1920, 500));
		panelPicture.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelPicture.setBackground(new Color(99, 100, 103, 0));
		panelPicture.setOpaque(false);

		JPanel PanelTextSumbit = new JPanel();
		PanelTextSumbit.setLayout(new BorderLayout());
		PanelTextSumbit.setPreferredSize(new Dimension(1920, 500));
		PanelTextSumbit.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		PanelTextSumbit.setBackground(new Color(99, 100, 103, 0));
		PanelTextSumbit.setOpaque(false);

		JPanel PanelAnswer = new JPanel();
		PanelAnswer.setLayout(new BorderLayout());
		PanelAnswer.setPreferredSize(new Dimension(1920, 50));
		PanelAnswer.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		PanelAnswer.setBackground(new Color(255, 0, 0, 0));


		Panelsumbit.setLayout(new BorderLayout());
		Panelsumbit.setPreferredSize(new Dimension(1920, 50));
		Panelsumbit.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		Panelsumbit.setBackground(new Color(142, 16, 60, 0));
		Panelsumbit.setOpaque(false);

		panelbutton.setLayout(new BorderLayout());
		panelbutton.setPreferredSize(new Dimension(1920, 50));
		panelbutton.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelbutton.setBackground(new Color(142, 16, 60, 0));
		panelbutton.setOpaque(false);

		PanelAnswerExample.setLayout(new BorderLayout());
		PanelAnswerExample.setPreferredSize(new Dimension(1920, 50));
		PanelAnswerExample.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		PanelAnswerExample.setBackground(new Color(142, 16, 60, 0));
		PanelAnswerExample.setOpaque(false);





		// =========================
		// Title and navigation buttons
		// =========================
		JLabel picture = Picture_Learn_Component.picture();



		JButton goed = Picture_Learn_Component.goed();
		JTextPane answerExample = Picture_Learn_Component.answerExample();
		Check_Descriptoins check_descriptoins = new Check_Descriptoins();
		goed.addActionListener(_ -> check_descriptoins.descriptionCheck());
		goed.addActionListener(_ -> check_descriptoins.answerCorrect());
		fout.addActionListener(_ ->  check_descriptoins.descriptionCheck());

		Descriptions_and_answers descriptions_and_answers = new Descriptions_and_answers();
		JButton sumbit = Picture_Learn_Component.submit();
		sumbit.addActionListener(_ -> PictureSlideShow.next());
		sumbit.addActionListener(_ -> descriptions_and_answers.descriptions());

		JTextPane answer = Picture_Learn_Component.answer();
		JTextArea description = Picture_Learn_Component.description();

		// Disable navigation during exercise


		// =========================
		// Layout composition
		// =========================

		panelMain.add(panelMainCenterPicture, BorderLayout.CENTER);



		panelMainCenterPicture.add(panelPicture);
		panelMainCenterPicture.add(PanelTextSumbit);

		panelPicture.add(picture, BorderLayout.CENTER);

		PanelTextSumbit.add(new JScrollPane(description), BorderLayout.CENTER);
		PanelTextSumbit.add(PanelAnswer, BorderLayout.NORTH);
		PanelTextSumbit.add(Panelsumbit, BorderLayout.SOUTH);

		PanelAnswer.add(answer, BorderLayout.CENTER);

		Panelsumbit.add(sumbit, BorderLayout.CENTER);

		panelbutton.add(goed, BorderLayout.CENTER);

		PanelAnswerExample.add(answerExample, BorderLayout.CENTER);

		// =========================
		// Responsive font resizing
		// =========================
		List<JComponent> resizableComponents = new ArrayList<>();
		resizableComponents.add(picture);
		resizableComponents.add(description);
		resizableComponents.add(answer);
		resizableComponents.add(sumbit);
		resizableComponents.add(goed);
		resizableComponents.add(fout);
		resizableComponents.add(example);
		resizableComponents.add(answerExample);

		Font_Resizer.applyResizeLogic(panelMain, resizableComponents);

		// Return completed panel
		return panelMain;
	}
}
