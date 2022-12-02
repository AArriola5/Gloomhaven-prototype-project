package gloomhavenPrototype;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Testcases {

	@Test
	public void TestPlayerGetName() {
		String name = "GetName";
		Player player = new Player(name);
		assertEquals(player.getName(), name);
	}
	
	@Test
	public void TestPlayerSetName() {
		String name = "SetName";
		Player player = new Player("");
		player.setName(name);
		assertEquals(name, player.getName());
		
	}
	
	@Test
	public void TestPlayerGetHealth() {
		int health = 10;
		Player player = new Player("");
		assertEquals(player.getHealth(), health);
	}
	
	@Test
	public void TestPlayerSetHealth() {
		int health = 50;
		Player player = new Player("");
		player.setHealth(health);
		assertEquals(health, player.getHealth());
	}
	
	@Test
	public void TestPlayerGetMapPosX() {
		int x = 0;
		Player player = new Player("", 0, 0);
		assertEquals(player.getMapPosX(), x);
	}
	
	@Test
	public void TestPlayerSetMapPosX() {
		int x = 10;
		Player player = new Player("", 0, 0);
		player.setMapPosX(x);
		assertEquals(x, player.getMapPosX());
	}
	
	@Test
	public void TestPlayerGetMapPosY() {
		int y = 0;
		Player player = new Player("", 0, 0);
		assertEquals(player.getMapPosX(), y);
	}
	
	@Test
	public void TestPlayerSetMapPosY() {
		int y = 10;
		Player player = new Player("", 0, 0);
		player.setMapPosX(y);
		assertEquals(y, player.getMapPosX());
	}
	
	@Test
	public void TestPlayerGetTurns() {
		int turns = 2;
		Player player = new Player("");
		assertEquals(player.getTurns(), turns);
	}
	
	@Test
	public void TestPlayerSetTurns() {
		int turns = 50;
		Player player = new Player("");
		player.setTurns(turns);
		assertEquals(turns, player.getTurns());
	}
}
