package com.prebensoft.adventureoftheknight;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.prebensoft.adventureoftheknight.blocks.BlockHandler;
import com.prebensoft.adventureoftheknight.collision.CollisionChecker;
import com.prebensoft.adventureoftheknight.entities.EntitiesHandler;
import com.prebensoft.adventureoftheknight.entities.Player;
import com.prebensoft.adventureoftheknight.gui.*;
import com.prebensoft.adventureoftheknight.input.*;
import com.prebensoft.adventureoftheknight.level.*;

public class AdventureOfTheKnight extends Canvas implements Runnable {

	private static final long serialVersionUID = 1675721404694872215L;
	private static final int HEIGHT = 704, WIDTH = 960;
	private static final String TITLE = "Adventure of the Knight; Alpha 1.4.0!";
	private Thread thread;
	private boolean running = false;

	Player player;
	LevelConstructor lc;
	BlockHandler bh;
	CollisionChecker cc;
	EntitiesHandler eh;
	Backgroundmusic bgm;
	Menu menu;

	public enum STATE {
		Menu, Game;
	};

	public STATE gameState = STATE.Menu;

	public AdventureOfTheKnight () {
		bgm = new Backgroundmusic();
		bgm.startBackGroundMusic();
		gameState = STATE.Menu;
		menu = new Menu();
		this.addMouseListener(new MouseInput(this));
		eh = new EntitiesHandler();
		bh = new BlockHandler();
		cc = new CollisionChecker(bh);
		player = new Player(13 * 32, 33, cc);
		lc = new LevelConstructor(bh, eh, player, cc);
		new Window(WIDTH, HEIGHT, TITLE, this);

		this.addKeyListener(new KeyInput(player, this, bgm));
	}

	public void tick() {

		if (gameState == STATE.Menu) {

		} else {
			eh.tick();
			player.tick();
			lc.tick();
		}

	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		if (gameState == STATE.Menu) {
			menu.render(g);
		} else {
			lc.render(g);
			bh.render(g);
			eh.render(g);
			player.render(g);
		}

		g.dispose();
		bs.show();
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	public static void main(String[] args) {

		new AdventureOfTheKnight();

	}
}
