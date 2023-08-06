package logic;

import java.util.ArrayList;

import role.base.Player;
import role.derived.Detective;
import role.derived.Mafia;
import role.derived.Mayor;

public class GameLogicUtility {

	public static void doNightAction(ArrayList<Player> targetPlayers) {
		for (int i = 0; i < targetPlayers.size(); i++) {
			Player player = GameLogic.getInstance().getPlayerList().get(i);
			if (player instanceof Detective) {
				((Detective) player).nightAction(targetPlayers.get(i));
			} else if (player instanceof Mafia) {
				((Mafia) player).nightAction(targetPlayers.get(i));
			}
		}
	}

	public static void doDayAction(ArrayList<Player> targetPlayers) {
		for (int i = 0; i < targetPlayers.size(); i++) {
			Player player = GameLogic.getInstance().getPlayerList().get(i);
			if (player instanceof Detective) {
				((Detective) player).dayAction(targetPlayers.get(i));
			} else if (player instanceof Mayor) {
				((Mayor) player).dayAction(targetPlayers.get(i));
			}
		}
	}
}
