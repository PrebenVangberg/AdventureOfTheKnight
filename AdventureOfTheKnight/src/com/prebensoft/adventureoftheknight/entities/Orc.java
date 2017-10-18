package com.prebensoft.adventureoftheknight.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.prebensoft.adventureoftheknight.collision.CollisionChecker;

public class Orc {

	private float x, y, velX, velY, playerX, playerY, nextX, nextY;
	private Player player;
	private int width = 48, height = 48;
	BufferedImage img, currentSprite;
	CollisionChecker cc;

	public Orc(float x, float y, Player player, CollisionChecker cc) {
		this.x = x;
		this.y = y;
		this.player = player;
		this.cc = cc;
		velX = 2;
		velY = 2;
		loadTextures();

	}

	public void loadTextures() {
		img = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
		currentSprite = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/enttex/OrcSprites.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		currentSprite = img.getSubimage(0 * 32, 0 * 32, 32, 32);
	}

	public void tick() {

		if (player != null) {
			float playerX = player.getX();
			float playerY = player.getY();

			float diffX = x - playerX - 8;
			float diffY = y - playerY - 8;
			float distance = (float) Math.hypot(diffX, diffY);

			if (distance < 300) {
				velX = ((-1 / distance) * diffX);
				velY = ((-1 / distance) * diffY);
			} else {
				velX = 0;
				velY = 0;
			}

		}

		if (velX > 0) {
			currentSprite = img.getSubimage(32, 0, 32, 32);
		} else if (velX < 0) {
			currentSprite = img.getSubimage(0, 0, 32, 32);
		}
		
		nextX = x + velX;
		nextY = y + velY;

		cc.CheckCollision(this);

		x = nextX;
		y = nextY;

	}

	public void render(Graphics g) {
		g.drawImage(currentSprite, (int)x, (int)y, width, height, null);
	}

	public Rectangle nextBounds() {
		return new Rectangle((int)nextX, (int)nextY, width, height);
	}

	public float getX() {
		return x;
	}

	public void setNextX(float f) {
		this.nextX = f;
	}

	public float getY() {
		return y;
	}

	public void setNextY(float nextY) {
		this.nextY = nextY;
	}

}
