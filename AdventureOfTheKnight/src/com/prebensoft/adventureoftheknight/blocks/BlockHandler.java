package com.prebensoft.adventureoftheknight.blocks;

import java.awt.Graphics;
import java.util.LinkedList;

public class BlockHandler {

	private LinkedList<Block> block = new LinkedList<Block>();	

	public void render(Graphics g) {

		for (int i = 0; i < block.size(); i++) {

			Block tempBlock = block.get(i);
			tempBlock.render(g);

		}

	}

	public void addObject(Block block) {
		this.block.add(block);
	}

	public void removeObject(Block block) {
		this.block.remove(block);
	}
	public int getSize() {
		return block.size();
	}
	public void clear() {
		block.clear();
	}
	public Block getBlock(int i) {
		return block.get(i);
	}
	
	

}
