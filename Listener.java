package textgame;

import java.util.List;
import java.util.ArrayList;

/**
 * Gets user input and issues a command to the player from it. The string of
 * user input is decoded into a <code>Command</code> that can be used to
 * modify the game state.
 *
 * @author Lewis Brown
 *
 * @see Command
 *
 */
public class Listener {
  public static Command getCommand() {
    List<Character> charList = new ArrayList<Character>();
    char userResponse = (char)0;
    while (userResponse != '\n') {
    //TODO: handle IOException properly
      try {
        userResponse = (char)System.in.read();
      } catch (java.io.IOException e) {
        userResponse = (char)'\n';
      }
      charList.add((Character)userResponse);
    }
    char[] commandString = new char[charList.size()];
    for (int i = 0; i<charList.size(); i++) {
      commandString[i] = (char)(Character)charList.toArray()[i];
    }
    return new Command(new String(commandString));
  }

  public Listener() {
    super();
  }
}
