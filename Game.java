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
  //private Modifier modifier;
  private Player player;

  private Game() {
    super();
    player = new Player(makeMap());
    listener = new Listener();
    printer = new Printer();
    //modifier = new Modifier(player);
  }

  protected Room makeMap() {
    //TODO: Colin implements makeMap
  }

  public static void main(String [] args) {
    Game game = new Game();
    while (true) { //TODO: success condition
      try {
        Command command = game.listener.getCommand();
        command.execute(game.player);
      } catch (InvalidCommandException e) {
        game.printer.printFailure();
        System.out.println(e.getMessage());
      } catch (QuitException e) {
        break;
      } catch (ErrMsg e) {
        System.out.println(e.getMsg());
      } catch (MsgToUser e) {
        System.out.println(e.getMsg());
      } catch (WinThrowable w) {
        //TODO: print text
        return;
      }
      game.printer.printState();
    }
  }
}
