package mtm.mavenproject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Game {
	DeckBuilder deckBuilder = new DeckBuilder();
	
	Player player1 = new Player(1);
	Player player2 = new Player(2);
	
	public void loadDecks() {
		try {
			deckBuilder.loadCards(player1);
			deckBuilder.loadCards(player2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void playersCards() {
		player1.printDeck();
		player2.printDeck();
	}
}

