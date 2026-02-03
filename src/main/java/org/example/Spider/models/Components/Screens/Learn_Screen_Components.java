package org.example.Spider.models.Components.Screens;

import org.example.Spider.models.Models_Everywhere.MasterButton;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Color.gray;

/**
 * Provides reusable UI components for the
 * Learn screen of the application.
 */
public class Learn_Screen_Components {

	/**
	 * Counter representing the current assignment number.
	 */
	public static int numberOpdracht = 0;

	/**
	 * List storing assignment buttons.
	 */
	public static List<JButton> opdrachten = new ArrayList<>();

	/**
	 * Creates a button for the current assignment number.
	 *
	 * @return a configured JButton representing an assignment
	 */
	public static JButton opdrachten() {
		MasterButton opdracht  = new MasterButton("assignment " + numberOpdracht, "", gray);
		return opdracht.getMasterbutton();
	}

}
