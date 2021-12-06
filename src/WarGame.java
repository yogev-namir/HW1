import java.util.Locale;

public class WarGame {
    Player player1,player2;
    Deck warDeck;

    public WarGame(String pOne,String pTwo){
        player1 = new Player(pOne);
        player2 = new Player(pTwo);
        warDeck = new Deck(false);
    }
    public void initializeGame(){
        Deck deck =new Deck(true);
        deck.shuffle();
        if( ((player1.toString()).compareTo(player2.toString()))>=0){
            while (deck[0] != null){
                player1.drawDeck.addCard(deck.removeTopCard());
            }
        }

    }

}
