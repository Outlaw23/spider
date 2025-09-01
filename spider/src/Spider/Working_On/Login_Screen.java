package Spider.Working_On;

import Spider.Controllers.Screen_controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Login_Screen implements ActionListener {

	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("userID:");
	JLabel userPasswordLabel = new JLabel("password:");
	JLabel messageLabel = new JLabel();

	HashMap<String,String> userData = new HashMap<String,String>();

	Login_Screen(HashMap<String, String> userDataLogin) {

		userData = userDataLogin;

		userIDLabel.setBounds(50,100,75,25);
		userPasswordLabel.setBounds(50,150,75,25);

		messageLabel.setBounds(125,250,250,35);
		messageLabel.setFont(new Font(null,Font.BOLD,25));

		userIDField.setBounds(125,100,200,25);
		userPasswordField.setBounds(125,150,200,25);

		loginButton.setBounds(125,200,100,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);

		resetButton.setBounds(225,200,100,25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);

		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(resetButton);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
		}
		if(e.getSource() == loginButton) {

			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());

			if(userData.containsKey(userID)) {
				if(userData.get(userID).equals(password)) {
					messageLabel.setForeground(Color.green);
					messageLabel.setText("Welcome " + userID );
					Screen_controller.screenContoller();
					frame.dispose();
				}
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("wrong password");

				}
			}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("user does not exist");
			}
		}

	}
	
}
