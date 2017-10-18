package com.prebensoft.adventureoftheknight.level;

import com.prebensoft.adventureoftheknight.collision.CollisionChecker;
import com.prebensoft.adventureoftheknight.entities.EntitiesHandler;
import com.prebensoft.adventureoftheknight.entities.Orc;
import com.prebensoft.adventureoftheknight.entities.Player;

public class Level {
	
	EntitiesHandler eh;
	Player player;
	CollisionChecker cc;
	private String name;
	private float[] x = new float[10];
	private float[] y = new float[10];

	public Level(String name, EntitiesHandler eh, Player player, CollisionChecker cc) {
		this.name = name;
		this.eh = eh;
		this.player = player;
		this.cc = cc;
	}
	
	public void saveLevel() {
		for(int i = 0; i < eh.getSize(); i++) {
			x[i] = eh.getObject(i).getX();
			y[i] = eh.getObject(i).getY();
		}
	}
	
	public void loadLevel() {
		for(int i = 0; i < x.length; i++) {
			if(x[i] != 0) {
				eh.addObject(new Orc(x[i], y[i], player, cc));				
			}
		}
	}
	
	public String getName() {
		return name;
	}
	
}
