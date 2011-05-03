package textgame;

import java.util.ArrayList;

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

  /**
   * Generates the game world, and returns the start room.
   *
   * @author Colin Rothwell
   */
  protected Room makeMap() {
      Room yourRoom = _makeYourRoom();
      Room library = _makeLibrary();
      Room johnsRoom = _makeJohnsRoom();
      Room corridor = _makeCorridor();

      yourRoom.addConnection(corridor);
      corridor.addConnection(yourRoom);
      library.addConnection(corridor);
      corridor.addConnection(library);
      johnsRoom.addConnection(corridor);
      corridor.addConnection(johnsRoom);

      return yourRoom;
  }

  /**
   * @author Colin Rothwell
   */
  protected Room _makeYourRoom() {
      Room r = new Room(0,
              "Your Room",
              "A small, dingy room. Sheets of paper cover the floor, along " +
              "with trays stolen from hall, complete with plates of moldering " +
              "food. One of the molds appears to twitch periodically, and the " +
              "radiator emits a worrying smell.");
      r.addItem(_makePen());
      r.addItem(_makePaper());
      return r;
  }

  /**
   * @author Colin Rothwell
   */
  protected Room _makeLibrary() {
      Room r = new Room(1,
              "The Library",
              "The shelves locked as a result of recent vandalism, borrowable " +
              "only with the express permission of the ferocious librarian, " +
              "a few flickering bulbs cast a dingy light over the masses of " +
              "silently oppressed students, bent and labouring at their desks. ");
      r.addNPC(_makeLibrarian);
      return r;
  }

  /**
   * @author Colin Rothwell
   */
  protected NPC _makeLibrarian() {
      ConversationState start = new ConversationState(
              "Well?! What do you want?! Can't you see I'm busy!");

      ConversationState askForBook = new ConversationState(
              "Hmm, I think I do have something like that. But if you don't " +
              "bring it back by the due date, I will reach into your chest, " +
              "break off your ribs, and skewer you with them.");

      start.putSpeech("Do you have a book that could help me with this piece of " +
             "very difficult supervision work, please?", askForBook);

      ConversationState end = new ConversationState(
              "There you go. Remember what I said about returns!");

      askForBook.putGivableItem(_makeTextBook(), end);
      
      return new NPC(0, "The Ferocious Librarian", 
              "The intimidating librarian. She appears to be busy tending to " +
              "the books. You'd better have a good reason to talk to her.",
              start);
  }

  /**
   * @author Colin Rothwell
   */
  protected Room _makeJohnsRoom() {
      Room r = new Room(2,
              "47E, John's Room",
              "47E, The legendary home of the legendary John Fawcett. The " +
              "walls are lined with skulls of students who have failed to " +
              "hand in their supervision work on time, in various states of " +
              "decay. A large television sits on the floor. You have never " +
              "quite worked up the courage to ask what it's actually for.");
      r.addNPC(_makeJohn());
      return r;
  }

  /**
   * @author Colin Rothwell
   */
  protected NPC _makeJohn() {
      ConversationState start = new ConversationState("Where is your " +
              "supervision work?! You can't come on my famous MOUNTAIN " +
              "BIKING EXPEDITION if you don't hand in your supervision work!");

      ConversationState win = new ConversationState("This is excellent work! " +
              "Let's go mountain biking!") {
          public String getReply() {
              throw new WinThrowable();
              return super.getReply();
          }
      };

      start.putAcceptableItem(_makeSupervisionWork(), win);

      return new NPC(1, "Dr. John Fawcett, MA PhD (Cantab)",
              "The legendary DoS for Churchill College CompScis. He is " +
              "rumoured to never leave any survivors. Surprisingly keen on " +
              "mountain biking.", start);
  }

  /**
   * @author Colin Rothwell
   */
  protected Room _makeCorridor() {
      return new Room(3,
              "The Corridor",
              "An angry corridor. It's vicious snaps and snarls make you jump " +
              "as you creep from one destination to the next.");
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
