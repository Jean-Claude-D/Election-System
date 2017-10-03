package election.business;


import java.time.LocalDate;

import election.business.interfaces.Tally;

public class DawsonElectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StubTally tally = new StubTally();
		
		testConstructor();
		testAllGetter("Canada Election", "SINGLE", 2017, 11, 25, 2018, 2, 20, "A", "J7E", tally, "H", "Jean Claude", "Fei", "Maria");
		testToString("Canada Election", "SINGLE", 2017, 11, 25, 2018, 2, 20, "A", "J7E", tally, "H", "Jean Claude", "Fei", "Maria");
		testIsLimitedToPostalRange("Canada Election", "SINGLE", 2017, 11, 25, 2018, 2, 20, "A", "J7E", tally, "H", "Jean Claude", "Fei", "Maria");
		testEquals();
		testCompareToAndHashcode();
	}
	
//	public DawsonElection(String name, String type, int startYear, int
//			startMonth, int startDay, int endYear, int endMonth, int endDay,
//			String startRange, String endRange, Tally tally, String... items )
	
	private static void testConstructor() {
		try {
			StubTally tally = new StubTally();

			DawsonElection newElection = new DawsonElection("Canada Election", "single", 2017, 11, 25, 2018, 2, 20
					,"A", "J7E", tally, "Me", "Jean Claude", "Stuff");
			System.out.println("Creating a DawsonElection with all valid arguments \t\t\t\t\t\t\t === TEST PASSED ===\n");
		}
		catch (Exception e){
			System.out.println("TEST FAILED");
		}
		
		try {
			StubTally tally = new StubTally();
			DawsonElection newElection = new DawsonElection(null, "single", 2017, 11, 25, 2018, 2, 20
					,"A", "J7E", tally, "Me", "Jean Claude", "Stuff");
			System.out.println("TEST FAILED");
		}
		catch (Exception e){
			System.out.println("Creating a DawsonElection with NULL name \t\t\t\t\t\t\t\t === TEST PASSED ===");
			System.out.println(e + "\n");
		}
		
		try {
			StubTally tally = new StubTally();
			DawsonElection newElection = new DawsonElection("President for Mars", null, 2017, 11, 25, 2018, 2, 20
					,"A", "J7E", tally, "Me", "Jean Claude", "Stuff");
			System.out.println("TEST FAILED");
		}
		catch (Exception e){
			System.out.println("Creating a DawsonElection with NULL type \t\t\t\t\t\t\t\t === TEST PASSED ===");
			System.out.println(e + "\n");
		}
		
		try {
			StubTally tally = new StubTally();
			DawsonElection newElection = new DawsonElection("", "", 2017, 11, 25, 2018, 2, 20
					,"A", "J7E", tally, "Me", "Jean Claude", "Stuff");
			System.out.println("TEST FAILED");
		}
		catch (Exception e){
			System.out.println("Creating a DawsonElection with Empty name and type \t\t\t\t\t\t\t === TEST PASSED ===");
			System.out.println(e + "\n");
		}
		
		try {
			StubTally tally = new StubTally();
			DawsonElection newElection = new DawsonElection("A", "Ranked", 2000, 11, 25, 2018, 2, 20
					,"A", "J7E", tally, "Me", "Jean Claude", "Stuff");
			System.out.println("TEST FAILED");
		}
		catch (Exception e){
			System.out.println("Creating a DawsonElection with a YEAR in the past \t\t\t\t\t\t\t === TEST PASSED ===");
			System.out.println(e + "\n");
		}
		
		try {
			StubTally tally = new StubTally();
			DawsonElection newElection = new DawsonElection("A", "Ranked", 2017, 2, 25, 2018, 2, 20
					,"A", "J7E", tally, "Me", "Jean Claude", "Stuff");
			System.out.println("TEST FAILED");
		}
		catch (Exception e){
			System.out.println("Creating a DawsonElection with a MONTH in the past \t\t\t\t\t\t\t === TEST PASSED ===");
			System.out.println(e + "\n");
		}
		
		try {
			StubTally tally = new StubTally();
			DawsonElection newElection = new DawsonElection("A", "Ranked", 2017, 10, 1, 2018, 2, 20
					,"A", "J7E", tally, "Me", "Jean Claude", "Stuff");
			System.out.println("TEST FAILED");
		}
		catch (Exception e){
			System.out.println("Creating a DawsonElection with a DAY in the past \t\t\t\t\t\t\t === TEST PASSED ===");
			System.out.println(e + "\n");
		}
		
		try {
			StubTally tally = new StubTally();
			DawsonElection newElection = new DawsonElection("A", "Ranked", 2018, 10, 30, 2018, 9, 20
					,"A", "J7E", tally, "Me", "Jean Claude", "Stuff");
			System.out.println("TEST FAILED");
		}
		catch (Exception e){
			System.out.println("Creating a DawsonElection with a endDate BEFORE startDate \t\t\t\t\t\t === TEST PASSED ===");
			System.out.println(e + "\n");
		}
		
		try {
			DawsonElection newElection = new DawsonElection("A", "Ranked", 2018, 10, 30, 2019, 9, 20
					,"A", "J7E", null, "Me", "Jean Claude", "Stuff");
			System.out.println("TEST FAILED");
		}
		catch (Exception e){
			System.out.println("Creating a DawsonElection with a null tally \t\t\t\t\t\t\t\t === TEST PASSED ===");
			System.out.println(e + "\n");
		}
		
		try {
			StubTally tally = new StubTally();
			DawsonElection newElection = new DawsonElection("A", "DICTATORIAL", 2018, 10, 30, 2019, 9, 20
					,"A", "J7E", tally, "Me", "Jean Claude", "Stuff");
			System.out.println("TEST FAILED");
		}
		catch (Exception e){
			System.out.println("Creating a DawsonElection with a type that is NOT in enum\t\t\t\t\t\t === TEST PASSED ===");
			System.out.println(e + "\n");
		}
	}
	
	private static void testAllGetter(String name, String type, int startYear, int
			startMonth, int startDay, int endYear, int endMonth, int endDay,
			String startRange, String endRange, Tally tally, String... items)
	{
		System.out.println("------------------------------------------------------- TEST GETTERS METHOD -------------------------------------------------------\n");
		LocalDate startDate = LocalDate.of (2017, 11, 25);
		LocalDate endDate = LocalDate.of (2018, 2, 20);

		DawsonElection newElection = new DawsonElection(name, type, startYear, startMonth, startDay, endYear, endMonth, endDay
				,startRange, endRange, tally, "H", "Jean Claude", "Feli", "Maria");
		
		System.out.println( (newElection.getName().equals(name)) ? "Name of the election is: " + newElection.getName() + "\t\t\t\t\t\t\t\t === TEST PASSED ===" : "TEST FAILED" );
		System.out.println();
		System.out.println( (newElection.getElectionType().toString().equalsIgnoreCase(type) ) ? "Type of the election is: " + newElection.getElectionType() + "\t\t\t\t\t\t\t\t\t\t === TEST PASSED ===" : "TEST FAILED\n" );
		System.out.println();
		System.out.println( (newElection.getStartDate().isEqual(startDate) ) ? "Start date of the election is: " + newElection.getStartDate() + "\t\t\t\t\t\t\t\t === TEST PASSED ===" : "TEST FAILED" );
		System.out.println();
		System.out.println( (newElection.getEndDate().isEqual(endDate) ) ? "End date of the election is: " + newElection.getEndDate() + "\t\t\t\t\t\t\t\t\t === TEST PASSED ===" : "TEST FAILED" );
		System.out.println();
		System.out.println( (newElection.getPostalRangeStart().equals(startRange) ? "Start Range of postal code is:  " + newElection.getPostalRangeStart() + "\t\t\t\t\t\t\t\t\t === TEST PASSED ===" : "TEST FAILED") );
		System.out.println();
		System.out.println( (newElection.getPostalRangeEnd().equals(endRange) ? "End Range of postal code is:  " + newElection.getPostalRangeEnd() + "\t\t\t\t\t\t\t\t\t === TEST PASSED ===" : "TEST FAILED") );
		System.out.println();
		System.out.println( (newElection.getTally() == tally) ? "Address memory of tally is: " + newElection.getTally() + "\t\t\t\t\t === TEST PASSED === " : "TEST FAILED");
		System.out.println();
	}
	
	private static void testToString(String name, String type, int startYear, int
			startMonth, int startDay, int endYear, int endMonth, int endDay,
			String startRange, String endRange, Tally tally, String... items ) {
		
		System.out.println("------------------------------------------------------- TEST toString() METHOD -----------------------------------------------------\n");
		DawsonElection newElection = new DawsonElection(name, type, startYear, startMonth, startDay, endYear, endMonth, endDay
				,startRange, endRange, tally, "H", "Jean Claude", "Feli", "Maria");
		
		String test = "Canada Election*2017*11*25*2018*2*20*A*J7E*SINGLE*4";
		test += "\nH";
		test += "\nJean Claude";
		test += "\nFeli";
		test += "\nMaria";
		
		System.out.println( (newElection.toString().equals(test) ? "test String is equal to DawsonElection's toString output\t\t\t\t\t\t === TEST PASSED ===" : "TEST FAILED") );
		System.out.println();
	}
	
	private static void testIsLimitedToPostalRange(String name, String type, int startYear, int
			startMonth, int startDay, int endYear, int endMonth, int endDay,
			String startRange, String endRange, Tally tally, String... items) {
		System.out.println("------------------------------------------------------- TEST isLimitedToPostalRange() METHOD ---------------------------------------\n");
		
		DawsonElection newElection = new DawsonElection(name, type, startYear, startMonth, startDay, endYear, endMonth, endDay
				,startRange, endRange, tally, "H", "Jean Claude", "Feli", "Maria");
		
		DawsonElection newElection2 = new DawsonElection(name, type, startYear, startMonth, startDay, endYear, endMonth, endDay
				,null,null , tally, "H", "Jean Claude", "Feli", "Maria");
		
		DawsonElection newElection3 = new DawsonElection(name, type, startYear, startMonth, startDay, endYear, endMonth, endDay
				,"","" , tally, "H", "Jean Claude", "Feli", "Maria");
		
		System.out.println( (newElection.isLimitedToPostalRange() ? "newElection has postal range\t\t\t\t\t\t\t\t\t\t === TEST PASSED ===" : "TEST FAILED\n") );
		System.out.println();
		System.out.println( (newElection2.isLimitedToPostalRange() ? "TEST FAILED" : "newElection2 does NOT have postal range\t\t\t\t\t\t\t\t\t === TEST PASSED ===") );
		System.out.println();
		System.out.println( (newElection3.isLimitedToPostalRange() ? "TEST FAILED" : "newElection3 does NOT have postal range\t\t\t\t\t\t\t\t\t === TEST PASSED ===") );
		System.out.println();
	}
	
	private static void testEquals() {
		System.out.println("------------------------------------------------------- TEST equals() METHOD -------------------------------------------------------\n");
		StubTally tally = new StubTally();
		
		String name = "Canada Election";
		String type = "SINGLE";
		String startRange = "A";
		String endRange = "J7E";
		
		String Choice1 = "H";
		String Choice2 = "Jean Claude";
		String Choice3 = "Felicia";
		String Choice4 = "Maria";

		DawsonElection newElection = new DawsonElection(name, type, 2017, 11, 25, 2018, 2, 20
				,startRange, endRange, tally, Choice1, Choice2, Choice3, Choice4);
		
		DawsonElection newElection2 = new DawsonElection(name, type, 2017, 11, 25, 2018, 2, 20
				,startRange, endRange, tally, Choice1, Choice2, Choice3, Choice4);
		
		DawsonElection newElection3 = new DawsonElection(name, type, 2017, 11, 25, 2018, 2, 20
				,startRange, endRange, tally, Choice1, Choice2, Choice3, Choice4);
		
		System.out.println( (newElection.equals(newElection2))  ? "FAILED" : newElection.getName() +" is NOT the same as " + newElection2.getName() + "\t\t\t\t\t\t\t\t === TEST PASSED ===");
		System.out.println();		
		System.out.println( (newElection.equals(newElection3))  ? newElection.getName() +" IS the same as " + newElection3.getName() + "\t\t\t\t\t\t\t\t === TEST PASSED ===" : "TEST FAILED");
		System.out.println();
		System.out.println( (newElection3.equals(newElection))  ? newElection3.getName() +" IS the same as " + newElection.getName() + "\t\t\t\t\t\t\t\t === TEST PASSED ===" : "TEST FAILED");
		System.out.println();
		System.out.println( (newElection3.equals(newElection2))  ? "FAILED" : newElection3.getName() +" is NOT the same as " + newElection2.getName() + "\t\t\t\t\t\t\t\t === TEST PASSED ===");
		System.out.println();
	}
	
	private static void testCompareToAndHashcode() {
		System.out.println("--------------------------------------------------- TEST compareTo() AND hashcode() METHOD -----------------------------------------\n");
		StubTally tally = new StubTally();
		
		String name = "Canada Election";
		String name2 = "US Election";
		String name3 = "Milky Way Galaxy Election";
		
		String type = "SINGLE";
		String startRange = "A";
		String endRange = "J7E";
		
		String Choice1 = "H";
		String Choice2 = "Jean Claude";
		String Choice3 = "Felicia";
		String Choice4 = "Maria";
		
		DawsonElection newElection = new DawsonElection(name, type, 2017, 11, 25, 2018, 2, 20
				,startRange, endRange, tally, Choice1, Choice2, Choice3, Choice4);
		
		DawsonElection newElection2 = new DawsonElection(name2, type, 2017, 11, 25, 2018, 2, 20
				,startRange, endRange, tally, Choice1, Choice2, Choice3, Choice4);
		
		DawsonElection newElection3 = new DawsonElection(name, type, 2017, 11, 25, 2018, 2, 20
				,startRange, endRange, tally, Choice1, Choice2, Choice3, Choice4);
		
		DawsonElection newElection4 = new DawsonElection(name3, type, 2017, 11, 25, 2018, 2, 20
				,startRange, endRange, tally, Choice1, Choice2, Choice3, Choice4);
		
		if ( (newElection.compareTo(newElection3) == 0) && (newElection.hashCode() == newElection3.hashCode()) ) {
			System.out.println("newElection and newElection3 are \"equal\", so they also have the SAME hashcode \t\t\t\t === TEST PASSED === ");
			System.out.println();
		}
		else
		{
			System.out.println("TEST FAILED");
		}
		
		if ( (newElection.compareTo(newElection2) < 0) && (newElection.hashCode() != newElection2.hashCode()) ) {
			System.out.println("newElection and newElection2 are NOT \"equal\", so they also have DIFFERENT hashcode \t\t\t === TEST PASSED === ");
			System.out.println();
		}
		else
		{
			System.out.println("TEST FAILED");
		}
		
		if ( (newElection4.compareTo(newElection) > 0) && (newElection4.hashCode() != newElection.hashCode()) ) {
			System.out.println("newElection4 and newElection are NOT \"equal\", so they also have DIFFERENT hashcode \t\t\t === TEST PASSED === ");
			System.out.println();
		}
		else
		{
			System.out.println("TEST FAILED");
		}	
	}
}
