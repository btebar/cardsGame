import java.util.Random;

public class Deck {
  private final Card[] cards;
  //cards taken off the deck are not actually removed
  //rather size points to the first index after the cards
  //that are still in the deck
  private int size;
  private final Random random = new Random();

  public static void main(String[] args) {
    Deck deck = new Deck();
    deck.reset();
    deck.println();
    deck.shuffle();
    deck.println();
    for (int i = 0; i < deck.cards.length; i++) {
      System.out.print(deck.next() +",");
    }
  }
  public Deck(){
    this.cards = new Card[52];
    reset();
  }

  public void reset(){
    //resets the whole deck
    int index = 0;
    for (Suit s : Suit.values()) {
      for (Rank r : Rank.values()) {
        Card c = new Card(r, s);
        this.cards[index] = c;
        index++;
      }
    }
    this.size = this.cards.length;
  }

  public void shuffle() {
    //shuffles the deck, randomizing the game
    for (int i = size-1; i > 0; i--) {
      Card card = cards[i];
      int index = random.nextInt(i);
      cards[i] = cards[index];
      cards[index] = card;

    }
  }

  public Card next() {
    //takes the next card of the deck
    assert (size > 0) : "There must be at least one card";
    size --;
    return cards[size];
  }

  public void println(){
    for(Card c : cards) {
      System.out.println(c + ",");
    }
    System.out.println();
  }



}
