package spider.building_blocks.screens;

import spider.building_blocks.masterbutton;
import spider.building_blocks.masterlabel;
import spider.building_blocks.masterscrollpane;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.*;

public class screen_hado {

	public JPanel screenHado() {


		// Create a new JPanel
		JPanel panelHado = new JPanel();
		panelHado.setLayout(new BorderLayout());
		panelHado.setPreferredSize(new Dimension(1920, 1080));
		panelHado.setBorder(BorderFactory.createEmptyBorder(0, 20,20 ,20));
		panelHado.setBackground(new Color(255, 255, 255));

		// sub panels

		// panel center
		JPanel panelHadoCenter = new JPanel();
		panelHadoCenter.setLayout(new GridLayout(3,0,0,15));
		panelHadoCenter.setPreferredSize(new Dimension(1920, 500));
		panelHadoCenter.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
		panelHadoCenter.setBackground(new Color(95, 102, 107));

		// panel north
		JPanel panelHadoNorth = new JPanel();
		panelHadoNorth.setLayout(new GridLayout(0,10,5,0));
		panelHadoNorth.setPreferredSize(new Dimension(1920, 50));
		panelHadoNorth.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelHadoNorth.setBackground(new Color(38, 66, 87));

		// labels

		// label title
		masterlabel titel = new masterlabel("hado",white);

		// buttons

		// button main
		masterbutton home = new masterbutton("home","screenMain", gray);

		// button hado
		masterbutton hado = new masterbutton("hado","screenHado",darkGray);

		// button screen video
		masterbutton video = new masterbutton("video","screenVideo",gray);

		// button translate
		masterbutton translate = new masterbutton("translate","",gray);
		translate.masterActionListener();

		// textAreas

//		// text area input
//		mastertextarea input = new mastertextarea();
// 		// text area output
//		mastertextarea output = new mastertextarea();

		// scollpans

		//  text input
		masterscrollpane scrollPaneInput = new masterscrollpane();

		// text output
		masterscrollpane scrollPaneOutput = new masterscrollpane();

		// Add panels main screen
		panelHado.add(panelHadoNorth, BorderLayout.NORTH);
		panelHado.add(panelHadoCenter, BorderLayout.CENTER);

		// add to the panel north
		panelHadoNorth.add(titel.getMasterLabel());
		panelHadoNorth.add(home.getMasterbutton());
		panelHadoNorth.add(hado.getMasterbutton());
		panelHadoNorth.add(video.getMasterbutton());

		// add to panel center
		panelHadoCenter.add(scrollPaneInput.masterscrollpane());
		panelHadoCenter.add(translate.getMasterbutton());
		panelHadoCenter.add(scrollPaneOutput.masterscrollpane());

		return panelHado;  // Return the panel to be added to the JFrame
	}
}
