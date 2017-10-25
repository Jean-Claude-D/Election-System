package election.business;


import java.time.LocalDate;
import election.business.interfaces.Tally;

public class DawsonElectionTest {

  public static void main(String[] args) {
    DawsonTally tally = new DawsonTally(1, "none");
    
    DawsonElection a = new DawsonElection("Canada Election", "single", 2017, 11, 25, 2018, 2, 20, "A", "J7E", new DawsonTally(2, a.getName()), "H",
        "Jean Claude", "Felicia", "Maria");

    testConstructor("Canada Election", "single", 2017, 11, 25, 2018, 2, 20, "A", "J7E", tally, "H",
        "Jean Claude", "Felicia", "Maria");

    testConstructor("NULL name", null, "single", 2017, 11, 25, 2018, 2, 20, "A", "J7E", tally, "H",
        "Jean Claude", "Felicia", "Maria");

    testConstructor("NULL type", "Canada Election", null, 2017, 11, 25, 2018, 2, 20, "A", "J7E",
        tally, "H", "Jean Claude", "Felicia", "Maria");

    testConstructor("EMPTY name and type", "", "", 2017, 11, 25, 2018, 2, 20, "A", "J7E", tally,
        "H", "Jean Claude", "Felicia", "Maria");

    testConstructor("a type NOT from enum", "Canada Election", "Dictatorial", 2017, 11, 25, 2018, 2,
        20, "A", "J7E", tally, "H", "Jean Claude", "Felicia", "Maria");

    testConstructor("startYear in the PAST", "Canada Election", "single", 2000, 11, 25, 2018, 2, 20,
        "A", "J7E", tally, "H", "Jean Claude", "Felicia", "Maria");

    testConstructor("startMonth in the PAST", "Canada Election", "single", 2017, 2, 25, 2018, 2, 20,
        "A", "J7E", tally, "H", "Jean Claude", "Felicia", "Maria");

    testConstructor("startDay in the PAST", "Canada Election", "single", 2017, 10, 1, 2018, 2, 20,
        "A", "J7E", tally, "H", "Jean Claude", "Felicia", "Maria");

    testConstructor("endDate before startDate", "Canada Election", "single", 2017, 12, 25, 2016, 12,
        4, "A", "J7E", tally, "H", "Jean Claude", "Felicia", "Maria");

    testConstructor("NULL tally", "Canada Election", "single", 2017, 11, 25, 2018, 2, 20, "A",
        "J7E", null, "H", "Jean Claude", "Felicia", "Maria");

    testConstructor("LESS than 2 items", "Canada Election", "single", 2017, 11, 25, 2018, 2, 20,
        "A", "J7E", tally, "Me");

    testAllGetter("Canada Election", "single", 2017, 11, 25, 2018, 2, 20, "A", "J7E", tally, "H",
        "Jean Claude", "Felicia", "Maria");

    testToString("Canada Election", "single", 2017, 11, 25, 2018, 2, 20, "A", "J7E", tally, "H",
        "Jean Claude", "Felicia", "Maria");

    testIsLimitedToPostalRange("Canada Election", "single", 2017, 11, 25, 2018, 2, 20, "A", "J7E",
        tally, "H", "Jean Claude", "Felicia", "Maria");

    testEquals("Canada Election", "SINGLE", 2017, 11, 25, 2018, 2, 20, "A", "J7E", tally, "H",
        "Jean Claude", "Felicia", "Maria");

    testCompareToAndHashcode("Canada Election", "SINGLE", 2017, 11, 25, 2018, 2, 20, "A", "J7E",
        tally, "H", "Jean Claude", "Felicia", "Maria");
  }


  private static void testConstructor(String name, String type, int startYear, int startMonth,
      int startDay, int endYear, int endMonth, int endDay, String startRange, String endRange,
      Tally tally, String... items) {
    try {
      DawsonTally realTally = new DawsonTally(0, name);
      
      DawsonElection newElection = new DawsonElection(name, type, startYear, startMonth, startDay,
          endYear, endMonth, endDay, startRange, endRange, realTally, items);
      
      tally = new DawsonTally(newElection.getElectionChoices().length, newElection.getName());
      
      newElection.setTally(tally);
      
      
      System.out.println(
          "Creating a DawsonElection with all valid arguments \t\t\t\t\t\t\t === TEST PASSED ===\n");
    } catch (Exception e) {
      System.out.println("TEST FAILED");
    }
  }

  private static void testConstructor(String errorMessage, String name, String type, int startYear,
      int startMonth, int startDay, int endYear, int endMonth, int endDay, String startRange,
      String endRange, Tally tally, String... items) {
    try {
      DawsonElection newElection = new DawsonElection(name, type, startYear, startMonth, startDay,
          endYear, endMonth, endDay, startRange, endRange, tally, items);
      
      tally = new DawsonTally(newElection.getElectionChoices().length, newElection.getName());
      
      newElection.setTally(tally);

      System.out.println("TEST FAILED");
    } catch (Exception e) {
      System.out.println("Creating a DawsonElection with " + errorMessage);
      System.out.println(e);
      System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t === TEST PASSED ===");
    }
  }


