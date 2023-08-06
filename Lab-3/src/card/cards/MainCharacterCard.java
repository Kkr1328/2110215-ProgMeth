package card.cards;

import card.base.CharacterCard;
import player.Player;

//You CAN modify the first line
public class MainCharacterCard extends CharacterCard {
	private float levelUpBonus;
	private int level;

	public MainCharacterCard(String name, String description, int lifePoint, int attackPoint, int defensePoint,
			float levelUpBonus) {
		super(name, description, lifePoint, attackPoint, defensePoint);
		this.levelUpBonus = levelUpBonus;
		this.level = 0;
	}

	public int sacrifice(Player player) {
		player.healPlayer(player.getMaxLifePoint() / 8);
		return player.getCurrentLifePoint();
	}

	public float levelUp(Player player) {
		level += 1;
		int newLifePoint = (int) (player.getMaxLifePoint() * (levelUpBonus + 1));
		player.setNewCharacterLifePoint(newLifePoint);
		int newAttackPoint = (int) (player.getAttack() * (levelUpBonus + 1));
		player.setAttack(newAttackPoint);
		int newDefensePoint = (int) (player.getDefense() * (levelUpBonus + 1));
		player.setDefense(newDefensePoint);
		return levelUpBonus;
	};

	@Override
	public String getName() {
		return super.getName() + " [level " + this.getLevel() + "]";
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
