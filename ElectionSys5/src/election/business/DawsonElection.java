
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
		this.ballotItems = checkItem(items);
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
	
	public String getPostalRangeStart() {
		return this.startRange;
	}
	
	
	public String getPostalRangeEnd() {
		return this.endRange;
	}
	
	
	
	public Tally getTally() {
		return this.tally;
	}
	
	public int getTotalVotesCast() {
		throw new UnsupportedOperationException ("THIS METHOD IS NOT SUPPORTED");
	}
	
	public int getInvalidVoteAttempts() {
		throw new UnsupportedOperationException ("THIS METHOD IS NOT SUPPORTED");
	}
		
	private void nullChecker (String check) {
		if ( (check == null) || (check.isEmpty()) )
		{
			throw new IllegalArgumentException ("IT'S NULL OR EMPTY");
		}
	}
	
	private void dateChecker (int y, int m, int d) {
		LocalDate currentDate = LocalDate.now();
		if ( (y < currentDate.getYear()) || (m < currentDate.getMonthValue()) || (d < currentDate.getDayOfMonth()))
		{
			throw new DateTimeException ("YOUR DATE IS IN THE PAST");
		}
	}
	
	private void validStartEnd (LocalDate start, LocalDate end) {
		if (end.isBefore(start))
		{
			throw new DateTimeException ("END DATE MUST BE BEFORE START DATE");
		}
	}
	
	private ElectionType electionTypeCheck (String type) {
		type = type.toUpperCase().trim();

		for (ElectionType elect : ElectionType.values()) {
			if (!elect.name().equals(type))
			{
				throw new IllegalArgumentException ("INCORRECT TYPE");
			}
		}
		return ElectionType.valueOf(type);
	}
	
	private void checkTally (Tally tally) {
		if (tally == null)
		{
			throw new IllegalArgumentException ("TALLY MUST NOT BE NULL");
		}
	}
	
	private BallotItem[] checkItem (String...items ) {
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
	
	@Override
	public String toString() {
	    String election = (this.name + "*" + startDate.getYear() + "*" + startDate.getMonthValue()
	    + "*" + startDate.getDayOfMonth() + "*" + endDate.getYear() + "*" + endDate.getMonthValue()
	    + "*" + endDate.getDayOfMonth() + "*" + this.startRange + "*" + this.endRange
	    + "*" + this.type + "*" +  ballotItems.length);  //    THIS IS NOT FINISH   <=======================================================
	   
	    for (int i = 0; i < ballotItems.length; i++)
	    {
	    	election += "\n" + ballotItems[i].toString();
	    }
	    return election;	
	}
	
	@Override
	public int compareTo(Election name) {
		if (name == null)
		{
			throw new IllegalArgumentException("Object Name is Null");
		}
		int check = this.getName().compareToIgnoreCase(name.getName());
		return check;
	}
	
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
	
	@Override
	public int hashCode() {
		return Objects.hash(this.getName());
	}
}