  private static void testAllGetter(String name, String type, int startYear, int startMonth,
      int startDay, int endYear, int endMonth, int endDay, String startRange, String endRange,
      Tally tally, String... items) {
    System.out.println(
        "------------------------------------------------------- TEST GETTERS METHOD -------------------------------------------------------\n");

    LocalDate startDate = LocalDate.of(2017, 11, 25);
    LocalDate endDate = LocalDate.of(2018, 2, 20);


    DawsonElection newElection =
        new DawsonElection(name, type, startYear, startMonth, startDay, endYear, endMonth, endDay,
            startRange, endRange, tally, "H", "Jean Claude", "Felicia", "Maria");
    
    tally = new DawsonTally(newElection.getElectionChoices().length, newElection.getName());
    
    newElection.setTally(tally);

    String[] test = newElection.getElectionChoices();

    System.out.println((newElection.getName().equals(name)) ? "Name of the election is: "
        + newElection.getName() + "\t\t\t\t\t\t\t\t === TEST PASSED ===" : "TEST FAILED");
    System.out.println();
    System.out.println((newElection.getElectionType().toString().equalsIgnoreCase(type))
        ? "Type of the election is: " + newElection.getElectionType()
            + "\t\t\t\t\t\t\t\t\t\t === TEST PASSED ==="
        : "TEST FAILED\n");
    System.out.println();
    System.out
        .println((newElection.getStartDate().isEqual(startDate)) ? "Start date of the election is: "
            + newElection.getStartDate() + "\t\t\t\t\t\t\t\t === TEST PASSED ===" : "TEST FAILED");
    System.out.println();
    System.out.println((newElection.getEndDate().isEqual(endDate)) ? "End date of the election is: "
        + newElection.getEndDate() + "\t\t\t\t\t\t\t\t\t === TEST PASSED ===" : "TEST FAILED");
    System.out.println();
    System.out.println((newElection.getPostalRangeStart().equals(startRange)
        ? "Start Range of postal code is:  " + newElection.getPostalRangeStart()
            + "\t\t\t\t\t\t\t\t\t === TEST PASSED ==="
        : "TEST FAILED"));
    System.out.println();
    System.out.println((newElection.getPostalRangeEnd().equals(endRange)
        ? "End Range of postal code is:  " + newElection.getPostalRangeEnd()
            + "\t\t\t\t\t\t\t\t\t === TEST PASSED ==="
        : "TEST FAILED"));
    System.out.println();
    System.out.println((newElection.getTally() == tally) ? "Address memory of tally is: "
        + newElection.getTally() + "\t\t\t\t\t === TEST PASSED === " : "TEST FAILED");
    System.out.println();
    System.out.println("The choices in the newElection are: ");

    for (String check : test) {
      System.out.println(check);
    }
  }

  private static void testToString(String name, String type, int startYear, int startMonth,
      int startDay, int endYear, int endMonth, int endDay, String startRange, String endRange,
      Tally tally, String... items) {

    System.out.println(
        "------------------------------------------------------- TEST toString() METHOD -----------------------------------------------------\n");
    DawsonElection newElection =
        new DawsonElection(name, type, startYear, startMonth, startDay, endYear, endMonth, endDay,
            startRange, endRange, tally, "H", "Jean Claude", "Feli", "Maria");

    String test = "Canada Election*2017*11*25*2018*2*20*A*J7E*SINGLE*4";
    test += "\nH";
    test += "\nJean Claude";
    test += "\nFeli";
    test += "\nMaria";

    System.out.println((newElection.toString().equalsIgnoreCase(test)
        ? "test String is equal to DawsonElection's toString output\t\t\t\t\t\t === TEST PASSED ==="
        : "TEST FAILED"));
    System.out.println();
    System.out.println("The String test:");
    System.out.println(test);
    System.out.println();
    System.out.println("DawsonElection.toString():");
    System.out.println(newElection.toString());
    System.out.println();
  }

