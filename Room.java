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
    public boolean isKnownAs(String n) {
        return name.toLowerCase().equals(n.toLowerCase());
    }

    public String getDescription() { return description; }
    public void setDescription(String d) { description = d; }

    private List<NPC> NPCs;
    public List<NPC> getNPCs() { return NPCs; }
    public NPC getNPC(String name) {
        for (NPC candidate : NPCs) {
            if (candidate.isKnownAs(name)) {
                return candidate;
            }
        }
        return null;
    }
    public void addNPC(NPC n) { NPCs.add(n); }
    public void removeNPC(NPC n) { NPCs.remove(n); }

    private List<Room> connections;
    public List<Room> getConnections() { return connections; }
    public Room getConnectionTo(String roomName) {
        for (Room candidate : connections) {
            if (candidate.isKnownAs(roomName)) {
                return candidate;
            }
        }
        return null;
    }
    public String describeConnections() {
        int connCount = connections.size();
        switch (connCount) {
            case 0:
                return "nowhere. You are stuck, and this is probably a bug";
            case 1:
                return connections.get(0).getName();
            default:
                int i;
                String desc = "";
                for (i = 0; i < connCount - 1; ++i) {
                    desc += connections.get(i).getName() + ", ";
                }
                return desc + "and " + connections.get(i).getName();
        }
    }
    public void addConnection(Room r) { connections.add(r); }

    public String descriptionForPlayer() {
        return getName() + ". " + getDescription() + 
            "\n\nFrom here, you can go to " + describeConnections() +
            ". \n\nYou can see " + describeItems() + " lying around.";
    }

    public Room(int id, String name, String description, List<Item> items, List<NPC> NPCs, List<Room> connections) {
        super(id, items);
        this.name = name;
        this.description = description;
        this.NPCs = NPCs;
        this.connections = connections;
    }

    public Room(int id, String name, String description) {
        this(id, name, description, new ArrayList<Item>(), new ArrayList<NPC>(), new ArrayList<Room>());
    }
}
