package mtm.mavenproject;

public class Sorcery extends Card{

	public Sorcery(String name, int gemCost, String gemColor) {
		super(name, gemCost, gemColor);
		// TODO Auto-generated constructor stub
	}
	
	public Sorcery(String name, int gemCost, String gemColor, String effect) {
		super(name, gemCost, gemColor, effect);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Message() {
		Print print = new Print();
		print.out("Card, Name: " +  name + ", gemCosto: " + gemCost + ", gemColor: " + gemColor + " , ability: " + effect + ", type: Sorcery");
	}

}
