public enum Rank {

  ACE("A"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE(
      "9"), TEN("10"), JACK("J"), QUEEN("Q"), KING("K");

  private final String representation;

  Rank(String representation) {
    this.representation = representation;
  }

  public boolean lessThan(Rank r) {
    return this.ordinal() < r.ordinal();
  }

  public boolean equals(Rank r) {
    return this.ordinal() == r.ordinal();
  }

  public String toString() {
    return representation;
  }
}
