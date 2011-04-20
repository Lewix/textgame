package textgame;

/**
 * Enum type which lists all possible objects and possible ways of writing
 * them.
 *
 * @author Lewis Brown
 *
 * @see Article
 * @see Prepositions
 * @see Objects
 * @see Command
 */
public enum Objects {
  JOHNSON ("johnson"),
  NONE ("");

  private final String spellings;

  Objects(String spellings) {
    this.spellings = spellings;
  }
  String getSpellings() {
    return spellings;
  }
  static Objects getObject(String object) {
    for (Objects o: Objects.values()) {
      if (o.getSpellings().equals(object))
        return o;
    }
    return NONE;
  }
}
