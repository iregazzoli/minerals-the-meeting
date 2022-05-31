package mtm;

import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> cards = new ArrayList<Card>();;
	
	public void addCard(Card card) {
			cards.add(card);
	}
	
	public void printCards() {
		for(Card card : cards) 
			System.out.println(card.toString());
	}
}
