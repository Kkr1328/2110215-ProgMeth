package entity;

import entity.base.Consumable;
import entity.base.Entity;
import entity.base.Interactable;
import entity.base.Updatable;
import exception.IllegalValueException;
import logic.GameController;
import logic.Sprites;

public class TrashCompactor extends Entity implements Interactable, Consumable, Updatable {

	private int cooldown;

	public TrashCompactor() {
		// TODO Auto-generated constructor stub
		this.cooldown = 0;
	}

	@Override
	public void update() throws IllegalValueException {
		// TODO Auto-generated method stub
		if (this.cooldown > 0) {
			this.cooldown -= 1;
		}
		try {
			if (this.cooldown < 0) {
				throw new IllegalValueException();
			}
		} catch (IllegalValueException e) {
			valueCorrection();
		}
	}

	@Override
	public void valueCorrection() {
		// TODO Auto-generated method stub
		this.cooldown = 0;
	}

	@Override
	public boolean consume(Entity e) {
		// TODO Auto-generated method stub
		if (isBox(e) && (this.cooldown == 0)) {
			this.cooldown = GameController.MAX_COOLDOWN_TIME;
			return true;
		}
		return false;
	}

	@Override
	public boolean interact(Entity e) {
		// TODO Auto-generated method stub
		if (isBox(e) && (this.cooldown == 0)) {
			return true;
		}
		return false;
	}

	@Override
	public int getSymbol() {
		// TODO Auto-generated method stub
		if (cooldown == 0) {
			return Sprites.COMPACTOR_ON;
		}
		return Sprites.COMPACTOR_OFF;
	}

	public int getCooldown() {
		return cooldown;
	}

	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}

}