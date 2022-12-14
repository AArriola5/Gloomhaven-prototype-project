package gloomhavenPrototype;

import java.util.ArrayList;
import java.util.HashMap;


public final class Market {
	private static HashMap<String, Items> MarketData = new HashMap<>();
	public static ArrayList<Items>[] levels =  (ArrayList<Items>[]) new ArrayList[4]; //array of lists for each item level
	private static boolean initStarted = false;
	//Initialization function called when a game starts
	public static void Init() {
		if (initStarted) { return; }
	    for (int i = 0; i < 4; i++) {
	    	levels[i] = new ArrayList<Items>();
	    }
		MarketManifest();
		initStarted = true;
	}
	
	//Helper function for adding an Item
	public static void addItem(Items toAdd) {
		MarketData.put(toAdd.getItemName(), toAdd);
		levels[toAdd.getItemLevel() - 1].add(toAdd);
	}
	//Helper for removing item
	private static void removeItem(Items toRemove) {
		for (int i = 0; i < levels[toRemove.getItemLevel() - 1].size(); i++ ) {
			Items curItem = levels[toRemove.getItemLevel() - 1].get(i);
			if (curItem.getItemName() == toRemove.getItemName()) {
				levels[toRemove.getItemLevel() - 1].remove(i);
			}
		}
	}
	
	public static boolean Purchase(Player player, Items toBuy) {
		//Money validations.
		if (player.getGold() < toBuy.getPrice()) { return false; }
		player.addToInventory(toBuy);
		removeItem(toBuy);
		return true;
	}
	
	public static void Sell(Player player, Items toSell) {
		player.removeFromInventory(toSell);
		player.addGold(toSell.getPrice() / 2);
		addItem(toSell);
	}

	public static ArrayList<Items> getItemsForSale() {
		ArrayList<Items> ret = new ArrayList<Items>();
		for (int i = 0; i < City.getProsperityLevel(); i++ ) {
			for (Items item : levels[i]) {
				ret.add(item);
			}
		}
		return ret;
	}
	
	//Creates some items for the market.
	private static void MarketManifest(){
		addItem(new Items(
			"Minor Healing Potion", //name
			"During your turn you can heal 3 damage.", // description
			10, // price
			1, // item level
			ItemUseType.SINGLE,
			ItemEquipType.SMALL,
			//Called then item is used. 'player' is the one who used the item
			(Items thisItem, Player player) -> {
				player.setHealth(player.getHealth() + 3);
		    },
			//Called when the Item is unused/sold/consumed
			(Items thisItem, Player player) -> {}
		));
		
		addItem(new Items(
			"Heater Shield", //name
			"When damaged by an attack, gain Shield +1 for the attack.", // description
			20, // price
			1, // item level
			ItemUseType.REUSABLE,
			ItemEquipType.ONEHAND,
			//Called then item is used. 'player' is the one who used the item
			(Items thisItem, Player player) -> {
				Events.Add("OnPlayerDamage", "HeaterShieldDamage", (Entity[] ents) -> {
					thisItem.itemUseCount++;
					if (thisItem.itemUseCount >= 3) {
						Events.Remove("OnPlayerDamage", "HeaterShieldDamage");
						return;
					}
					Entity dmgInfo = ents[1];
					if (dmgInfo == null) { return; }
					player.setHealth(player.getHealth() + 3);
			    });
			},
			//Called when the Item is unused/sold/consumed
			(Items thisItem, Player player) -> {
				Events.Remove("OnPlayerDamage", "HeaterShieldDamage");
			}
		));
		
	}
	

}
