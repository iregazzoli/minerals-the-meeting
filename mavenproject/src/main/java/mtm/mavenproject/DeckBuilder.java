package mtm.mavenproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DeckBuilder {
	public ArrayList<Card> getCards() throws FileNotFoundException {
		ArrayList<Card> cards = new ArrayList<Card>();
		File f = new File("D:\\Eclipse\\workspace\\cards.txt");
		Scanner scan = new Scanner(f);
		
		String name;
		int gemCost;
		String gemColor;
		String description;
		int atk;
		int defense;
		
		while(scan.hasNextLine()) {
			name = scan.next();
			gemCost = Integer.parseInt(scan.next());
			gemColor = scan.next();
			description = scan.next();
			atk = Integer.parseInt(scan.next());
			defense = Integer.parseInt(scan.next());
			
			MineralCard newMineral = new MineralCard(name, gemCost, gemColor, description, atk, defense);
			newMineral.Message();
			
			cards.add(newMineral);
		}
		
		scan.close();
		return cards;
	}
}
