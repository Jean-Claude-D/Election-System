/**
 * 
 */
package election.business;

import election.business.interfaces.Tally;

/**
 * @author Crusader2142
 *
 */
public class DawsonElection {
	private String name;
	private String type;
	private int startYear;
	private int startMonth;
	private int startDay;
	private int endYear;
	private int endMonth;
	private int endDay;
	private String startRange;
	private String endRange;
	private Tally tally;
	private String[] items;

}
