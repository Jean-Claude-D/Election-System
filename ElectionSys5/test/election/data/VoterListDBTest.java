package election.data;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import election.business.DawsonVoter;
import election.business.interfaces.Voter;
import util.ListUtilities;

public class VoterListDBTest {

  public static void main(String[] args) {
    // testGetVoter();
    // TODO Add more method invocations to test all methods

    DawsonVoter aWildVoterAppear = new DawsonVoter("Yarrick", "Sebastian", "zaj@test.ru", "H3G5J1");

    DawsonVoter badVoter = new DawsonVoter("Joe", "Mancini", "aoe.mancini@mail.me", "H3C4B7");

    // testToString();
    testAdd(aWildVoterAppear);
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
    } catch (InvalidPathException e) {
      System.err.println("could not create testfiles directory " + e.getMessage());
    } catch (FileAlreadyExistsException e) {
      System.err.println("could not create testfiles directory " + e.getMessage());
    } catch (IOException e) {
      System.err.println("could not create testfiles in setup() " + e.getMessage());
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

  private static void testAdd(Voter v) {
    setup();
    System.out.println("========= ** Test add method of VoterListDB ** ========= \n\n");

    SequentialTextFileList file = new SequentialTextFileList("datafiles/testfiles/testVoters.txt",
        "datafiles/testfiles/testElections.txt", "datafiles/testfiles/testTally.txt");

    VoterListDB voterDatabase = new VoterListDB(file);


    System.out.println(voterDatabase.toString());

    try {
      voterDatabase.add(v);
      // voterDatabase.add(badVoter);
      System.out.println(voterDatabase.toString());

    } catch (DuplicateVoterException e) {
      System.out.println("Failed to add the new Voter to Database, Error: " + e);
    }

  }

  private static void testToString() {
    setup();

    System.out.println("========= ** Test toString method of VoterListDB ** ========= \n\n");

    SequentialTextFileList file = new SequentialTextFileList("datafiles/testfiles/testVoters.txt",
        "datafiles/testfiles/testElections.txt", "datafiles/testfiles/testTally.txt");

    VoterListDB voterDatabase = new VoterListDB(file);

    System.out.println("==> Content of Voter text files as seen by VoterListDB: \n");
    System.out.println(voterDatabase.toString());

    Path testVoterPath = Paths.get("datafiles/testfiles/testVoters.txt");

    /*
     * This try catch will read the Voters directly from file, then convert it to a String using
     * StringBuilder. This String will be compared to the String that is produced from the toString
     * method for voterDatabase
     */
    try {
      List<String> lines = Files.readAllLines(testVoterPath);
      StringBuilder voters =
          new StringBuilder("Number of voters in database: " + lines.size() + "\n");

      for (String line : lines) {
        voters.append(line + "\n");
      }
      System.out.println("==> Content of Voter text files as seen by readAllLines: \n");
      System.out.println(voters.toString());

      if (voterDatabase.toString().equals(voters.toString())) {
        System.out.println("========> TEST PASSED <========");
      } else {
        System.out.println("========> TEST FAILED <========");
      }
    } catch (IOException e) {
      System.out.println("Failed to read the file, error code: " + e);
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

