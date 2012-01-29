package textgame;

import java.util.*;

public class Item {
    private String type;
	private String name;
	private String description;
	
	public Item(String t, String n, String d) {
        type = t;
		name = n;
		description = d;
	}

    public String getType() {
        return type;
    }
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
}
