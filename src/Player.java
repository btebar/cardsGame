public class Player {
  private String name;
  private int score;
  public Hand hand;

  public Player(String name){
    this.name = name;
    score = 0;
    hand = new Hand();

  }

  public String getName() {
    return name;
  }
}
