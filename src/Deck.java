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
        int i;
        for( i=this.deck.length-1;i>=0; i--)
            if(this.deck[i]!=null)
                return i;
        return i;
    }
    public void addCard(Card card) {

        if(isEmpty())
            this.deck[0]=card;

        if((topCard()!=this.deck.length-1))
            this.deck[topCard()+1] = card;



    }
    public Card removeTopCard() {
        if(topCard()>=0) {
            Card topCard;
            topCard = new Card(deck[topCard()].getType(),
                    deck[topCard()].getValue());
            deck[topCard()] = null;
            return topCard;
        }

else
    return null;

    }

   public boolean isEmpty() {
        return deck[0] == null;
    }

/*
    int a = ar[index];
    ar[index] = ar[i];
    ar[i] = a;

*/



    public void shuffle() {
        Random rnd = new Random();
        for (int i=0;i<deck.length;i++) {
            if (deck[i] != null) {
                int next = rnd.nextInt(cardAmount);
                Card rndCard =deck[i];
                deck[i] =deck[next];
                deck[next] = rndCard;
            }
        }
    }
}
