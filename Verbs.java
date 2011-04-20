package textgame;

/**
 * Enum type which lists all possible verbs and possible ways of writing
 * them.
 *
 * @author Lewis Brown
 *
 * @see Article
 * @see Prepositions
 * @see Objects
 * @see Command
 */
public enum Verbs {
  GO ("go"),
  BIKE ("bike"),
  NONE (""),
  QUIT ("q");

  private final String spellings;

  Verbs(String spellings) {
    this.spellings = spellings;
  }
  String getSpellings() {
    return spellings;
  }
  static Verbs getVerb(String verb) {
    for (Verbs v: Verbs.values()) {
      if (v.getSpellings().equals(verb))
        return v;
    }
    return NONE;
  }
}
