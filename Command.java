package textgame;

/**
 * Encodes the commands issued by the user. The <code>Listener</code> creates
 * <code>Command</code>s that are passed to the <code>Modifier</code> to
 * change the game state. A command should have the form <code>verb article
 * [preposition object]</code>. For example "Go north" or "Give bike to
 * Colin".
 *
 * @author Lewis Brown
 *
 * @see Listener
 * @see Modifier
 */
public class Command {
  //TODO: decide on command syntax
  private final String verb;
  private final String article;
  private final String preposition;
  private final String object;

  public Command(String commandString) {
    String[] elements = commandString.split(" ");
    verb = recogniseVerb(elements);
    article = recogniseArticle(elements);
    preposition = recognisePreposition(elements);
    object = recogniseObject(elements);
  }

  /**
   * Extracts a verb from the string. A verb may span more than one words.
   * Possible verbs will be stored in a file as will the articles and objects
   * they are allowed to operate on.
   */
  private String recogniseVerb(String[] elements) {
    //TODO: write recogniseVerb
    return "";
  }
  private String recogniseArticle(String[] elements) {
    //TODO: write recogniseArticle
    return "";
  }
  private String recognisePreposition(String[] elements) {
    //TODO: write recognisePreposition
    return "";
  }
  private String recogniseObject(String[] elements) {
    //TODO: write recogniseObject
    return "";
  }
}
