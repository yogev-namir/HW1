public class WarGame {
    public Player player1, player2;
    public Deck warDeck;

    /**
     * initializes an empty deck(main\war deck) and two players as required
     * @param pOne first player's name
     * @param pTwo second player's name
     */
    public WarGame(String pOne, String pTwo) {
        player1 = new Player(pOne);
        player2 = new Player(pTwo);
        warDeck = new Deck(false);
    }
    /**
     * shuffles the primal(pre-game) deck and deals the cards among the player's
     * drawingDeck by their name's alphabetic order
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
     * checks which player supposed to be the first to play\draw
     according to alphabetic order
     @return negative number for player1, negative o.w
     */
    public int alphabetOrder() {
        return (this.player1.toString()).compareTo(this.player2.toString());
    }

    /**
     *checks if the drawing deck is empty and if so it shuffles the storeDeck
     and adds it to the drawing deck (the cards are in the same order as they
     are after the shuffle)
     @param player the player that is being checked
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
     * checks which player if out of cards
     *@return the other player's name(the winner)
     */
    public String finalWinner() {
        if(player1.outOfCards())
            return player2.toString();
        else
            return player1.toString();
    }

    /**
     * runs the game according to the laws of "war game", until one player is
     * out of cards
     * @return winner's name
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

    /**
     * runs the game according to the laws of "war game"
     * @param first first player by alphabetic order
     * @param second second player by alphabetic order
     * @param isInWar true if it is in recursive method(war/multiple wars)
     */
    public void gameplay(Player first, Player second, boolean isInWar){
        int winner;
        isDrawDeckEmpty(first);
        isDrawDeckEmpty(second);


        if(!first.outOfCards() && !second.outOfCards()) {
            Card firstHand = first.drawCard(), secondHand = second.drawCard();

            warDeck.addCard(firstHand);
            System.out.println(first.getName()+ " drew " +firstHand.toString());

            warDeck.addCard(secondHand);
            System.out.println(second.getName()+ " drew " +secondHand.toString());

            winner = firstHand.compare(secondHand);

            if (winner > 0) {
                while(!warDeck.isEmpty())
                    first.addCard(warDeck.removeTopCard(),false);
                if(isInWar)
                    System.out.println(first.getName() + " won the war");
                else
                    System.out.println(first.getName() + " won");

            }
            else if(winner < 0) {
                while(!warDeck.isEmpty()) {
                    second.addCard(warDeck.removeTopCard(),false);
                }
                if (isInWar)
                    System.out.println(second.getName() + " won the war");
                else
                    System.out.println(second.getName() + " won");
            }
            else {
                System.out.println("Starting a war...");
                war(first, second);
            }
        }
    }

    /**
     * each player adds a card to the warDeck and announces it, repeated twice
     * than starts a recursive war
     * @param first first player by alphabetic order
     * @param second second player by alphabetic order
     */
    public void war(Player first, Player second){
        int rounds = 2;
        while (rounds-- >0 &&(!first.outOfCards() && !second.outOfCards())) {
            isDrawDeckEmpty(first);
            warDeck.addCard(first.drawCard());
            System.out.println(first.getName() + " drew a war card");
            isDrawDeckEmpty(second);
            warDeck.addCard(second.drawCard());
            System.out.println(second.getName() + " drew a war card");
        }
        gameplay(first,second,true);
    }

}