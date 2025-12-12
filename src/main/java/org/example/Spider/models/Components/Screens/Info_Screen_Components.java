package org.example.Spider.models.Components.Screens;

import org.example.Spider.models.Models_Everywhere.MasterLabel;

import javax.swing.*;

import static java.awt.Color.white;

public class Info_Screen_Components {

	public static JLabel infoLabel() {
		MasterLabel hadoScreen = new MasterLabel("<html><font size=30>Hado</font><br/><br/>" +
				"Welcome to Hado! This language replaces letters using a fixed system.<br/>" +
				"There are no grammar rules — Hado is playful and experimental.<br/>" +
				"Use it to explore patterns, translate words, and learn creatively.<br/><br/>" +

				"<b>Letter mappings:</b><br/><br/>" +

				"B → H &nbsp; | &nbsp; C → J &nbsp; | &nbsp; D → K<br/>" +
				"H → N &nbsp; | &nbsp; J → P &nbsp; | &nbsp; K → Q<br/>" +
				"N → Z &nbsp; | &nbsp; P → T &nbsp; | &nbsp; Q → V<br/>" +
				"Z → B &nbsp; | &nbsp; T → X &nbsp; | &nbsp; V → D<br/>" +
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; | &nbsp; X → C &nbsp; |<br/><br/>" +

				"Every task in this program gives you the chance to practice Hado!<br/>" +
				"Try translating words and see how the letters shift.<br/>" +
				"</html>",
				white
		);
		return hadoScreen.getMasterLabel();
	}
}
