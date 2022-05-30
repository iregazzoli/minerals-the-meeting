package mtm.mavenproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.yaml.snakeyaml.Yaml;

public class DeckBuilder {
	Deck playerDeck = new Deck();
	
	public void loadCards(Player player) throws FileNotFoundException {
		
		InputStream inputStreamCards = new FileInputStream(new File("C:\\Users\\nacho\\git\\minerals-the-meeting\\mavenproject\\resources\\cards.yml"));
		Yaml yamlCards = new Yaml();
		Map<String, Object> cardsData = yamlCards.load(inputStreamCards);
		ArrayList<HashMap> cards = (ArrayList<HashMap>) cardsData.get("cards");
		
		InputStream inputStream = new FileInputStream(new File("C:\\Users\\nacho\\git\\minerals-the-meeting\\mavenproject\\resources\\decks.yml"));
		Yaml yaml = new Yaml();
		Map<String, Object> deckData = yaml.load(inputStream);
		
		int playerId = player.getId();
		String stringPlayerId = "player_" + playerId;
		
		ArrayList<HashMap> player_cards = (ArrayList<HashMap>) deckData.get(stringPlayerId);
		
//		System.out.println(player_cards);
//		System.out.println(cards);
		
		int cardAmount;
		int currentCardId;
		String currentCardName;
		int currentCardGemCost;
		String currentCardGemColor;
		String currentCardEffect;
		int currentCardHardness;
		int currentCardAtk;
		
		for(int i = 0; i < player_cards.size(); i++) {
			
			currentCardId = (int) player_cards.get(i).get("id");
			cardAmount = (int) player_cards.get(i).get("quantity");
			
			for(int k = 0; k < cards.size(); k++) {
				if((int) cards.get(k).get("id") == currentCardId) { //here is error
					currentCardName = (String) cards.get(k).get("name");
					currentCardGemCost = (int) cards.get(k).get("gem_cost");
					currentCardGemColor = (String) cards.get(k).get("gem_color");
					currentCardEffect = (String) cards.get(k).get("effect");
					currentCardHardness = (int) cards.get(k).get("hardness");
					currentCardAtk = (int) cards.get(k).get("atk");
				
					for(int j = 0; j < cardAmount; j++) {
						Card newCard = new Mineral(currentCardName, currentCardGemCost, currentCardGemColor, 
																				 currentCardEffect, currentCardHardness, currentCardAtk);
						playerDeck.addCard(newCard);
					}
				}
			}
		}
		
		player.setDeck(playerDeck);
	}
	
}
