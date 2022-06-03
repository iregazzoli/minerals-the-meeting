package mtm;

public class Mineral extends Card {
	
	int hardness;
	int atk;
	
	public Mineral(String name, int gemCost, String gemColor, int hardness, int atk) {
		super(name, gemCost, gemColor);
		this.hardness = hardness;
		this.atk = atk;
		
	}
	
	public Mineral(String name, int gemCost, String gemColor, String effect, int hardness, int atk) {
		super(name, gemCost, gemColor, effect);
		this.hardness = hardness;
		this.atk = atk;
	}

	@Override
	public String toString() {
		return "Mineral [name: " + name + ", gemCost: " + gemCost + ", gemColor: " + gemColor + ", effect: " + effect
						+ ", hardness: " + hardness + ", atk: " + atk + "]";
	}
	
	
}
