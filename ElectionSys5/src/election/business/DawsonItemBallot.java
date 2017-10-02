package election.business;

import election.business.interfaces.BallotItem;

public class DawsonItemBallot implements BallotItem {
	
	//hello
	private String choiceString;
	private int value;
	private final int maxValue;
	private static final long serialVersionUID = 42031768871L;
	
	
	public DawsonItemBallot(String choiceString, int maxValue){
		
		
		this.choiceString=choiceString;
		this.maxValue=maxValue;
		this.value=0;
		validateBallotItem();
		
		
	}
	
	public DawsonItemBallot(DawsonItemBallot item) {
		
		this.choiceString=getChoice();
		this.value=getValue();
		this.maxValue=getMaxValue();
		validateBallotItem(); 
		
	}
	
	public void validateBallotItem() {
		
		if (choiceString == null && maxValue <1 ) {
			
			throw new IllegalArgumentException("not valid");
		}
		
	}
	
@Override
	
	public final boolean equals(Object dawsonItemBallot){
	
	if(dawsonItemBallot == null) {
		return false;
	}

		  if (this instanceof DawsonItemBallot) {
			  
		  if (this.choiceString.equals(((DawsonItemBallot)dawsonItemBallot).getChoice())) {
			  
		    
		      return true;
		    
		  
		  }
		 
	}
		  return false; 
}

@Override

public int hashCode() {
	
	return this.getChoice().toLowerCase().hashCode();
	
	}

@Override

public String toString() {
	
	String choice=this.getChoice();
	int Value=this.getValue();
	
	
	
	return (choice + "*" + Value);
	
	
}


	
	public void setValue(int value) {
		
		if (!(0 <= value && value <= maxValue)) {
			
			throw new IllegalArgumentException("not valid");
		}
		
		this.value=value;
	}
	
	public String getChoice() {
		
		return this.choiceString;
	}
	
	
	public int getValue() {
		
		return value;
	}
	
	public int getMaxValue() {
		
		return maxValue;
	}
	
	public int compareTo(DawsonItemBallot item) {
		
		if(this.getChoice().compareToIgnoreCase(item.getChoice()) ==1) {
			
			return 1;
		}
	
	
	else if(this.getChoice().compareToIgnoreCase(item.getChoice()) ==1) {
		
		return -1;
	}
	
	else {
		
		return 0;
	}
	
}
	
	public int compareTo(BallotItem bItem) {
		
		return (this.compareTo(bItem));
	}

}
