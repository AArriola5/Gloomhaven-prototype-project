package gloomhavenPrototype;

public class PlayerView {
	public static void printPlayerLoc(int x, int y) {
		System.out.println("Current position: " + x + ", " + y);
	}
	public static void printPlayerNewLoc(int x, int y) {
		System.out.println("moved to position: " + x + ", " + y);
	}
	public static void printErrorMovement(int x, int y) {
		System.out.println("Position: " + x + ", " + y + " is not available");
	}
	public static void printMovementChoices() {
		System.out.println("Where do you want to move?" + '\n' + 
				"1: Up Left" + '\n' +
				"2: Up Right" + '\n' +
				"3: Left" + '\n' +
				"4: Right" + '\n' +
				"5: Down Left" + '\n' +
				"6: Down Right");
	}
	public static void printPlayerInventory(Items inv[], int invSize) {
		for (int i = 0; i < invSize; i++) {
			System.out.println(inv[i].toString());
		}
	}
}
