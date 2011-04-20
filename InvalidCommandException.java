package textgame;

/**
 * Exception thrown when a valid command cannot be made from the supplied
 * string. This exception is typically thrown by the <code>Command</code>
 * constructor when the user enters an invalid command.
 *
 * @author Lewis Brown
 *
 * @see Command
 */

public class InvalidCommandException extends Exception {
  public InvalidCommandException(String message) {
    super(message);
  }
}
