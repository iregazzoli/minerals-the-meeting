package mtm.tests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Ignore;
import org.junit.Test;

import junit.framework.Assert;
import mtm.Deck;
import mtm.DeckBuilder;
import mtm.Player;

public class DeckBuilderTest {
	
	@Test
	public void testOpenFileShouldReturnADeckIfBothPathFileAreCorrect(){
		DeckBuilder deckBuilder = new DeckBuilder();
		String decksPathFile = new File("resources/decks.yml").getAbsolutePath();
		String cardsPathFile = new File("resources/cards.yml").getAbsolutePath();
		
		
		
		assertEquals((deckBuilder.loadCards("player_1", cardsPathFile, decksPathFile)).getClass(), Deck.class);
	}


	@Test
	public void testOpenFileShouldReturnNullIfEitherPathFileIsInvalid(){
		DeckBuilder deckBuilder = new DeckBuilder();
		String invalidPath = "invalid\\path";
		String decksCorrectPathFile = new File("resources/decks.yml").getAbsolutePath();
		String cardsCorrectPathFile = new File("resources/cards.yml").getAbsolutePath();
		
		Assert.assertNull(deckBuilder.loadCards("player_0", invalidPath, decksCorrectPathFile));
		Assert.assertNull(deckBuilder.loadCards("player_0", cardsCorrectPathFile, invalidPath));
	}

}
