package gloomhavenPrototype;

import java.util.Scanner;

public class Player {
	String name = "";
	int level = 1;
	int health = 10;
	int inventorySize = 5;
	Items[] inventory = new Items[inventorySize];
	int mapPosX = 2; //Position of player for hex grid.
	int mapPosY = 5;
	
	//Constructor to build a player, could add more variables later. Just the name for now
	public Player(String name) {
		this.name = name;
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
	
	//Method to print out user's inventory, not yet implemented
	public void showInventory() {
		for (int i = 0; i < inventorySize; i++) {
			System.out.println(inventory[i].toString());
		}
	}
	//Method to move the player around the map, Need to implement whether the tile is occupied by another enemy or player.
	public void move(Gridmap currentMap[][]) {
		boolean madeMove = false; //Boolean to check whether the player made a move and get them out of the loop
		Scanner moveCommand = new Scanner(System.in);
		System.out.println("Current position: " + mapPosX + ", " + mapPosY);
		System.out.println("Where do you want to move?" + '\n' + 
				"1: Up Left" + '\n' +
				"2: Up Right" + '\n' +
				"3: Left" + '\n' +
				"4: Right" + '\n' +
				"5: Down Left" + '\n' +
				"6: Down Right");
		
		while(!madeMove) {
			int command = moveCommand.nextInt();
			switch(command) {
			case 1: //Moves Player Up Left / The mapPosY % 2 is to check whether the tile is even or odd to properly change tiles.
				if(mapPosY % 2 == 0 && mapPosX > 0 && mapPosY > 0) {
					this.setMapPosX(mapPosX -1);
					this.setMapPosY(mapPosY -1);
					madeMove = true;
				} 
				else if (mapPosY > 0) {
					this.setMapPosY(mapPosY - 1);
					madeMove = true;
				}
				System.out.println("moved to position: " + mapPosX + ", " + mapPosY);
				break;
			case 2: // Moves player Up Right
				if(mapPosY % 2 == 0 && mapPosY > 0) {
					this.setMapPosY(this.getMapPosY()-1);
					madeMove = true;
				}
				else if(mapPosY > 0 && mapPosX < currentMap.length-1) {
					this.setMapPosY(this.getMapPosY()-1);
					this.setMapPosX(this.getMapPosX()+1);
					madeMove = true;
				}
				System.out.println("moved to position: " + mapPosX + ", " + mapPosY);
				break;
			case 3: //Moves Player Left / Doesn't need even or odd check
				if(mapPosX > 0) {
					this.setMapPosX(this.getMapPosX()-1);
					madeMove = true;
				}
				System.out.println("moved to position: " + mapPosX + ", " + mapPosY);
				break;
			case 4: //Moves Player Right
				if(mapPosX < currentMap.length-1) {
					this.setMapPosX(this.getMapPosX()+1);
					madeMove = true;
				}
				System.out.println("moved to position: " + mapPosX + ", " + mapPosY);
				break;
			case 5: //Moves Player Down Left
				if(mapPosY % 2 == 0 && mapPosX > 0 && mapPosY < currentMap[0].length-1) {
					this.setMapPosX(this.getMapPosX()-1);
					this.setMapPosY(this.getMapPosY()+1);
					madeMove = true;
				}
				else if(mapPosY < currentMap[0].length-1) {
					this.setMapPosY(this.getMapPosY()+1);
					madeMove = true;
				}
				System.out.println("moved to position: " + mapPosX + ", " + mapPosY);
				break;
			case '6': //Moves Player Down Right
				if(mapPosY % 2 == 0 && mapPosY < currentMap[0].length-1) {
					this.setMapPosY(this.getMapPosY()+1);
					madeMove = true;
				}
				else if(mapPosX < currentMap[0].length-1 && mapPosY < currentMap[0].length-1) {
					this.setMapPosX(this.getMapPosX()+1);
					this.setMapPosY(this.getMapPosY()+1);
					madeMove = true;
				}
				System.out.println("moved to position: " + mapPosX + ", " + mapPosY);
				break;
			}
		}
	}
}

