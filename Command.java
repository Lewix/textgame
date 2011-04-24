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
  private final Articles article;
  private final Prepositions preposition;
  private final Objects object;

  public Command(String commandString) {
    String[] elements = commandString.split(" ");
    args = Arrays.copyOfRange(elements,1,elements.length);
    verb = recogniseVerb(elements);
    article = recogniseArticle(elements);
    preposition = recognisePreposition(elements);
    object = recogniseObject(elements);
  }

  public void execute(Player player) throws InvalidCommandException, QuitException {
    this.verb.execute(args,player);
  }

  // Verb spellings
  private static String[] go = {"go","Go"};
  private static String[] combine = {"combine"};
  private static String[] talk = {"talk"};
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
        switch (args.length) {
          case 1: player.goRight(); //TODO: say where to go
                  break;
          default: throw new InvalidCommandException("Wrong amount of arguments");
        }
      }
    },
    COMBINE(combine) {
      void execute(String[] args, Player player) throws InvalidCommandException {
        switch (args.length) {
          case 2: //combine(args[0],args[1]); break;
          case 3: if (args[1].equals("and")) {
                    //combine(args[0],args[2]); break;
          }
          default: throw new InvalidCommandException("Wrong amount of arguments");
        }
      }
    },
    TALK(talk) {
      void execute(String[] args, Player player) throws InvalidCommandException {
        switch (args.length) {
          case 1: player.talkTo(/*args[0]*/); break;
          default: throw new InvalidCommandException("Wrong amount of arguments");
        }
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
  private Articles recogniseArticle(String[] elements) {
    String articleCandidate;
    try {
      articleCandidate = elements[1];
    } catch (ArrayIndexOutOfBoundsException e) {
      articleCandidate = "";
    }
    return Articles.getArticle(articleCandidate);
  }
  private Prepositions recognisePreposition(String[] elements) {
    String prepositionCandidate;
    try {
      prepositionCandidate = elements[2];
    } catch (ArrayIndexOutOfBoundsException e) {
      prepositionCandidate = "";
    }
    return Prepositions.getPreposition(prepositionCandidate);
  }
  private Objects recogniseObject(String[] elements) {
    String objectCandidate;
    try {
      objectCandidate = elements[3];
    } catch (ArrayIndexOutOfBoundsException e) {
      objectCandidate = "";
    }
    return Objects.getObject(objectCandidate);
  }

  public Verb getVerb() {
    return verb;
  }
  public Articles getArticle() {
    return article;
  }
  public Prepositions getPreposition() {
    return preposition;
  }
  public Objects getObject() {
    return object;
  }
}
