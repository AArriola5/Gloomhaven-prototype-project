package gloomhavenPrototype;


public final class City {
	private static int prosperityLevel = 1; //Posperity's max level is 4. This is for the sake of time.
	private static int prosperityProg = 0;
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
	
	//Helper function for giving a prosperity point to city
	private static void giveProsperity() {
		prosperityProg++;
		if (prosperityProg == (4 + prosperityLevel - 1)) {
			prosperityLevel++;
			prosperityProg = 0;
		}
	}
	//Player will donate 50 gold to the church 
	public static void donate(Player player) {
		if (player.getGold() < 50 || prosperityLevel == 4) {return;}
		player.takeGold(50);
		churchBank = churchBank + 50;
		
		//Every 100 gold city gains a point
		if (churchBank >= 100) {
			giveProsperity();
			churchBank = churchBank - 100;
		}
	}
}
