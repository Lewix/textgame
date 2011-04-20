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
  private Player player;

  private Game() {
    super();
    player = new Player();
    listener = new Listener();
    printer = new Printer();
    modifier = new Modifier(player);
  }

  public static void main(String [] args) {
    Game game = new Game();
    while (true) { //TODO: success condition
      try {
        Command command = game.listener.getCommand();
        game.modifier.issueCommand(command);
      } catch (InvalidCommandException e) {
        game.printer.printFailure();
        System.out.println(e.getMessage());
      } catch (QuitException e) {
        break;
      }
      game.printer.printState();
    }
  }
}
