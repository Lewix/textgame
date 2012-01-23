package textgame;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.lang.IllegalArgumentException;

/**
 * Represents the state of the Character.
 *
 * At each step in the conversation, the player may do one of several things to
 * the character, and each thing they do leads to a new state.
 *
 * @author Colin Rothwell
 * @see NPC
 */
class ConversationState {
    private String reply;
    public String getReply() { return reply; }

    public ConversationState(String reply) {
        this.reply = reply;
        this.acceptableItems = new HashMap<Item, ConversationState>();
        this.givableItems = new HashMap<Item, ConversationState>();
        this.speeches = new HashMap<String, ConversationState>();
    }

    public ConversationState(String reply, 
            Map<Item, ConversationState> acceptableItems,
            Map<Item, ConversationState> givableItems,
            Map<String, ConversationState> speeches) {
        this.reply = reply;
        this.acceptableItems = acceptableItems;
        this.givableItems = givableItems;
        this.speeches = speeches;
    }

    private Map<Item, ConversationState> acceptableItems;
    /**
     * @return The set of all items the character can accept at this time.
     */
    public Set<Item> getAcceptableItems() {
        return acceptableItems.keySet();
    }

    public void putAcceptableItem(Item i, ConversationState s) {
        acceptableItems.put(i, s);
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

    public void putGivableItem(Item i, ConversationState s) {
        givableItems.put(i, s);
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

    public void putSpeech(String s, ConversationState c) {
        speeches.put(s, c);
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

