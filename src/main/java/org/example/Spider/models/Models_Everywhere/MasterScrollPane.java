package org.example.Spider.models.Models_Everywhere;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class MasterScrollPane {

	private final JScrollPane scrollPane;

	public MasterScrollPane(Component content) {
		scrollPane = new JScrollPane(content);

		scrollPane.setBorder(null);
		scrollPane.setBackground(Color.DARK_GRAY);
		scrollPane.getViewport().setBackground(Color.DARK_GRAY);

		// Vertical scrollbar
		JScrollBar vBar = scrollPane.getVerticalScrollBar();
		vBar.setPreferredSize(new Dimension(8, Integer.MAX_VALUE));
		vBar.setUI(createModernScrollBarUI());

		// Horizontal scrollbar (optioneel)
		JScrollBar hBar = scrollPane.getHorizontalScrollBar();
		hBar.setPreferredSize(new Dimension(Integer.MAX_VALUE, 8));
		hBar.setUI(createModernScrollBarUI());
	}

	private BasicScrollBarUI createModernScrollBarUI() {
		return new BasicScrollBarUI() {

			@Override
			protected void configureScrollBarColors() {
				thumbColor = new Color(71, 71, 71, 120);
				trackColor = new Color(0, 0, 0, 0);
			}

			@Override
			protected JButton createDecreaseButton(int orientation) {
				return createZeroButton();
			}

			@Override
			protected JButton createIncreaseButton(int orientation) {
				return createZeroButton();
			}

			private JButton createZeroButton() {
				JButton btn = new JButton();
				btn.setPreferredSize(new Dimension(0, 0));
				btn.setMinimumSize(new Dimension(0, 0));
				btn.setMaximumSize(new Dimension(0, 0));
				return btn;
			}
		};
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}
}
