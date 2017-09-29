package election.business;

import lib.email;

public class DawsonItemBallot implements BallotItem {
	
	
	private String choiceString;
	private int value;
	private final int maxValue;
	private static final long serialVersionUID = 42031768871L;
	
	
	public DawsonItemBallot(String choiceString, int maxValue){
		
		validateBallotItem();
		this.choiceString=choiceString;
		this.maxValue=maxValue;
		this.value=0;
		
		
	}
	
	public DawsonItemBallot(DawsonItemBallot item) {
		
		this.choiceString=getChoice();
		this.value=getValue();
		this.maxValue=getMaxValue();
		
	}
	
	public void validateBallotItem() {
		
		if (choiceString == null && maxValue <1 ) {
			
			throw new IllegalArgumentException("not valid");
		}
		
	}
	
@Override
	
	public boolean equals(Object DawsonItemBallot){

		  if (this instanceof DawsonItemBallot) {
			  
		  
		    if (DawsonItemBallot.toString().equalsIgnoreCase(this.getChoice())) {
		      
		      return true;
		    }
		  
		  }
		return false;  
	}	
	
	public void setValue(int value) {
		
		if (!(0 <= value && value <= maxValue)) {
			
			throw new IllegalArgumentException("not valid");
		}
		
		this.value=value;
	}
	

}
