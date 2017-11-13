package election.data;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import election.business.DawsonVoter;
import election.business.interfaces.Voter;
import util.ListUtilities;

public class VoterListDBTest {

  public static void main(String[] args) {
    // TODO Add more method invocations to test all methods

    // ==========================> Data And Method Called To Test add Method

    DawsonVoter aWildVoterAppear =
        new DawsonVoter("Joe", "Mancini", "koe.mancini@mail.me", "H3C4B7");
    DawsonVoter badVoter = new DawsonVoter("Joe", "Mancini", "joe.mancini@mail.me", "H3C4B7");

    String voterFilePath = "datafiles/testfiles/testVoters.txt";
    String electionFilePath = "datafiles/testfiles/testElections.txt";
    String tallyFilePath = "datafiles/testfiles/testTally.txt";

    StringBuilder confirm = new StringBuilder("Number of voters in database: 3\n");
    confirm.append("joe.mancini@mail.me*Joe*Mancini*H3C4B7\n");
    confirm.append("koe.mancini@mail.me*Joe*Mancini*H3C4B7\n");
    confirm.append("raj@test.ru*Raj*Wong*H3E1B4\n");

    System.out.println(
        "<><><><><><><><><><> ** TEST add METHOD OF VoterListDB ** <><><><><><><><><><> \n");
    // Passing a brand new valid Voter
    testAdd(aWildVoterAppear, voterFilePath, electionFilePath, tallyFilePath, confirm.toString());
    // Passing an existed Voter
    testAdd(badVoter, voterFilePath, electionFilePath, tallyFilePath, "FAILED");

    System.out.println("<><><><><><><><><><> ** TEST END ** <><><><><><><><><><> \n");

    // Data And Method Called To Test add Method <==========================


    // ==========================> Data And Method Called To Test toString Method

    System.out.println(
        "<><><><><><><><><><> ** TEST toString METHOD OF VoterListDB ** <><><><><><><><><><> \n");

    StringBuilder check = new StringBuilder("Number of voters in database: 2\n");
    check.append("joe.mancini@mail.me*Joe*Mancini*H3C4B7\n");
    check.append("raj@test.ru*Raj*Wong*H3E1B4\n");

    testToString(voterFilePath, electionFilePath, tallyFilePath, check.toString());

    System.out.println("<><><><><><><><><><> ** TEST END ** <><><><><><><><><><> \n");

    // Data And Method Called To Test toString Method <==========================


  }



  private static void setup() {
    String[] voters = new String[2];
    voters[0] = "joe.mancini@mail.me*Joe*Mancini*H3C4B7";
    voters[1] = "raj@test.ru*Raj*Wong*H3E1B4";
    // TODO add more voters if needed, but they must be in sorted order!

    String[] elecs = new String[2];
    elecs[0] =
        "Presidental race*2020*11*1*2020*11*1***single*2" + "\nDonald Trump" + "\nAnyone Else";
    elecs[1] =
        "Favourite program*2018*5*1*2019*5*31*H4G*H4G*single*2" + "\nGame of Thrones" + "\nNarcos";
    // TODO add more elections if needed, but the must be in sorted order

    String[] tallies = new String[2];
    tallies[0] = "Presidental race*2" + "\n100*0" + "\n0*102";
    tallies[1] = "Favourite program*2" + "\n1000*0" + "\n0*560";

    // make the testfiles directory
    Path dir;
    try {
      dir = Paths.get("datafiles/testfiles");
      if (!Files.exists(dir))
        Files.createDirectory(dir);
      ListUtilities.saveListToTextFile(voters, "datafiles/testfiles/testVoters.txt");
      ListUtilities.saveListToTextFile(elecs, "datafiles/testfiles/testElections.txt");
      ListUtilities.saveListToTextFile(tallies, "datafiles/testfiles/testTally.txt");
    } catch (InvalidPathException | IOException e) {
      System.err.println("could not create testfiles directory " + e.getMessage());
    }

  }

  private static void teardown() {
    Path file;
    try {
      file = Paths.get("datafiles/testfiles/testVoters.txt");
      Files.deleteIfExists(file);
      file = Paths.get("datafiles/testfiles/testElections.txt");
      Files.deleteIfExists(file);
      file = Paths.get("datafiles/testfiles/testTally.txt");
      Files.deleteIfExists(file);
    } catch (InvalidPathException e) {
      System.err.println("could not delete test files " + e.getMessage());
    } catch (NoSuchFileException e) {
      System.err.println("could not delete test files " + e.getMessage());
    } catch (DirectoryNotEmptyException e) {
      System.err.println("could not delete test files " + e.getMessage());
    } catch (IOException e) {
      System.err.println("could not delete test files " + e.getMessage());
    }
  }

  private static void testAdd(Voter v, String voterFilePath, String electionFilePath,
      String tallyFilePath, String toValid) {

    setup();
    SequentialTextFileList file =
        new SequentialTextFileList(voterFilePath, electionFilePath, tallyFilePath);

    VoterListDB voterDatabase = new VoterListDB(file);

    System.out.println("Voter Database BEFORE adding new Voter: \n");
    System.out.println(voterDatabase.toString());

    try {
      voterDatabase.add(v);

      System.out.println("Voter Database AFTER adding new Voter: \n");
      System.out.println(voterDatabase.toString());

      if (voterDatabase.toString().equals(toValid)) {
        System.out.println("========> TEST PASSED <========\n");
      } else {
        System.out.println("========> TEST FAILED <========\n");
      }

    } catch (DuplicateVoterException e) {
      System.out.println(
          "Failed to add the new Voter to Database, Error: " + e + "/t/t === TEST PASSED ===\n");
    }
    teardown();
  }

  private static void testToString(String voterFilePath, String electionFilePath,
      String tallyFilePath, String toValid) {
    setup();
    SequentialTextFileList file =
        new SequentialTextFileList(voterFilePath, electionFilePath, tallyFilePath);

    VoterListDB voterDatabase = new VoterListDB(file);

    System.out.println("==> Content of Voter text files as seen by VoterListDB: \n");
    System.out.println(voterDatabase.toString());

    System.out.println("==> Content of Voter text files as seen by readAllLines: \n");
    System.out.println(toValid.toString());

    if (voterDatabase.toString().equals(toValid.toString())) {
      System.out.println("========> TEST PASSED <========\n");
    } else {
      System.out.println("========> TEST FAILED <========\n");
    }

    teardown();
  }


  // private static void testGetVoter() {
  // setup();
  // SequentialTextFileList file = new SequentialTextFileList("datafiles/testfiles/testVoters.txt",
  // "datafiles/testfiles/testElections.txt", "datafiles/testfiles/testTally.txt");
  // VoterListDB db = new VoterListDB(file);
  //
  // System.out.println("\n** test getVoter ** ");
  // System.out.println("\nTest case 1: Voter in database:");
  // try {
  // Voter voter = db.getVoter("raj@test.ru");
  // System.out.println("SUCCESS: Voter found " + voter.toString());
  // } catch (IllegalArgumentException e) { // TEMPORARY EXCEPTION <===
  // System.out.println("FAILING TEST CASE: voter should be fould");
  // }
  //
  // System.out.println("\nTest case 2: Voter not in database:");
  // try {
  // Voter voter = db.getVoter("jar@test.ru");
  // System.out.println("FAILING TEST CASE: Voter found " + voter.toString());
  // } catch (IllegalArgumentException e) { // TEMPORARY EXCEPTION <===
  // System.out.println("SUCCESS: voter not found");
  // }
  //
  // teardown();
  // }

}

