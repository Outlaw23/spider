package org.example.Spider.models.Models_Everywhere;

import org.example.Spider.Controllers.Screen_controller;
import org.example.Spider.models.Sentences.Check_Sentences_Words;
import org.example.Spider.models.Words.Check_Word;
import org.example.Spider.models.Login.Login_Verification;
import org.example.Spider.models.hado_language.Hado_Translater;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * A reusable JButton class with pre-configured styling, hover effects,
 * and utility methods for attaching actions such as Hado translation,
 * login verification, and word/sentence checking.
 */
public class MasterButton {

	/** Instance for Hado translation actions */
	Hado_Translater hado = new Hado_Translater();

	/** Instance for login verification */
	Login_Verification login = new Login_Verification();

	/** Instance for checking guessed words */
	Check_Word check = new Check_Word();

	/** Instance for checking guessed sentences */
	Check_Sentences_Words checkSent = new Check_Sentences_Words();

	/** The actual JButton that will be styled and used */
	private final JButton masterbutton = new JButton();

	/** Border used for the button */
	Border borderbutton = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);

	/**
	 * Constructs a MasterButton with specified text, panel for navigation, and background color.
	 * Adds hover effects and default action to switch panels.
	 *
	 * @param name      the text to display on the button
	 * @param panelname the name of the panel to switch to when clicked
	 * @param coler     the background color of the button
	 */
	public MasterButton(String name, String panelname, Color coler) {
		masterbutton.setText(name);
		masterbutton.setFocusPainted(false);
		masterbutton.setFont(new Font("Arial", Font.PLAIN, 25));
		masterbutton.setForeground(Color.white);
		masterbutton.setBackground(coler);
		masterbutton.setOpaque(true);
		masterbutton.setBorder(borderbutton);
		masterbutton.setPreferredSize(new Dimension(100, 35));

		// Mouse hover effect
		masterbutton.addMouseListener(new MouseAdapter() {
			Color coler = masterbutton.getBackground();

			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				coler = masterbutton.getBackground();
				masterbutton.setBackground(new Color(52, 53, 54));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				masterbutton.setBackground(coler);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				// Optional: extra click behavior can go here
			}
		});

		// Switch a panel when the button is clicked
		masterbutton.addActionListener(_ -> Screen_controller.showPanel(panelname));
	}

	/**
	 * Returns the underlying JButton so it can be added to panels.
	 *
	 * @return the styled JButton
	 */
	public JButton getMasterbutton() {
		return masterbutton;
	}

	/**
	 * Attaches an action listener to translate input text to Hado language
	 * and set it in the output JTextArea when the button is clicked.
	 *
	 * @param input  the input JTextArea
	 * @param output the output JTextArea
	 */
	public void transletActionListener(JTextArea input, JTextArea output) {
		masterbutton.addActionListener(_ -> hado.transform(input, output));
	}

	/**
	 * Attaches an action listener to reverse-translate Hado text to normal text
	 * when the button is clicked.
	 *
	 * @param inputR  the Hado input JTextArea
	 * @param outputR the output JTextArea
	 */
	public void transletRActionListener(JTextArea inputR, JTextArea outputR) {
		masterbutton.addActionListener(_ -> hado.transformR(inputR, outputR));
	}

	/**
	 * Attaches an action listener for login verification using the provided components.
	 *
	 * @param ID           the JTextField containing the user ID
	 * @param password     the JPasswordField containing the user's password
	 * @param messageLabel the JLabel to display login messages
	 */
	public void loginButtonActionListener(JTextField ID, JPasswordField password, JLabel messageLabel) {
		masterbutton.addActionListener(_ -> login.loginVerification(ID, password, messageLabel));
	}

	/**
	 * Attaches an action listener to check a list of guessed words when the button is clicked.
	 *
	 * @param guess a list of JTextPane elements containing guessed words
	 */
	public void startWords(List<JTextPane> guess) {
		masterbutton.addActionListener(_ -> check.RowsTrue(guess));
	}

	/**
	 * Attaches an action listener to check guessed sentences when the button is clicked.
	 *
	 * @param sentences a list of JTextPane elements containing guessed sentences
	 * @param p         start index of the row
	 * @param q         end index of the row
	 */
	public void startSentences(List<JTextPane> sentences, int p, int q) {
		masterbutton.addActionListener(_ -> checkSent.RowsTrueSentences(sentences, p, q));
	}
}
