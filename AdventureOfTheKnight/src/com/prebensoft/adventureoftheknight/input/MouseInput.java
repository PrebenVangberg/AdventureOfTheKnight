package com.prebensoft.adventureoftheknight.input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.prebensoft.adventureoftheknight.AdventureOfTheKnight;
import com.prebensoft.adventureoftheknight.AdventureOfTheKnight.STATE;

public class MouseInput extends MouseAdapter {

	AdventureOfTheKnight adventureofhteknight;
	
	public MouseInput(AdventureOfTheKnight adventureofhteknight) {
		this.adventureofhteknight = adventureofhteknight;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		//System.out.println("mx: "+ mx);
		//System.out.println("my: "+ my);
		
		if(adventureofhteknight.gameState == STATE.Menu) {
			if (mouseOver(mx, my, 395 , 296, 200, 64)) {
				adventureofhteknight.gameState = STATE.Game;
			}
			if (mouseOver(mx, my, 395 , 375, 200, 64)) {
				System.exit(1);
			}
		}
		
	}

	public void mouseReleased(MouseEvent e) {

	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		
		if (mx > x && mx < (x + width)) {
			if(my > y && my < (y + height)) {
				return true;
			}
		}		
		return false;
	}
	

}
