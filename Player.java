package textgame;

import java.util.*;

public class Player extends ItemContainer {
	private int location;
	private final String name = "Player";
	private List<Room> map; // = new LinkedList<Room>;
	
	protected Player(){
		//TODO: initiate map
		//TODO: location = someIndex ;
	}
	
	//move the player to the room on his left
	protected void goLeft() {
		if (location>0) location--;
		else System.out.println("The way is blocked");
	}

	//move the player to the room on his right
	protected void goRight() {
		if (location<map.size()) location++;
		else System.out.println("The way is blocked");
	}
	
	public void lookAt(String it){
		Item tempItem = map.get(location).contains(it);
		if (tempItem != null) {
			System.out.println(tempItem.getDescription());
		}
		else {
			tempItem = this.contains(it);
			if (tempItem != null) {
				System.out.println(tempItem.getDescription());
			}
			else System.out.println("No such item around");
		}
	}
	
	public void pickUp(String it){
		Item tempItem = map.get(location).contains(it);
		if (tempItem != null) {
			this.add(tempItem);
			map.get(location).remove(tempItem);
		}
		else {
			System.out.println("Sorry but I can't find any " + it);
		}
	}
	
	public void talkTo(/*Some character*/ ){
		//TODO
	}
	
	public void use(String it1, String it2, String tr){
		Item tempItem1 = this.contains(it1);
		Item tempItem2 = this.contains(it2);
		
		if (tempItem1 == null) {
			System.out.println("Sorry but I don't own a " + it1);
		} else if (tempItem2 == null) {
			System.out.println("Sorry but I don't own a " + it2);			
		} else {
			Transformation tempTransformation = tempItem1.contain(tr);
			if (tempTransformation != null) {
				if (tempTransformation.getLocation().equals(map.get(location).getName())) {
					if (tempTransformation.getContributionItem().equals(it2)) {
						for (Item newIt : tempTransformation.getOutputItems()){
							this.add(newIt);
						}
						if (tempTransformation.contributionItemVanishes()) this.remove(tempItem2);
						if (tempTransformation.itemVanishes()) this.remove(tempItem1);
					} else System.out.println("Sorry but I can't " + tr + " " + it1 + " with " + it2);
				} else System.out.println("Sorry but I can't do that here");

			} else System.out.println("Sorry but I can't " + tr + " " + it1);
		}
	}
	
	public void use(String it1, String tr){
		Item tempItem1 = this.contains(it1);
		
		if (tempItem1 == null) {
			System.out.println("Sorry but I don't own a " + it1);			
		} else {
			Transformation tempTransformation = tempItem1.contain(tr);
			if (tempTransformation != null) {
				if (tempTransformation.getLocation().equals(map.get(location).getName())) {

						for (Item newIt : tempTransformation.getOutputItems()){
							this.add(newIt);
						}
						if (tempTransformation.itemVanishes()) this.remove(tempItem1);
				} else System.out.println("Sorry but I can't do that here");
			} else System.out.println("Sorry but I can't " + tr + " " + it1);
		}
	}
	
	
}

