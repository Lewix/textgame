package textgame;

import java.util.List;

/**
 * An ingame room.
 *
 * Rooms are simple containers for NPCs and Items. They are connected to other
 * rooms. The character is in one room at any time.
 *
 * @author Colin Rothwell
 * @see NPC
 * @see Item
 * @see Character
 */
public class Room extends ItemContainer {
    private int id;
	private String name;
    private String description;

    public int getId() { return id; }	
	public String getName() { return name; }
    public String getDescription() { return description; }

    private List<NPC> NPCs;
    public List<NPC> getNPCs() { return NPCs; }

    public Room(int id, String name, String description, List<Item> items, List<NPC> NPCs) {
        super(items);
        this.id = id;
        this.name = name;
        this.description = description;
        this.NPCs = NPCs;
    }
}
