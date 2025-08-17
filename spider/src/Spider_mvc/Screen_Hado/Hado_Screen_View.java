package Spider_mvc.Screen_Hado;

import Spider_mvc.Controllers.Font_Resizer;
import Spider_mvc.models.Models_Everywhere.masterbutton;
import Spider_mvc.models.Models_Everywhere.masterlabel;
import Spider_mvc.models.Models_Everywhere.mastertextarea;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static java.awt.Color.*;

public class Hado_Screen_View {

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
		panelHadoCenter.setLayout(new BorderLayout());
		panelHadoCenter.setPreferredSize(new Dimension(1920, 500));
		panelHadoCenter.setBorder(BorderFactory.createEmptyBorder(5, 50, 50, 50));
		panelHadoCenter.setBackground(new Color(95, 102, 107));

		// panel north
		JPanel panelHadoNorth = new JPanel();
		panelHadoNorth.setLayout(new GridLayout(0,10,5,0));
		panelHadoNorth.setPreferredSize(new Dimension(1920, 50));
		panelHadoNorth.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelHadoNorth.setBackground(new Color(38, 66, 87));

		// panel buttons
		JPanel panelHadoButtons = new JPanel();
		panelHadoButtons.setLayout(new GridLayout(0,10,5,0));
		panelHadoButtons.setPreferredSize(new Dimension(1920, 50));
		panelHadoButtons.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelHadoButtons.setBackground(new Color(95, 102, 107));

		// panel text
		JPanel panelHadoText = new JPanel();
		panelHadoText.setLayout(new GridLayout(2,0,15,15));
		panelHadoText.setPreferredSize(new Dimension(1920, 50));
		panelHadoText.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelHadoText.setBackground(new Color(95, 102, 107));



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

		//
		masterbutton voice = new masterbutton("voice","",gray);

		mastertextarea input = new mastertextarea();

		// text output
		mastertextarea output = new mastertextarea();


		// button translate
		masterbutton translate = new masterbutton("translate","",gray);
		// transform input to output
		translate.transletActionListener(input, output);

		// textAreas

//		// text area input

// 		// text area output


		// scollpans

		//  text input

		// Add panels main screen
		panelHado.add(panelHadoNorth, BorderLayout.NORTH);
		panelHado.add(panelHadoCenter, BorderLayout.CENTER);

		// add to the panel north
		panelHadoNorth.add(titel.getMasterLabel());
		panelHadoNorth.add(home.getMasterbutton());
		panelHadoNorth.add(hado.getMasterbutton());
		panelHadoNorth.add(video.getMasterbutton());

		// add to panel center
		panelHadoCenter.add(panelHadoButtons, BorderLayout.NORTH);
		panelHadoCenter.add(panelHadoText,BorderLayout.CENTER);


		//add to panel buttons
		panelHadoButtons.add(translate.getMasterbutton());
		panelHadoButtons.add(voice.getMasterbutton());

		//add to panel text
		panelHadoText.add(new JScrollPane(input.gettextinput()));
		panelHadoText.add(new JScrollPane(output.gettextoutput()));

		//
		List<JComponent> resizableComponents = Arrays.asList(
				titel.getMasterLabel(),
				home.getMasterbutton(),
				hado.getMasterbutton(),
				video.getMasterbutton(),
				voice.getMasterbutton(),
				translate.getMasterbutton(),
				input.gettextinput(),
				output.gettextoutput()
		);
		Font_Resizer.applyResizeLogic(panelHado, resizableComponents);



		return panelHado;  // Return the panel to be added to the JFrame
	}
}
