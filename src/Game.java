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
    players[0] = new Player("Me");//holds the person on the 0th array element
    //initialise the cards (shuffles and deals)
    this.deck = new Deck();
    deck.shuffle();
    for (int i = 0; i < numOfCards; i++) {
      for (int j = 0; j < players.length; j++) {
        Card card = deck.next();
        players[j].hand.Add(card);
      }
    }
    //To test if Hand and Deck classes' methods are working correctly
    for (int i = 0; i < players.length; i++) {
      String cards = "";
      for (int j = 0; j < numOfCards; j++) {
        cards += players[i].hand.Get(j).toString() + " ";
      }
      if (players[i].getName().equals("Me")) {
        System.out.println("My cards are: " + cards + "\n" );
      } else {
        System.out.println(players[i].getName() + "'s cards are: " + cards + "\n" );
      }
    }
  }

  public void Biggest(){
    List<Card> getCards = new ArrayList<Card>();
    //iterates through the players looking for the player with biggest rank
    for(int i = 0; i < players.length; i++) {
      Player p = players[i];
      //each player takes a random card out of its hand
      int inPlayer = random.nextInt(p.hand.getCardCount());
      Card card = p.hand.Get(inPlayer);
      //adds the cards that are being shown to a list
      getCards.add(card);
      //For player "me" the text printed on screen has to be different
      if (p.getName().equals("Me")) {
        System.out.println("I show " + card);
      } else {
        System.out.println(p.getName() + " shows " + card);
      }
    }
    int pos = 0;
    Card winnerCard = getCards.get(pos);
    Player winner = players[pos];
    for(int i = 1; i < getCards.size(); i++) {
      Card card = getCards.get(i);
      //compares ranks
      if (card.biggerByRank(winnerCard)) { //if it's bigger substitute winner
        winnerCard = card;
        pos = i;
        winner = players[pos];
      //compares to see if both have same rank, which has greater suit
      } else if(card.rank.equals(winnerCard.rank) && card.biggerBySuit
          (winnerCard)) {
        winnerCard = card;
        pos = i;
        winner = players[pos];
      }
      //this print statement checks that suits and ranks are correctly ordered
      System.out.println("For now winner is " + winner.getName());
    }
    if (winner.getName().equals("Me")) {
      System.out.println("I win with: " + winnerCard);
    } else {
      System.out.println(winner.getName() + " wins with: " + winnerCard);
    }
  }




}


