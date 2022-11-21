package gloomhavenPrototype;

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
