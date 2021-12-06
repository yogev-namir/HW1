public class Card{
    private int value;
    private Suit type;
    private String[] cardType = {"♠","♦","♣","♥"}
    private String[] cardValue = {"Ace","2","3","4","5","6","7","8","9","10",
                                    "Jack","Queen","King"};

    public card(Suit type, int value){
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
        return Integer.compare(this.getValue(), other.getValue());
    }
    public String toString(){
        String state = cardValue[value-1] + "of" + cardType[type.showType()-1];
    }
}
