package entity;

import entity.base.Entity;
import entity.base.Interactable;
import entity.base.Updatable;
import logic.GameController;
import logic.Sprites;

public class Switch extends Entity implements Interactable, Updatable {

	private boolean isActive;

	public Switch() {
		// TODO Auto-generated constructor stub
		this.isActive = GameController.getGameSwitchStatus();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.isActive = GameController.getGameSwitchStatus();
	}

	@Override
	public void valueCorrection() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean interact(Entity e) {
		// TODO Auto-generated method stub
		if (e instanceof Player) {
			GameController.setGameSwitchStatus(!GameController.getGameSwitchStatus());
		}
		return false;
	}

	@Override
	public int getSymbol() {
		// TODO Auto-generated method stub
		if (isActive) {
			return Sprites.SWITCH_ON;
		}
		return Sprites.SWITCH_OFF;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}