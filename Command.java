package textgame;

import java.util.*;

/**
 * Encodes the commands issued by the user. The <code>Listener</code> creates
 * <code>Command</code>s that are passed to the <code>Modifier</code> to
 * change the game state. A command should have the form <code>verb
 * arguments</code>. For example "Go north" or "Give bike to Colin".
 *
 * @author Lewis Brown
 *
 * @see Listener
 * @see Modifier
 */
public class Command {
  private final Verb verb;
  private final String[] args;

  public Command(String commandString) {
    String[] elements = commandString.split(" ");
    args = Arrays.copyOfRange(elements,1,elements.length);
    verb = recogniseVerb(elements);
  }

  /**
   * Executes the command. Uses the <code>Verb</code>'s execute method to
   * execute the command and thus modify the game state.
   */
  public void execute(Player player) throws InvalidCommandException, QuitException {
    this.verb.execute(args,player);
  }

  // Verb spellings
  private static String[] go = {"go"};
  private static String[] combine = {"use", "combine"};
  private static String[] talk = {"speak", "talk"};
  private static String[] none = {""};
  private static String[] quit = {"q","quit","exit"};

  /**
   * Verb enum type defines the verbs that can be used and their spellings.
   * It has a single constructor which takes a String to recognise which verb
   * has that spelling.
   */
  private enum Verb {
    GO(go) {
      void execute(String[] args, Player player) throws InvalidCommandException {
        String roomName = "";
        for (String s: args) {
          roomName += s + " ";
        }
        // Get rid of trailing space
        roomName = roomName.substring(0,roomName.length()-2); 
        player.GoToRoom(roomName);
      }
    },
    COMBINE(combine) {
      void execute(String[] args, Player player) throws InvalidCommandException {
        switch (args.length) {
          case 2: combine(args[0],args[1]); break;
          case 3: if (args[1].equals("and")) {
                    combine(args[0],args[2]); break;
                  }
                  else if (args[1].equals("with")) {
                    combine(args[0],args[2]); break;
                  }
          default: throw new InvalidCommandException("Wrong amount of arguments");
        }
      }
    },
    TALK(talk) {
      void execute(String[] args, Player player) throws InvalidCommandException {
        String npcName = "";
        for (String s: args) {
          npcName += s + " ";
        }
        // Get rid of trailing space
        npcName = npcName.substring(0,npcName.length()-2); 
        player.talkTo(npcName);
      }
    },
    NONE(none) {
      void execute(String[] args, Player player) throws InvalidCommandException {
        throw new InvalidCommandException("No command");
      }
    },
    QUIT(quit) {
      void execute(String[] args, Player player) throws QuitException {
        throw new QuitException();
      }
    };

    private final String[] spellings;
    //TODO: visibility of the enums methods

    Verb(String[] spellings) {
      this.spellings = spellings;
    }

    String[] getSpellings() {
      return spellings;
    }
    static Verb getVerb(String verb) {
      for (Verb v: Verb.values()) {
        //TODO: binary search in arrays is a bit shit
        if (Arrays.binarySearch(v.getSpellings(),verb) >= 0)
          return v;
      }
      return NONE;
    }
    abstract void execute(String[] args, Player player) throws InvalidCommandException, QuitException;

  }

  /**
   * Extracts a verb from the string. A verb may span more than one words.
   * Possible verbs will be stored in a file as will the articles and objects
   * they are allowed to operate on.
   */
  private Verb recogniseVerb(String[] elements) {
    String verbCandidate;
    try {
      verbCandidate = elements[0];
    } catch (ArrayIndexOutOfBoundsException e) {
      verbCandidate = "";
    }
    return Verb.getVerb(verbCandidate);
  }

  public Verb getVerb() {
    return verb;
  }
}
