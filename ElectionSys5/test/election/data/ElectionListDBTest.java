package election.data;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import election.business.DawsonElectionFactory;
import election.business.interfaces.Election;
import election.data.interfaces.ListPersistenceObject;
import util.ListUtilities;
import util.Utilities;

/**
 * 
 * @author DesJC
 *
 */
public class ElectionListDBTest {

  private ElectionListDBTest() {}

  public static void main(String[] args) {
    // Workspace for DesJC

    testToString("Number of elections in database: " + 2
        + "\nFavourite program*2018*5*1*2019*5*31*H4G*H4G*single*2"
        + "\nPresidental race*2020*11*1*2020*11*1***single*2");
    System.out.println();
    System.out.println();
    System.out.println();

    String expectedDef = "Number of elections in database: " + 3;
    String elec1 = "\nFavourite program*2018*5*1*2019*5*31*H4G*H4G*single*2";
    String elec2 = "\nPresidental race*2020*11*1*2020*11*1***single*2";

    testAdd(
        DawsonElectionFactory.DAWSON_ELECTION.getElectionInstance("Dawson Color Election 2020",
            "ranked", 2020, 12, 20, 2022, 1, 20, "", "", "Red", "Green", "Orange", "Blue", "Pink",
            "Cyan"),
        expectedDef + "\nDawson Color Election 2020*2020*12*20*2022*1*20***RANKED*6" + elec1
            + elec2,
        false);
    System.out.println();
    System.out.println();
    System.out.println();
    testAdd(
        DawsonElectionFactory.DAWSON_ELECTION.getElectionInstance(
            "Brittany independence referendum", "single", 2017, 12, 6, 2018, 8, 5, "H3A", "M1Z",
            "Yes, I want independence", "No, I do not want independence"),
        expectedDef + "\nBrittany independence referendum*2017*12*6*2018*8*5*H3A*M1Z*SINGLE*2"
            + elec1 + elec2,
        false);
    System.out.println();
    System.out.println();
    System.out.println();

    testAdd(
        DawsonElectionFactory.DAWSON_ELECTION.getElectionInstance("Favourite program", "single",
            2018, 5, 1, 2019, 5, 31, "H4G", "H4G", "Java", "No Java"),
        expectedDef + "\nFavourite program*2018*5*1*2019*5*31*H4G*H4G*SINGLE*2" + elec1 + elec2,
        true);
    System.out.println();
    System.out.println();
    System.out.println();

    // Workspace for hoss_m
    // Testing the getElection method.

    List<Election> database;

    String type = "SINGLE";
    int startYear = LocalDateTime.now().getYear();
    int startMonth = LocalDateTime.now().getMonthValue();
    int startDay = LocalDateTime.now().getDayOfMonth();
    int endYear = LocalDateTime.now().getYear() + 1;
    int endMonth = LocalDateTime.now().getMonthValue();
    int endDay = LocalDateTime.now().getDayOfMonth();
    String startRange = null;
    String endRange = null;
    String choice = "MARIA";
    String choice2 = "FEL";
    String name = "Prom Queen";

    String type1 = "SINGLE";
    int startYear1 = LocalDateTime.now().getYear();
    int startMonth1 = LocalDateTime.now().getMonthValue();
    int startDay1 = LocalDateTime.now().getDayOfMonth();
    int endYear1 = LocalDateTime.now().getYear() + 1;
    int endMonth1 = LocalDateTime.now().getMonthValue();
    int endDay1 = LocalDateTime.now().getDayOfMonth();
    String startRange1 = null;
    String endRange1 = null;
    String choice3 = "JC";
    String choice4 = "H";
    String name1 = "Prom King";

    String type3 = "SINGLE";
    int startYear3 = LocalDateTime.now().getYear();
    int startMonth3 = LocalDateTime.now().getMonthValue();
    int startDay3 = LocalDateTime.now().getDayOfMonth();
    int endYear3 = LocalDateTime.now().getYear() + 1;
    int endMonth3 = LocalDateTime.now().getMonthValue();
    int endDay3 = LocalDateTime.now().getDayOfMonth();
    String startRange3 = null;
    String endRange3 = null;
    String choice5 = "Brent";
    String choice6 = "Stephanie";
    String name3 = "President of Dawson";

    Election election1 =
        DawsonElectionFactory.DAWSON_ELECTION.getElectionInstance(name, type, startYear, startMonth,
            startDay, endYear, endMonth, endDay, startRange, endRange, choice, choice2);

    Election election2 = DawsonElectionFactory.DAWSON_ELECTION.getElectionInstance(name1, type1,
        startYear1, startMonth1, startDay1, endYear1, endMonth1, endDay1, startRange1, endRange1,
        choice3, choice4);

    Election election3 = DawsonElectionFactory.DAWSON_ELECTION.getElectionInstance(name3, type3,
        startYear3, startMonth3, startDay3, endYear3, endMonth3, endDay3, startRange3, endRange3,
        choice5, choice6);

    testDisconnect(election1,
        "Number of elections in database: 3\nFavourite program*2018*5*1*2019*5*31*H4G*H4G*single*2\nPresidental race*2020*11*1*2020*11*1***single*2\n"
            + name + '*' + startYear + '*' + startMonth + '*' + startDay + '*' + endYear + '*'
            + endMonth + '*' + endDay + '*' + startRange + '*' + endRange + '*' + type + "*2",
        false);

    /* Presidental race*2020*11*1*2020*11*1***single*2 */

    // getElection Testing

    String testName1 = "Presidental race";
    testGetElection(testName1);


  }

