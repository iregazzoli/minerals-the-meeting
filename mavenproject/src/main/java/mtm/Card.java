package mtm;

public abstract class Card {
	String name;
	int gemCost;
	String gemColor;
	String effect;

	public Card(String name, int gemCost, String gemColor) {
		this.name = name;
		this.gemCost = gemCost;
		this.gemColor = gemColor; 
		this.effect = "none";
	}
	
	public Card(String name, int gemCost, String gemColor, String effect) {
		this.name = name;
		this.gemCost = gemCost;
		this.gemColor = gemColor; 
		this.effect = effect; 
	}
	
	abstract public String toString();
}
