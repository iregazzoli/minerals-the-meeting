package mtm.mavenproject;

public class Player {
	int hp;
	int id;
	Deck deck;

	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	public void printDeck() {
		System.out.println("\n" + "Player " + id + " cards: ");
		deck.printCards();
	}

	public Player(int id) {
		this.hp = 20;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void takeDmg(int dmg) {
		this.hp -= dmg;
	}

	public int getHp() {
		return hp;
	}
}