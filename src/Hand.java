import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> hand = new ArrayList<Card>();
    public Hand(){
       hand = new ArrayList<Card>();
    }
    public void clear(){
      hand.clear();
    }


    public void Add(Card c) {
      assert (c != null) : "It cannot be an empty card";
      hand.add(c);

    }
    public void removeCard(Card c) {
      hand.remove(c);
    }

    public Card Get(int pos) {
      assert (0 <= pos && pos < hand.size()) : "this position doesn't exist in hand";
      return hand.get(pos);
    }

    public void Remove(int a) {
      hand.remove(a);
    }

    public int getCardCount() {
      return hand.size();
    }

    public void sortBySuit() {
      List<Card> newHand = new ArrayList<Card>();
      while (hand.size() > 0) {
        int pos = 0;
        Card c = hand.get(0);
        for (int i = 1; i < hand.size(); i++) {
           Card c1 = hand.get(i);
           if (c1.suit.lessThan(c.suit) || (c1.suit.equals(c.suit) && c1.rank.lessThan(c.rank))) {
             pos = i;
             c = c1;
           }
        }
        hand.remove(pos);
        newHand.add(c);

      }
      hand = newHand;
    }

    public void sortByRank() {
      List<Card> newHand = new ArrayList<Card>();
      while (hand.size() > 0) {
        int pos = 0;
        Card c = hand.get(0);
        for (int i = 1; i < hand.size(); i++) {
           Card c1 = hand.get(i);
           if(c1.rank.lessThan(c.rank) || (c1.rank.equals(c.rank) && c1.suit.lessThan(c.suit))) {
             pos = i;
             c = c1;
           }
        }
        hand.remove(pos);
        newHand.add(c);
      }
      hand = newHand;
    }








}
