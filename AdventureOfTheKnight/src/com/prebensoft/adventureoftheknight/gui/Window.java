package com.prebensoft.adventureoftheknight.gui;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
import com.prebensoft.adventureoftheknight.AdventureOfTheKnight;

public class Window  extends Canvas{

	private static final long serialVersionUID = 8901254819732555398L;
	
	public Window (int width, int height, String title, AdventureOfTheKnight adventureoftheknight) {
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(adventureoftheknight);
		frame.setVisible(true);
		adventureoftheknight.start();
	}

}
