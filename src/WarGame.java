public class WarGame {
    public Player player1, player2;
    public Deck warDeck;
    // private int round = 1;

    /**
     * initializes a package and 2 name of the players as required
     * @param pOne: the name of the first player
     * @param pTwo: the name of the second player
     */
    public WarGame(String pOne, String pTwo) {
        player1 = new Player(pOne);
        player2 = new Player(pTwo);
        warDeck = new Deck(false);
    }
    /**
     * initializes the game, shuffle the deck and deal the cards among the players
     */
    public void initializeGame() {
        Deck deck = new Deck(true);
        deck.shuffle();
        if (alphabetOrder() <= 0) {
            while (deck.deck[0] != null) {
                player1.addCard(deck.removeTopCard(),true);
                player2.addCard(deck.removeTopCard(),true);
            }
        } else {
            while (deck.deck[0] != null) {
                player2.addCard(deck.removeTopCard(),true);
                player1.addCard(deck.removeTopCard(),true);
            }

        }
    }
    /**
     * checking which player supposed to be the first ti play 
     according to alphabetic order
     */
    public int alphabetOrder() {
        return (this.player1.toString()).compareTo(this.player2.toString());
    }
    /**
     *checking if the drawing deck is empty and if so ,it shuffles the storeDeck 
     and add it to the drawing one.
     */
    public void isDrawDeckEmpty(Player player) {
        if (player.drawDeck.isEmpty()) {
            player.storeDeck.shuffle();
            int topCard= player.storeDeck.topCard();
            for(int i=0; i<=topCard; i++)
                player.addCard(player.storeDeck.deck[i],true);
            player.storeDeck.clearDeck();
        }
    }
    /**
     * the scenario of the war itself
     * @param first: the  first player
     * @param second: the  second player
     */
    public void warHand(Player player) {
            isDrawDeckEmpty(player);
            warDeck.addCard(player.drawCard());
            System.out.println(player.toString() + " drew a war card");
    }

    /**
     *adding the card to warDeck and print it
     */
    public void printHand(Player player, Card card) {

        System.out.println(player.toString() + " drew " + card.toString());


    }
    /**
     *announcing the winner of each round
     */
    public void announceWinner(Player player) {
        System.out.println(player.toString() + " won");
    }
    /**
     *returns the name od=f final winner of the game
     */
    public String finalWinner()
    {
        if(player1.outOfCards())
            return player2.toString();
        else
            return player1.toString();

    }
    /**
     * runs the game according to the laws of "war game"
     * @return: the name of the winner in the game
     */
    public String start() {
        int round=1;
        System.out.println("Initializing the game...");
        initializeGame();
        while (!player1.outOfCards() && !player2.outOfCards()) {
            System.out.println("------------------------- Round number " +
                    "" + (round++) + " -------------------------");

            if (alphabetOrder() <= 0)
                gameplay(player1, player2, false);
            else
                gameplay(player2, player1, false);
        }

        return finalWinner();
    }




    public void gameplay(Player first, Player second, boolean isInWar){
        int winner;
        isDrawDeckEmpty(first);
        isDrawDeckEmpty(second);


        if(!first.outOfCards() && !second.outOfCards()) {
            Card firstHand = first.drawCard(), secondHand = second.drawCard();
            warDeck.addCard(firstHand);
          //  first.addCard(firstHand,true);
            printHand(first, firstHand);
            warDeck.addCard(secondHand);
           // second.addCard(firstHand,true);
            printHand(second, secondHand);
            winner = firstHand.compare(secondHand);

            if (winner > 0) {
                while (!warDeck.isEmpty()) {
                  //  Card card = warDeck.removeTopCard();
                    first.addCard(warDeck.removeTopCard(),false);
                    //first.storeDeck.addCard(warDeck.removeTopCard());
                }
                if (isInWar)
                    System.out.println(first.toString() + " won the war");
                else
                    announceWinner(first);


            } else if (winner < 0) {
                while (!warDeck.isEmpty()) {
                   // Card card = warDeck.removeTopCard();
                    second.addCard(warDeck.removeTopCard(),false);
                    //second.storeDeck.addCard(warDeck.removeTopCard());
                }
                if (isInWar)
                    System.out.println(second.toString() + " won the war");
                else
                    announceWinner(second);


            } else {
                System.out.println("Starting a war...");
                war(first, second);
            }
        }
    }

    /**
     * calls to the function that runs the war scenario
     *
     */
    public void war(Player first, Player second){
        int rounds = 2;
        while (rounds-- >0 &&(!first.outOfCards() && !second.outOfCards())) {
            warHand(first);
            warHand(second);
        }
        gameplay(first,second,true);
    }

}