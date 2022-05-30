package mtm.mavenproject;

public abstract class Card {
	String name;
	int gemCost;
	String gemColor;
	String effect;

	public Card(String name, int gemCost, String gemColor) {
		this.name = name;
		this.gemCost = gemCost;
		this.gemColor = gemColor; 
	}
	
	public Card(String name, int gemCost, String gemColor, String effect) {
		this.name = name;
		this.gemCost = gemCost;
		this.gemColor = gemColor; 
		this.effect = effect; 
	}
	
	abstract public void Message();
}
