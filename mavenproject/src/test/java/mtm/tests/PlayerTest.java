package mtm.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import mtm.DeckNullException;
import mtm.Player;

public class PlayerTest {
	
	@Test
	public void testSetDeckShouldThrowDeckNullExceptionIfGivenANullDeck() {
		Player player = new Player(0);
		assertThrows(DeckNullException.class, () -> {player.setDeck(null);}, "You can't set a null deck to a player");
	}

	@Test
	public void testPlayerShouldStartWith20Hp() {
		Player player = new Player(0);
		assertEquals(player.getHp(), 20);
	}

	@Test
	public void testPlayerHpShouldBe18IfTaking2Hp() {
		Player player = new Player(0);
		player.takeDmg(2);
		assertEquals(player.getHp(), 18);
	}

	@Test
	public void testPlayerIdShouldBeTheNumberAssignToHim() {
		Player player = new Player(0);
		assertEquals(player.getId(), 0);
	}
}
