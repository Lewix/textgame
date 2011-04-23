package textgame;

import java.util.*;

public abstract class ItemContainer {
	private List<Item> itemList;

    /**
     * Lets you initialise the ItemContainer with an existing List of items.
     *
     * @author Colin Rothwell
     */
    public ItemContainer(List<Item> itemList) {
        this.itemList = itemList;
    }
	
	protected ItemContainer(){
		itemList =  new ArrayList<Item>();
	}
	
	//add a newly created item in the container 
	protected void add(Item it){
		itemList.add(it);
	}
	
	//removes the item from the container 
	protected void remove(Item it){
		itemList.remove(it);
	}
	
	protected boolean contains(Item it){
		return itemList.contains(it);
	}
	
	protected Item contains(String s){
		for (Item it : itemList) {
			//if list contain an item with name equal to s return true
			if (it.getName().equals(s)) return it;
		}
		//if list does not contain an item with name equal to s return false
		return null;
	}
	
}
