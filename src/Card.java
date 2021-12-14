public class Card{
    private final int value;
    private final Suit type;
    public static final String[] cardType = {"♠","♦","♣","♥"};
    public static final String[] cardValue = {"Ace","2","3","4","5","6","7","8",
            "9","10","Jack","Queen","King"};
    /**
     * Initializes the card as required
     * @param value: the number of the card
     * @param type: the shape of the card
     */
    public Card(Suit type, int value){
        this.type = type;
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public Suit getType() {
        return type;
    }
    /**
     * Compares 2 cards and checks who is bigger
     * @param other: object from Card type
     * @return which of the cards values is higher
     */
    public int compare(Card other){

            return Integer.compare(this.getValue(), other.getValue());


    }
    /**
     * Create a string with the value of the Card and his shape
     * @return value and  shape of the Card
     */
    public String toString(){
        return (cardValue[value-1] + " of " + cardType[type.showType()]);
    }

}