public class Card {

  final Rank rank;
  final Suit suit;

  public Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  public String toString() {
    return rank.toString() + suit.toString();
  }

  //compares ranks
  public boolean biggerByRank(Card s){
    boolean Boolean = false;
    if (s.rank.lessThan(this.rank)) {
      Boolean = true;
    }else if(s.rank.equals(this.rank) && s.suit.lessThan(this.suit)) {
      Boolean = true;

    }
    return Boolean;
  }

  //compares suits
  public boolean biggerBySuit(Card s) {
    boolean Boolean = false;
    if (s.suit.lessThan(this.suit)) {
      Boolean = true;
    } else if (s.suit.equals(this.suit) && s.rank.lessThan(this.rank)) {
      Boolean = true;

    }
    return Boolean;
  }

}
