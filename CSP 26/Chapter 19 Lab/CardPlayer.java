/**
 * Class is responsible for holding a player's cards
 *
 * Written by Nathan Ross
 */

import java.util.ArrayList;
import java.util.List;

public class CardPlayer {
    List<Card> hand;

    public CardPlayer() {
        hand = new ArrayList<>(5);
    }

    public void getCard(Card card) {
        hand.add(card);
    }

    public void showCards() {
        System.out.println("player's hand:");
        for (Card card : hand) {
            System.out.printf("%s%n", card);
        }
        System.out.println();
    }
}
