package textgame;

import java.util.*;

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
  private final Verbs verb;
  private final Articles article;
  private final Prepositions preposition;
  private final Objects object;

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
  private Verbs recogniseVerb(String[] elements) {
    String verbCandidate;
    try {
      verbCandidate = elements[0];
    } catch (ArrayIndexOutOfBoundsException e) {
      verbCandidate = "";
    }
    return Verbs.getVerb(verbCandidate);
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

  public Verbs getVerb() {
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
