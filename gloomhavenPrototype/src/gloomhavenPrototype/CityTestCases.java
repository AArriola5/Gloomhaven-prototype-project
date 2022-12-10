package gloomhavenPrototype;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class CityTestCases {
	@Test
	public void TestCityRest() {
		ArrayList<Player> party = new ArrayList<Player>();
		party.add(new Player("Test guy"));
		City.rest(party);
		assertTrue(party.get(0).getHealth() == 10);
	}

	@Test
	public void TestCityDonation() {
		Player testPly = new Player("Test guy");
		testPly.addGold(500);

		ArrayList<Player> party = new ArrayList<Player>();
		party.add(testPly);

		City.donate(party);
		assertTrue(City.getDonations() == 50);
	}
}
