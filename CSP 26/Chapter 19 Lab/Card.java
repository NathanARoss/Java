/**
 * Class is responsible for storing class suit and face, and displaying it
 *
 * Written by Nathan Ross
 */

public class Card {
    final static String[] SUITS = {
            "Hearts",
            "Diamonds",
            "Spades",
            "Clubs"
    };

    final static String[] FACES = {
            "Ace",
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack",
            "Queen",
            "King"
    };

    private int suit, face;

    public Card(int suit, int face) {
        this.suit = suit;
        this.face = face;
    }

    @Override
    public String toString() {
        return String.format("%s of %s", FACES[face], SUITS[suit]);
    }
}
