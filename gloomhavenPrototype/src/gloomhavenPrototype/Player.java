package gloomhavenPrototype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Player extends Entity{
	String name = "";
	int level = 1;
	int health = 10;
	int gold = 30;
	int inventorySize = 5;
	int turns = 2;
	Items[] inventory = new Items[inventorySize];
	HashMap<ItemEquipType, ArrayList<Items>> Equipment = new HashMap<ItemEquipType, ArrayList<Items>>();
	Deck deck = new Deck(); // player's deck to pull cards from

	int mapPosX = 2; //Position of player for hex grid.
	int mapPosY = 5;

	int move = 0; // attack values and movement values
	int attack = 0;
	
	//Constructor to build a player, could add more variables later. Just the name for now
	public Player(String name) {
		this.name = name;
	}

	public Player(String name, int x, int y) {
		this.name = name;
		this.mapPosX = x;
		this.mapPosY = y;
	}
	
	public String getName() {
		return this.name;
	}
	public int getLevel() {
		return this.level;
	}
	public int getHealth() {
		return this.health;
	}
	public int getMapPosX() {
		return this.mapPosX;
	}
	public int getMapPosY() {
		return this.mapPosY;
	}
	public int getTurns() {
		return this.turns;
	}
	public int getGold() {
		return this.gold;
	}
	public int getAttack() {
		return this.attack;
	}
	public int getMove() {
		return this.move;
	}
	public void setName(String newName) {
		this.name = newName;
	}
	public void setLevel(int newLevel) {
		this.level = newLevel;
	}
	public void setHealth(int newHealth) {
		this.health = newHealth;
	}
	public void setMapPosX(int newMapPosX) {
		this.mapPosX = newMapPosX;
	}
	public void setMapPosY(int newMapPosY) {
		this.mapPosY = newMapPosY;
	}
	public void setTurns(int newTurns) {
		this.turns = newTurns;
	}
	public void setAttack (int newAttack) {
		this.attack = newAttack;
	}
	public void setMove (int newMove) {
		this.move = newMove;
	}
	public void addGold(int amt) {
		if (amt <= 0) { return; }
		this.gold = this.gold + amt;
	}
	public void takeGold(int amt) {
		if (amt <= 0) { return; }
		this.gold = this.gold - amt;
	}
	//Finds the first empty index and adds item to it
	public void addToInventory(Items toAdd) {
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] == null) {
				inventory[i] = toAdd;
				return;
			}
		}
	}
	//Remove item from inventory
	public void removeFromInventory(Items toRemove) {
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i].getItemName() == toRemove.getItemName()) {
				inventory[i] = null;
				return;
			}
		}
	}
	//Method to print out user's inventory, not yet implemented
	public void showInventory() {
		for (int i = 0; i < inventorySize; i++) {
			System.out.println(inventory[i].toString());
		}
	}
	
	//Equip an item onto player item must not be a SMALL item.
	public void equipItem(Items toEquip) {
		ItemEquipType itemType = toEquip.getItemEquipType();
		if (itemType == ItemEquipType.SMALL) {return;}
		
		if (!Equipment.containsKey(itemType)) {
			//You can't equip a Two handed weapon if you have a One handed weapon equipped already.
			if (itemType == ItemEquipType.TWOHANDS && Equipment.containsKey(ItemEquipType.ONEHAND)){
				return;
			}
			//You can't equip a One handed weapon if you have a Two handed weapon equipped already.
			if (itemType == ItemEquipType.ONEHAND && Equipment.containsKey(ItemEquipType.TWOHANDS)){
				return;
			}
			
			if (Equipment.containsKey(itemType)){
				Equipment.get(itemType).add(toEquip);
			}
			removeFromInventory(toEquip);
			toEquip.Use(this);
		}
	}
	//Unequip and item from player.
	public void unequipItem(Items toUnequip) {
		ItemEquipType itemType = toUnequip.getItemEquipType();
		if (itemType == ItemEquipType.SMALL) {return;}
		Equipment.get(itemType).remove(toUnequip);
		addToInventory(toUnequip);
		toUnequip.Unuse(this); //call any unuse functions
	}

	//Method to move the player around the map, Need to implement whether the tile is occupied by another enemy or player.
	public void move(Gridmap currentMap[][]) {
		if (move == 0) {
			System.out.printf("Unable to move, out of moves\n");
		}

		// boolean madeMove = false; //Boolean to check whether the player made a move and get them out of the loop
		Scanner moveCommand = new Scanner(System.in);
		PlayerView.printPlayerLoc(mapPosX, mapPosY);
		PlayerView.printMovementChoices();
		
		for(; move > 0; move--) {
			int command = moveCommand.nextInt();
			switch(command) {
			case 1: //Moves Player Up Left / The mapPosY % 2 is to check whether the tile is even or odd to properly change tiles.
				if(mapPosY % 2 == 0 && mapPosX > 0 && mapPosY > 0) {
					this.setMapPosX(mapPosX -1);
					this.setMapPosY(mapPosY -1);
					// madeMove = true;
				} 
				else if (mapPosY > 0) {
					this.setMapPosY(mapPosY - 1);
					// madeMove = true;
				}
				else {
					PlayerView.printErrorMovement(mapPosX, mapPosY);
				}
				PlayerView.printPlayerNewLoc(mapPosX, mapPosY);
				break;
			case 2: // Moves player Up Right
				if(mapPosY % 2 == 0 && mapPosY > 0) {
					this.setMapPosY(this.getMapPosY()-1);
					// madeMove = true;
				}
				else if(mapPosY > 0 && mapPosX < currentMap.length-1) {
					this.setMapPosY(this.getMapPosY()-1);
					this.setMapPosX(this.getMapPosX()+1);
					// madeMove = true;
				}
				else {
					PlayerView.printErrorMovement(mapPosX, mapPosY);
				}
				PlayerView.printPlayerNewLoc(mapPosX, mapPosY);
				break;
			case 3: //Moves Player Left / Doesn't need even or odd check
				if(mapPosX > 0) {
					this.setMapPosX(this.getMapPosX()-1);
					// madeMove = true;
				}
				else {
					PlayerView.printErrorMovement(mapPosX, mapPosY);
				}
				PlayerView.printPlayerNewLoc(mapPosX, mapPosY);
				break;
			case 4: //Moves Player Right
				if(mapPosX < currentMap.length-1) {
					this.setMapPosX(this.getMapPosX()+1);
					// madeMove = true;
				}
				else {
					PlayerView.printErrorMovement(mapPosX, mapPosY);
				}
				PlayerView.printPlayerNewLoc(mapPosX, mapPosY);
				break;
			case 5: //Moves Player Down Left
				if(mapPosY % 2 == 0 && mapPosX > 0 && mapPosY < currentMap[0].length-1) {
					this.setMapPosX(this.getMapPosX()-1);
					this.setMapPosY(this.getMapPosY()+1);
					// madeMove = true;
				}
				else if(mapPosY < currentMap[0].length-1) {
					this.setMapPosY(this.getMapPosY()+1);
					// madeMove = true;
				}
				else {
					PlayerView.printErrorMovement(mapPosX, mapPosY);
				}
				PlayerView.printPlayerNewLoc(mapPosX, mapPosY);
				break;
			case 6: //Moves Player Down Right
				if(mapPosY % 2 == 0 && mapPosY < currentMap[0].length-1) {
					this.setMapPosY(this.getMapPosY()+1);
					// madeMove = true;
				}
				else if(mapPosX < currentMap[0].length-1 && mapPosY < currentMap[0].length-1) {
					this.setMapPosX(this.getMapPosX()+1);
					this.setMapPosY(this.getMapPosY()+1);
					// madeMove = true;
				}
				else {
					PlayerView.printErrorMovement(mapPosX, mapPosY);
				}
				PlayerView.printPlayerNewLoc(mapPosX, mapPosY);
				break;
			}
		}
	}

	public void drawPhase() {
		deck.drawCards();
		attack = deck.getDrawnAttack();
		move = deck.getDrawnMove();
	}
}

