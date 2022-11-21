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
	
	public void showInventory() {
		for (int i = 0; i < inventorySize; i++) {
			System.out.println(inventory[i].toString());
		}
	}
	public void move(Gridmap currentMap[][]) {
		boolean madeMove = false;
		Scanner moveCommand = new Scanner(System.in);
		System.out.println("Current position: " + mapPosX + ", " + mapPosY);
		System.out.println("Where do you want to move?" + '\n' + 
				"1: Up Left" + '\n' +
				"2: Up Right" + '\n' +
				"3: Left" + '\n' +
				"4: Right" + '\n' +
				"5: Down Left" + '\n' +
				"6: Down Right");
		int command = moveCommand.nextInt();
		
		while(!madeMove) {
			switch(command) {
			case 1:
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
			case 2:
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
			case 3:
				if(mapPosX > 0) {
					this.setMapPosX(this.getMapPosX()-1);
					madeMove = true;
				}
				System.out.println("moved to position: " + mapPosX + ", " + mapPosY);
				break;
			case 4:
				if(mapPosX < currentMap.length-1) {
					this.setMapPosX(this.getMapPosX()+1);
					madeMove = true;
				}
				System.out.println("moved to position: " + mapPosX + ", " + mapPosY);
				break;
			case 5:
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
			case '6':
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

