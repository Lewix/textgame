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

    public ConversationState getState() { return state; }

    public NPC(int id, String name, ConversationState initialState) {
        this.id = id;
        this.name = name;
        this.state = initialState;
    }

    public void talk(String speech) {
        //TODO: implement Character.talk
    }

    /**
     * Represents the character receiving an item from the player
     */
    public void getItem(Item item) {
        //TODO: implement Character.getItem
    }

    /**
     * Represents the character giving an item to the player
     */
    public void giveItem(Item item) {
        //TODO: implement Character.giveItem
    }
}
