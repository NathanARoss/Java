/**
 * Test program for Card, Deck, and CardPlayer classes
 * Creates a deck, shuffles it, and draws 5 cards from it
 *
 * Written by Nathan Ross
 */

public class Question2 {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        CardPlayer player = new CardPlayer();

        //give the player 5 cards
        for (int i = 0; i < 5; ++i) {
            player.getCard(deck.deal());
        }

        player.showCards();
    }
}