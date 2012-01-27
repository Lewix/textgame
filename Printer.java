package textgame;

/**
 * Prints output to the screen for the user to read. The can request various
 * parts of the game state to be printed. A generic message will be printed
 * after each command the user issues.
 *
 * @author Lewis Brown
 * @author Colin Rothwell
 */
public class Printer {
    Player player;

    public Printer(Player p) {
        player = p;
    }

    public void printState() {
        System.out.println(player.describeLocation());
    }

    public void printResponse(UserResponse resp) {
        System.out.println(resp.getMessage());
    }
}
