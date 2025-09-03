package Spider.Screen_Login;

import Spider.Controllers.Font_Resizer;
import Spider.models.Models_Everywhere.masterbutton;
import Spider.models.Models_Everywhere.masterlabel;
import Spider.models.Models_Everywhere.masterpasswordfield;
import Spider.models.Models_Everywhere.mastertextarea;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static java.awt.Color.gray;
import static java.awt.Color.white;

public class Login_Screen {


	JPanel panelMain = new JPanel();

//	HashMap<String,String> userData = new HashMap<String,String>();

	public JPanel Login_Screen(HashMap<String,String> userdata) {

		JPanel panelMain = new JPanel();
		panelMain.setLayout(new BorderLayout());
		panelMain.setPreferredSize(new Dimension(1920, 1080));
		panelMain.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		panelMain.setBackground(new Color(255, 255, 255));

		JPanel panelMainCenter = new JPanel();
		panelMainCenter.setLayout(new GridLayout(8, 0, 5, 5));
		panelMainCenter.setPreferredSize(new Dimension(1920, 500));
		panelMainCenter.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
		panelMainCenter.setBackground(new Color(95, 102, 107));

		JPanel panelMainNorth = new JPanel();
		panelMainNorth.setLayout(new GridLayout(0, 10, 5, 0));
		panelMainNorth.setPreferredSize(new Dimension(1920, 50));
		panelMainNorth.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
		panelMainNorth.setBackground(new Color(38, 66, 87));

//		userData =  userdata;

		masterlabel titel = new masterlabel("Login", white);


		masterlabel userID = new masterlabel("User ID:", white);

		masterlabel userPassword = new masterlabel("User password:", white);

		masterlabel messageLabel = new masterlabel("Login please", white);

		mastertextarea ID = new mastertextarea();

		masterpasswordfield password = new masterpasswordfield();

		masterbutton login = new masterbutton("login","", gray);
		login.loginButtonActionListener(ID,password,messageLabel);

		panelMain.add(panelMainNorth, BorderLayout.NORTH);
		panelMain.add(panelMainCenter, BorderLayout.CENTER);

		panelMainNorth.add(titel.getMasterLabel());

		panelMainCenter.add(userID.getMasterLabel());
		panelMainCenter.add(userPassword.getMasterLabel());
		panelMainCenter.add(login.getMasterbutton());
		panelMainCenter.add(messageLabel.getMasterLabel());
		panelMainCenter.add(ID.getID());
		panelMainCenter.add(password.getPasswordField());


		List<JComponent> resizableComponents = Arrays.asList(
				titel.getMasterLabel(),
				userID.getMasterLabel(),
				userPassword.getMasterLabel(),
				messageLabel.getMasterLabel(),
				ID.getID(),
				password.getPasswordField(),
				login.getMasterbutton()
		);
		Font_Resizer.applyResizeLogic(panelMain, resizableComponents);

		return panelMain;
	}
	
}
