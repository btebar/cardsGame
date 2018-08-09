import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

public class DeckList {
  private List<Card> cards = new ArrayList<Card>();
  //cards taken off the deck are not actually removed
  //rather size points to the first index after the cards
  //that are still in the deck
  private final Random random = new Random();
  public static void main(String[] args) {
    DeckList deck = new DeckList();
    deck.println();
    deck.shuffle();
    deck.println();
    for (int i = 0; i < deck.cards.size(); i++) {
      System.out.print(deck.next() +",");
    }
  }
  public DeckList(){

    for (Suit s : Suit.values()) {
      for (Rank r : Rank.values()) {
        cards.add(new Card(r, s));
      }

    }

  }


  public void shuffle() {
    for (int i = cards.size()-1; i > 0; i--) {
      int index = random.nextInt(i);
      Collections.swap(cards, i, index);


    }
  }

  public Card next() {
    assert (cards.size() > 0) : "There must be at least one card";
    Card c = cards.get(cards.size() -1);
    cards.remove(cards.size() - 1);
    return c;
  }

  public void println(){
    for(Card c : cards) {
      System.out.println(c + ",");
    }
    System.out.println();
  }



}


