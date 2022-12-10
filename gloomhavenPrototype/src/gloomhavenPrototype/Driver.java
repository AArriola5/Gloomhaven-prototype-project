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
		Market.Init(); //Initialize the Market
		MarketView mkv = new MarketView();
		CityView cv = new CityView();
		

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
		

		System.out.println("Would you like to go to battle or to the city?\n" + "1: Battle\n" + "2: Visit City");
		Scanner activityCmd = new Scanner(System.in);
		int activity = activityCmd.nextInt();
		//If player decides to go to city first
		if (activity == 2) {
			cv.printWelcome(players); //print welcome message
			int CityAct = activityCmd.nextInt();
			//Branch to choice
			switch(CityAct) {
			//Player chooses to rest party healing 2hp
			case 1:	cv.printRest();
					City.rest(players);
					break;
			//Decides to go to the market
			case 2:	mkv.printMarketChoices();
					char buyOrSell = activityCmd.next().charAt(0);
					//player chooses to buy
					if (buyOrSell == 'b') {
						//Print the market items and choices
						mkv.printItemsForSale();
						mkv.printMarketBuyChoices();
						int index = activityCmd.nextInt() - 1;
						//if the index is out of bounds print message
						if (index < 0 || index > Market.getItemsForSale().size()) {
							mkv.printErrorInput(index + 1);
						}else {
							Items itemBought = Market.getItemsForSale().get(index);
							//returns true if the purchase was successful and player had enough money
							boolean success = Market.Purchase(players.get(0), Market.getItemsForSale().get(index));
							if (!success) {mkv.printNotEnoughMoney(Market.getItemsForSale().get(index)); break;}
							mkv.printMarketBuy(itemBought);// print buy message
						}
					}else {
						//Player choose to sell from inventory
						mkv.printMarketSellChoices(players.get(0).inventory, 5);
						int index = activityCmd.nextInt();
						if (players.get(0).inventory[index] == null ) {
							mkv.printErrorInput(index);
						}else {
							Items savedItem = players.get(0).inventory[index];
							Market.Sell(players.get(0), players.get(0).inventory[index]);
							mkv.printMarketSell(savedItem);
						}
					}
					break;
			//Decides to donate to the church
			case 3:	cv.printDonation();
					char yesOrNo = activityCmd.next().charAt(0);
					if (yesOrNo == 'n') {break;}
					boolean success = City.donate(players);
					
					if (!success) {cv.printDonationNotEnough();}
					break;
			}
		}
		activityCmd.close();

		System.out.println("Heading to battlefield.");
		//This lets the map know if the space is occupied at the map position
		for(int i = 0; i < players.size(); i++) {
			int x = players.get(i).getMapPosX();
			int y = players.get(i).getMapPosY();
			testMap[x][y].setOccupied(true);
		}
		
		//Menu list for which player is performing an action. 
		for(int i = 0; i < players.size(); i++) {
			System.out.println(players.get(i).getName() + "'s turn");
			players.get(i).drawPhase(); // Player will draw cards before doing anything
			
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