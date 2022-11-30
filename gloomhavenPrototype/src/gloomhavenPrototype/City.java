package gloomhavenPrototype;

public final class City {
	private static int prosperityLevel = 1;
	private static int prosperityProg = 0;
	private static int churchBank = 0; //Amount of money given to the church
	public static int getProsperityLevel() {
		return prosperityLevel;
	}
	public static int getProsperityXP() {
		return prosperityProg;
	}
	public static int getDonations() {
		return churchBank;
	}
	private static void giveProsperity() {
		prosperityProg++;
		if (prosperityProg == (4 + prosperityLevel - 1)) {
			prosperityLevel++;
			prosperityProg = 0;
		}
	}
	public static void donate(Player player) {
		if (player.getGold() < 50 || prosperityLevel == 4) {return;}
		player.takeGold(50);
		churchBank = churchBank + 50;
		
		if (churchBank >= 100) {
			giveProsperity();
			churchBank = 0;
		}
	}
}
