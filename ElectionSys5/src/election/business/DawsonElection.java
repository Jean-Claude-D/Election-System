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
		
		electionTypeCheck(type);
		ElectionType.valueOf(type.toUpperCase().trim());
		
		checkTally(tally);
		
		this.name = name;
		this.type = type;
		this.startRange = startRange;
		this.endRange = endRange;
		this.tally = tally;
		this.items = items;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public LocalDate getStartDate( ) {
		return startDate;
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
	
	private void electionTypeCheck (String type) {
		ElectionType elecType[] = ElectionType.values();
		if ( (!elecType[0].toString().equals(type)) || (!elecType[1].toString().equals(type)) ) {
			throw new IllegalArgumentException ("INCORRECT TYPE");
		}
	}
	
	private void checkTally (Tally tally) {
		if (tally == null)
		{
			throw new IllegalArgumentException ("TALLY MUST NOT BE NULL");
		}
	}


}
