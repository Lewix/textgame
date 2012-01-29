package textgame;

import java.util.*;

public class Player extends ItemContainer {
	private Room location;
    private TransformationManager transman;
	
    public Player(Room r, TransformationManager tm) {
		super(144); //id=144 restricted for player
		location = r;
        transman = tm;
	}

    public String describeLocation() {
        return "You are in " + location.descriptionForPlayer();
    }
	
	//move the player to the specified room 
	public UserResponse goTo(String r) {
        Room next = location.getConnectionTo(r);
        if (next == null) {
            return UserResponse.error("You can't get to " + r + " from here.");
        }
        location = next;
        return UserResponse.message(describeLocation());
	}
	
	public UserResponse lookAt(String it) {
		Item tempItem = location.itemWithName(it);
		if (tempItem != null) {
			return UserResponse.message(tempItem.getDescription());
		}
		else {
			return UserResponse.error("No such item around");
		}
	}
	
	public UserResponse pickUp(String it) {
		Item tempItem = location.itemWithName(it);
		if (tempItem != null) {
			this.addItem(tempItem);
			location.removeItem(tempItem);
            return UserResponse.message("Picked up " + tempItem.getName() + ".");
		}
		else {
			return UserResponse.error("Sorry but I can't find any " + it);
		}
	}
	
	public UserResponse talkTo(String characterName) {
        NPC npc = location.getNPC(characterName);
        if (npc == null) {
            return UserResponse.error("There's nobody called " + characterName + " here.");
        }
        return UserResponse.message("I don't want to speak to them!");
	}
	
	public UserResponse use(String name1, String name2) {
        Item item1 = itemWithName(name1);
        if (item1 == null) {
            return UserResponse.error("You don't have a " + name1 + ".");
        }

        Item item2 = itemWithName(name2);
        if (item2 == null) {
            return UserResponse.error("You don't have a " + name2 + ".");
        }

        List<String> in = new ArrayList<String>();
        in.add(item1.getType());
        in.add(item2.getType());
        Set<Transformation> ts = transman.getTransformations(in);

        if (ts.isEmpty()) {
            return UserResponse.error("You can't do anything with a " + 
                    name1 + " and a " + name2 + "!");
        }
        else if (ts.size() > 1) {
            return UserResponse.error("Non unique combinations. Probably a bug.");
        }
        else {
            return ts.iterator().next().performTransformation(this);
        }
	}
}



