package mtm.tests;

import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import mtm.mavenproject.Player;

public class PlayerTest 
{
   
	@Test
	public void PlayerShouldStartWith20Hp() {
		Player player = new Player(0);
		assertEquals(player.getHp(), 20);	
  }
	
	@Test
	public void PlayerHpShouldBe18IfTaking2Hp() {
		Player player = new Player(0);
		player.takeDmg(2);
		assertEquals(player.getHp(), 18);	
  }
	@Test
	public void PlayerIdShouldBeTheNumberAssignToHim() {
		Player player = new Player(0);
		assertEquals(player.getId(), 0);	
  }
}

