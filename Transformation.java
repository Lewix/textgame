package textgame;

import java.util.*;

public class Transformation {
	private String name;
	private String contributionItem;
	private List<Item> listOutput;
	private Room location; //for transformations that can be performed everywhere location = "Player"
	private boolean itemAffected;
	private boolean contributionItemAffected;
	
	//creates a new transformation that requires the existencs of the iterm in1 
	public Transformation(String n, String in1, List<Item> lIt, Room l,boolean b1, boolean b2){
		name = n;
		contributionItem = in1;
		listOutput = lIt;
		location = l;
		itemAffected = b1;
		contributionItemAffected = b2;
	}
	
	//creates a new transformation that does not require the existence of an other object
	public Transformation(String n, List<Item> lIt, Room l, boolean b){
		name = n;
		contributionItem = null;
		listOutput = lIt;
		location = l;
		itemAffected = b;
		contributionItemAffected = false;
	}
	
	public String getName(){
		return name;
	}
	
	//checks whether a contribution item is needed fo the transformation to be applied
	public boolean hasContributionItem(String s){
		return (contributionItem != null);
	}
	
	public String getContributionItem() {
		return contributionItem;
	}
	
	public List<Item> getOutputItems(){
		return listOutput;
	}
	
	public Room getLocation(){
		return location;
	}
	
	public boolean itemVanishes() {
		return itemAffected;
	}
	
	public boolean contributionItemVanishes() {
		return contributionItemAffected;
	}
	
}
