package election.business;


import election.business.interfaces.Tally;

public class DawsonElectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testConstructor();
	}
	
//	public DawsonElection(String name, String type, int startYear, int
//			startMonth, int startDay, int endYear, int endMonth, int endDay,
//			String startRange, String endRange, Tally tally, String... items )
	
	private static void testConstructor() {
		try {
			StubTally tally = new StubTally();
			DawsonElection newElection = new DawsonElection("Canada Election", "single", 2017, 11, 25, 2018, 2, 20
					,"A", "J7E", tally, "Me", "Jean Claude", "Stuff");
			System.out.println("TEST PASSED");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			System.out.println("TEST FAILED");
		}
		
		try {
			StubTally tally = new StubTally();
			DawsonElection newElection = new DawsonElection(null, "single", 2017, 11, 25, 2018, 2, 20
					,"A", "J7E", tally, "Me", "Jean Claude", "Stuff");
			System.out.println("TEST FAILED");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			System.out.println("TEST PASSED");
		}
		
		try {
			StubTally tally = new StubTally();
			DawsonElection newElection = new DawsonElection("President for Mars", null, 2017, 11, 25, 2018, 2, 20
					,"A", "J7E", tally, "Me", "Jean Claude", "Stuff");
			System.out.println("TEST FAILED");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			System.out.println("TEST PASSED");
		}
		
		try {
			StubTally tally = new StubTally();
			DawsonElection newElection = new DawsonElection("", "", 2017, 11, 25, 2018, 2, 20
					,"A", "J7E", tally, "Me", "Jean Claude", "Stuff");
			System.out.println("TEST FAILED");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			System.out.println("TEST PASSED");
		}
	}

}
