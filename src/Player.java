public class Player {
    String name;
    Deck drawDeck, storeDeck;

    /**
     * initializes 2 package and the name of the player as required
     * @param name: the name of the player
     */
    public Player(String name){
        this.name = name;
        drawDeck = new Deck(false);
        storeDeck = new Deck(false);
    }

    //public String getName() {return this.name};

    public void addCard(Card card, boolean playingDeck){
        if(playingDeck){
            drawDeck.addCard(card);
        }
        else{
            storeDeck.addCard(card);
        }
    }

    /**
     * draw a card
     * @return: the card we wand to draw
     */
    public Card drawCard() {return drawDeck.removeTopCard();}

    /**
     * check if the 2 pack is empty
     * @return : true if the 2 pack is empty, otherwise false
     */


    public boolean outOfCards(){
        return drawDeck.isEmpty() && storeDeck.isEmpty();
    }
    /**
     * return the name of the player
     * @return : the name of the player
     */
    public String toString() {return this.name;}

}