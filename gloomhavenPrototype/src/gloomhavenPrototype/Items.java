package gloomhavenPrototype;

//Need to add more variables, such as if the item is a weapon or not.
//Want Player to be able to purchase items from a merchant or pick up on the map
enum ItemUseType {
    REUSABLE,
    SINGLE,
    UNLIMITED
}

enum ItemEquipType {
    HEAD,
    BODY,
    LEGS,
    ONEHAND,
    TWOHANDS,
    SMALL
}

interface OnUseCallBack {
    void call(Items item,Player player);
}

public class Items implements Comparable<Items>{
	String itemName, itemDescription;
	int itemPrice, itemLevel;
	ItemUseType useType;
	ItemEquipType equipType;
	OnUseCallBack itemOnUse; //lambda for when the player uses the item
	OnUseCallBack itemOnUnuse; //lambda for when the player unuses the item. Unequips/sells/consumes it
	int itemUseCount = 0;
	//Constructor for creating an item
	public Items (String name, String desc, int price, int level, ItemUseType use, ItemEquipType equip, OnUseCallBack callback1, OnUseCallBack callback2){
		itemName = name;
		itemDescription = desc;
		itemPrice = price;
		useType = use;
		itemLevel = level;
		equipType = equip;
		itemOnUse = callback1;
		itemOnUnuse = callback2;
	}

	public String getItemName() {
		return itemName;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public int getPrice() {
		return itemPrice;
	}

	//Get the level of the item
	public int getItemLevel() {
		return itemLevel;
	}

	public ItemEquipType getItemEquipType() {
		return equipType;
	}
	public void setItemName(String newName) {
		itemName = newName;
	}
	public void setItemDescription(String newItemDescription) {
		itemDescription = newItemDescription;
	}
	
	//Setters for Price, UseType, & Level
	public void setItemPrice(int newPrice) {
		itemPrice = newPrice;
	}
	public void setItemUseType(ItemUseType newUse) {
		useType = newUse;
	}
	public void setItemLevel(int level) {
		itemLevel = level;
	}
	
	public void onUse(OnUseCallBack e) {
		itemOnUse = e;
	}

	public void onUnuse(OnUseCallBack e) {
		itemOnUnuse = e;
	}
	//Function calls the objects lambda expression itemOnUse & passes the Player who used it as paramater.
	public void Use(Player player) {
		itemOnUse.call(this, player);
	}
	public void Unuse(Player player) {
		itemOnUnuse.call(this, player);
	}
	@Override
	public String toString() {
		return itemName + ": " + itemDescription;
	}
	
	@Override
	public int compareTo(Items otherItem) {
		if (this.itemName == otherItem.getItemName() && this.itemDescription == otherItem.getItemDescription()) {
			return 0;
		}
	  return 1;
	}
}
