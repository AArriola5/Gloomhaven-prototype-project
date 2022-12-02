package gloomhavenPrototype;
import java.util.ArrayList;
import java.util.Scanner;

public class Deck {
    /*
    Attributes of a Deck
    */
    ArrayList<Cards> deck = new ArrayList<>();
    ArrayList<Cards> drawn = new ArrayList<>();
    int drawnAttackValue;
    int drawnMoveValue;

    /*
    Functions of a Deck
    */
    // Constructor of deck
    public Deck() {
        // Hard code the cards into the deck
        deck.add(new Cards("ability 1", "desc", 1, 5));
        deck.add(new Cards("ability 2", "desc", 2, 7));
        deck.add(new Cards("ability 3", "desc", 4, 4));
        deck.add(new Cards("ability 4", "desc", 3, 6));
        deck.add(new Cards("ability 5", "desc", 5, 3));
        deck.add(new Cards("ability 6", "desc", 1, 12));
        deck.add(new Cards("ability 7", "desc", 0, 15));
        deck.add(new Cards("ability 8", "desc", 6, 3));
        deck.add(new Cards("ability 9", "desc", 7, 10));
        // Initialize drawn card values to 0
        drawnAttackValue = 0;
        drawnMoveValue = 0;
    }

    // Displays the whole deck
    private void displayDeck() {
        // Loop through the deck ArrayList and display info of the Cards in it
        // Include Card's index
        for (int index = 0; index < deck.size(); index++) {
            System.out.printf("[%d] - ", index);
            deck.get(index).displayCard();
            System.out.printf("----------\n");
        }
    }

    // Displays the whole drawn deck
    private void displayDrawn() {
        // Loop through the drawn ArrayList and display info of the Cards in it
        // Include Card's index
        for (int index = 0; index < drawn.size(); index++) {
            System.out.printf("You've drawn these cards:\n");
            System.out.printf("[%d] - ", index);
            drawn.get(index).displayCard();
            System.out.printf("----------\n");
        }
    }

    // Returns the drawn attack value
    public int getDrawnAttack() {
        return drawnAttackValue;
    }

    // Returns the drawn move value
    public int getDrawnMove() {
        return drawnMoveValue;
    }

    /*
    Steps on player turn
    1. Draw two cards
    2. Choose which cards to use for attack and move
    */
    public void playerTurn() {
        Scanner inputScanner = new Scanner(System.in);

        // 1. Draw two cards
        // Choose first card
        displayDeck();
        System.out.printf("Choose a card (0-8): ");
        int firstCardIndex = inputScanner.nextInt();
        drawn.add(0, deck.get(firstCardIndex));

        // Choose second card
        displayDeck();
        System.out.printf("Choose another card (0-8): ");
        int secondCardIndex = inputScanner.nextInt();
        drawn.add(1, deck.get(secondCardIndex));

        // 2. Choose which cards to use for attack and move
        // Get attack value
        displayDrawn();
        System.out.printf("Choose a card to use for attack (0-1): ");
        int attackCardIndex = inputScanner.nextInt();
        drawnAttackValue = drawn.get(attackCardIndex).getAttackValue();

        // Get movement value
        // Since already chose attack, automatically choose other card for move value
        drawn.remove(attackCardIndex);   // Can remove the attack card frrom the drawn list to get move value card easier
        drawnMoveValue = drawn.get(0).getMoveValue(); // Move card will automatically be 0 due to removing attack card
        System.out.printf("The other card has been automatically chosen for movement\n");
    }
}