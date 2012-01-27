package textgame;

import java.util.*;

/**
 * Represents some way in which items can be transformed to make new items.
 * 
 * input is a list of String item types which are consumed from the user's
 * inventory.
 * output is a list of Items which are added to the user's inventory
 *
 * @author ColinRothwell
 *
 * @see Item
 */
public class Transformation {
	private String name;
    private List<String> input;
	private List<Item> output;
	
	public Transformation(String n, List<String> in, List<Item> out) {
		name = n;
        input = in;
        output = out;
	}
	
    public UserResponse performTransformation(ItemContainer player) {
        ArrayList<Item> consumed = new ArrayList<Item>();
        for (String type : input) {
            Item it = player.itemOfType(type);
            if (it == null) {
                return UserResponse.error("You must have an object of type " + type + " to " + name + ".");
            }
            consumed.add(it);
        }

        for (Item rem : consumed) {
            player.removeItem(rem);
        }

        for (Item add : output) {
            player.addItem(add);
        }

        return UserResponse.message("Removed " + ItemContainer.describeItems(consumed) +
                ", and added " + ItemContainer.describeItems(output) + ".");
    }

	public String getName() {
		return name;
	}

    public List<String> getInput() {
        return input;
    }
	
	public List<Item> getOutput() {
		return output;
	}
}
