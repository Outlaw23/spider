package org.example.Spider.models.Components.Screens;

import org.example.Spider.models.Models_Everywhere.MasterLabel;

import javax.swing.*;

import static java.awt.Color.white;

/**
 * Provides reusable UI components for the
 * Info screen of the application.
 */
public class Info_Screen_Components {

	/**
	 * Creates a label displaying information and instructions about Hado.
	 * Includes an explanation of letter mappings and usage tips.
	 *
	 * @return a formatted JLabel containing the info text
	 */
	public static JLabel infoLabel() {
		MasterLabel hadoScreen = new MasterLabel(
				"<html><font size=30>Hado</font><br/><br/>" +
						"Welcome to Hado! This language replaces letters using a fixed system.<br/>" +
						"There are no grammar rules — Hado is playful and experimental.<br/>" +
						"Use it to explore patterns, translate words, and learn creatively.<br/><br/>" +

						"<b>Letter mappings:</b><br/><br/>" +

						"B → H &nbsp; | &nbsp; C → J &nbsp; | &nbsp; D → K &nbsp; | &nbsp; F → L &nbsp; | &nbsp; G → M<br/>" +
						"H → N &nbsp; | &nbsp; J → P &nbsp; | &nbsp; K → Q &nbsp; | &nbsp; L → R &nbsp; | &nbsp; M → S<br/>" +
						"N → Z &nbsp; | &nbsp; P → T &nbsp; | &nbsp; Q → V &nbsp; | &nbsp; R → W &nbsp; | &nbsp; S → Y<br/>" +
						"Z → B &nbsp; | &nbsp; T → X &nbsp; | &nbsp; V → D &nbsp; | &nbsp; W → F &nbsp; | &nbsp; Y → G<br/>" +
						"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; | &nbsp; X → C &nbsp; |<br/><br/>" +

						"Every task in this program gives you the chance to practice Hado!<br/>" +
						"Try translating words and see how the letters shift.<br/>" +
						"</html>",
				white
		);
		return hadoScreen.getMasterLabel();
	}
}
