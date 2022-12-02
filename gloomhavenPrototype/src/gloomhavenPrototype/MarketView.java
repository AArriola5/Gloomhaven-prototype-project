package gloomhavenPrototype;

import java.util.ArrayList;

public class MarketView {
	public static void printItemsForSale() {
		System.out.println("Following Item For Sale:");
		
		ArrayList<Items> marketData = Market.getItemsForSale();
        for (int j = 0; j < marketData.size(); j++) {
        	int index = j + 1;
            System.out.println(index + ": "+ marketData.get(j));
        }
	}

	public static void printErrorInput(int s) {
		System.out.println("Item at " + s + " doesn't exist");
	}

	public static void printNotEnoughMoney(Items itm) {
		System.out.println("You do not have enough gold for " + itm.getItemName());
	}

	public static void printMarketChoices() {
		System.out.println("Do you want to buy or sell (b/s)?"
				+ "\n");
	}

	public static void printMarketBuyChoices() {
		System.out.println("Select an Item to buy (based on number)?"
				+ "\n");
	}

	public static void printMarketSellChoices(Items inv[], int invSize) {
		System.out.println("Select an Item to sell (based on number)?");
		for (int i = 0; i < invSize; i++) {
			System.out.println(i + ": " + inv[i].toString());
		}
	}

	public static void printMarketSell(Items itmSold) {
		System.out.println("You sold " + itmSold.getItemName() + " for " + (itmSold.getPrice() / 2) + " gold!");
	}
	public static void printMarketBuy(Items itmBought) {
		System.out.println("You bought " + itmBought.getItemName() + " for " + itmBought.getPrice() + " gold!");
	}
}
