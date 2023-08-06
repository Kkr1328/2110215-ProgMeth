package entity;

import entity.base.Entity;
import entity.base.Interactable;
import logic.Sprites;

public class Box extends Entity implements Interactable {

	public Box() {
		// TODO Auto-generated constructor stub
	}

	public int getSymbol() {
		return Sprites.BOX;
	}

	@Override
	public boolean interact(Entity e) {
		// TODO Auto-generated method stub
		return this.move(e.getDirection());
	}
}