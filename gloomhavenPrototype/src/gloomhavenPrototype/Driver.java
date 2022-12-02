package gloomhavenPrototype;

import java.util.ArrayList;
import java.util.Scanner;

//For now just checks whether the Player can move around the hex grid map.
//Need to properly change player to a list, but for now like this for testing
public class Driver {
	public static void main(String[] args) {
		int turns = 2;
		int mapX = 6;
		int mapY = 6;
		Gridmap testMap[][] = new Gridmap[6][6];
		
		//sets the map with default parameters, in this case so far just false occupation.
		//There might be a better way of implementing this, but not sure.
		for(int i = 0; i < mapX; i++) {
			for(int j = 0; j < mapY; j++) {
				testMap[i][j] = new Gridmap();
			}
		}
		
		ArrayList<Player> players = new ArrayList<>();
		players.add(new Player ("John Test"));
		players.add(new Player ("Bob Test", 3, 5));
		
		//This lets the map know if the space is occupied at the map position
		for(int i = 0; i < players.size(); i++) {
			int x = players.get(i).getMapPosX();
			int y = players.get(i).getMapPosY();
			testMap[x][y].setOccupied(true);
		}
		
		//Menu list for which player is performing an action. 
		for(int i = 0; i < players.size(); i++) {
			System.out.println(players.get(i).getName() + "'s turn");
			
			for(int j = 0; j < players.get(i).getTurns(); j++) {
				System.out.println("What action would you like to perform?\n"
						+ "1: Move");
				System.out.println("Turn: " + (j+1) + "/" + players.get(i).getTurns());
				Scanner actionCommand = new Scanner(System.in);
				int command = actionCommand.nextInt();
				switch(command) {
				case 1:	System.out.println("Testing map movement\n");
						players.get(i).move(testMap);
						break;
				}
			}
		}
	}
}