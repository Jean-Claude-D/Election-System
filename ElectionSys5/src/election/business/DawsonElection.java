
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
			String startRange, String endRange, Tally tally, String... items ) {
		
		nullChecker(name);
		nullChecker(type);
		
		dateChecker(startYear, startMonth, startDay);
		dateChecker(endYear, endMonth, endDay);
		
		LocalDate startDate = LocalDate.of (startYear, startMonth, startDay);
		LocalDate endDate = LocalDate.of (endYear, endMonth, endDay);
		
		validStartEnd(startDate, endDate);
		checkTally(tally);
		
		this.name = name;
		this.type = type;
		this.startRange = startRange;
		this.endRange = endRange;
		this.tally = tally;
		//this.ballotItems = checkItem(items);
		this.startDate = startDate;
		this.endDate = endDate;
		this.electType = electionTypeCheck(type);
	}
	
	/**
	 * Return the LocalDate representation of startDate of DawsonElection.
	 * @return startDate of This DawsonElection
	 */
	public LocalDate getStartDate() {
		return startDate;
	}
	
	/**
	 * Return the LocalDate representation of startDate of DawsonElection.
	 * @return endDate of This DawsonElection
	 */
	public LocalDate getEndDate() {
		return endDate;
	}
	
	/**
	 * Return the array of String representation of ballotItem of This DawsonElection.
	 * @return the String array.
	 */
	public String[] getElectionChoices() {
		String[] choices = new String[this.ballotItems.length];
		
		for (int i = 0; i < this.ballotItems.length; i++)
		{
			choices[i] = this.ballotItems[i].toString();
		}
		return choices;
	}
	
	/**
	 * Return the StubBallot of This DawsonElection
	 * @return StubBallot
	 */
	public StubBallot getBallot() {
		BallotItem[] temp = new BallotItem[this.ballotItems.length];
		
		for (int i = 0; i < this.ballotItems.length; i++)
		{
			temp[i] = this.ballotItems[i];
		}
		StubBallot stubBallot = new StubBallot(this.ballotItems, this);
		return stubBallot;
	}
	
	/**
	 * Return the Ballot of This DawsonElection
	 * @return Ballot
	 * @param v the Voter object
	 * @throws IllegalArgumentException when voter is not eligible
	 */
	public Ballot getBallot(Voter v) {
		if(v.isEligible(this)) {
			return (Ballot) this.getBallot();
		}
		throw new IllegalArgumentException ("Voter is not eligible");
	}

	/**
	 * Return true if both postalRange Start and End are NOT null
	 * @return boolean
	 */
	public boolean isLimitedToPostalRange() {
		if ( (this.getPostalRangeStart() == null) || (this.getPostalRangeEnd() == null))
		{
			return false;
		}
		return true;
	}
	
	/**
	 * Update tally if voter isEligible
	 * @throws IllegalArgumentException when voter is not eligible
	 * @param b the Ballot object
	 * @param v the Voter bject
	 */
	public void castBallot(Ballot b, Voter v) {
		if (!v.isEligible(this))
		{
			throw new UnsupportedOperationException ("VOTER IS NOT ELIGIBLE");
		}
		b.validateSelections();
		this.tally.update(b);
	}
	
	/**
	 * Set the value of Tally object
	 * @throws IllegalArgumentException when Name of the Tallies are not equal
	 * @param tally the Tally object
	 */
	public void setTally(Tally tally) {
		checkTally(tally);
		if (tally.getElectionName() != this.tally.getElectionName())
		{
			throw new IllegalArgumentException ("Name must be equal");
		}
		this.tally = tally;
	}
	
	/**
	 * Return the name of This DawsonElection
	 * @return This name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Set the ElectionType of
	 * @return This ElectionType
	 */
	public ElectionType getElectionType() {
		return this.electType;
	}
	
	/**
	 * Return startRange as String of This DawsonElection
	 * @return This DawsonElection startRange
	 */
	public String getPostalRangeStart() {
		return this.startRange;
	}
	
	/**
	 * Return endRange as String of This DawsonElection
	 * @return This DawsonElection endRange
	 */
	public String getPostalRangeEnd() {
		return this.endRange;
	}
	
	
	/**
	 * Return tally as Tally object
	 * @return This Dawsoncollege Tally
	 */
	public Tally getTally() {
		return this.tally;
	}
	
	/**
	 * Method is not yet available
	 * @throws UnsupportedOperationException
	 */
	public int getTotalVotesCast() {
		throw new UnsupportedOperationException ("THIS METHOD IS NOT SUPPORTED");
	}
	
	/**
	 * Method is not yet available
	 * @throws UnsupportedOperationException
	 */
	public int getInvalidVoteAttempts() {
		throw new UnsupportedOperationException ("THIS METHOD IS NOT SUPPORTED");
	}
	
	/**
	 * Check to see if a String is null or not
	 * @throws IllegalArgumentException when String is null
	 */
	private void nullChecker (String check) {
		if ( (check == null) || (check.isEmpty()) )
		{
			throw new IllegalArgumentException ("IT'S NULL OR EMPTY");
		}
	}
	
	/**
	 * Check if the parameter y, m, d are valid and logical or not.
	 * @param y year as 4+ digits number. E.g. 1990
	 * @param m month as 2 digits number. E.g 05 or 12
	 * @param d day as 2+ digits number. E.g 02 or 26
	 * @throws DateTimeException when the data is invalid or inconsistent
	 */
	private void dateChecker (int y, int m, int d) {
		LocalDate currentDate = LocalDate.now();
		if ( (y < currentDate.getYear()) && (m < currentDate.getMonthValue()) && (d < currentDate.getDayOfMonth()))
		{
			throw new DateTimeException ("YOUR DATE IS IN THE PAST");
		}
	}
	
	/**
	 * Check if the LocalDate start and LocalDate end are logical
	 * @param start LocalDate of This DawsonCollege
	 * @param end LocalDate of This DawsonCollege
	 */
	private void validStartEnd (LocalDate start, LocalDate end) {
		if (end.isBefore(start))
		{
			throw new DateTimeException ("END DATE MUST BE BEFORE START DATE");
		}
	}
	
	/**
	 * 
	 * @param type the String representation of type of This DawsonElection
	 * @return the correct enum value of ElectionType
	 */
	private ElectionType electionTypeCheck (String type) {
		type = type.toUpperCase().trim();
		return ElectionType.valueOf(type);
	}
	
	/**
	 * Check if Tally object is null or not
	 * @param tally the Tally object
	 * @throws IllegalArgumentException when Tally object is null
	 */
	private void checkTally (Tally tally) {
		if (tally == null)
		{
			throw new IllegalArgumentException ("TALLY MUST NOT BE NULL");
		}
	}
	
	/**
	 * 
	 * @param items varargs
	 * @return BallotItem array of all This DawsonElection items
	 * @throws IllegalArgumentException when there is less that 2 items
	 */
