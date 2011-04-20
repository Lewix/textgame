package textgame;

/**
 * Modifies the game state, through the <code>player</code>.
 * <code>Modifier</code>'s methods take <code>Command</code>s which specify
 * which state to change.
 *
 * @author Lewis Brown
 *
 * @see Command
 * @see Verbs
 * @see Articles
 * @see Prepositions
 * @see Objects
 */
public class Modifier {
  private Player player;

  public void issueCommand(Command command) throws InvalidCommandException, QuitException {
    //TODO: make the game playable?
    // Locate the verb, then for each verb the article and possibly more
    switch (command.getVerb()) {
      case GO: 
        switch (command.getArticle()) {
          case EAST: player.goRight(); break;
          case JOHNSON: player.lookAt(Articles.JOHNSON.getSpellings()); break;
          default: throw new InvalidCommandException("No article for GO"); 
        }
        break;
      case BIKE: 
        switch (command.getArticle()) {
          case EAST: player.goRight(); break;
          case JOHNSON: player.talkTo(); break;
          default: throw new InvalidCommandException("No article for BIKE");
        }
        break;
      case QUIT:
        throw new QuitException();
      default: throw new InvalidCommandException("No verb");
    }
  }

  public Modifier(Player player) {
    this.player = player;
  }
}
