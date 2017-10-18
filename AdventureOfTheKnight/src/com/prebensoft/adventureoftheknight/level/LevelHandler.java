package com.prebensoft.adventureoftheknight.level;

import java.util.LinkedList;

public class LevelHandler {
	
	private LinkedList<Level> level = new LinkedList<Level>();
	
	public void addObject(Level level) {
		this.level.add(level);
	}
	public void removeObject(int i) {
		this.level.remove(i);
	}
	
	public Level getObject(int i) {
		return level.get(i);
	}
	public int getSize() {
		return level.size();
	}
	public String getName(int i) {
		return level.get(i).getName();
	}
	
	

}