//	private BallotItem[] checkItem (String...items ) {
//		if (items.length < 2)
//		{
//			throw new IllegalArgumentException ("THERE MUST BE AT LEAST 2 ITEMS");
//		}
//		BallotItem[] choices = new BallotItem[items.length];
//		
//		for (int i = 0; i < items.length; i++)
//		{
//			choices[i] = new DawsonBallotItem(items[i], items.length);
//		}
//		return choices;
//	}
	
	/**
	 * Return a String in this format:
	 * name*Y*M*D*endY*endM*endD*startPcode*endPcode*electtype*numOpts
	 * choice1
	 * choice2
	 * @return the String representation of This DawsonElection
	 */
	@Override
	public String toString() {
	    String election = (this.name + "*" + startDate.getYear() + "*" + startDate.getMonthValue()
	    + "*" + startDate.getDayOfMonth() + "*" + endDate.getYear() + "*" + endDate.getMonthValue()
	    + "*" + endDate.getDayOfMonth() + "*" + this.startRange + "*" + this.endRange
	    + "*" + this.type + "*" +  ballotItems.length);  //    
	   
	    for (int i = 0; i < ballotItems.length; i++)
	    {
	    	election += "\n" + ballotItems[i].toString();
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
	public int compareTo(Election name) {
		if (name == null)
		{
			throw new IllegalArgumentException("Object Name is Null");
		}
		int check = this.getName().compareToIgnoreCase(name.getName());
		return check;
	}
	
	/**
	 * Check if an Object is equal to DawsonCollege object
	 * @return true if they are equal, false otherwise
	 * @param object of type Object
	 */
	@Override
	public boolean equals(Object object) {
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
			if ( ((DawsonElection)object).getName().equalsIgnoreCase(this.getName())  )
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
	public int hashCode() {
		return Objects.hash(this.getName());
	}
}