  public static void testToString(String expected) {
    System.out.println("\n===== TEST TOSTRING =====");
    setup();

    ListPersistenceObject file =
        new ObjectSerializedList(null, "datafiles/testfiles/testElections.ser");

    ElectionListDB electionDB = new ElectionListDB(file);

    if (electionDB.toString().equals(expected)) {
      System.out.println("PASS");
    } else {
      System.out.println("FAIL, should be :\n" + expected);
    }

    System.out.println("\n" + electionDB.toString() + "\n");
    teardown();
    System.out.println("===== END  TOSTRING =====\n");
  }

  public static void testAdd(Election election, String expected, boolean exceptionExpected) {
    setup();
    boolean testPassed = false;

    ListPersistenceObject file =
        new ObjectSerializedList(null, "datafiles/testfiles/testElections.ser");

    ElectionListDB electionDB = new ElectionListDB(file);

    try {
      electionDB.add(election);
      testPassed = electionDB.toString().equals(expected);
    } catch (DuplicateElectionException e) {
      testPassed = exceptionExpected;
      e.printStackTrace();
    }

    System.out.println(electionDB);
    System.out.println(expected);

    System.out.println(testPassed ? "PASS" : "FAIL");

    teardown();
  }

  /**
   * 
   * @author DesJC, hoss_m
   * @param election
   * @param expected
   * @param exceptionExpected
   */
  public static void testDisconnect(Election election, String expected, boolean exceptionExpected) {

    boolean testPassed = false;

    setup();

    ListPersistenceObject listPersistenceObject =
        new ObjectSerializedList(null, "datafiles/testfiles/testElections.ser");

    ElectionListDB disconnectingElection = new ElectionListDB(listPersistenceObject);

    try {
      disconnectingElection.add(election);
      disconnectingElection.disconnect();
      disconnectingElection = new ElectionListDB(listPersistenceObject);

      testPassed = disconnectingElection.toString().equals(expected);
    } catch (IOException | DuplicateElectionException e) {
      testPassed = exceptionExpected;
      e.printStackTrace();
    }

    System.out.println(disconnectingElection);
    System.out.println(expected);

    System.out.println(testPassed ? "PASS" : "FAIL");

    teardown();
  }

  public static void testGetElection(String testName) {

    try {

      setup();

      ListPersistenceObject listPersistenceObject =
          new ObjectSerializedList(null, "datafiles/testfiles/testElections.ser");

      ElectionListDB gettingElection = new ElectionListDB(listPersistenceObject);
      Election result = gettingElection.getElection(testName);
      if (result.getName().compareTo(testName) == 0) {

        System.out.println();
        System.out.println("===========================PASS===============================");
        System.out.println();
      }

      else {

        System.out.println();
        System.out.println("===========================FAIL===============================");
        System.out.println();
      }

      teardown();

    } catch (InexistentElectionException e) {

      e.printStackTrace();
    }
  }

  public static void setup() {
    String[] elecs = new String[2];
    elecs[1] =
        "Presidental race*2020*11*1*2020*11*1***single*2" + "\nDonald Trump" + "\nAnyone Else";
    elecs[0] =
        "Favourite program*2018*5*1*2019*5*31*H4G*H4G*single*2" + "\nGame of Thrones" + "\nNarcos";
    // TODO add more elections if needed, but the must be in sorted order

    String[] tallies = new String[2];
    tallies[1] = "Presidental race*2" + "\n100*0" + "\n0*102";
    tallies[0] = "Favourite program*2" + "\n1000*0" + "\n0*560";

    Path dir;

    // make the testfiles directory
    try {
      dir = Paths.get("datafiles/testfiles");

      if (!Files.exists(dir)) {
        Files.createDirectory(dir);
      }

      ListUtilities.saveListToTextFile(elecs, "datafiles/testfiles/testElections.txt");
      ListUtilities.saveListToTextFile(tallies, "datafiles/testfiles/testTally.txt");

      SequentialTextFileList elementOfElection =
          new SequentialTextFileList("datafiles/testfiles/testVoters.txt",
              "datafiles/testfiles/testElections.txt", "datafiles/testfiles/testTally.txt");

      Utilities.serializeObject(elementOfElection.getVoterDatabase(),
          "datafiles/testfiles/testVoters.ser");
      Utilities.serializeObject(elementOfElection.getElectionDatabase(),
          "datafiles/testfiles/testElections.ser");

    } catch (InvalidPathException | FileAlreadyExistsException e) {
      System.err.println("could not create testfiles directory " + e.getMessage());
    } catch (IOException e) {
      System.err.println("could not create testfiles in setup() " + e.getMessage());
    }
  }

  public static void teardown() {
    Path file;

    try {
      file = Paths.get("datafiles/testfiles/testVoters.txt");
      Files.deleteIfExists(file);
      file = Paths.get("datafiles/testfiles/testElections.txt");
      Files.deleteIfExists(file);
      file = Paths.get("datafiles/testfiles/testTally.txt");
      Files.deleteIfExists(file);

      file = Paths.get("datafiles/testfiles/testElections.ser");
      Files.deleteIfExists(file);
      file = Paths.get("datafiles/testfiles/testVoters.ser");
      Files.deleteIfExists(file);

    } catch (InvalidPathException | IOException e) {
      System.err.println("could not delete test files " + e.getMessage());
    }
  }

}
