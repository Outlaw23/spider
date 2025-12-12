package org.example.Spider.view.Learn_Sub_Screens.Words_Screens;

import org.example.Spider.Controllers.Font_Resizer;
import org.example.Spider.Controllers.Screen_controller;
import org.example.Spider.Img.Img_Paths;
import org.example.Spider.models.Components.Components_Everywhere;
import org.example.Spider.models.Components.Sub_Screens.Components_Words_Screens.Words_Learn_Components;
import org.example.Spider.models.Learn.Check_Word;
import org.example.Spider.models.Learn.List_Maker;
import org.example.Spider.models.Learn.Screen_Reset_Worlds;
import org.example.Spider.models.Models_Everywhere.masterpanel;
import org.example.Spider.models.hado_language.HadoLanguageMvc;
import org.example.Spider.models.hado_language.Hado_Translater;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Color.gray;
import static org.example.Spider.models.Components.Sub_Screens.Components_Words_Screens.Words_Explanation_Components.GuessList;


public class Words_Learn_Screen_View {
	Hado_Translater hadoWord = new Hado_Translater();
	Check_Word check = new Check_Word();

// instance

	// Method to create and return the main screen JPanel
	public JPanel Words_Learn_screen () {

		// Create the main panel with BorderLayout
		JPanel panelMain = new JPanel();
		panelMain.setLayout(new BorderLayout());
		panelMain.setPreferredSize(new Dimension(1920, 1080));
		panelMain.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		panelMain.setBackground(new Color(255, 255, 255));

		// Create sub-panels for layout structure
		// Center panel
		masterpanel panelMainCenter = new masterpanel(Img_Paths.background_Spider_2);
		panelMainCenter.setLayout(new BorderLayout());
		panelMainCenter.setPreferredSize(new Dimension(1920, 500));
		panelMainCenter.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		panelMainCenter.setBackground(new Color(95, 102, 107));

		// North panel (top area)
		masterpanel panelMainNorth = new masterpanel(Img_Paths.Background_Strip);
		panelMainNorth.setLayout(new GridLayout(0, 10, 5, 0));
		panelMainNorth.setPreferredSize(new Dimension(1920, 50));
		panelMainNorth.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelMainNorth.setBackground(new Color(38, 66, 87));

		//panel top buttons
		JPanel paneltop = new JPanel();
		paneltop.setLayout(new  BorderLayout());
		paneltop.setPreferredSize(new Dimension(1920, 75));
		paneltop.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
		paneltop.setBackground(new Color(52, 62, 69, 0));
		paneltop.setOpaque(false);

		//panel top label
		JPanel panelTopLabel = new JPanel();
		panelTopLabel.setLayout(new BorderLayout());
		panelTopLabel.setPreferredSize(new Dimension(450, 50));
		panelTopLabel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
		panelTopLabel.setBackground(new Color(52, 62, 69, 0));
		panelTopLabel.setOpaque(false);

		//panel to buttons
		JPanel panelTopButtons = new JPanel();
		panelTopButtons.setLayout(new GridLayout(0, 4, 5, 5));
		panelTopButtons.setPreferredSize(new Dimension(550, 50));
		panelTopButtons.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
		panelTopButtons.setBackground(new Color(52, 62, 69, 0));

		// panel words
		JPanel panelWords = new JPanel();
		panelWords.setLayout(new GridLayout(10,0,5,5));
		panelWords.setPreferredSize(new Dimension(220, 50));
		panelWords.setBorder(BorderFactory.createEmptyBorder(5, 55, 5, 30));
		panelWords.setBackground(new Color(75, 89, 74, 0));
		panelWords.setOpaque(false);


		// panel invoer
		JPanel panelInvoer = new JPanel();
		panelInvoer.setLayout(new GridLayout(10,6,5,5));
		panelInvoer.setPreferredSize(new Dimension(1920, 75));
		panelInvoer.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
		panelInvoer.setBackground(new Color(75, 89, 74, 0));



		// Labels
		// Title label
		JLabel title = Components_Everywhere.Title("Words");

		//op1 label
		JLabel op1Titel = Words_Learn_Components.op1Titel();

		// words label
		// words in een lijst

		List<String> woorden = List_Maker.getWoorden();
		List<JLabel> wordList = new ArrayList<>();

		for (String words : woorden) {
			JLabel word = Words_Learn_Components.word(words);

			StringBuilder wordlist = new StringBuilder();
			for (char c : words.toCharArray()) {
				wordlist.append(HadoLanguageMvc.hadoLanguagee(String.valueOf(c)));
				wordList.add(word);
			}
			word.setText(wordlist.toString());
			panelWords.add(word);
		}



		// Buttons
		// Home button
		JButton home = Components_Everywhere.homeButton(gray);
		home.setEnabled(false);

		// Hado button
		JButton hado = Components_Everywhere.hadoButton(gray);
		hado.setEnabled(false);

		// HadoR button
		JButton hadoR = Components_Everywhere.hadoRButton(gray);
		hadoR.setEnabled(false);

		// Learn button
		JButton learn = Components_Everywhere.learnButton(gray);
		learn.setEnabled(false);

		// info button
		JButton info = Components_Everywhere.infoButton(gray);
		info.setEnabled(false);

		// Back button
		JButton back = Words_Learn_Components.back();

		// Reset button
		JButton reset = Words_Learn_Components.reset();
		reset.addActionListener(_ -> hadoWord.getWords(panelWords));

		// submit button
		JButton submit = Words_Learn_Components.submit();
		submit.addActionListener(_ -> check.checkWord(GuessList));

		//done button
		JButton done = Words_Learn_Components.done();
		done.addActionListener(_ ->
				Screen_Reset_Worlds.resetScreen(
						panelWords,
						woorden,
						GuessList,
						title,
						op1Titel,
						reset,
						submit,
						back,
						done,
						check
				)
		);
		done.addActionListener(_ -> Screen_controller.showPanel("screenLearn"));
		done.setEnabled(false);

		//textfield
		//Quess field
		for (int i = 0; i  < 60; i++) {
			JTextPane guess = Words_Learn_Components.textPane();
			GuessList.add(guess);
			panelInvoer.add(guess);
			guess.setEditable(false);
			guess.setBackground(new Color(55, 64, 54));
		}




		// Add subpanels to the main panel
		panelMain.add(panelMainNorth, BorderLayout.NORTH);
		panelMain.add(panelMainCenter, BorderLayout.CENTER);

		// Add components to the north panel
		panelMainNorth.add(title);
		panelMainNorth.add(home);
		panelMainNorth.add(hado);
		panelMainNorth.add(hadoR);
		panelMainNorth.add(learn);
		panelMainNorth.add(info);

		//Add components to the Center panel
		panelMainCenter.add(paneltop, BorderLayout.NORTH);
		panelMainCenter.add(panelWords, BorderLayout.WEST);
		panelMainCenter.add(panelInvoer, BorderLayout.CENTER);

		// Add components to the Top panel
		paneltop.add(panelTopLabel, BorderLayout.EAST);
		paneltop.add(panelTopButtons, BorderLayout.WEST);

		// Add components to the Top buttons panel
		panelTopButtons.add(back);
		panelTopButtons.add(reset);
		panelTopButtons.add(submit);
		panelTopButtons.add(done);


		//Add components to the Top label panel
		panelTopLabel.add(op1Titel, BorderLayout.CENTER);
		// Add components to the Words panel


		// Components that will resize when the window is resized
		List<JComponent> resizableComponents = new ArrayList<>();

		// vaste onderdelen
		resizableComponents.add(title);
		resizableComponents.add(home);
		resizableComponents.add(hado);
		resizableComponents.add(hadoR);
		resizableComponents.add(learn);
		resizableComponents.add(back);
		resizableComponents.add(reset);
		resizableComponents.add(op1Titel);
		resizableComponents.add(submit);
		resizableComponents.add(done);
		resizableComponents.add(info);
		resizableComponents.addAll(GuessList);
		resizableComponents.addAll(wordList);
		Font_Resizer.applyResizeLogic(panelMain, resizableComponents);

		// Return the main panel
		return panelMain;
	}

}
