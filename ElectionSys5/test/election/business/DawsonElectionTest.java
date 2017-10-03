package election.business;


import java.time.LocalDate;

public class DawsonElectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testConstructor();
		testAllGetter();
	//	testToString();
		testEquals();
	}
	
//	public DawsonElection(String name, String type, int startYear, int
//			startMonth, int startDay, int endYear, int endMonth, int endDay,
//			String startRange, String endRange, Tally tally, String... items )
	
	private static void testConstructor() {
		try {
			StubTally tally = new StubTally();

			DawsonElection newElection = new DawsonElection("Canada Election", "single", 2017, 11, 25, 2018, 2, 20
					,"A", "J7E", tally, "Me", "Jean Claude", "Stuff");
			System.out.println("Creating a DawsonElection with all valid arguments \t\t\t\t\t === TEST PASSED ===\n");
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
			System.out.println("Creating a DawsonElection with NULL name \t\t\t\t\t\t === TEST PASSED ===");
			System.out.println(e + "\n");
		}
		
		try {
			StubTally tally = new StubTally();
			DawsonElection newElection = new DawsonElection("President for Mars", null, 2017, 11, 25, 2018, 2, 20
					,"A", "J7E", tally, "Me", "Jean Claude", "Stuff");
			System.out.println("TEST FAILED");
		}
		catch (Exception e){
			System.out.println("Creating a DawsonElection with NULL type \t\t\t\t\t\t === TEST PASSED ===");
			System.out.println(e + "\n");
		}
		
		try {
			StubTally tally = new StubTally();
			DawsonElection newElection = new DawsonElection("", "", 2017, 11, 25, 2018, 2, 20
					,"A", "J7E", tally, "Me", "Jean Claude", "Stuff");
			System.out.println("TEST FAILED");
		}
		catch (Exception e){
			System.out.println("Creating a DawsonElection with Empty name and type \t\t\t\t\t === TEST PASSED ===");
			System.out.println(e + "\n");
		}
		
		try {
			StubTally tally = new StubTally();
			DawsonElection newElection = new DawsonElection("A", "Ranked", 2000, 11, 25, 2018, 2, 20
					,"A", "J7E", tally, "Me", "Jean Claude", "Stuff");
			System.out.println("TEST FAILED");
		}
		catch (Exception e){
			System.out.println("Creating a DawsonElection with a YEAR in the past \t\t\t\t\t === TEST PASSED ===");
			System.out.println(e + "\n");
		}
		
		try {
			StubTally tally = new StubTally();
			DawsonElection newElection = new DawsonElection("A", "Ranked", 2017, 2, 25, 2018, 2, 20
					,"A", "J7E", tally, "Me", "Jean Claude", "Stuff");
			System.out.println("TEST FAILED");
		}
		catch (Exception e){
			System.out.println("Creating a DawsonElection with a MONTH in the past \t\t\t\t\t === TEST PASSED ===");
			System.out.println(e + "\n");
		}
		
		try {
			StubTally tally = new StubTally();
			DawsonElection newElection = new DawsonElection("A", "Ranked", 2017, 10, 1, 2018, 2, 20
					,"A", "J7E", tally, "Me", "Jean Claude", "Stuff");
			System.out.println("TEST FAILED");
		}
		catch (Exception e){
			System.out.println("Creating a DawsonElection with a DAY in the past \t\t\t\t\t === TEST PASSED ===");
			System.out.println(e + "\n");
		}
		
		try {
			StubTally tally = new StubTally();
			DawsonElection newElection = new DawsonElection("A", "Ranked", 2018, 10, 30, 2018, 9, 20
					,"A", "J7E", tally, "Me", "Jean Claude", "Stuff");
			System.out.println("TEST FAILED");
		}
		catch (Exception e){
			System.out.println("Creating a DawsonElection with a endDate BEFORE startDate \t\t\t\t === TEST PASSED ===");
			System.out.println(e + "\n");
		}
	}
	
//	private static void testToString() {
//		StubTally tally = new StubTally();
//		LocalDate startDate = LocalDate.of (2017, 11, 25);
//		LocalDate endDate = LocalDate.of (2018, 2, 20);
//		DawsonElection newElection = new DawsonElection("Canada Election", "SINGLE", 2017, 11, 25, 2018, 2, 20
//				,"A", "J7E", tally, "Me", "Jean Claude", "Feli", "Maria");
//		
//		System.out.println(newElection.toString());
//	}
	
	
	
	private static void testAllGetter() {
		System.out.println("----------- Test getter methodS -----------\n");
		StubTally tally = new StubTally();
		LocalDate startDate = LocalDate.of (2017, 11, 25);
		LocalDate endDate = LocalDate.of (2018, 2, 20);

		DawsonElection newElection = new DawsonElection("Canada Election", "SINGLE", 2017, 11, 25, 2018, 2, 20
				,"A", "J7E", tally, "Me", "Jean Claude", "Feli", "Maria");
		
		System.out.println( (newElection.getName().equals("Canada Election") ) ? "Name of the election is: " + newElection.getName() + "\t\t\t\t\t\t === TEST PASSED ===" : "TEST FAILED" );
		System.out.println();
		System.out.println( (newElection.getElectionType().toString().equalsIgnoreCase("SINGLE") ) ? "Type of the election is: " + newElection.getElectionType() + "\t\t\t\t\t\t\t\t === TEST PASSED ===" : "TEST FAILED\n" );
		System.out.println();
		System.out.println( (newElection.getStartDate().isEqual(startDate) ) ? "Start date of the election is: " + newElection.getStartDate() + "\t\t\t\t\t\t === TEST PASSED ===" : "TEST FAILED" );
		System.out.println();
		System.out.println( (newElection.getEndDate().isEqual(endDate) ) ? "End date of the election is: " + newElection.getEndDate() + "\t\t\t\t\t\t\t === TEST PASSED ===" : "TEST FAILED" );
		System.out.println();
		
	}
	
	private static void testEquals() {
		System.out.println("----------- Test equals() method -----------\n");
		StubTally tally = new StubTally();

		DawsonElection newElection = new DawsonElection("Canada Election", "SINGLE", 2017, 11, 25, 2018, 2, 20
				,"A", "J7E", tally, "Me", "Jean Claude", "Feli", "Maria");
		
		DawsonElection newElection2 = new DawsonElection("US Election", "SINGLE", 2017, 11, 25, 2018, 2, 20
				,"A", "J7E", tally, "Me", "Jean Claude", "Feli", "Maria");
		
		DawsonElection newElection3 = new DawsonElection("Canada Election", "SINGLE", 2017, 11, 25, 2018, 2, 20
				,"A", "J7E", tally, "Me", "Jean Claude", "Feli", "Maria");
		
		System.out.println( (newElection.equals(newElection2))  ? "FAILED" : newElection.getName() +" Is not the same as " + newElection2.getName() + "\t\t\t\t\t\t === TEST PASSED ===");
		System.out.println();		
		System.out.println( (newElection.equals(newElection3))  ? newElection.getName() +" Is the same as " + newElection3.getName() + "\t\t\t\t\t\t === TEST PASSED ===" : "TEST FAILED");
		System.out.println();
		System.out.println( (newElection3.equals(newElection))  ? newElection3.getName() +" Is the same as " + newElection.getName() + "\t\t\t\t\t\t === TEST PASSED ===" : "TEST FAILED");
		System.out.println();
		System.out.println( (newElection3.equals(newElection2))  ? "FAILED" : newElection3.getName() +" Is not the same as " + newElection2.getName() + "\t\t\t\t\t\t === TEST PASSED ===");

	}

}
