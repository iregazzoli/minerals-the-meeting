package mtm;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Game {
	DeckBuilder deckBuilder = new DeckBuilder();
	
	Player player1 = new Player(1);
	Player player2 = new Player(2);
	
	public boolean loadDecks(String cardFile, String deckFile) {
		boolean successLoading = true;
		
		try {
			player1.setDeck(deckBuilder.loadCards(player1.idToString(), cardFile, deckFile));
			player2.setDeck(deckBuilder.loadCards(player2.idToString(), cardFile, deckFile));
		} catch (DeckNullException e) {
			successLoading = false;
			e.printStackTrace();
		}
		
		return successLoading;	
	}
}
