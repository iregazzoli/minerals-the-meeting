package mtm.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import mtm.Sorcery;

public class SorceryTest {

	@Test
	public void testSorceryCorrectCreation() {
		Sorcery newSorcery = new Sorcery("testName", 5, "testColor", "testEffect");
		assertEquals(newSorcery.toString(), "Sorcery [name: testName, gemCost: 5, gemColor: testColor, effect: testEffect]");	
	}
	
	@Test
	public void testSorceryWithNoSetEffectShouldHaveNoneAsEffect() {
		Sorcery newSorcery = new Sorcery("testName", 5, "testColor");
		assertEquals(newSorcery.toString(), "Sorcery [name: testName, gemCost: 5, gemColor: testColor, effect: none]");	
	}

}
