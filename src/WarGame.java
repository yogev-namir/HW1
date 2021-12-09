

public class WarGame {
    public Player player1, player2;
    public Deck warDeck;
   // private int round = 1;


    public WarGame(String pOne, String pTwo) {
        player1 = new Player(pOne);
        player2 = new Player(pTwo);
        warDeck = new Deck(false);
    }

    public void initializeGame() {
        Deck deck = new Deck(true);
        deck.shuffle();
        if (alphabetOrder() <= 0) {
            while (deck.deck[0] != null) {
                player1.drawDeck.addCard(deck.removeTopCard());
                player2.drawDeck.addCard(deck.removeTopCard());
            }
        } else {
            while (deck.deck[0] != null) {
                player2.drawDeck.addCard(deck.removeTopCard());
                player1.drawDeck.addCard(deck.removeTopCard());

            }

        }
    }

    public int alphabetOrder() {
        return (this.player1.toString()).compareTo(this.player2.toString());
    }

    public void isDrawDeckEmpty(Player player) {
        if (player.drawDeck.isEmpty()) {
            player.storeDeck.shuffle();
            while (!player.storeDeck.isEmpty()) {
                Card card = player.storeDeck.removeTopCard();
                player.drawDeck.addCard(card);
            }

        }



    }

    public void warHand(Player first, Player second) {
        int rounds = 2;
        while (rounds-- > 0 &&(!player1.outOfCards() && !player2.outOfCards()) ){

                isDrawDeckEmpty(player1);
                warDeck.addCard(first.drawCard());
                if(first.outOfCards())
                    break;
                System.out.println(first.toString() + " drew a war card");
                // finalWinner();
                isDrawDeckEmpty(player2);
                warDeck.addCard(second.drawCard());
                if(second.outOfCards())
                 break;
                System.out.println(second.toString() + " drew a war card");
                //  finalWinner();
            }
            finalWinner();
        }


    public void printHand(Player player, Card card) {
        warDeck.addCard(card);
        System.out.println(player.toString() + " drew " + card.toString());


    }

    public void announceWinner(Player player) {
        System.out.println(player.toString() + " won");
    }

    public String finalWinner()
    {
        if(player1.outOfCards())
            return player2.toString();
        else
            return player1.toString();

    }
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
         isDrawDeckEmpty(player1);
         isDrawDeckEmpty(player2);

        Card firstHand = first.drawCard(), secondHand = second.drawCard();
        if(!player1.outOfCards() && !player2.outOfCards()) {
            printHand(first, firstHand);
            printHand(second, secondHand);
            winner = firstHand.compare(secondHand);

            if (winner > 0) {
                while (!warDeck.isEmpty()) {
                    Card card = warDeck.removeTopCard();
                    first.storeDeck.addCard(card);
                }
                if (isInWar)
                    System.out.println(first.toString() + " won the war");
                else
                    announceWinner(first);


            } else if (winner < 0) {
                while (!warDeck.isEmpty()) {
                    Card card = warDeck.removeTopCard();
                    second.storeDeck.addCard(card);
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
        else
        finalWinner();

    }


    public void war(Player first, Player second){
        warHand(first,second);
         gameplay(first,second,true);
    }

}
