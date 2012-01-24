package textgame;

/**
 * Thrown when the player wins the game
 *
 * @author Colin Rothwell
 */

import java.lang.Throwable;

public class WinThrowable extends Throwable {
    public WinThrowable(String msg) {
        super(msg);
    }
}
