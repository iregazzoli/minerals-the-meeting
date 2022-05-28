package mtm.mavenproject;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Game {
	DeckBuilder deckBuilder = new DeckBuilder();
	ArrayList<Card> Deck = new ArrayList<Card>();
	
	public void loadDecks() {
		try {
			deckBuilder.getCards();
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block, ask "Rome" if i Should do something here.
			e.printStackTrace();
		}
	}
}
