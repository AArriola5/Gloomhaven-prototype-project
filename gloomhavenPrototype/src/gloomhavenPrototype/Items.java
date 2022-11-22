package gloomhavenPrototype;

//Need to add more variables, such as if the item is a weapon or not.
//Want Player to be able to purchase items from a merchant or pick up on the map
public class Items {
	String itemName, itemDescription;
	
	public String getItemName() {
		return itemName;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemName(String newName) {
		itemName = newName;
	}
	public void setItemDescription(String newItemDescription) {
		itemDescription = newItemDescription;
	}
	
	@Override
	public String toString() {
		return itemName + ": " + itemDescription;
	}
}
