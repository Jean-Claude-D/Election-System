package election.business;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Objects;
import election.business.interfaces.Ballot;
import election.business.interfaces.BallotItem;
import election.business.interfaces.Election;
import election.business.interfaces.Tally;
import election.business.interfaces.Voter;

/**
 * Name Class represents by 4 Strings: name, type, startRange, endRange.
 * 2 LocalDate objects: startDate and endDate.
 * 1 Tally object: tally.
 * 1 Array of BallotItem.
 * 1 enum ElectionType.
 * @author Cao Hoang Nguyen
 * @version 1.5
 */
public class DawsonElection implements Election {
	private static final long serialVersionUID = 42031768871L;
	private String name;
	private String type;
	private ElectionType electType;
	private LocalDate startDate;
	private LocalDate endDate;
	private String startRange;
	private String endRange;
	private Tally tally;
	private BallotItem[] ballotItems;
	
	public DawsonElection(String name, String type, int startYear, int
			startMonth, int startDay, int endYear, int endMonth, int endDay,
			String startRange, String endRange, Tally tally, String... items ) {								// Constructor
		
		try {
		this.startDate = LocalDate.of (startYear, startMonth, startDay); 
		this.endDate = LocalDate.of (endYear, endMonth, endDay);
		
		if ( this.startDate.isBefore(LocalDate.now()) )
				{
					throw new IllegalArgumentException("YOUR START DATE IS IN THE PASS");
				}
		}
		catch (DateTimeException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		
		startEndDateChecker(startDate, endDate);	
		tallyChecker(tally);
		
		this.name = nullChecker(name);
		this.type = nullChecker(type);
		this.startRange = startRange;
		this.endRange = endRange;
		this.tally = tally;
		this.ballotItems = checkItem(items);
		this.electType = electionTypeChecker(type);
	}

	
	// ============================================== CHECKER/VALIDATE METHODS ================================================= \\
	
	
	/**
	 * Check to see if a String is null or not
	 * @throws IllegalArgumentException when String is null
	 */
	private String nullChecker (String check) {																	// nullChecker

		if (check == null)
		{
			throw new IllegalArgumentException ("THE NAME OR TYPE OF THE ELECTION IS NULL OR EMPTY");
		}
		
		check.trim();
		
		if (check.isEmpty())
		{
			throw new IllegalArgumentException ("THE NAME OR TYPE OF THE ELECTION IS NULL OR EMPTY");
		}
		return check;
	}
	
	/**
	 * Check if the LocalDate start and LocalDate end are logical
	 * @param start LocalDate of This DawsonCollege
	 * @param end LocalDate of This DawsonCollege
	 */
	private void startEndDateChecker (LocalDate start, LocalDate end) {											// startEndDateChecker
		if (end.isBefore(start))
		{
			throw new IllegalArgumentException ("END DATE: " + end.toString() + " MUST BE BEFORE START DATE: " + start.toString());
		}
	}
	
	/**
	 * Return the corresponding value of enum accordin to String type
	 * @param type the String representation of type of This DawsonElection
	 * @return the correct enum value of ElectionType
	 * @throws exception if the String type is not found in the enum.
	 */
	private ElectionType electionTypeChecker (String type) {													// electionTypeChecker
		type = type.toUpperCase().trim();
		
		try {
		return ElectionType.valueOf(type);
		}
		catch (IllegalArgumentException e){
			throw new IllegalArgumentException("Election type is incorrect \n"+ e.getMessage());
		}
	}
	
	/**
	 * Check if Tally object is null or not
	 * @param tally the Tally object
	 * @throws IllegalArgumentException when Tally object is null
	 */
	private void tallyChecker (Tally tally) {																	// tallyChecker
		if (tally == null)
		{
			throw new IllegalArgumentException ("TALLY MUST NOT BE NULL");
		}
	}
	
	/**
	 * Return true if both postalRange Start and End are NOT null
	 * @return boolean
	 */
	public boolean isLimitedToPostalRange() {  																	// isLimitedToPostalRange
		if ( (this.startRange == null) || (this.endRange == null)
				|| (this.startRange.isEmpty()) || (this.endRange.isEmpty()) )
		{
		return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @param items varargs
	 * @return BallotItem array of all This DawsonElection items
	 * @throws IllegalArgumentException when there is less that 2 items
	 */
	private BallotItem[] checkItem (String...items ) {															// checkItem
		if (items.length < 2)
		{
			throw new IllegalArgumentException ("THERE MUST BE AT LEAST 2 ITEMS");
		}
		BallotItem[] choices = new BallotItem[items.length];
		
		for (int i = 0; i < items.length; i++)
		{
			choices[i] = new DawsonBallotItem(items[i], items.length);
		}
		return choices;
	}
		

	// ============================================== END CHECKER/VALIDATE METHODS ============================================== \\
	
	
	
	

	// ==============================================  GETTERS METHODS =========================================================== \\
	
	
	/**
	 * Return the LocalDate representation of startDate of DawsonElection.
	 * @return startDate of This DawsonElection
	 */
	public LocalDate getStartDate() {																			// getStartDate
		return startDate;
	}
	
	/**
	 * Return the LocalDate representation of startDate of DawsonElection.
	 * @return endDate of This DawsonElection
	 */
	public LocalDate getEndDate() {																				// getEndDate
		return endDate;
	}
	
	/**
	 * Return the array of String representation of ballotItem of This DawsonElection.
	 * @return the String array.
	 */
	public String[] getElectionChoices() {																		// getElectionChoices
		String[] choices = new String[this.ballotItems.length];
		
		for (int i = 0; i < choices.length; i++)
		{
			choices[i] = this.ballotItems[i].getChoice();
		}
		return choices;
	}
	
	/**
	 * Return the name of This DawsonElection
	 * @return This name
	 */
	public String getName() {																					// getName
		return this.name;
	}
	
	/**
	 * Set the ElectionType of
	 * @return This ElectionType
	 */
	public ElectionType getElectionType() {																		// getElectionType
		return this.electType;
	}
	
	/**
	 * Return the StubBallot of This DawsonElection
	 * @return StubBallot
	 */
	private StubBallot getBallot() {																				// getBallot
		BallotItem[] temp = new BallotItem[this.ballotItems.length];
		
		for (int i = 0; i < this.ballotItems.length; i++)
		{
			temp[i] = this.ballotItems[i];
		}
		StubBallot stubBallot = new StubBallot(this.ballotItems, this);
		return stubBallot;
	}
	
	/**
	 * Return startRange as String of This DawsonElection
	 * @return This DawsonElection startRange
	 */
	public String getPostalRangeStart() {																		// getPostalRangeStart
		return this.startRange;
	}
	
	/**
	 * Return endRange as String of This DawsonElection
	 * @return This DawsonElection endRange
	 */
	public String getPostalRangeEnd() {																			// getPostalRangeEnd
		return this.endRange;
	}
	
	/**
	 * Return tally as Tally object
	 * @return This Dawsoncollege Tally
	 */
	public Tally getTally() {																					// getTally
		return this.tally;
	}
	
	/**
	 * Return the Ballot of This DawsonElection
	 * @return Ballot
	 * @param v the Voter object
	 * @throws IllegalArgumentException when voter is not eligible
	 */
	public Ballot getBallot(Voter v) {																			// getBallot
		if(v.isEligible(this)) {
			return (Ballot) this.getBallot();
		}
		throw new IllegalArgumentException ("Voter is not eligible");
	}
	
	// ==============================================  END GETTERS METHODS ============================================== \\
	
	
	

	// ==============================================  SETTERS METHODS =================================================== \\

	
	/**
	 * Set the value of Tally object
	 * @throws IllegalArgumentException when Name of the Tallies are not equal
	 * @param tally the Tally object
	 */
	public void setTally(Tally tally) {																			// setTally
		tallyChecker(tally);
		if (tally.getElectionName().equals(this.tally.getElectionName()) )
		{
			throw new IllegalArgumentException ("Name must be equal");
		}
		this.tally = tally;
	}
	
	// ==============================================  END SETTERS METHODS ================================================ \\
	
	
	
	
	// ==============================================  OTHERS METHODS ====================================================== \\
	
	
	/**
	 * Update tally if voter isEligible
	 * @throws IllegalArgumentException when voter is not eligible
	 * @param b the Ballot object
	 * @param v the Voter bject
	 */
	public void castBallot(Ballot b, Voter v) {																	// castBallot
		if (!v.isEligible(this))
		{
			throw new UnsupportedOperationException ("VOTER IS NOT ELIGIBLE");
		}
		b.validateSelections();
		this.tally.update(b);
	}
	
	/**
	 * Method is not yet available
	 * @throws UnsupportedOperationException
	 */
	public int getTotalVotesCast() {																			// getTotalVotesCast
		throw new UnsupportedOperationException ("THIS METHOD IS NOT SUPPORTED");
	}
	
	/**
	 * Method is not yet available
	 * @throws UnsupportedOperationException
	 */
	public int getInvalidVoteAttempts() {																		// getInvalidVoteAttempts
		throw new UnsupportedOperationException ("THIS METHOD IS NOT SUPPORTED");
	}
	
	// ==============================================  END OTHERS METHODS =================================================== \\
	
	
	
	
	// ==============================================  OVERRIDED METHODS ====================================================== \\
	
	
	/**
	 * Return a String in this format:
	 * name*Y*M*D*endY*endM*endD*startPcode*endPcode*electtype*numOpts
	 * choice1
	 * choice2
	 * @return the String representation of This DawsonElection
	 */
	@Override
	public String toString() {																					// toString
	    String election = (this.name + "*" + startDate.getYear() + "*" + startDate.getMonthValue()
	    + "*" + startDate.getDayOfMonth() + "*" + endDate.getYear() + "*" + endDate.getMonthValue()
	    + "*" + endDate.getDayOfMonth() + "*" + this.startRange + "*" + this.endRange
	    + "*" + this.type + "*" +  ballotItems.length);  //    
	   
	    for (int i = 0; i < ballotItems.length; i++)
	    {
	    	election += "\n" + ballotItems[i].getChoice();
	    }
	    return election;	
	}
	
	/**
	 * Compare two Election objects to see if they are equal or not
	 * @return 0 if they are equal, negative integer if name greater than This DawsonElection,
	 * positive if vice versa
	 * @param name as Election object
	 */
	@Override
	public int compareTo(Election name) {																		// compareTo
		if (name == null)
		{
			throw new IllegalArgumentException("Object Name is Null");
		}
		int check = this.getName().compareTo(name.getName());
		return check;
	}
	
	/**
	 * Check if an Object is equal to DawsonCollege object
	 * @return true if they are equal, false otherwise
	 * @param object of type Object
	 */
	@Override
	public boolean equals(Object object) {																		// equals
		if (this == object)
		{
			return true;
		}
		if (object == null)
		{	
			return false;
		}
		if (object instanceof DawsonElection)
		{
			if ( ((DawsonElection)object).getName().equals(this.getName())  )
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Return the hascode of This DawsonCollege
	 * @return Object DawsonCollege hashcode.
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {																						// hashCode
		return Objects.hash(this.getName());
	}
	
	// ==============================================  END OVERRIDED METHODS ====================================================== \\
}
