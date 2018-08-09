public class LetsPlay {

  public static void main(String[] args) {
    System.out.println("How many players are going to play?");
    int numPlayers = IOUtil.readInt();
    System.out.println("With how many cards per player?");
    int numCards = IOUtil.readInt();
    System.out.println("You are going to play with " + numPlayers + " players and " + numCards + " cards.");
    Game game = new Game(numPlayers, numCards);
    System.out.println("Lets play.");

    game.Biggest();
    System.out.println("Goodbye");



  }

}
