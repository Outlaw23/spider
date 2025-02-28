package Spider;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Copy JLabel Text");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);
		frame.setLayout(new FlowLayout());

		JLabel label = new JLabel("Hello, World!");
		JButton copyButton = new JButton("Copy Text");

		copyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = label.getText();
				StringSelection selection = new StringSelection(text);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(selection, null);
				JOptionPane.showMessageDialog(frame, "Text copied to clipboard!");
			}
		});

		frame.add(label);
		frame.add(copyButton);
		frame.setVisible(true);
	}
}
