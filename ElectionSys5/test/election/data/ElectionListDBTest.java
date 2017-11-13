package election.data;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import election.business.DawsonElectionFactory;
import election.business.interfaces.Election;
import election.data.interfaces.ListPersistenceObject;
import util.ListUtilities;

/**
 * 
 * @author DesJC
 *
 */
public class ElectionListDBTest {

  private ElectionListDBTest() {}

  public static void main(String[] args) {
    // Workspace for DesJC

    // Workspace for hoss_m
    // Testing the getElection method.

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
    String choice5 = "MARIA";
    String choice6 = "FEL";
    String name3 = "Prom Queen";

    Election election1 =
        DawsonElectionFactory.DAWSON_ELECTION.getElectionInstance(name, type, startYear, startMonth,
            startDay, endYear, endMonth, endDay, startRange, endRange, choice, choice2);

    Election election2 = DawsonElectionFactory.DAWSON_ELECTION.getElectionInstance(name1, type1,
        startYear1, startMonth1, startDay1, endYear1, endMonth1, endDay1, startRange1, endRange1,
        choice3, choice4);

    Election election3 = DawsonElectionFactory.DAWSON_ELECTION.getElectionInstance(name3, type3,
        startYear3, startMonth3, startDay3, endYear3, endMonth3, endDay3, startRange3, endRange3,
        choice5, choice6);
  }

  public static void testToString() {
    // TODO an actual test
    setup();

    ListPersistenceObject file = new SequentialTextFileList(null,
        "datafiles/testfiles/testElections.txt", "datafiles/testfiles/testTally.txt");

    ElectionListDB electionDB = new ElectionListDB(file);

    System.out.println(electionDB.toString());
    teardown();
  }

  public static void testAdd() {
    setup();

    ListPersistenceObject file = new SequentialTextFileList(null,
        "datafiles/testfiles/testElections.txt", "datafiles/testfiles/testTally.txt");

    ElectionListDB electionDB = new ElectionListDB(file);

    /*
     * Centenial Worldwide Elections*2000*12*20*2010*12*4*H1A*H2C*single*10 Florence McCrady Cary
     * Fee Angie Johnson Dorothy Ouimet Bronislaw Selezneva Martha Vasilieva Rahman Ganem Nashah
     * Naser Chen Kung Rachelle Leduc
     */

    try {
      electionDB.add(DawsonElectionFactory.DAWSON_ELECTION.getElectionInstance(
          "Dawson Color Election 2020", "ranked", 2020, 12, 20, 2022, 1, 20, "Red", "Green",
          "Orange", "Blue", "Pink", "Cyan"));

      electionDB.add(DawsonElectionFactory.DAWSON_ELECTION.getElectionInstance(
          "Brittany independence referendum", "single", 2017, 12, 6, 2018, 8, 5, "H3A", "M1Z",
          "Yes, I want independence", "No, I do not want independence"));
    } catch (DuplicateElectionException e) {
      e.printStackTrace();
    }

    System.out.println(electionDB + "");

    teardown();
  }

  public static void testDisconnect() {
    setup();
    // TODO test the disconnect() from ElectionListDB
    teardown();
  }

  public static void testGetElection(String testName) {
    setup();
    // TODO test the getElection(String) from ElectionListDB
    teardown();
  }

  public static void setup() {
    String[] elecs = new String[2];
    elecs[1] =
        "Presidental race*2020*11*1*2020*11*1***single*2" + "\nDonald Trump" + "\nAnyone Else";
    elecs[0] =
        "Favourite program*2018*5*1*2019*5*31*H4G*H4G*single*2" + "\nGame of Thrones" + "\nNarcos";
    // TODO add more elections if needed, but the must be in sorted order

    String[] tallies = new String[2];
    tallies[0] = "Presidental race*2" + "\n100*0" + "\n0*102";
    tallies[1] = "Favourite program*2" + "\n1000*0" + "\n0*560";

    Path dir;

    // make the testfiles directory
    try {
      dir = Paths.get("datafiles/testfiles");

      if (!Files.exists(dir)) {
        Files.createDirectory(dir);
      }

      ListUtilities.saveListToTextFile(elecs, "datafiles/testfiles/testElections.txt");
      ListUtilities.saveListToTextFile(tallies, "datafiles/testfiles/testTally.txt");
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
    } catch (InvalidPathException | IOException e) {
      System.err.println("could not delete test files " + e.getMessage());
    }
  }

}
