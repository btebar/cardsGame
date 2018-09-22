import java.util.Scanner;

public class LetsPlay {

  public static void main(String[] args) {
    System.out.println("How many players are joining you?");
    int numPlayers = IOUtil.readInt();
    System.out.println("With how many cards per player?");
    int numCards = IOUtil.readInt();
    System.out.println("You are going to play along with " + numPlayers + " "
        + "players and " + numCards + " cards.");
    Game game = new Game(numPlayers, numCards);
    System.out.println("Lets play.\n");

    game.Biggest();

    System.out.println("Do you want to play again?(y/n)");
    Scanner scanner = new Scanner(System.in);
    String answer = scanner.nextLine();
    while (answer.equals("y")) {
      System.out.println("With the same settings?(y/n)");
      String answer2 = scanner.next();
      if(answer2.equals("n")) {
        System.out.println("How many players are joining you?");
        numPlayers = IOUtil.readInt();
        System.out.println("With how many cards per player?");
        numCards = IOUtil.readInt();
      }
      game = new Game(numPlayers, numCards);
      game.Biggest();
      System.out.println("Do you want to play again?(y/n)");
      answer = scanner.next();
    }

    System.out.println("Goodbye");



  }

}
