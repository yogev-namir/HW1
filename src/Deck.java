import java.util.Random;

public class Deck {

    Card[] deck;
    private static final int cardAmount =52;
    private static final int suitAmount=13;
    /**
     * initializes the package as required
     * @param set: tells us whether to initialize the Pack
     */
    public Deck(boolean set) {
        deck = new Card[cardAmount];
        if (set)
            for (Suit type : Suit.values())
                for (int val = 1; val <= Card.cardValue.length; val++)
                    deck[(type.showType() * suitAmount) - 1 + val] =
                            new Card(type, val);
    }
    /**
     * Provide the index of the top card in the deck
     *
     */
    public int topCard(){
        int i;
        for( i=this.deck.length-1;i>=0; i--)
            if(this.deck[i]!=null)
                return i;
        return i;
    }
    /**
     * get a card, and adds it as the top card in the pack
     * @param card: the card required to be added to the pack
     */
    public void addCard(Card card) {

        if(this.isEmpty())
            this.deck[0]=card;

        else if((this.topCard()!=this.deck.length-1))
            this.deck[topCard()+1] = card;



    }
    /**
     * remove the card that found at the top of the deck
     * @return : the card that removed from the deck
     */
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
    /**
     * check if the pack is empty
     * @return : true if the pack is empty, otherwise false
     */
    public boolean isEmpty() {
        return deck[0] == null;
    }

/*
    int a = ar[index];
    ar[index] = ar[i];
    ar[i] = a;
*/
    /**
     * shuffle the pack- change the location of all the cards in the deck
     */

    public void shuffle() {
        int next;
       // int current;
                for (int i = 0; i <topCard()+1; i++) {
                    next = Main.rnd.nextInt(topCard()+1);
                   // current= Main.rnd.nextInt(topCard()+1);
                   // if(deck[next]!=null && deck[i]!=null) {
                        Card rndCard = deck[i];
                        deck[i] = deck[next];
                        deck[next] = rndCard;

                   // }
                }
           // }
        }

    public void clearDeck(){
        for(int i = topCard(); i<=0; i--){
            this.deck[i]=null;
        }

    }
}