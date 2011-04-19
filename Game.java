package textgame;

/**
 * Stores the current state of the game. The player's state is saved in
 * <code>player</code> and the user can interact with it using
 * <code>listener</code>.
 *
 * @author Lewis Brown
 *
 * @see Listener
 * @see Printer
 * @see Modifier
 *
 */
public class Game {
  private Listener listener;
  private Printer printer;
  private Modifier modifier;
  //private Player player;

  private Game() {
    super();
    listener = new Listener();
    printer = new Printer();
    modifier = new Modifier();
    //player = new Player();
    //TODO: write game constructor
  }

  public static void main(String [] args) {
    //TODO: write main
  }


}
