package mtm;

public class Player {
	int hp;
	int id;
	Deck deck;

	public void setDeck(Deck deck) throws DeckNullException {
		if (deck == null)
			throw new DeckNullException("You can't set a null deck to a player");
		else
			this.deck = deck;
	}

	public Player(int id) {
		this.hp = 20;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String idToString() {
		return "player_" + id;
	}

	public void takeDmg(int dmg) {
		this.hp -= dmg;
	}

	public int getHp() {
		return hp;
	}
}
