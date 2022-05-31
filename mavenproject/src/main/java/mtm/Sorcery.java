package mtm;

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
	public String toString() {	
		return "Sorcery [name: " + name + ", gemCost: " + gemCost + ", gemColor: " + gemColor + ", effect: " + effect + "]";
	}

}
