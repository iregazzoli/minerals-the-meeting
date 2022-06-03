package mtm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Game game = new Game();

		String cardsPathFile = new File("resources/cards.yml").getAbsolutePath();
		String decksPathFile = new File("resources/decks.yml").getAbsolutePath();

		if (game.loadDecks(cardsPathFile, decksPathFile)) {
			// rest of the game.
		}

		else {
			System.out.println(
					"There was an error loading the decks, check if the path of the files containing the data are correct"
							+ ", ending Program.");
		}
	}
}
