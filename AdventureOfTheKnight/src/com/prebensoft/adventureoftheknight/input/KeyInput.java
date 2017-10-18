package com.prebensoft.adventureoftheknight.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.prebensoft.adventureoftheknight.AdventureOfTheKnight;
import com.prebensoft.adventureoftheknight.AdventureOfTheKnight.STATE;
import com.prebensoft.adventureoftheknight.Backgroundmusic;
import com.prebensoft.adventureoftheknight.entities.Player;

public class KeyInput extends KeyAdapter {

	Player player;
	AdventureOfTheKnight aotk;
	Backgroundmusic bgm;
	private boolean[] keyDown = new boolean[4];

	public KeyInput(Player player, AdventureOfTheKnight aotk, Backgroundmusic bgm) {
		this.player = player;
		this.aotk = aotk;
		this.bgm = bgm;

		// KeyDown
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;

	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_W) {
			player.setVelY(-5);
			keyDown[0] = true;
		}
		if (key == KeyEvent.VK_S) {
			player.setVelY(5);
			keyDown[1] = true;
		}
		if (key == KeyEvent.VK_A) {
			player.setVelX(-5);
			keyDown[2] = true;
		}
		if (key == KeyEvent.VK_D) {
			player.setVelX(5);
			keyDown[3] = true;
		}

		if (key == KeyEvent.VK_ESCAPE) {
			System.exit(1);
		}

		if (key == KeyEvent.VK_M) {			
			System.out.println("M pressed! This will in the future pause the music!");
		}

		if (aotk.gameState == STATE.Menu) {
			if (key == KeyEvent.VK_ENTER) {
				aotk.gameState = STATE.Game;
			}
		}

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_W) {
			keyDown[0] = false;
		}
		if (key == KeyEvent.VK_S) {
			keyDown[1] = false;
		}
		if (key == KeyEvent.VK_A) {
			keyDown[2] = false;
		}
		if (key == KeyEvent.VK_D) {
			keyDown[3] = false;
		}

		if (keyDown[0] == false && keyDown[1] == false) {
			player.setVelY(0);
		}
		if (keyDown[2] == false && keyDown[3] == false) {
			player.setVelX(0);
		}
	}

}
