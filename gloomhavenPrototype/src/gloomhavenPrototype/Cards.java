package gloomhavenPrototype;

public class Cards {

    /*
    Attributes of a Card, keeping it simple for prototype
    purposes. Not providing initiative number.
    */
    String cardTitle;
    String cardDescription;
    int moveValue;
    int attackValue;

    /*
    Functions of a Card
    */
    // Constructor when creating a Card
    public Cards(String cardTitle, String cardDescription, int moveValue, int attackValue) {
        this.cardTitle = cardTitle;
        this.cardDescription = cardDescription;
        this.moveValue = moveValue;
        this.attackValue = attackValue;
    }

    // Returns attack value when called
    public int getAttackValue() {
        return attackValue;
    }

    // Returns move value when called
    public int getMoveValue() {
        return moveValue;
    }

    public void displayCard() {
        System.out.printf("[Card Details]\nTitle: %s\nDescription: %s\nMoves: %d\nAttack: %d\n",
        cardTitle, cardDescription, moveValue, attackValue);
    }
}