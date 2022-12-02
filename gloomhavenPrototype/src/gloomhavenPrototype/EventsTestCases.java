package gloomhavenPrototype;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EventsTestCases {
	@Test
	public void TestEventsCall() {
		//Increments the health by 1 every time its called
		Events.Add("TestEventsCall", "UniqueID", (Entity[] ent) -> {
			Player ply = (Player)ent[0];
			ply.setHealth(ply.getHealth() + 1);
		});
		
		
		Player testPly = new Player("Test guy");
		//Increment their HP by 1. three times
		for (int i = 0; i < 3; i++) {
			Events.Call("TestEventsCall", new Entity[] {testPly});
		}
		
		assertTrue(testPly.getHealth() == 13);
	}

	@Test
	public void TestEventsRemove() {
		//Increments the health by 1 every time its called
		Events.Add("TestEventsRemove", "UniqueID", (Entity[] ent) -> {
			Player ply = (Player)ent[0];
			//Remove this callback after 3 calls
			if (ply.getHealth() == 13) {
				Events.Remove("TestEventsRemove", "UniqueID");
				return;
			}
			ply.setHealth(ply.getHealth() + 1);
		});
		
		
		Player testPly = new Player("Test guy");
		//Try to increment their HP by 1. twenty times
		for (int i = 0; i < 20; i++) {
			Events.Call("TestEventsRemove", new Entity[] {testPly});
		}

		assertTrue(testPly.getHealth() == 13);
	}
}
