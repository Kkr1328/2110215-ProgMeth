package test.student;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import card.cards.BasicCharacterCard;
import card.cards.MainCharacterCard;
import player.Player;

public class TestMainCharacter {

	Player player;
	MainCharacterCard testMainChar;

	@Before
	public void setUp() {
		player = new Player("testPlayer", 300, 50, 30);
		testMainChar = new MainCharacterCard("Test Main Character", "test maincharacter", 250, 100, 80, 0.2f);
	}

	@Test
	public void testConstructor() {

		assertEquals("Test Main Character [level 0]", testMainChar.getName());
		assertEquals("test maincharacter", testMainChar.getDescription());
		assertEquals(0, testMainChar.getLevel());
	}

	// Fill Code Here!!!
	// 1.testSwitchCharacter
	// 2.testSacrifice
	@Test
	public void testSwitchCharacter() {
		testMainChar.switchCharacter(player);
		assertEquals(250, player.getMaxLifePoint());
		assertEquals(100, player.getAttack());
		assertEquals(80, player.getDefense());
	}

	@Test
	public void testSacrifice() {
		player.setCurrentLifePoint(200);
		testMainChar.sacrifice(player);
		assertEquals(237, player.getCurrentLifePoint());
	}

	@Test
	public void testLevelUp() {
		testMainChar.switchCharacter(player);
		assertEquals("Test Main Character [level 0]", testMainChar.getName());
		testMainChar.levelUp(player);
		assertEquals("Test Main Character [level 1]", testMainChar.getName());
		assertEquals(300, player.getMaxLifePoint());
		assertEquals(120, player.getAttack());
		assertEquals(96, player.getDefense());
		// Fill Code Here!!!
		// Add Level 2 case
		testMainChar.levelUp(player);
		assertEquals("Test Main Character [level 2]", testMainChar.getName());
		assertEquals(360, player.getMaxLifePoint());
		assertEquals(144, player.getAttack());
		assertEquals(115, player.getDefense());
	}

}