  private static void testIsLimitedToPostalRange(String name, String type, int startYear,
      int startMonth, int startDay, int endYear, int endMonth, int endDay, String startRange,
      String endRange, Tally tally, String... items) {

    System.out.println(
        "------------------------------------------------------- TEST isLimitedToPostalRange() METHOD ---------------------------------------\n");

    DawsonElection newElection = new DawsonElection(name, type, startYear, startMonth, startDay,
        endYear, endMonth, endDay, startRange, endRange, tally, items);

    DawsonElection newElection2 = new DawsonElection(name, type, startYear, startMonth, startDay,
        endYear, endMonth, endDay, "", "", tally, items);

    DawsonElection newElection3 = new DawsonElection(name, type, startYear, startMonth, startDay,
        endYear, endMonth, endDay, null, null, tally, items);

    System.out.println((newElection.isLimitedToPostalRange()
        ? "newElection has postal range\t\t\t\t\t\t\t\t\t\t === TEST PASSED ==="
        : "TEST FAILED\n"));
    System.out.println();
    System.out.println((newElection2.isLimitedToPostalRange() ? "TEST FAILED"
        : "newElection2 does NOT have postal range\t\t\t\t\t\t\t\t\t === TEST PASSED ==="));
    System.out.println();
    System.out.println((newElection3.isLimitedToPostalRange() ? "TEST FAILED"
        : "newElection3 does NOT have postal range\t\t\t\t\t\t\t\t\t === TEST PASSED ==="));
    System.out.println();
  }

  private static void testEquals(String name, String type, int startYear, int startMonth,
      int startDay, int endYear, int endMonth, int endDay, String startRange, String endRange,
      Tally tally, String... items) {

    System.out.println(
        "------------------------------------------------------- TEST equals() METHOD -------------------------------------------------------\n");

    DawsonElection newElection = new DawsonElection(name, type, startYear, startMonth, startDay,
        endYear, endMonth, endDay, startRange, endRange, tally, items);

    DawsonElection newElection2 = new DawsonElection("U.S Election", type, startYear, startMonth,
        startDay, endYear, endMonth, endDay, startRange, endRange, tally, items);

    DawsonElection newElection3 = new DawsonElection(name, type, startYear, startMonth, startDay,
        endYear, endMonth, endDay, startRange, endRange, tally, items);

    System.out.println((newElection.equals(newElection2)) ? "FAILED"
        : newElection.getName() + " is NOT the same as " + newElection2.getName()
            + "\t\t\t\t\t\t\t\t === TEST PASSED ===");
    System.out.println();
    System.out
        .println((newElection.equals(newElection3)) ? newElection.getName() + " IS the same as "
            + newElection3.getName() + "\t\t\t\t\t\t\t\t === TEST PASSED ===" : "TEST FAILED");
    System.out.println();
    System.out
        .println((newElection3.equals(newElection)) ? newElection3.getName() + " IS the same as "
            + newElection.getName() + "\t\t\t\t\t\t\t\t === TEST PASSED ===" : "TEST FAILED");
    System.out.println();
    System.out.println((newElection3.equals(newElection2)) ? "FAILED"
        : newElection3.getName() + " is NOT the same as " + newElection2.getName()
            + "\t\t\t\t\t\t\t\t === TEST PASSED ===");
    System.out.println();
  }

  private static void testCompareToAndHashcode(String name, String type, int startYear,
      int startMonth, int startDay, int endYear, int endMonth, int endDay, String startRange,
      String endRange, Tally tally, String... items) {

    System.out.println(
        "--------------------------------------------------- TEST compareTo() AND hashcode() METHOD -----------------------------------------\n");


    DawsonElection newElection = new DawsonElection(name, type, startYear, startMonth, startDay,
        endYear, endMonth, endDay, startRange, endRange, tally, items);

    DawsonElection newElection2 = new DawsonElection("U.S Election", type, startYear, startMonth,
        startDay, endYear, endMonth, endDay, startRange, endRange, tally, items);

    DawsonElection newElection3 = new DawsonElection(name, type, startYear, startMonth, startDay,
        endYear, endMonth, endDay, startRange, endRange, tally, items);

    DawsonElection newElection4 = new DawsonElection("Milky Way Galaxy", type, startYear,
        startMonth, startDay, endYear, endMonth, endDay, startRange, endRange, tally, items);

    if ((newElection.compareTo(newElection3) == 0)
        && (newElection.hashCode() == newElection3.hashCode())) {
      System.out.println(
          "newElection and newElection3 are \"equal\", so they also have the SAME hashcode \t\t\t\t === TEST PASSED === ");
      System.out.println();
    } else {
      System.out.println("TEST FAILED");
    }

    if ((newElection.compareTo(newElection2) < 0)
        && (newElection.hashCode() != newElection2.hashCode())) {
      System.out.println(
          "newElection and newElection2 are NOT \"equal\", so they also have DIFFERENT hashcode \t\t\t === TEST PASSED === ");
      System.out.println();
    } else {
      System.out.println("TEST FAILED");
    }

    if ((newElection4.compareTo(newElection) > 0)
        && (newElection4.hashCode() != newElection.hashCode())) {
      System.out.println(
          "newElection4 and newElection are NOT \"equal\", so they also have DIFFERENT hashcode \t\t\t === TEST PASSED === ");
      System.out.println();
    } else {
      System.out.println("TEST FAILED");
    }
  }
}

