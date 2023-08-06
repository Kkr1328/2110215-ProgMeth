package card.cards;

import player.Player;
import card.base.ItemCard;

//You CAN modify the first line
public class BasicItemCard extends ItemCard {

	public BasicItemCard(String name, String description, int lpBonus, int attackBonus, int defenseBonus) {
		super(name, description, lpBonus, attackBonus, defenseBonus);
	}

	public void equipItem(Player player) {
		player.addInventory(this);
		player.setMaxLifePoint(lpBonus + player.getMaxLifePoint());
		player.setCurrentLifePoint(lpBonus + player.getCurrentLifePoint());
		player.setAttack(attackBonus + player.getAttack());
		player.setDefense(defenseBonus + player.getDefense());
	}
}