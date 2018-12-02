/**
 * Class is responsible for creating 52 cards, shuffling them, and dealing them
 *
 * Written by Nathan Ross
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>(52);

        for (int suit = 0; suit < 4; ++suit) {
            for (int face = 0; face < 13; ++face) {
                cards.add(new Card(suit, face));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card deal() {
        return cards.remove(cards.size() - 1);
    }
}