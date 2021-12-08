public enum Suit {
    Spades(0),
    Diamonds(1),
    Clubs(2),
    Hearts(3);

    int type;
    Suit(int val){
        type = val;
    }
    int showType(){
         return type;
    }
}
