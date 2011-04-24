package textgame;

import java.util.Arrays;

/**
 * Enum type which lists all possible verbs and possible ways of
 * writing them. The <code>getVerb</code> method an be used to
 * recognise a verb in a given string.
 *
 * @author Lewis Brown
 *
 * @see Article
 * @see Prepositions
 * @see Objects
 * @see Command
 */
public enum Verbs {
  // Make sure spellings are alphabetically ordered
  GO ({"go"}),
  BIKE (),
  COMBINE (),
  TALK (),
  NONE (),
  QUIT ();

  private final String[] spellings;

  Verbs(String[] spellings) {
    this.spellings = spellings;
  }
  Verbs() {
    this.spellings = null;
  }

  String[] getSpellings() {
    return spellings;
  }
  static Verbs getVerb(String verb) {
    for (Verbs v: Verbs.values()) {
      System.out.println(Arrays.toString(v.getSpellings()));
      System.out.println(verb);
      if (Arrays.binarySearch(v.getSpellings(),verb) >= 0)
        return v;
    }
    return NONE;
  }
}
