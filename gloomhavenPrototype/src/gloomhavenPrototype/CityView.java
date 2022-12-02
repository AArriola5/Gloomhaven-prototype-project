package gloomhavenPrototype;

public class CityView {
	public static void printWelcome(Player player) {
		System.out.println("Welcome to Gloomhaven" + '\n' +
				"You have " + player.getGold() + " Gold to spend!" + '\n' +
				"What would you like to do: " + '\n' +
				"1: Rest" + '\n' +
				"2: Shop" + '\n' +
				"3: Donate"
				);
	}
	
	public static void printDonation() {
		System.out.println("Would you like to donate 50 Gold to the church (y/n)?");
	}
	public static void printDonationNotEnough() {
		System.out.println("You don't have enough Gold for the donation?");
	}
	public static void printRest() {
		System.out.println("You have healed 2 HP and recovered your spent items.");
	}
}
