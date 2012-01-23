package textgame;

/**
 * Prints output to the screen for the user to read. The can request various
 * parts of the game state to be printed. A generic message will be printed
 * after each command the user issues.
 *
 * @author Lewis Brown
 */
public class Printer {
  public void printState() {
    //TODO: write printState (and others for different parts of state)
    System.out.println("No info");
  }

  public void printFailure() {
    System.out.println("You can't do that");
  }

}
