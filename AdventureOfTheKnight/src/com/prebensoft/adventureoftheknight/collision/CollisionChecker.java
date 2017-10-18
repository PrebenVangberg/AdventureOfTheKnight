package com.prebensoft.adventureoftheknight.collision;

import com.prebensoft.adventureoftheknight.blocks.*;
import com.prebensoft.adventureoftheknight.entities.Orc;
import com.prebensoft.adventureoftheknight.entities.Player;


public class CollisionChecker {
	
	BlockHandler bh;
	Player player;

	public CollisionChecker(BlockHandler bh) {		
		this.bh = bh;
	}
	
	public void CheckCollision(Player player) {
		this.player = player;
		for (int i = 0; i < bh.getSize(); i++) {

			Block tempBlock = bh.getBlock(i);

			if (tempBlock.isSolid() == true) {
				if (tempBlock.getBounds().intersects(player.nextBounds())) {
					while (tempBlock.getBounds().intersects(player.nextBounds())) {						

						if (tempBlock.getX() + tempBlock.getWidth() < player.getX()) {
							player.setNextX(player.getX());
						} else if (tempBlock.getX() > player.getX() + 63) {
							player.setNextX(player.getX());
						} else if (tempBlock.getY() + tempBlock.getHeight() < player.getY()) {
							player.setNextY(player.getY());
						} else if (tempBlock.getY() > player.getY() + 63) {
							player.setNextY(player.getY());
						}
					}
				}
			}
		}
	}
	public void CheckCollision(Orc orc) {
		
		//BlockCollision
		for (int i = 0; i < bh.getSize(); i++) {

			Block tempBlock = bh.getBlock(i);

			if (tempBlock.isSolid() == true) {
				if (tempBlock.getBounds().intersects(orc.nextBounds())) {
					while (tempBlock.getBounds().intersects(orc.nextBounds())) {						

						if (tempBlock.getX() + tempBlock.getWidth() < orc.getX()) {
							orc.setNextX(orc.getX());
						} else if (tempBlock.getX() > orc.getX() + 47) {
							orc.setNextX(orc.getX());
						} else if (tempBlock.getY() + tempBlock.getHeight() < orc.getY()) {
							orc.setNextY(orc.getY());
						} else if (tempBlock.getY() > orc.getY() + 47) {
							orc.setNextY(orc.getY());
						}
					}
				}
			}
		}
		
		//PlayerCollision
		if(player != null) {
			if(orc.nextBounds().intersects(player.nextBounds())) {
				System.out.println("Eg tar DMG!");
			}
		}
		
		
	}
	
	
}
