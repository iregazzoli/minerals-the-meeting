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
	private Map<String, Object> openFile(String path) throws FileNotFoundException {
		InputStream file = new FileInputStream(new File(path));
		Yaml yaml = new Yaml();
		return yaml.load(file);
	}

	private Deck setPlayerDecks(ArrayList<HashMap> cards, ArrayList<HashMap> player_cards) {
		int cardAmount, currentCardId, currentCardGemCost, currentCardHardness, currentCardAtk;
		String currentCardName, currentCardGemColor, currentCardEffect, currentCardType;
		Deck playerDeck = new Deck();

		for (int i = 0; i < player_cards.size(); i++) {
			currentCardId = (int) player_cards.get(i).get("id");
			cardAmount = (int) player_cards.get(i).get("quantity");

			for (int k = 0; k < cards.size(); k++) {
				if ((int) cards.get(k).get("id") == currentCardId) {
					currentCardName = (String) cards.get(k).get("name");
					currentCardGemCost = (int) cards.get(k).get("gem_cost");
					currentCardGemColor = (String) cards.get(k).get("gem_color");
					currentCardEffect = (String) cards.get(k).get("effect");
					currentCardType = (String) cards.get(k).get("type");

					if (currentCardType.equals("mineral")) {
						currentCardHardness = (int) cards.get(k).get("hardness");
						currentCardAtk = (int) cards.get(k).get("atk");

						for (int j = 0; j < cardAmount; j++) {
							Card newCard = new Mineral(currentCardName, currentCardGemCost, currentCardGemColor, currentCardEffect,
									currentCardHardness, currentCardAtk);
							playerDeck.addCard(newCard);
						}

					}

					else if (currentCardType.equals("sorcery")) {
						for (int j = 0; j < cardAmount; j++) {
							Card newCard = new Sorcery(currentCardName, currentCardGemCost, currentCardGemColor, currentCardEffect);
							playerDeck.addCard(newCard);
						}
					}
				}
			}
		}

		return playerDeck;
	}

	public Deck loadCards(String stringPlayerId, String cardFile, String deckFile) {
		Map<String, Object> cardsData;
		Map<String, Object> deckData;

		try {
			cardsData = openFile(cardFile);
			deckData = openFile(deckFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}

		ArrayList<HashMap> cards = (ArrayList<HashMap>) cardsData.get("cards");
		ArrayList<HashMap> playerCards = (ArrayList<HashMap>) deckData.get(stringPlayerId);

		return setPlayerDecks(cards, playerCards);
	}
}
