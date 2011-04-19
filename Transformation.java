import java.util.*;

public class Transformation {
	private String name;
	private String contributionItem;
	private List<Item> listOutput;
	private String location; //for transformations that can be performed everywhere location = "Player"
	private boolean itemAffected;
	private boolean contributionItemAffected;
	
	//creates a new transformation that requires the existencs of the iterm in1 
	protected Transformation(String n, String in1, List<Item> lIt, String l,boolean b1, boolean b2){
		name = n;
		contributionItem = in1;
		listOutput = lIt;
		location = l;
		itemAffected = b1;
		contributionItemAffected = b2;
	}
	
	//creates a new transformation that does not require the existence of an other object
	protected Transformation(String n, List<Item> lIt, String l, boolean b){
		name = n;
		contributionItem = null;
		listOutput = lIt;
		location = l;
		itemAffected = b;
		contributionItemAffected = false;
	}
	
	protected String getName(){
		return name;
	}
	
	//checks whether a contribution item is needed fo the transformation to be applied
	protected boolean hasContributionItem(String s){
		return (contributionItem != null);
	}
	
	protected String getContributionItem() {
		return contributionItem;
	}
	
	protected List<Item> getOutputItems(){
		return listOutput;
	}
	
	protected String getLocation(){
		return location;
	}
	
	protected boolean itemVanishes() {
		return itemAffected;
	}
	
	protected boolean contributionItemVanishes() {
		return contributionItemAffected;
	}
	
}
