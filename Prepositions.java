package textgame;

/**
 * Enum type which lists all possible prepositions and possible ways of writing
 * them.
 *
 * @author Lewis Brown
 *
 * @see Article
 * @see Prepositions
 * @see Objects
 * @see Command
 */
public enum Prepositions {
  TO ("to"),
  FROM ("from"),
  NONE ("");

  private final String spellings;

  Prepositions(String spellings) {
    this.spellings = spellings;
  }
  String getSpellings() {
    return spellings;
  }
  static Prepositions getPreposition(String preposition) {
    for (Prepositions p: Prepositions.values()) {
      if (p.getSpellings().equals(preposition))
        return p;
    }
    return NONE;
  }
}
