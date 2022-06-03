package mtm.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import mtm.Mineral;

public class MineralTest {

	@Test
	public void testMineralCorrectCreation() {
		Mineral newMineral = new Mineral("testName", 5, "testColor", "testEffect", 10, 10);
		assertEquals(newMineral.toString(), "Mineral [name: testName, gemCost: 5, gemColor: testColor, "
									+ "effect: testEffect, hardness: 10, atk: 10]");	
	}
	
	@Test
	public void testMineralWithNoSetEffectShouldHaveNoneAsEffect() {
		Mineral newMineral = new Mineral("testName", 5, "testColor", 10, 10);
		assertEquals(newMineral.toString(), "Mineral [name: testName, gemCost: 5, gemColor: testColor, "
									+ "effect: none, hardness: 10, atk: 10]");	
	}

}
