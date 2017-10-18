package com.prebensoft.adventureoftheknight.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;


import javax.imageio.ImageIO;

import com.prebensoft.adventureoftheknight.collision.CollisionChecker;

public class Player {
	
	private float x, y, velX, velY, nextX, nextY;
	private int width, height;
	int color;
	BufferedImage img, currentSprite;
	CollisionChecker cc;
	
	public Player(float x, float y, CollisionChecker cc) {		
		this.x = x;
		this.y = y;
		color =  16711680;
		velX = 0;
		velY = 0;
		nextX = x;
		nextY = y;
		width = 64;
		height = 64;
		this.cc = cc;
		loadTextures();
			
	}
	
	public void tick() {
		nextX = x + velX;
		nextY = y + velY;
		
		cc.CheckCollision(this);
		
		x = nextX;
		y = nextY;
		
		if(velX > 0 ) {
			currentSprite = img.getSubimage(0, 0, 32, 32);
		}
		else if(velX < 0 ) {
			currentSprite = img.getSubimage(0, 32, 32, 32);
		}
		else if(velY > 0 ) {
			currentSprite = img.getSubimage(32, 0, 32, 32);
		}
		else if(velY < 0 ) {
			currentSprite = img.getSubimage(32, 32, 32, 32);
		}
		
	}
	
	public void render(Graphics g) {

		g.drawImage(currentSprite, (int)x, (int)y, width, height, null);
	}
	
	public Rectangle nextBounds() {
		return new Rectangle((int)nextX, (int)nextY, width, height);
	}
	
	public void loadTextures() {
		img = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
		currentSprite = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/enttex/PlayerSprites.png"));			

		} catch (IOException e) {
			e.printStackTrace();
		}
		currentSprite = img.getSubimage(0*32, 0*32, 32, 32);
	}	
	
	//Getter and setters
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}		

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}
	
	public void setVelY(float velY) {
		this.velY = velY;
	}
	
	public float getNextX() {
		return nextX;
	}

	public void setNextX(float nextX) {
		this.nextX = nextX;
	}

	public float getNextY() {
		return nextY;
	}

	public void setNextY(float nextY) {
		this.nextY = nextY;
	}	
}
