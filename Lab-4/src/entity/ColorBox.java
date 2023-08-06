package entity;

import entity.base.Entity;
import entity.base.Interactable;
import logic.Direction;
import logic.GameController;
import logic.Sprites;

public class ColorBox extends Entity implements Interactable {
	private boolean activeBool;

	public ColorBox(boolean activeBox) {
		super();
		this.activeBool = activeBox;
	}

	public boolean isActiveBool() {
		return activeBool;
	}

	public void setActiveBool(boolean activeBool) {
		this.activeBool = activeBool;
	}

	public int getSymbol() {
		if (activeBool) {
			return Sprites.BOX_RED;
		}
		return Sprites.BOX_BLUE;
	}

	public boolean interact(Entity e) {
		if (GameController.getGameSwitchStatus() == activeBool) {
			Direction targetDir = e.getDirection();
			return this.move(targetDir);
		}
		return false;
	}
}