package textgame;

/**
 * Represents an ingame non player character. The player can talk to them, give
 * them items, and recieve items from them.
 *
 * id, name and description serve the same purpose as in Room. Perhaps they
 * should be in a superclass, but this seems like more effort than it is worth.
 *
 * Talk, getItem and giveItem all represent performing some action in the
 * conversation, and advance the state of the conversation appropriately.
 *
 * @see ConversationState
 * @see Item
 * @author Colin Rothwell
 */
class NPC {
    private ConversationState state;
    private int id;
    private String name, description;

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }

    public boolean isKnownAs(String n) {
        return name.toLowerCase().equals(n.toLowerCase());
    }

    public ConversationState getState() { return state; }

    public NPC(int id, String name, String description, ConversationState initialState) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.state = initialState;
    }

    public String toString() {
        return id + ": " + name;
    }

    public void talk(String speech) throws IllegalArgumentException {
        try {
            state = state.talk(speech);
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(this + " " + e.getMessage());
        }
    }

    /**
     * Represents the character receiving an item from the player
     */
    public void getItem(Item item) throws IllegalArgumentException {
        try {
            state = state.getItem(item);
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(this + " " + e.getMessage());
        }
    }

    /**
     * Represents the character giving an item to the player
     */
    public void giveItem(Item item) throws IllegalArgumentException {
        try {
            state = state.giveItem(item);
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(this + " " + e.getMessage());
        }
    }
}
