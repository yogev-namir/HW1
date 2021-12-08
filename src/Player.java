public class Player {
    String name;
    Deck drawDeck, storeDeck;

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
    public Card drawCard() {return drawDeck.removeTopCard();}

    public boolean outOfCards(){
        return drawDeck.isEmpty() && storeDeck.isEmpty();
    }
    public String toString() {return this.name;}

}
