package org.example.Spider.Screen_Learn_Hado.Sub_Screens.Assignments;

import org.example.Spider.Controllers.Font_Resizer;
import org.example.Spider.models.Learn.List_Maker;
import org.example.Spider.models.Models_Everywhere.masterTextPane;
import org.example.Spider.models.Models_Everywhere.masterbutton;
import org.example.Spider.models.Models_Everywhere.masterlabel;
import org.example.Spider.models.hado_language.HadoLanguageMvc;
import org.example.Spider.models.hado_language.Hado_Translater;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Color.*;

public class Words_Learn_Screen {
	Hado_Translater hado = new Hado_Translater();

	private static final Logger log = LoggerFactory.getLogger(Words_Learn_Screen.class);

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
		JPanel panelMainCenter = new JPanel();
		panelMainCenter.setLayout(new BorderLayout());
		panelMainCenter.setPreferredSize(new Dimension(1920, 500));
		panelMainCenter.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		panelMainCenter.setBackground(new Color(95, 102, 107));

		// North panel (top area)
		JPanel panelMainNorth = new JPanel();
		panelMainNorth.setLayout(new GridLayout(0, 10, 5, 0));
		panelMainNorth.setPreferredSize(new Dimension(1920, 50));
		panelMainNorth.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelMainNorth.setBackground(new Color(38, 66, 87));

		//panel top buttons
		JPanel paneltop = new JPanel();
		paneltop.setLayout(new  BorderLayout());
		paneltop.setPreferredSize(new Dimension(1920, 75));
		paneltop.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
		paneltop.setBackground(new Color(52, 62, 69));

		//panel top label
		JPanel panelTopLabel = new JPanel();
		panelTopLabel.setLayout(new BorderLayout());
		panelTopLabel.setPreferredSize(new Dimension(450, 50));
		panelTopLabel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
		panelTopLabel.setBackground(new Color(52, 62, 69));

		//panel to buttons
		JPanel panelTopButtons = new JPanel();
		panelTopButtons.setLayout(new GridLayout(0, 3, 5, 5));
		panelTopButtons.setPreferredSize(new Dimension(450, 50));
		panelTopButtons.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
		panelTopButtons.setBackground(new Color(52, 62, 69));

		// panel words
		JPanel panelWords = new JPanel();
		panelWords.setLayout(new GridLayout(10,0,5,5));
		panelWords.setPreferredSize(new Dimension(220, 50));
		panelWords.setBorder(BorderFactory.createEmptyBorder(5, 55, 5, 30));
		panelWords.setBackground(new Color(75, 89, 74));

		// panel invoer
		JPanel panelInvoer = new JPanel();
		panelInvoer.setLayout(new GridLayout(10,6,5,5));
		panelInvoer.setPreferredSize(new Dimension(1920, 75));
		panelInvoer.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
		panelInvoer.setBackground(new Color(75, 89, 74));



		// Labels
		// Title label
		masterlabel titel = new masterlabel("Words", white);

		//op1 label
		masterlabel op1Titel = new masterlabel("  guess words", white);

		// words label
		// words in een lijst

		List<String> woorden = List_Maker.getWoorden();
		List<masterlabel> wordList = new ArrayList<>();

		for (String words : woorden) {
			masterlabel word = new masterlabel(words, white);
			StringBuilder wordlist = new StringBuilder();
			for (char c : words.toCharArray()) {
				wordlist.append(HadoLanguageMvc.hadoLanguagee(String.valueOf(c)));
				wordList.add(word);
			}
			word.getMasterLabel().setText(wordlist.toString());
			panelWords.add(word.getMasterLabel());
		}



		// Buttons
		// Home button
		masterbutton home = new masterbutton("Home", "screenMain", gray);

		// Hado button
		masterbutton hado = new masterbutton("Hado", "screenHado", gray);

		// HadoR button
		masterbutton hadoR = new masterbutton("HadoR", "screenHadoR", gray);

		// Learn button
		masterbutton Learn = new masterbutton("Learn", "screenLearn", gray);

		// Back button
		masterbutton Back = new masterbutton("Back", "wordsExplanation", gray);

		// Reset button
		masterbutton Reset = new masterbutton("reset", "", gray);
		Reset.getWords(panelWords);

		// submit button
		masterbutton Submit = new masterbutton("Submit", "", gray);
		List<masterTextPane> GuessList = new ArrayList<>();
		Submit.checkWords(GuessList);

		//textfield
		//Quess field
		masterTextPane guess = null;
		for (int i = 0; i  < 60; i++) {
			guess = new masterTextPane("", black);
			GuessList.add(guess);
			panelInvoer.add(guess.getMasterTextPane());
			guess.getMasterTextPane().setEditable(true);
		}

		// Add subpanels to the main panel
		panelMain.add(panelMainNorth, BorderLayout.NORTH);
		panelMain.add(panelMainCenter, BorderLayout.CENTER);

		// Add components to the north panel
		panelMainNorth.add(titel.getMasterLabel());
		panelMainNorth.add(home.getMasterbutton());
		panelMainNorth.add(hado.getMasterbutton());
		panelMainNorth.add(hadoR.getMasterbutton());
		panelMainNorth.add(Learn.getMasterbutton());

		//Add components to the Center panel
		panelMainCenter.add(paneltop, BorderLayout.NORTH);
		panelMainCenter.add(panelWords, BorderLayout.WEST);
		panelMainCenter.add(panelInvoer, BorderLayout.CENTER);

		// Add components to the Top panel
		paneltop.add(panelTopLabel, BorderLayout.CENTER);
		paneltop.add(panelTopButtons, BorderLayout.WEST);

		// Add components to the Top buttons panel
		panelTopButtons.add(Back.getMasterbutton());
		panelTopButtons.add(Reset.getMasterbutton());
		panelTopButtons.add(Submit.getMasterbutton());


		//Add components to the Top label panel
		panelTopLabel.add(op1Titel.getMasterLabel(), BorderLayout.CENTER);
		// Add components to the Words panel



		// Components that will resize when the window is resized
		List<JComponent> resizableComponents = new ArrayList<>();

		// vaste onderdelen
		resizableComponents.add(titel.getMasterLabel());
		resizableComponents.add(home.getMasterbutton());
		resizableComponents.add(hado.getMasterbutton());
		resizableComponents.add(hadoR.getMasterbutton());
		resizableComponents.add(Learn.getMasterbutton());
		resizableComponents.add(Back.getMasterbutton());
		resizableComponents.add(Reset.getMasterbutton());
		resizableComponents.add(op1Titel.getMasterLabel());
		resizableComponents.add(Submit.getMasterbutton());
		for (masterTextPane tf : GuessList) {
			resizableComponents.add(tf.getMasterTextPane());
		}
		for (masterlabel wo : wordList) {
			resizableComponents.add(wo.getMasterLabel());
		}
		Font_Resizer.applyResizeLogic(panelMain, resizableComponents);

		// Return the main panel
		return panelMain;
	}
}
