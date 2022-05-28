package mtm.mavenproject;

public class Player {
	int hp;  


	public Player() {
		this.hp = 20;
	}
	
	public void takeDmg(int dmg) {
		this.hp -= dmg;
	}

	public int getHp() {
		return hp;
	}
}