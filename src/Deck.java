import java.util.Random;

public class Deck {

    Card[] deck;
    private static final int cardAmount =52;
    private static final int suitAmount=13;

    public Deck(boolean set) {
        deck = new Card[cardAmount];
        if (set)
            for (Suit type : Suit.values())
                for (int val = 1; val <= Card.cardValue.length; val++)
                    deck[(type.showType() * suitAmount) - 1 + val] =
                            new Card(type, val);
    }

    public int topCard(){
        for(int i=deck.length-1; i>=0; i--)
            if(deck[i]!=null)
                return i;
        return 0;
    }
    public void addCard(Card card) {
        deck[topCard()] = card;
    }
    public Card removeTopCard() {
        Card topCard = new Card(deck[topCard()].getType(),
                deck[topCard()].getValue());
        deck[topCard()] = null;
        return topCard;
    }

    boolean isEmpty() {
        return deck[0] != null;
    }

    public void shuffle() {
        Random rnd = new Random();
        for (Card card : deck) {
            if (card != null) {
                int next = rnd.nextInt(cardAmount);
                Card rndCard = card;
                deck[next] = card;
                card = rndCard;
            }
        }
    }
}
