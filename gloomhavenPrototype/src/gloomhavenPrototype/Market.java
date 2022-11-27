package gloomhavenPrototype;

import java.util.ArrayList;
import java.util.HashMap;


public final class Market {
	private static HashMap<String, Items> MarketData = new HashMap<>();
	public static ArrayList<Items>[] levels = new ArrayList[4]; //array of lists for each item level
	
	public Market() {
        for (int i = 0; i < 4; i++) {
        	levels[i] = new ArrayList<Items>();
        }
		MarketManifest();
	}
	
	//Helper function for adding an Item
	public static void addItem(Items toAdd) {
		MarketData.put(toAdd.getItemName(), toAdd);
		levels[toAdd.getItemLevel() - 1].add(toAdd);
	}
	
	public static void OnPurchase (Player player, Items toBuy) {
		//Money validations.
	}
	
	//Creates some items for the market.
	public static void MarketManifest(){
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
		    }
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
			}
		));
		
	}
	

}
