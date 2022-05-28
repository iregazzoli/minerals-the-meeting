package mtm.mavenproject;

public abstract class Card {
	String name;
	int gemCost;
	String gemColor;
	String ability;

	public Card(String name, int gemCost, String gemColor) {
		this.name = name;
		this.gemCost = gemCost;
		this.gemColor = gemColor; 
	}
	
	public Card(String name, int gemCost, String gemColor, String ability) {
		this.name = name;
		this.gemCost = gemCost;
		this.gemColor = gemColor; 
		this.ability = ability; 
	}
	
	abstract public void Message();
}
