import java.util.Locale;

public class WarGame {
    public Player player1,player2;
    public Deck warDeck;
    private int round = 1;


    public WarGame(String pOne,String pTwo){
        player1 = new Player(pOne);
        player2 = new Player(pTwo);
        warDeck = new Deck(false);
    }
    public void initializeGame(){
        Deck deck =new Deck(true);
        deck.shuffle();
        if( alphabetOrder() >= 0){
            while (deck.deck[0] != null){
                player1.drawDeck.addCard(deck.removeTopCard());
                player2.drawDeck.addCard(deck.removeTopCard());
            }
        }
    }
    public int alphabetOrder(){
        return (this.player1.toString()).compareTo(this.player2.toString());
    }
    public String start(){

        System.out.print("Initializing the game...");
        initializeGame();
        while(!player1.outOfCards() && !player2.outOfCards()){
            System.out.println("------------------------- Round number " +
                    "" + (round++) + " -------------------------");
            isDrawDeckEmpty(player1);
            isDrawDeckEmpty(player2);
            if(alphabetOrder() >= 0)
                gameplay(player1,player2,false);
            else
                gameplay(player2, player1,false);
        }
        if(player1.outOfCards())
            return player1.toString();
        else
            return player2.toString();
    }
    public void isDrawDeckEmpty(Player player){
        if(player.drawDeck.isEmpty()){
            player.storeDeck.shuffle();
            while(!player.storeDeck.isEmpty())
                player.addCard(player.storeDeck.removeTopCard(), true);
        }
    }
    public String gameplay(Player first, Player second, boolean isInWar){
        int winner;
        Card firstHand = first.drawCard(), secondHand = second.drawCard();

        printHand(first,firstHand);
        printHand(second,secondHand);
        winner = firstHand.compare(secondHand);

        if(winner>0){
            if(isInWar)
                System.out.println(first.toString()+"wan the war");
            else
                announceWinner(first);
            while(!warDeck.isEmpty())
                first.addCard(warDeck.removeTopCard(), false);
            return first.toString();
        }
        else if(winner<0){
            if(isInWar)
                System.out.println(second.toString()+"wan the war");
            else
                announceWinner(second);
            while(!warDeck.isEmpty())
                second.addCard(warDeck.removeTopCard(), false);
            return first.toString();
        }
        else
            return war(first, second);
    }
    public void printHand(Player player, Card card){
        System.out.println(player.toString() + " drew" + card.toString());
        warDeck.addCard(card);
    }
    public void announceWinner(Player player){
        System.out.println(player.toString() + " won");
    }
    public void warHand(Player first, Player second){
        int rounds=2;
        while(round-->0) {
            warDeck.addCard(first.drawCard());
            System.out.println(first.toString()+" drew a war card");
            warDeck.addCard(second.drawCard());
            System.out.println(second.toString()+" drew a war card");
        }
    }
    public String war(Player first, Player second){
        warHand(first,second);
        return gameplay(first,second,true);
    }

}
