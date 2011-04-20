package textgame;

/**
 * Enum type which lists all possible articles and possible ways of writing
 * them.
 *
 * @author Lewis Brown
 *
 * @see Article
 * @see Prepositions
 * @see Objects
 * @see Command
 */
public enum Articles {
  EAST ("east"),
  STICKS ("sticks"),
  BOXES ("boxes"),
  JOHNSON ("johnson"),
  NONE ("");

  private final String spellings;

  Articles(String spellings) {
    this.spellings = spellings;
  }
  String getSpellings() {
    return spellings;
  }
  static Articles getArticle(String article) {
    for (Articles a: Articles.values()) {
      if (a.getSpellings().equals(article))
        return a;
    }
    return NONE;
  }
}
