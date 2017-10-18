package com.prebensoft.adventureoftheknight.level;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.prebensoft.adventureoftheknight.blocks.*;
import com.prebensoft.adventureoftheknight.collision.CollisionChecker;
import com.prebensoft.adventureoftheknight.entities.*;

public class LevelConstructor {

	int LevelX = 1, LevelY = 1;
	EntitiesHandler eh;
	CollisionChecker cc;
	BlockHandler bh;
	Player player;
	LevelHandler lh;
	Level currentLvl;
	int levelNr, lastNr;
	BufferedImage Floor, Walls, Textures, Colors;
	int Wall1, Wall2, Wall3, Wall4, Wall5, Wall6, Wall7, Wall8, Wall9, GrassTile, DungeonFloor, Tiles;

	public LevelConstructor(BlockHandler bh, EntitiesHandler eh, Player player, CollisionChecker cc) {
		this.bh = bh;
		this.cc = cc;
		this.eh = eh;
		this.player = player;
		lh = new LevelHandler();
		Floor = new BufferedImage(30, 22, BufferedImage.TYPE_INT_ARGB);
		Walls = new BufferedImage(30, 22, BufferedImage.TYPE_INT_ARGB);
		Textures = new BufferedImage(320, 320, BufferedImage.TYPE_INT_ARGB);
		Colors = new BufferedImage(15, 11, BufferedImage.TYPE_INT_ARGB);
		LevelX = 1;
		LevelY = 1;
		levelNr = 1;
		lastNr = 1;
		try {
			Textures = ImageIO.read(getClass().getResourceAsStream("/tex/Textures.png"));
			Colors = ImageIO.read(getClass().getResourceAsStream("/tex/Colors.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		loadColors();
		loadLevel();

	}

	public void tick() {

		if (player.getX() + 48 < 0) {
			LevelX--;
			player.setX(959);
			loadLevel();
		}
		if (player.getX() > 960) {
			LevelX++;
			player.setX(1);
			loadLevel();
		}
		if (player.getY() + 48 < 0) {
			LevelY--;
			player.setY(703);
			loadLevel();
		}
		if (player.getY() > 704) {
			LevelY++;
			player.setY(1);
			loadLevel();
		}

	}

	public void loadLevel() {
		// SaveCurrentLevel
		if (currentLvl != null) {
			System.out.println("CurrentLvl Saved");
			currentLvl.saveLevel();
		}

		// Clearing Level
		eh.clear();
		bh.clear();

		// Check if level Exist (Loading/Creating Level)
		boolean foundLvl = false;
		for (int i = 0; i < lh.getSize(); i++) {
			if (lh.getName(i).equals("x" + LevelX + "y" + LevelY)) {
				System.out.println("Level Found. Loading Level!");
				currentLvl = lh.getObject(i);
				currentLvl.loadLevel();
				foundLvl = true;
			}
		}
		if (foundLvl == false) {
			lh.addObject(new Level(("x" + LevelX + "y" + LevelY), eh, player, cc));
			currentLvl = lh.getObject(lh.getSize() - 1);
			System.out.println("Level Not Found. Creating Level");

			// Put in code for creation of lvl here. Based on image file!
			
		}

		// Else make lvl

		System.out.println("");

		loadMap();
		makeWalls();
		levelNr++;
		eh.addObject(new Orc(100, 100, player, cc));
	}

	private void loadMap() {
		System.out.println("CurrentCoordinates: x"+ LevelX + " y" + LevelY);
		try {
			Floor = ImageIO.read(getClass().getResourceAsStream("/level/x" + LevelX + "/y" + LevelY + "/floor.png"));
			Walls = ImageIO.read(getClass().getResourceAsStream("/level/x" + LevelX + "/y" + LevelY + "/wall.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void render(Graphics g) {

		drawFloor(g);

	}

	private void drawFloor(Graphics g) {
		for (int x = 0; x < 30; x++) {
			for (int y = 0; y < 22; y++) {
				if (Floor.getRGB(x, y) == GrassTile) {
					g.drawImage(Textures.getSubimage(0 * 32, 0 * 32, 32, 32), x * 32, y * 32, 32, 32, null);
				}
				if (Floor.getRGB(x, y) == DungeonFloor) {
					g.drawImage(Textures.getSubimage(1 * 32, 0 * 32, 32, 32), x * 32, y * 32, 32, 32, null);
				}
				if (Floor.getRGB(x, y) == Tiles) {
					g.drawImage(Textures.getSubimage(11 * 32, 0 * 32, 32, 32), x * 32, y * 32, 32, 32, null);
				}
			}
		}
	}

	private void makeWalls() {
		for (int x = 0; x < 30; x++) {
			for (int y = 0; y < 22; y++) {
				if (Walls.getRGB(x, y) == Wall1) {
					bh.addObject(new Wall((x * 32), (y * 32), Textures.getSubimage(2 * 32, 0, 32, 32)));
				}
				if (Walls.getRGB(x, y) == Wall2) {
					bh.addObject(new Wall(x * 32, y * 32, Textures.getSubimage(3 * 32, 0, 32, 32)));
				}
				if (Walls.getRGB(x, y) == Wall3) {
					bh.addObject(new Wall(x * 32, y * 32, Textures.getSubimage(4 * 32, 0, 32, 32)));
				}
				if (Walls.getRGB(x, y) == Wall4) {
					bh.addObject(new Wall(x * 32, y * 32, Textures.getSubimage(5 * 32, 0, 32, 32)));
				}
				if (Walls.getRGB(x, y) == Wall5) {
					bh.addObject(new Wall(x * 32, y * 32, Textures.getSubimage(6 * 32, 0, 32, 32)));
				}
				if (Walls.getRGB(x, y) == Wall6) {
					bh.addObject(new Wall(x * 32, y * 32, Textures.getSubimage(7 * 32, 0, 32, 32)));
				}
				if (Walls.getRGB(x, y) == Wall7) {
					bh.addObject(new Wall(x * 32, y * 32, Textures.getSubimage(8 * 32, 0, 32, 32)));
				}
				if (Walls.getRGB(x, y) == Wall8) {
					bh.addObject(new Wall(x * 32, y * 32, Textures.getSubimage(9 * 32, 0, 32, 32)));
				}
				if (Walls.getRGB(x, y) == Wall9) {
					bh.addObject(new Wall(x * 32, y * 32, Textures.getSubimage(10 * 32, 0, 32, 32)));
				}
			}
		}
	}

	public void loadColors() {
		Wall1 = Colors.getRGB(0, 0);
		Wall2 = Colors.getRGB(1, 0);
		Wall3 = Colors.getRGB(2, 0);
		Wall4 = Colors.getRGB(3, 0);
		Wall5 = Colors.getRGB(4, 0);
		Wall6 = Colors.getRGB(5, 0);
		Wall7 = Colors.getRGB(6, 0);
		Wall8 = Colors.getRGB(7, 0);
		Wall9 = Colors.getRGB(8, 0);
		GrassTile = Colors.getRGB(10, 0);
		DungeonFloor = Colors.getRGB(11, 0);
		Tiles = Colors.getRGB(12, 0);
	}

}
