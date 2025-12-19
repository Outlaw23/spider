package org.example.Spider.view.Screen_Main;


import org.example.Spider.Controllers.Font_Resizer;
import org.example.Spider.Img.Img_Paths;
import org.example.Spider.models.Components.Components_Everywhere;
import org.example.Spider.models.Components.Screens.Main_Screen_Components;
import org.example.Spider.models.Models_Everywhere.masterpanel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static java.awt.Color.darkGray;
import static java.awt.Color.gray;

/**
 * Builds the application's Home/Main screen.
 * <p>
 * This view assembles a top navigation bar (Home, Hado, HadoR, Learn) and a center
 * area with brief descriptions for the Hado and HadoR sections. Fonts are made
 * responsive via {@link org.example.Spider.Controllers.Font_Resizer}.
 * </p>
 */
public class Main_Screen_View {

 /**
  * Creates and returns the Main screen panel.
  *
  * @return a fully constructed {@link JPanel} for the Home screen
  */
 public JPanel screenMain() {

  // Main container with BorderLayout
  JPanel panelMain = new JPanel();
  panelMain.setLayout(new BorderLayout());
  panelMain.setPreferredSize(new Dimension(1920, 1080));
  panelMain.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
  panelMain.setBackground(new Color(255, 255, 255));

  // Sub-panels for layout structure
  // Center area with two rows for short descriptions
  masterpanel panelMainCenter = new masterpanel(Img_Paths.Background_Spider);
  panelMainCenter.setLayout(new GridLayout(6, 0, 5, 5));
  panelMainCenter.setPreferredSize(new Dimension(1920, 500));
  panelMainCenter.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
  panelMainCenter.setBackground(new Color(95, 102, 107));

  // North/top navigation area
  masterpanel panelMainNorth = new masterpanel(Img_Paths.Background_Strip);
  panelMainNorth.setLayout(new GridLayout(0, 10, 5, 0));
  panelMainNorth.setPreferredSize(new Dimension(1920, 50));
  panelMainNorth.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
  panelMainNorth.setBackground(new Color(38, 66, 87));

  // Labels
  // Title label (screen heading)
  JLabel title = Components_Everywhere.Title("home");

		// Hado description text
		JLabel hadoScreen = Main_Screen_Components.hadoLabel();
		JLabel hadoRScreen = Main_Screen_Components.hadoRLabel();

  // Buttons (top navigation)
  // Home button
  JButton home = Components_Everywhere.homeButton(darkGray);
  // Hado button
  JButton hado = Components_Everywhere.hadoButton(gray);
  // HadoR button
  JButton hadoR = Components_Everywhere.hadoRButton(gray);
  //Learn button
  JButton learn = Components_Everywhere.learnButton(gray);
  //Info button
  JButton info = Components_Everywhere.infoButton(gray);

		// Hado button


  // Compose layout: add subpanels to the main panel
  panelMain.add(panelMainNorth, BorderLayout.NORTH);
  panelMain.add(panelMainCenter, BorderLayout.CENTER);

  // Top bar contents
  panelMainNorth.add(title);
  panelMainNorth.add(home);
  panelMainNorth.add(hado);
  panelMainNorth.add(hadoR);
  panelMainNorth.add(learn);
  panelMainNorth.add(info);

  // Center content (short descriptions)
  panelMainCenter.add(hadoScreen);
  panelMainCenter.add(hadoRScreen);

  // Components that will resize when the window is resized
  List<JComponent> resizableComponents = Arrays.asList(
          title,
          hadoScreen,
          hadoRScreen,
          home,
          hado,
          hadoR,
          learn,
		  info
  );
  Font_Resizer.applyResizeLogic(panelMain, resizableComponents);

        // Return the assembled main panel
        return panelMain;
    }
}

