package com.prebensoft.adventureoftheknight;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Menu extends Canvas{
	
	private static final long serialVersionUID = 1L;
	private BufferedImage MenuBackground;
	private BufferedImage MenuLogo;
	private BufferedImage PlaygameButton;
	private BufferedImage ExitButton;
	private int offset = 25;
	
	
	public Menu() {		
		MenuBackground = new BufferedImage(960, 704, BufferedImage.TYPE_INT_RGB);
		MenuLogo = new BufferedImage(304, 145, BufferedImage.TYPE_INT_RGB);
		PlaygameButton = new BufferedImage(200, 64, BufferedImage.TYPE_INT_RGB);
		ExitButton = new BufferedImage(200, 64, BufferedImage.TYPE_INT_RGB);
		try {
			MenuBackground = ImageIO.read(getClass().getResourceAsStream("/menu/BackGround.png"));	
			MenuLogo = ImageIO.read(getClass().getResourceAsStream("/menu/MenuLogo.png"));	
			PlaygameButton = ImageIO.read(getClass().getResourceAsStream("/menu/PlaygameButton.png"));
			ExitButton = ImageIO.read(getClass().getResourceAsStream("/menu/ExitButton.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public void render(Graphics g) {	
		g.drawImage(MenuBackground, 0, 0, 960, 704, null);	
		g.drawImage(MenuLogo, (960/2)-(304/2) -offset, 100, 304, 145, null);	
		g.drawImage(PlaygameButton, 370, 295, 200, 64, null);
		g.drawImage(ExitButton, 370, 375, 200, 64, null);
	}
	
}
