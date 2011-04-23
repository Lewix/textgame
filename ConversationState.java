package textgame;

import java.util.Set;
import java.util.Map;
import java.util.TreeSet;
import java.lang.IllegalArgumentException;

/**
 * Represents the state of the Character.
 *
 * At each step in the conversation, the player may do one of several things to
 * the character, and each thing they do leads to a new state.
 *
 * @see NPC
 * @author Colin Rothwell
 */
class ConversationState {
    private Map<Item, ConversationState> acceptableItems;
    /**
     * @return The set of all items the character can accept at this time.
     */
    public Set<Item> getAcceptableItems() {
        return acceptableItems.keySet();
    }

    /**
     * @exception IllegalArgumentException thrown if the character cannot
     * accept this item at this time.
     */ 
    public ConversationState getItem(Item i) throws IllegalArgumentException {
        ConversationState r = acceptableItems.get(i);
        if (r != null) {
            return r;
        }
        else {
            throw new IllegalArgumentException("cannot accept " + i);
        }
    }
      
    private Map<Item, ConversationState> givableItems; 
    /**
     * @return The set of all items the character can give at this time. 
     */
    public Set<Item> getGivableItems() {
        return givableItems.keySet();
    }

    /**
     * @exception IllegalArgumentException thrown is the character cannot give
     * that item at this time
     */
    public ConversationState giveItem(Item i) throws IllegalArgumentException {
        ConversationState r = givableItems.get(i);
        if (r != null) {
            return r;
        }
        else {
            throw new IllegalArgumentException("cannot give " + i);
        }
    }

    private Map<String, ConversationState> speeches;
    public Set<String> getSpeeches() {
        return speeches.keySet();
    }

    /**
     * @exception IllegalArgumentException thrown if you cannot say that to the
     * character at this time
     */
    public ConversationState talk(String s) throws IllegalArgumentException {
        ConversationState r = speeches.get(s);
        if (r != null) {
            return r;
        }
        else {
            throw new IllegalArgumentException("cannot speak " + s);
        }
    }
}

