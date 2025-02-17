package spider.building_blocks.screens;

import spider.building_blocks.masterbutton;
import spider.building_blocks.masterlabel;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.*;

public class screen_video {

	// Method to create and return a JPanel
	public JPanel screenVideo() {
		// Create a new JPanel
		JPanel panelVideo = new JPanel();
		panelVideo.setLayout(new BorderLayout());
		panelVideo.setPreferredSize(new Dimension(1920, 1080));
		panelVideo.setBorder(BorderFactory.createEmptyBorder(0, 20, 20,20));
		panelVideo.setBackground(new Color(255, 255, 255));

		// sub panels

		// panel Center
		JPanel panelVideoCenter = new JPanel();
		panelVideoCenter.setLayout(new GridLayout(1,0,5,5));
		panelVideoCenter.setPreferredSize(new Dimension(1920, 500));
		panelVideoCenter.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
		panelVideoCenter.setBackground(new Color(95, 102, 107));
		// panel North
		JPanel panelVideoNorth = new JPanel();
		panelVideoNorth.setLayout(new GridLayout(0,10,5,0));
		panelVideoNorth.setPreferredSize(new Dimension(1920, 50));
		panelVideoNorth.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelVideoNorth.setBackground(new Color(38, 66, 87));

		//labels

		// labal title
		masterlabel titel = new masterlabel("video",white);


		// buttons

		// button home
		masterbutton home = new masterbutton("home","screenMain", gray);

		// button hado
		masterbutton hado = new masterbutton("hado","screenHado",gray);

		// button screen video
		masterbutton video = new masterbutton("video","screenVideo",DARK_GRAY);

		// Add panels main screen
		panelVideo.add(panelVideoNorth, BorderLayout.NORTH);
		panelVideo.add(panelVideoCenter, BorderLayout.CENTER);

		// add  o the panel north
		panelVideoNorth.add(titel.getMasterLabel());
		panelVideoNorth.add(home.getMasterbutton());
		panelVideoNorth.add(hado.getMasterbutton());
		panelVideoNorth.add(video.getMasterbutton());

		// add to panel center


		//


		return panelVideo;  // Return the panel to be added to the JFrame
	}
}
