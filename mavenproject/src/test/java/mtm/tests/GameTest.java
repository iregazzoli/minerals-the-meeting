package mtm.tests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import mtm.Game;

public class GameTest {

	@Test
	public void testLoadDecksShouldReturnTrueIfPassedValidFilePaths() {
		String cardsPathFile = new File("resources/cards.yml").getAbsolutePath();
		String decksPathFile = new File("resources/decks.yml").getAbsolutePath();
		Game game = new Game();

		assertEquals(game.loadDecks(cardsPathFile, decksPathFile), true);
	}

	@Test
	public void testLoadDecksShouldReturnFalseIfPassedInvalidFilePaths() {
		Game game = new Game();
		String cardsPathFile = new File("resources/cards.yml").getAbsolutePath();
		String decksPathFile = new File("resources/decks.yml").getAbsolutePath();
		String invalidPath = "invalid\\path";

		assertEquals(game.loadDecks(invalidPath, invalidPath), false);
		assertEquals(game.loadDecks(cardsPathFile, invalidPath), false);
		assertEquals(game.loadDecks(invalidPath, decksPathFile), false);
	}

}
