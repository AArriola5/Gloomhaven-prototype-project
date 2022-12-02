package gloomhavenPrototype;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class CityTestCases {
	@Test
	public void TestCityRest() {
		Player testPly = new Player("Test guy");
		City.rest(testPly);
		assertFalse(testPly.getHealth() == 10);
	}

	@Test
	public void TestCityDonation() {
		Player testPly = new Player("Test guy");
		testPly.addGold(500);
		City.donate(testPly);
		assertFalse(City.getDonations() == 50);
	}
}
