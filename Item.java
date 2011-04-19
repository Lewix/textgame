import java.util.*;

public class Item {
	
	private String name;
	private String description;
	private List<Transformation> listTransformations;
	
	protected Item(int i, String n, String d) {
		name = n;
		description = d;
		listTransformations = new ArrayList<Transformation>();
	}
	
	protected String getName() {
		return name;
	}
	
	protected String getDescription() {
		return description;
	}
	
	//check if transormation is applicable for the item
	protected Transformation contain(String s) {
		for (Transformation tr : listTransformations) {
			//if list contain a transformation with name equal to s return true
			if (tr.getName().equals(s)) return tr;
		}
		//if list does not contain a transformation with name equal to s return false
		return null;
	}
	
}
