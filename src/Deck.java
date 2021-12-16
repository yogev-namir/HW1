public class Deck {

    Card[] deck;
    private static final int cardAmount = 52;
    private static final int suitAmount = 13;

    /**
     * initializes the deck as required
     * @param set: determine whether to initialize the deck
     *           false will create an empty deck
     *           true will initialize the deck by value and type
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
     *
     * @return top-card's index, -1 if the deck is empty
     */
    public int topCard(){
        int i;
        for( i=this.deck.length-1;i>=0; i--)
            if(this.deck[i]!=null)
                return i;
        return i;
    }

    /**
     * gets a card and stack it on-top of the current top-card
     * @param card: the required card to be added in to the deck
     */
    public void addCard(Card card) {
        if(this.isEmpty())
            this.deck[0]=card;

        else if((this.topCard()!=this.deck.length-1))
            this.deck[topCard()+1] = card;
    }

    /**
     * remove the current top-card of the deck
     * returns null if the deck is empty
     * @return the removed card
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
     * checks if the deck is empty
     * @return true if the pack is empty, otherwise false
     */
    public boolean isEmpty() {
        return deck[0] == null;
    }

    /**
     * shuffle the deck's cards
     * gets the new permutation from pre-determined(Main) seed
     */
    public void shuffle() {
        int next;
            for (int i = 0; i <topCard()+1; i++) {
                next = Main.rnd.nextInt(topCard()+1);
                Card rndCard = deck[i];
                deck[i] = deck[next];
                deck[next] = rndCard;
            }
        }
    /**
     * initialize each card in the deck to Null
     */
    public void clearDeck(){
        for(int i = this.topCard(); i>=0; i--){
            this.deck[i]=null;
        }
    }
}