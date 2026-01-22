package org.example.Spider.view.Learn_Sub_Screens.Picture_Screen;

import org.example.Spider.Controllers.Font_Resizer;
import org.example.Spider.Controllers.Picture.PictureSlideShow;
import org.example.Spider.Img.Img_Paths;
import org.example.Spider.models.Components.Components_Everywhere;
import org.example.Spider.models.Components.Sub_Screens.Components_Picture_Screen.Picture_Learn_Component;
import org.example.Spider.models.Models_Everywhere.masterpanel;
import org.example.Spider.models.Picture.Descriptions_and_answers;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Color.gray;

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
	 * @return fully constructed Sentences Learn JPanel
	 */
	public JPanel picture_Learn_Screen_view() {

		// =========================
		// Main container
		// =========================
		JPanel panelMain = new JPanel();
		panelMain.setLayout(new BorderLayout());
		panelMain.setPreferredSize(new Dimension(1920, 1080));
		panelMain.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		panelMain.setBackground(Color.WHITE);

		// =========================
		// Center panel with background
		// =========================
		masterpanel panelMainCenter = new masterpanel(Img_Paths.background_Spider_2);
		panelMainCenter.setLayout(new GridLayout(0,2,5,5));
		panelMainCenter.setPreferredSize(new Dimension(1920, 500));
		panelMainCenter.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
		panelMainCenter.setBackground(new Color(95, 102, 107));

		// =========================
		// Top navigation bar
		// =========================
		masterpanel panelMainNorth = new masterpanel(Img_Paths.Background_Strip);
		panelMainNorth.setLayout(new GridLayout(0, 10, 5, 0));
		panelMainNorth.setPreferredSize(new Dimension(1920, 50));
		panelMainNorth.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelMainNorth.setBackground(new Color(38, 66, 87));

		//
		JPanel panelPicture = new JPanel();
		panelPicture.setLayout(new BorderLayout());
		panelPicture.setPreferredSize(new Dimension(1920, 500));
		panelPicture.setBorder(BorderFactory.createEmptyBorder(20, 5, 20, 5));
		panelPicture.setBackground(new Color(99, 100, 103, 0));
		panelPicture.setOpaque(false);

		JPanel PanelTextSumbit = new JPanel();
		PanelTextSumbit.setLayout(new BorderLayout());
		PanelTextSumbit.setPreferredSize(new Dimension(1920, 500));
		PanelTextSumbit.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		PanelTextSumbit.setBackground(new Color(99, 100, 103, 0));

		JPanel PanelAnswer = new JPanel();
		PanelAnswer.setLayout(new BorderLayout());
		PanelAnswer.setPreferredSize(new Dimension(1920, 50));
		PanelAnswer.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		PanelAnswer.setBackground(new Color(255, 0, 0, 0));

		JPanel Panelsumbit = new JPanel();
		Panelsumbit.setLayout(new BorderLayout());
		Panelsumbit.setPreferredSize(new Dimension(1920, 50));
		Panelsumbit.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		Panelsumbit.setBackground(new Color(142, 16, 60, 0));




		// =========================
		// Title and navigation buttons
		// =========================
		JLabel title = Components_Everywhere.Title("Picture");
		JLabel picture = Picture_Learn_Component.picture();


		JButton home = Components_Everywhere.homeButton(gray);
		JButton hado = Components_Everywhere.hadoButton(gray);
		JButton hadoR = Components_Everywhere.hadoRButton(gray);
		JButton learn = Components_Everywhere.learnButton(gray);
		JButton info = Components_Everywhere.infoButton(gray);

		Descriptions_and_answers descriptions_and_answers = new Descriptions_and_answers();
		JButton sumbit = Picture_Learn_Component.submit();
		sumbit.addActionListener(_ -> PictureSlideShow.next());
		sumbit.addActionListener(_ -> descriptions_and_answers.descriptions());

		JTextPane answer = Picture_Learn_Component.answer();
		JTextArea description = Picture_Learn_Component.description();

		// Disable navigation during exercise
		home.setEnabled(false);
		hado.setEnabled(false);
		hadoR.setEnabled(false);
		learn.setEnabled(true);
		info.setEnabled(false);


		// =========================
		// Layout composition
		// =========================
		panelMain.add(panelMainNorth, BorderLayout.NORTH);
		panelMain.add(panelMainCenter, BorderLayout.CENTER);

		panelMainNorth.add(title);
		panelMainNorth.add(home);
		panelMainNorth.add(hado);
		panelMainNorth.add(hadoR);
		panelMainNorth.add(learn);
		panelMainNorth.add(info);

		panelMainCenter.add(panelPicture);
		panelMainCenter.add(PanelTextSumbit);

		panelPicture.add(picture, BorderLayout.CENTER);

		PanelTextSumbit.add(description, BorderLayout.CENTER);
		PanelTextSumbit.add(PanelAnswer, BorderLayout.NORTH);
		PanelTextSumbit.add(Panelsumbit, BorderLayout.SOUTH);

		PanelAnswer.add(answer, BorderLayout.CENTER);

		Panelsumbit.add(sumbit, BorderLayout.CENTER);


		// =========================
		// Responsive font resizing
		// =========================
		List<JComponent> resizableComponents = new ArrayList<>();
		resizableComponents.add(title);
		resizableComponents.add(home);
		resizableComponents.add(hado);
		resizableComponents.add(hadoR);
		resizableComponents.add(learn);
		resizableComponents.add(info);
		resizableComponents.add(picture);
		resizableComponents.add(description);
		resizableComponents.add(answer);
		resizableComponents.add(sumbit);

		Font_Resizer.applyResizeLogic(panelMain, resizableComponents);

		// Return completed panel
		return panelMain;
	}
}
