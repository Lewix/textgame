package textgame;

import java.util.List;
import java.util.ArrayList;

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
	private String name;
    private String description;

	public String getName() { return name; }
    public String getDescription() { return description; }
    public void setDescription(String d) { description = d; }

    private List<NPC> NPCs;
    public List<NPC> getNPCs() { return NPCs; }
    public void addNPC(NPC n) { NPCs.add(n); }
    public void removeNPC(NPC n) { NPCs.remove(n); }

    private List<Room> connections;
    public List<Room> getConnections() { return connections; }
    public void addConnection(Room r) { connections.add(r); }

    public Room(int id, String name, String description, List<Item> items, List<NPC> NPCs, List<Room> connections) {
        super(id, items);
        this.id = id;
        this.name = name;
        this.description = description;
        this.NPCs = NPCs;
        this.connections = connections;
    }

    public Room(int id, String name, String description) {
        this(id, name, description, new ArrayList<Item>, new ArrayList<NPC>, new ArrayList<Room>);
    }
}
