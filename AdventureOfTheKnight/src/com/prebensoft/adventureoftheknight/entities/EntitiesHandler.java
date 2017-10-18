package com.prebensoft.adventureoftheknight.entities;

import java.awt.Graphics;
import java.util.LinkedList;

public class EntitiesHandler {

	private LinkedList<Orc> orc = new LinkedList<Orc>();	
	
	public void tick() {
		for (int i = 0; i < orc.size(); i++) {

			Orc tempOrc = orc.get(i);
			tempOrc.tick();
		}
	}
	

	public void render(Graphics g) {

		for (int i = 0; i < orc.size(); i++) {

			Orc tempOrc = orc.get(i);
			tempOrc.render(g);

		}

	}

	public void addObject(Orc orc) {
		this.orc.add(orc);
	}

	public void removeObject(Orc orc) {
		this.orc.remove(orc);
	}
	public int getSize() {
		return orc.size();
	}
	public void clear() {
		orc.clear();
	}
	public Orc getObject(int i) {
		return orc.get(i);
	}
	
	

}
