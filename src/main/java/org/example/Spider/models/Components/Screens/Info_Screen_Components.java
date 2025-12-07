package org.example.Spider.models.Components.Screens;

import org.example.Spider.models.Models_Everywhere.masterlabel;

import javax.swing.*;

import static java.awt.Color.white;

public class Info_Screen_Components {

	public static JLabel infoLabel() {
		masterlabel hadoScreen = new masterlabel(
				"<html><font size=30>Hado</font><br/>" +
						"Welcome to Hado! This language replaces letters using a fixed system.<br/><br/>" +
						"<b>Letter mappings:</b><br/>" +
						"B → H, H → N, N → Z, Z → B<br/>" +
						"C → J, J → P, P → T, T → X, X → C<br/>" +
						"D → K, K → Q, Q → V, V → D<br/>" +
						"F → L, L → R, R → W, W → F<br/>" +
						"G → M, M → S, S → Y, Y → G<br/><br/>" +
						"There are no grammar rules — Hado is a playful and experimental language.<br/>" +
						"Use it to explore patterns, translate words, and learn in a creative way.<br/>" +
						"Every task in this program gives you the chance to practice Hado!<br/>" +
						"</html>",
				white
		);
		return hadoScreen.getMasterLabel();
	}
}
