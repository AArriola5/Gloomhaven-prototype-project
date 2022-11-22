package gloomhavenPrototype;

//For now just checks whether the Player can move around the hex grid map.
//Need to properly change player to a list, but for now like this for testing
public class Driver {
	public static void main(String[] args) {
		Gridmap testMap[][] = new Gridmap[6][6];
		Player player1 = new Player("Tutorial Man");
		
		System.out.println("Testing map movement");
		for(int i = 0; i < 5; i++) {
			player1.move(testMap);			
		}
	}
	
}
