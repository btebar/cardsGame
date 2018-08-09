import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Game {

  private final static String[] PLAYERSnames = {"Juan", "Sofi", "Maria", "Ignacio"};
  private final Player[] players;
  private Deck deck = new Deck();
  private final Random random = new Random();



  public Game(int numOtherPlayers, int numOfCards) {
    assert numOtherPlayers > 0 && numOtherPlayers < 5 :
        "Can only support 1 - 4 other players";
    //initialise Players
    this.players = new Player[numOtherPlayers + 1];
    for (int i = 1; i < players.length; i++) {
      players[i] = new Player(PLAYERSnames[i-1]);
    }
    players[0] = new Player("Me");//hold the human on the 0th array element
    //initialise the cards (shuffle and deal)
    this.deck = new Deck();
    deck.shuffle();
    for (int i = 0; i < numOfCards; i++) {
      for (int j = 0; j < players.length; j++) {
        players[j].hand.Add(deck.next());

      }
    }
  }
  public void Biggest(){
    List<Card> getCards = new ArrayList<Card>();
    for(int i = 0; i < players.length; i++) {
      Player p = players[i];
      int inPlayer = random.nextInt(p.hand.getCardCount());
      Card c = p.hand.Get(inPlayer);
      getCards.add(c);
      System.out.println(p.getName() + " shows " + c);
    }
    int pos = 0;
    Card winner = getCards.get(pos);
    Player winnerP = players[pos];
    for(int i = 1; i < getCards.size(); i++) {
      Card c = getCards.get(i);
      if (c.biggerByRank(winner)) {
        winner = c;
        pos = i;
        winnerP = players[pos];
      }


    }
    System.out.println(winnerP.getName() + " wins with: " + winner);
  }




}


