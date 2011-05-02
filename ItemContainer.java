package textgame;

import java.util.*;

public abstract class ItemContainer {
	private List<Item> itemList = new ArrayList<Item>();
	private int id;
	
	public ItemContainer(int i){
		id = i;
	}
	
	//add a newly created item in the container 
	public void addItem(Item it){
		itemList.add(it);
	}
	
	//removes the item from the container 
	public void removeItem(Item it){
		itemList.remove(it);
	}
	
	public boolean containsItem(Item it){
		return itemList.contains(it);
	}
	
	public Item contains(String s){
		for (Item it : itemList) {
			//if list contain an item with name equal to s return true
			if (it.getName().equals(s)) return it;
		}
		//if list does not contain an item with name equal to s return false
		return null;
	}
	
	public int getId(){
		return id;
	}
	
}
