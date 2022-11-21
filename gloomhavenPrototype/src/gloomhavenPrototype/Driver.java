package gloomhavenPrototype;

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
