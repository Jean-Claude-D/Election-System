/**
 * 
 * @author Maria Hossain
 * @since Oct. 2nd 2017
 */


package election.business;

import election.business.interfaces.BallotItem;

public class DawsonItemBallot implements BallotItem {
	
	
	private String choiceString;
	private int value;
	private final int maxValue;
	private static final long serialVersionUID = 42031768871L;
	
	
	/**
	 * 
	 * The constructor takes in 2 parameter to create the DawsonItemBallot which
	 * is the Choice and the MaxValue
	 * 
	 * @param choiceString
	 * @param maxValue
	 */
	
	
	public DawsonItemBallot(String choiceString, int maxValue){
		
		
		this.choiceString=choiceString;
		this.maxValue=maxValue;
		this.value=0;
		validateBallotItem();
		
		
	}
	
	/**
	 * 
	 * This is the copy constructor that takes a DawsonItemBallot Object as a parameter
	 * DawsonItemBallot objet.
	 * @param item
	 */
	
	public DawsonItemBallot(DawsonItemBallot item) {
		
		this.choiceString=getChoice();
		this.value=getValue();
		this.maxValue=getMaxValue();
		validateBallotItem(); 
		
	}
	
	/**
	 * 
	 * This method makes sure that the choice is not null and that the maxValue 
	 * is not lower than 1 
	 */
	
	public void validateBallotItem() {
		
		if (choiceString == null && maxValue <1 ) {
			
			throw new IllegalArgumentException("not valid");
		}
		
	}
	
	/**
	 * This methods check that the object is of the same instance as DawsonItemBallot
	 * 
	 * And that the choice is the same
	 * 
	 */
	
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

/**
 * 
 * This method returns the hash code of the choice.
 */

@Override

public int hashCode() {
	
	return this.getChoice().toLowerCase().hashCode();
	
	}

/**
 * 
 * This overriden toString() method return a string that has the value and choice
 * with a '*' delimeter. 
 * 
 * For example it returns
 * 
 * choice*value
 */

@Override

public String toString() {
	
	String choice=this.getChoice();
	int Value=this.getValue();
	
	
	
	return (choice + "*" + Value);
	
	
}

/**
 * 
 * Method set the value field to another value. It makes sure it is not greater than MaxValue
 */


	
	public void setValue(int value) {
		
		if (!(0 <= value && value <= maxValue)) {
			
			throw new IllegalArgumentException("not valid");
		}
		
		this.value=value;
	}
	
	/**
	 * 
	 * Returns the current choice
	 */
	
	public String getChoice() {
		
		return this.choiceString;
	}
	
	
	/**
	 * 
	 * Returns the current value
	 */
	public int getValue() {
		
		return value;
	}
	
	
	/**
	 * 
	 * Returns the current MaxValue
	 */
	
	public int getMaxValue() {
		
		return maxValue;
	}
	
	/**
	 * 
	 * Returns int that represent if one choice is greater than the lexicographical order
	 *  
	 *  0=equal
	 *  1= Greater than
	 *  -1= Less than
	 *  
	 * @param item
	 * @return
	 */
	
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
	
	/**
	 * 
	 * Compare an object to the BollotItem
	 */
	
	public int compareTo(BallotItem bItem) {
		
		return (this.compareTo(bItem));
	}

}
