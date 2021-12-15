public class Player {
    String name;
    Deck drawDeck, storeDeck;

    /**
     * initializes two empty decks and the name of the player as required
     * @param name: the name of the player
     */

    public Player(String name){
        this.name = name;
        drawDeck = new Deck(false);
        storeDeck = new Deck(false);
    }
    /**
     * @return player's name
     */
    public String getName(){
        return this.name;
    }

    /**
     * true adds the card into playingDeck, to the top of the deck
     * false adds the card into the winningDeck, to the top of the deck
     * @param card: the desired card to be added
     * @param playingDeck: true -> playingDeck, false -> winningDeck
     */
    public void addCard(Card card, boolean playingDeck){
        if(playingDeck){
            drawDeck.addCard(card);
        }
        else{
            storeDeck.addCard(card);
        }
    }

    /**
     * @return the deck's top-card
     */
    public Card drawCard() {
        return drawDeck.removeTopCard();
    }

    /**
     * checks if the player is out of card in both decks
     * @return true if both deck are empty
     */
    public boolean outOfCards(){
        return drawDeck.isEmpty() && storeDeck.isEmpty();
    }

    /**
     * @return the name of the player
     */
    public String toString() {
        return getName();
    }
}