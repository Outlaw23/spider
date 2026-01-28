package org.example.Spider.models.Models_Everywhere;

import javax.swing.*;
import java.awt.*;

/**
 * A custom JPanel that displays a background image stretched to fit the panel size.
 */
public class MasterImagePanel extends JPanel {

	/** The background image to display */
	private final Image image;

	/**
	 * Constructs a masterpanel with the specified image path.
	 *
	 * @param imagePath the path to the image file to be used as a background
	 */
	public MasterImagePanel(String imagePath) {
		this.image = new ImageIcon(imagePath).getImage();
	}

	/**
	 * Paints the component with the background image, scaling it to fill the panel.
	 *
	 * @param g the Graphics context used for painting
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
	}
}
