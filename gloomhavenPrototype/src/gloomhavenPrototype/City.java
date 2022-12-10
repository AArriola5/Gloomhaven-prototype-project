package gloomhavenPrototype;

import java.util.ArrayList;

public final class City {
	private static int prosperityLevel = 1; //Posperity's max level is 4. This is for the sake of time.
	private static int prosperityProg = 0; //Progress counter
	private static int churchBank = 0; //Amount of money given to the church
	
	//Prosperity accessors
	public static int getProsperityLevel() {
		return prosperityLevel;
	}
	public static int getProsperityXP() {
		return prosperityProg;
	}
	public static int getDonations() {
		return churchBank;
	}
	//When the Player decides to rest
	public static void rest(ArrayList<Player> players) {
		for (Player ply : players) {
			ply.setHealth(Math.min(ply.getHealth() + 2, 10));
		}
	}
	
	//Helper function for giving a prosperity point to city
	private static void giveProsperity() {
		prosperityProg++;
		if (prosperityProg == (4 + prosperityLevel - 1)) {
			prosperityLevel++;
			prosperityProg = 0;
		}
	}
	//Player will donate 50 gold to the church 
	public static boolean donate(ArrayList<Player> players) {
		int sum = 0; //gets the sum of party's money
		for(Player ply : players) {
			sum += ply.getGold();
		}
		//check if the toal sum is less than 50 gold
		if (sum < 50 || prosperityLevel == 4) {return false;}
		int counter = 50;
		//Take money from each player til they have 50 gold
		for(Player ply : players) {
			if (counter == 0) {break;}
			int diff =(ply.getGold() - counter);
			if (diff < 0) {
				ply.takeGold(ply.getGold());
				counter -= ply.getGold();	
			}else {
				ply.takeGold(ply.getGold() - diff);
				counter -= ply.getGold() - diff;	
			}
		}
		
		churchBank = churchBank + 50;
		
		//Every 100 gold city gains a point
		if (churchBank >= 100) {
			giveProsperity();
			churchBank = churchBank - 100;
		}
		return true;
	}
}
