/**
 * This enum contains the types of the cards
 */
public enum Suit {
    Spades(0),
    Diamonds(1),
    Clubs(2),
    Hearts(3);
    /**
     *
     */
    int type;
    /**
     * @param val integer {0..3} represent the serial number of the type
     */
    Suit(int val){
        type = val;
    }
    /**
     * @return the number that represent the type, {0..3}
     */
    int showType(){
         return type;
    }
}
