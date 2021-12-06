import java.util.Random;

public class Deck {

    Card[] deck;
    private int counterAdd = 0, counterRemove = 0;

    public Deck(boolean set) {
        deck = new Card[52];
        if (set)
            for (Suit type : Suit.values())
                for (int val = 1; val <= Card.cardValue.length; val++)
                    deck[(type.showType() * 13) - 1 + val] = new Card(type, val);
    }

    public void addCard(Card card) {
        deck[counterAdd++] = card;
    }

    public Card removeTopCard() {
        int current = deck.length - (counterRemove++);
        Card topCard = new Card(deck[current - 1].getType(),
                deck[current - 1].getValue());
        deck[current - 1] = null;
        return topCard;
    }

    boolean isEmpty() {
        if (deck[0] != null)
            return false;
        return true;
    }

    public void shuffle() {
        Random ran = new Random();
        for (Card card : deck) {
            if (card != null) {
                int next = ran.nextInt(52);
                Card rndCard = card;
                deck[next] = card;
                card = rndCard;
            }
        }
        /*for (int i = 0; i < deck.length - 1; i++) {
            if (deck[i] != null) {
                int nxt = ran.nextInt(52);
                Card rndCard=deck[nxt];
                deck[nxt]=deck[i];
                deck[i] = rndCard;
            }
        }*/
    }
}