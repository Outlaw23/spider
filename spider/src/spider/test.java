package spider;

import javax.swing.*;
import java.awt.*;

public class test {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(test::new);

	}

	public test() {
		createGUI();
	}

	private void createGUI() {
		JFrame frame = new JFrame("Master Button Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 400);
		frame.setLayout(new GridLayout(3, 4, 10, 10)); // Betere lay-out

		// Array van knoppen
		JButton[] buttons = new JButton[10];
		String[] names = {"Hado", "Home", "Button 3", "Button 4", "Button 5", "Button 6", "Button 7", "Button 8", "Button 9", "Button 10"};
		Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE, Color.MAGENTA,
				Color.PINK, Color.CYAN, Color.GRAY, Color.YELLOW, Color.LIGHT_GRAY};

		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(names[i]);
			buttons[i].setBackground(colors[i]);
			buttons[i].setOpaque(true);
			buttons[i].setBorderPainted(false);

			// Elke knop krijgt een unieke actie
			int index = i;
			buttons[i].addActionListener(e -> JOptionPane.showMessageDialog(frame, "Je klikte op: " + names[index]));

			frame.add(buttons[i]);
		}

		// Master button
		JButton masterButton = new JButton("Master Button");
		masterButton.setFont(new Font("Arial", Font.BOLD, 16));
		masterButton.setBackground(Color.BLACK);
		masterButton.setForeground(Color.WHITE);
		frame.add(masterButton);

		// ActionListener voor de master button
		masterButton.addActionListener(e -> {
			for (int i = 0; i < buttons.length; i++) {
				buttons[i].setText("Updated " + names[i]);
				buttons[i].setBackground(colors[(i + 1) % colors.length]); // Wissel kleuren
			}
		});

		frame.setVisible(true);
	}
}
