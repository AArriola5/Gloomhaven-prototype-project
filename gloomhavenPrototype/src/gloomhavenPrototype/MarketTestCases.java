package gloomhavenPrototype;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class MarketTestCases {
	//Test Item for Unit Test
	Items toAdd = new Items(
			"Test Item", //name
			"This is just a test.", // description
			10, // price
			1, // item level
			ItemUseType.SINGLE,
			ItemEquipType.SMALL,
			//Called then item is used. 'player' is the one who used the item
			(Items thisItem, Player player) -> {},
			//Called when the Item is unused/sold/consumed
			(Items thisItem, Player player) -> {}
	);

	@Test
	public void TestMarketAddItems() {
		Market.Init();
		Market.addItem(toAdd);
		ArrayList<Items> data = Market.getItemsForSale();
		
		assertEquals(data.get(0).compareTo(toAdd), 0);
	}
	@Test
	public void TestMarketSell() {
		Market.Init();
		Player testPly = new Player("Test guy");
		testPly.addToInventory(toAdd);
		Market.Sell(testPly, toAdd);

		ArrayList<Items> data = Market.getItemsForSale();
		assertEquals(data.get(data.size()).compareTo(toAdd), 0);
	}
	
	@Test
	public void TestMarketBuy() {
		Market.Init();
		Player testPly = new Player("Test guy");

		Items itemtoBuy = Market.getItemsForSale().get(0);
		Market.Purchase(testPly, itemtoBuy);
		
		assertFalse(Market.getItemsForSale().contains(itemtoBuy));
	}
	
}