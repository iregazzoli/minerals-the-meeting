package mtm;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Game {
	DeckBuilder deckBuilder = new DeckBuilder();
	
	Player player1 = new Player(1);
	Player player2 = new Player(2);
	
	public boolean loadDecks() {
		
		boolean player1LoadDeckResult;
		boolean player2LoadDeckResult;
		
		player1LoadDeckResult = deckBuilder.loadCards(player1);
		player2LoadDeckResult = deckBuilder.loadCards(player2);
		
		if(player1LoadDeckResult == false || player2LoadDeckResult == false)
			return false;
		
		return true;
	}

	public void playersCards() {
		player1.printDeck();
		player2.printDeck();
	}
}

