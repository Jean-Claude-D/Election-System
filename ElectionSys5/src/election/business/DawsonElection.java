/**
 * 
 */
package election.business;

import java.time.DateTimeException;
import java.time.LocalDate;

import election.business.interfaces.Election;
import election.business.interfaces.Tally;

/**
 * @author Crusader2142
 *
 */
public class DawsonElection implements Election {
	private static final long serialVersionUID = 42031768871L;
	private String name;
	private String type;
	private ElectionType electType;
	private int startYear;
	private int startMonth;
	private int startDay;
	private LocalDate startDate;
	private int endYear;
	private int endMonth;
	private int endDay;
	private LocalDate endDate;
	private String startRange;
	private String endRange;
	private Tally tally;
	private String[] items;
	
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
		this.items = items;
		this.startDate = startDate;
		this.endDate = endDate;
		this.electType = electionTypeCheck(type);

		
	}
	

	public LocalDate getStartDate() {
		return startDate;
	}
	
	public LocalDate getEndDate() {
		return endDate;
	}
	
	public boolean isLimitedToPostalRange() {
		if ( (this.getPostalRangeStart() == null) || (this.getPostalRangeEnd() == null))
		{
			return false;
		}
		return true;
	}
	
	public StubBallot getBallot() {
		return //    THIS IS NOT FINISH   <=======================================================
	}
	
	public void setTally(Tally tally) {
		checkTally(tally);
		if (tally.getElectionName() != this.tally.getElectionName())
		{
			throw new IllegalArgumentException ("Name must be equal");
		}
		this.tally = tally;
	}
	
	public String getName() {
		return this.name;
	}
	
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
		throw new UnsupportedOperationException ("SHIT HAPPENED");
	}
	
	public int getInvalidVoteAttempts() {
		throw new UnsupportedOperationException ("SHIT HAPPENED");
	}
	
	@Override
	public String toString() {
	    String election = (this.name + "*" + startDate.getYear() + "*" + startDate.getMonthValue()
	    + "*" + startDate.getDayOfMonth() + "*" + endDate.getYear() + "*" + endDate.getMonthValue()
	    + "*" + endDate.getDayOfMonth() + "*" + this.startRange + "*" + this.endRange
	    + "*" + this.type );  //    THIS IS NOT FINISH   <=======================================================
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
//		ElectionType elecType[] = ElectionType.values();
//		if ( (!elecType[0].toString().equals(type)) || (!elecType[1].toString().equals(type)) ) {
//			throw new IllegalArgumentException ("INCORRECT TYPE");
//		}
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


}


