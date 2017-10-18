package com.prebensoft.adventureoftheknight.blocks;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Block {
	
	protected int id, x, y, width, height;
	protected boolean solid = true;
	
	public Block() {
		
	}
	
	public BufferedImage getTexture() {
		return null;
	}
	public int getID() {
		return id;
	}
	
	public boolean isSolid(){
		return solid;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}

	public abstract void render(Graphics g);

	public int getX() {
		return x;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getY() {
		return y;
	}
	
	
	
}	
	