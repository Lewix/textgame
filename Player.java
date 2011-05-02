package textgame;

public class Player extends ItemContainer {
	
	private Room location;
	//map removed
	
	public Player(Room r){
		super(144); //id=144 restricted for player
		location = r;
	}
	
	//move the player to the specified room 
	public void goTo(Room r){
		//TODO: check if available and then this.location = r; else throw RestrictedAccess
	}
	
	public void lookAt(String it) throws MsgToUser {
		Item tempItem = location.contains(it);
		if (tempItem != null) {
			throw new MsgToUser(tempItem.getDescription());
		}
		else {
			tempItem = this.contains(it);
			if (tempItem != null) {
				throw new MsgToUser(tempItem.getDescription());
			}
			else throw new ErrMsg("No such item around");
		}
	}
	
	public void pickUp(String it) throws MsgToUser {
		Item tempItem = location.contains(it);
		if (tempItem != null) {
			this.addItem(tempItem);
			location.removeItem(tempItem);
		}
		else {
			throw new ErrMsg("Sorry but I can't find any " + it);
		}
	}
	
	public void talkTo(/*Some character*/ ){
		//TODO
	}
	
	public void use(String it1, String it2, String tr) throws MsgToUser {
		Item tempItem1 = this.contains(it1);
		Item tempItem2 = this.contains(it2);
		
		if (tempItem1 == null) {
			throw new ErrMsg("Sorry but I don't own a " + it1);
		} else if (tempItem2 == null) {
			throw new ErrMsg("Sorry but I don't own a " + it2);			
		} else {
			Transformation tempTransformation = tempItem1.contain(tr);
			if (tempTransformation != null) {
				if (tempTransformation.getLocation().equals(location.getId())) {
					if (tempTransformation.getContributionItem().equals(it2)) {
						for (Item newIt : tempTransformation.getOutputItems()){
							this.addItem(newIt);
						}
						if (tempTransformation.contributionItemVanishes()) this.removeItem(tempItem2);
						if (tempTransformation.itemVanishes()) this.removeItem(tempItem1);
					} else throw new ErrMsg("Sorry but I can't " + tr + " " + it1 + " with " + it2);
				} else throw new ErrMsg("Sorry but I can't do that here");

			} else throw new ErrMsg("Sorry but I can't " + tr + " " + it1);
		}
	}
	
	public void use(String it1, String tr) throws MsgToUser {
		Item tempItem1 = this.contains(it1);
		
		if (tempItem1 == null) {
			throw new ErrMsg("Sorry but I don't own a " + it1);			
		} else {
			Transformation tempTransformation = tempItem1.contain(tr);
			if (tempTransformation != null) {
				if (tempTransformation.getLocation().equals(location.getId())) {

						for (Item newIt : tempTransformation.getOutputItems()){
							this.addItem(newIt);
						}
						if (tempTransformation.itemVanishes()) this.removeItem(tempItem1);
				} else throw new ErrMsg("Sorry but I can't do that here");
			} else throw new ErrMsg("Sorry but I can't " + tr + " " + it1);
		}
	}
	
	
}



