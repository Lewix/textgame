package uk.ac.cam.lab61.textgame;

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
 * @see Character
 * @author Colin Rothwell
 */
class ConversationState {
    private Map<Item, ConversationState> acceptableItems;
    /**
     * @return The set of all items the character can accept at this time.
     */
    public Set<Item> getAcceptableItems() {
        //TODO: Implement ConversationState.getAcceptableItems();
        return new TreeSet<Item>();
    }

    /**
     * @exception IllegalArgumentException thrown if the character cannot
     * accept this item at this time.
     */ 
    public ConversationState getItem(Item i) throws IllegalArgumentException {
        //TODO: Implement ConversationState.getItem();
        return this;
    }
      
    private Map<Item, ConversationState> giveableItems; 
    /**
     * @return The set of all items the character can give at this time. 
     */
    public Set<Item> getGivableItems() {
        //TODO: Implement ConversationState.getGivableItems();
        return new TreeSet<Item>();
    }

    /**
     * @exception IllegalArgumentException thrown is the character cannot give
     * that item at this time
     */
    public ConversationState giveItem(Item i) throws IllegalArgumentException {
        //TODO: Implement ConversationState.giveItem
        return this;
    }

    private Map<String, ConversationState> speeches;
    public Set<String> getSpeeches() {
        //TODO: Implement ConversationState.getSpeeches()
        return new TreeSet<String>();
    }

    /**
     * @exception IllegalArgumentException thrown if you cannot say that to the
     * character at this time
     */
    public ConversationState talk(String s) throws IllegalArgumentException {
        //TODO: Implment ConversationState.talk
        return this;
    }
}

