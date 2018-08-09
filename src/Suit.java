public enum Suit {
  SPADE("♠"), HEART("♥"), CLUB("♣"), DIAMOND("♦");

  private final String symbol;

  Suit(String symbol) {
    this.symbol = symbol;
  }

  public boolean lessThan(Suit s){
    return this.ordinal()<s.ordinal();
  }

  public boolean equals(Suit s){
    return this.ordinal()==s.ordinal();
  }

  public String toString() {
    return symbol;
  }
}
