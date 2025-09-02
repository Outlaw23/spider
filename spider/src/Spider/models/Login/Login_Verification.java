package Spider.models.Login;

import Spider.Controllers.Screen_controller;
import Spider.models.Models_Everywhere.masterlabel;
import Spider.models.Models_Everywhere.mastertextarea;

import javax.swing.*;
import java.awt.*;

public class Login_Verification {
	User_Data_Login LoginData = new User_Data_Login();

		public void loginVerification(mastertextarea ID, JPasswordField Password, masterlabel messageLabel) {

			String userID = ID.getID().getText();
			String password = String.valueOf(Password.getPassword());

			if(LoginData.getUserData().containsKey(userID)) {
				if(LoginData.getUserData().get(userID).equals(password)) {
					messageLabel.getMasterLabel().setForeground(Color.green);
					messageLabel.getMasterLabel().setText("Welcome " + userID );
					Screen_controller.showPanel("screenMain");
					return;
				}
				else {
					messageLabel.getMasterLabel().setForeground(Color.red);
					messageLabel.getMasterLabel().setText("wrong password");
					return;
				}
			}

			messageLabel.getMasterLabel().setForeground(Color.red);
			messageLabel.getMasterLabel().setText("user does not exist");
		}
}
