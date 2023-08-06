package card.cards;

import player.Player;
import card.base.CharacterCard;

//You CAN modify the first line
public class BasicCharacterCard extends CharacterCard {

	public BasicCharacterCard(String name, String description, int lifePoint, int attackPoint, int defensePoint) {
		super(name, description, lifePoint, attackPoint, defensePoint);
	}

	public int sacrifice(Player player) {
		player.healPlayer(player.getMaxLifePoint() / 6);
		return player.getCurrentLifePoint();
	}
}