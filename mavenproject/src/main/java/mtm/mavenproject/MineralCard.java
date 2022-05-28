package mtm.mavenproject;

public class MineralCard extends Card {
	
	int hardness;
	int atk;
	
	public MineralCard(String name, int gemCost, String gemColor, int hardness, int atk) {
		super(name, gemCost, gemColor);
		this.hardness = hardness;
		this.atk = atk;
	}
	
	public MineralCard(String name, int gemCost, String gemColor, String description, int hardness, int atk) {
		super(name, gemCost, gemColor, description);
		this.hardness = hardness;
		this.atk = atk;
	}

	@Override
	public void Message() {
		Print print = new Print();
		print.out("Card, Name: " +  name + ", gemCosto: " + gemCost + ", gemColor: " + gemColor + " , ability: " + ability 
															+ ", hardness: " + hardness + ", atk: "+ atk);
		
	}
	
}
