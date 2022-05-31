package mtm;

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
	public static final String CARD_FILE = "C:\\Users\\nacho\\git\\minerals-the-meeting\\mavenproject\\resources\\cardss.yml";
	public static final String DECK_FILE = "C:\\Users\\nacho\\git\\minerals-the-meeting\\mavenproject\\resources\\decks.yml";
	
	private Map<String, Object> openFile(String path) throws FileNotFoundException {
		InputStream file = new FileInputStream(new File(path));
		Yaml yaml = new Yaml();
		Map<String, Object> fileData = yaml.load(file);
		return fileData;
	}
	
	private void setPlayerDecks(ArrayList<HashMap> cards, ArrayList<HashMap> player_cards, Player player) {
		int cardAmount, currentCardId, currentCardGemCost, currentCardHardness, currentCardAtk;
		String currentCardName, currentCardGemColor, currentCardEffect, currentCardType;
		Deck playerDeck = new Deck();

		for(int i = 0; i < player_cards.size(); i++) {
			currentCardId = (int) player_cards.get(i).get("id");
			cardAmount = (int) player_cards.get(i).get("quantity");
			
			for(int k = 0; k < cards.size(); k++) {
				if((int) cards.get(k).get("id") == currentCardId) { 
					currentCardName = (String) cards.get(k).get("name");
					currentCardGemCost = (int) cards.get(k).get("gem_cost");
					currentCardGemColor = (String) cards.get(k).get("gem_color");
					currentCardEffect = (String) cards.get(k).get("effect");
					currentCardType = (String) cards.get(k).get("type");
					
					if(currentCardType.equals("mineral")) {
						currentCardHardness = (int) cards.get(k).get("hardness");
						currentCardAtk = (int) cards.get(k).get("atk");
						
						for(int j = 0; j < cardAmount; j++) {
							Card newCard = new Mineral(currentCardName, currentCardGemCost, currentCardGemColor, 
																					 currentCardEffect, currentCardHardness, currentCardAtk);
							playerDeck.addCard(newCard);
						}
						
					}
						
					else if(currentCardType.equals("sorcery")) {
						for(int j = 0; j < cardAmount; j++) {
							Card newCard = new Sorcery(currentCardName, currentCardGemCost, currentCardGemColor, 
																					 currentCardEffect);
							playerDeck.addCard(newCard);
						}
					}
				}
			}
		}
		
		player.setDeck(playerDeck);
	}
	
	public boolean loadCards(Player player) {
		Map<String, Object> cardsData;
		try {
			cardsData = openFile(CARD_FILE);
			ArrayList<HashMap> cards = (ArrayList<HashMap>) cardsData.get("cards");
			Map<String, Object> deckData = openFile(DECK_FILE);
			
			int playerId = player.getId();
			String stringPlayerId = "player_" + playerId;
			
			ArrayList<HashMap> playerCards = (ArrayList<HashMap>) deckData.get(stringPlayerId);
			
			setPlayerDecks(cards, playerCards, player);
			return true;	
			
		} catch (FileNotFoundException e) {
			return false;
		}
	}
}
