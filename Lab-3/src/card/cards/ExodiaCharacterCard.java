package card.cards;

import card.base.CharacterCard;
import card.base.ItemCard;
import player.Player;

//You CAN modify the first line
public class ExodiaCharacterCard extends CharacterCard{
		
	public ExodiaCharacterCard() {
		super("Exodia the Forbidden One", "With 4 or more Exodia Part Card equiped, you win the game", 800, 0, 25);
	}
	
	//Fill Code Here
	
	public int sacrifice(Player player) {
		player.healPlayer(player.getMaxLifePoint() / 10);
		return player.getCurrentLifePoint();
	}
	
	public boolean winConditionCheck(ItemCard[] inventory) {
		int count = 0;
		for (ItemCard item : inventory) {
			if (item instanceof ExodiaPartCard) {
				count += 1;
			}
		}
		return count >= 4;
	}
}