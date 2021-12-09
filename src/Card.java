public class Card{
    private final int value;
    private final Suit type;
    public static final String[] cardType = {"♠","♦","♣","♥"};
    public static final String[] cardValue = {"Ace","2","3","4","5","6","7","8",
                                                "9","10","Jack","Queen","King"};

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

    public int compare(Card other){
        if(other.getValue()!=1 && this.getValue()!=1)
        return Integer.compare(this.getValue(), other.getValue());
        else
            if((this.getValue()==1) && (Integer.compare(this.getValue(), other.getValue())!=1))
                return 1;
            else
                return -1;

    }

    public String toString(){
        return (cardValue[value-1] + " of " + cardType[type.showType()]);
    }

}
