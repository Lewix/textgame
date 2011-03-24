package textgame;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents a room ingame. The game world is made up of a series of
 * interconnected room. Paths between rooms are one way: if you want a player to
 * be able to go both ways, you need to add two connections.
 *
 * @author Colin Rothwell
 */
class Room {
    private int id;
    private String name, description;
    private List<Room> connections;

    /**
     * @return A unique identifier for the room
     */
    public int getId() { return id; } 

    /**
     * @return A short, human readable name for the room
     */
    public String getName() { return name; }

    /**
     * @return A more verbose description of the room
     */
    public String getDescription() { return description; }

    /**
     * Adds a connection to a neighbouring room.
     */
    public void addConnection(Room r) { connections.add(r); }

    /**
     * Removes a connection to a neighbouring room.
     */
    public void removeConnection(Room r) { connections.remove(r); }

    /**
     * @return The connections between this room and others. It is highly
     * recommended that you <em>don't</em> modify this manually, to avoid
     * confusion.
     */
    public List<Room> getConnections() { return this.connections; }

    public Room(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
