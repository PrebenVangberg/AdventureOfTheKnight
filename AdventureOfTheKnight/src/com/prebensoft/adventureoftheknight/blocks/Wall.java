package com.prebensoft.adventureoftheknight.blocks;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Wall extends Block{
	
	BufferedImage img = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);

	public Wall(int x, int y, BufferedImage img) {		
		id = 1;
		this.x = x;
		this.y = y;		
		this.img = img;
		solid = true;
		width = 32;
		height = 32;
	}

	
	public void render(Graphics g) {
			g.drawImage(img, x, y, width, height, null);	
	}
	
	
}
