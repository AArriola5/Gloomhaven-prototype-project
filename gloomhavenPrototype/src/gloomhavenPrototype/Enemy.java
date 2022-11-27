package gloomhavenPrototype;

import java.util.Scanner;

public class Enemy{
    String name = "";
    int level = 1;
    int health = 9;
    int mapPosX = 2;
    int mapPosY = 0;

    public Enemy(String name) {
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

	public void setEMapPosX(int newMapPosX) {
		this.mapPosX = newMapPosX;
	}
	public void setEMapPosY(int newMapPosY) {
		this.mapPosY = newMapPosY;
	}
}
/**
 * @param currentMap
 */
public void move(Gridmap currentMap[][]) {
	boolean madeMove = false;
	Scanner moveCommand = new Scanner(System.in);
	System.out.println("Current Enemy position: " + mapPosX + ", " + mapPosY);

	while(!madeMove) {
		int command = moveCommand.nextInt();
		switch(command) {
		case 1: //Moves Enemy Up Left 
			if(mapPosY % 2 == 0 && mapPosX > 0 && mapPosY > 0) {
				this.setEMapPosX(mapPosX -1);
				this.setEMapPosY(mapPosY -1);
				madeMove = true;
			} 
			else if (mapPosY > 0) {
				this.setEMapPosY(mapPosY - 1);
				madeMove = true;
			}
			System.out.println("Enemy moved to position: " + mapPosX + ", " + mapPosY);
			break;
		case 2: // Moves Enemy Up Right
			if(mapPosY % 2 == 0 && mapPosY > 0) {
				this.setEMapPosY(this.getMapPosY()-1);
				madeMove = true;
			}
			else if(mapPosY > 0 && mapPosX < currentMap.length-1) {
				this.setEMapPosY(this.getMapPosY()-1);
				this.setEMapPosX(this.getMapPosX()+1);
				madeMove = true;
			}
			System.out.println("Enemy moved to position: " + mapPosX + ", " + mapPosY);
			break;
		case 3: //Moves Enemy Left 
			if(mapPosX > 0) {
				this.setEMapPosX(this.getMapPosX()-1);
				madeMove = true;
			}
			System.out.println("Enemy moved to position: " + mapPosX + ", " + mapPosY);
			break;
		case 4: //Moves Enemy Right
			if(mapPosX < currentMap.length-1) {
				this.setEMapPosX(this.getMapPosX()+1);
				madeMove = true;
			}
			System.out.println("Enemy moved to position: " + mapPosX + ", " + mapPosY);
			break;
		case 5: //Moves Enemy Down Left
			if(mapPosY % 2 == 0 && mapPosX > 0 && mapPosY < currentMap[0].length-1) {
				this.setEMapPosX(this.getMapPosX()-1);
				this.setEMapPosY(this.getMapPosY()+1);
				madeMove = true;
			}
			else if(mapPosY < currentMap[0].length-1) {
				this.setEMapPosY(this.getMapPosY()+1);
				madeMove = true;
			}
			System.out.println("Enemy moved to position: " + mapPosX + ", " + mapPosY);
			break;
		case '6': //Moves Enemy Down Right
			if(mapPosY % 2 == 0 && mapPosY < currentMap[0].length-1) {
				this.setEMapPosY(this.getMapPosY()+1);
				madeMove = true;
			}
			else if(mapPosX < currentMap[0].length-1 && mapPosY < currentMap[0].length-1) {
				this.setEMapPosX(this.getMapPosX()+1);
				this.setEMapPosY(this.getMapPosY()+1);
				madeMove = true;
			}
			System.out.println("Enemy moved to position: " + mapPosX + ", " + mapPosY);
			break;
		}
	}
  }
}