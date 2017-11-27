package election.data;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import election.business.DawsonVoter;
import election.business.interfaces.Voter;
import lib.Email;
import lib.PostalCode;
import util.ListUtilities;
import util.Utilities;

public class VoterListDBTest {

  public static void main(String[] args) {
    // TODO Add more method invocations to test all methods

    // ==========================> Data And Method Called To Test add Method

    DawsonVoter newValidVoter = new DawsonVoter("Joe", "Mancini", "koe.mancini@mail.me", "H3C4B7");

    DawsonVoter newValidVoter2 = new DawsonVoter("Raj", "Wong", "zaj@test.ru", "H3E1B4");

    DawsonVoter newValidVoter3 = new DawsonVoter("Joe", "Mancini", "aoe.mancini@mail.me", "H3C4B7");

    DawsonVoter badVoter = new DawsonVoter("Joe", "Mancini", "joe.mancini@mail.me", "H3C4B7");

    String voterFilePath = "datafiles/testfiles/testVoters.ser";
    String electionFilePath = "datafiles/testfiles/testElections.ser";
    String tallyFilePath = null;

    StringBuilder confirm = new StringBuilder("Number of voters in database: 3\n");
    confirm.append("joe.mancini@mail.me*Joe*Mancini*H3C4B7\n");
    confirm.append("koe.mancini@mail.me*Joe*Mancini*H3C4B7\n");
    confirm.append("raj@test.ru*Raj*Wong*H3E1B4\n");

    StringBuilder confirm2 = new StringBuilder("Number of voters in database: 3\n");
    confirm2.append("joe.mancini@mail.me*Joe*Mancini*H3C4B7\n");
    confirm2.append("raj@test.ru*Raj*Wong*H3E1B4\n");
    confirm2.append("zaj@test.ru*Raj*Wong*H3E1B4\n");

    StringBuilder confirm3 = new StringBuilder("Number of voters in database: 3\n");
    confirm3.append("aoe.mancini@mail.me*Joe*Mancini*H3C4B7\n");
    confirm3.append("joe.mancini@mail.me*Joe*Mancini*H3C4B7\n");
    confirm3.append("raj@test.ru*Raj*Wong*H3E1B4\n");

    System.out.println(
        "<><><><><><><><><><> ** TEST add METHOD OF VoterListDB ** <><><><><><><><><><> \n");

    // Passing a brand new valid Voter. Expect the Voter to be added between the 2 exist Voter
    testAdd(newValidVoter, voterFilePath, electionFilePath, tallyFilePath, confirm.toString());

    // Passing a brand new valid Voter. Expect the Voter to be added at the end of the database
    testAdd(newValidVoter2, voterFilePath, electionFilePath, tallyFilePath, confirm2.toString());

    // Passing a brand new valid Voter. Expect the Voter to be added at the start of the database
    testAdd(newValidVoter3, voterFilePath, electionFilePath, tallyFilePath, confirm3.toString());

    // Passing an existed Voter (Expect to throw exception)
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

    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date date = new Date();
    System.out.println(dateFormat.format(date));

    // Data And Method Called To Test toString Method <==========================


    // Felicia Gorgatchov
    testGetVoter();
    testUpdate();

    // Data and Method Called to disconnect() <==========================

    testDisconnect();

  }

  private static void setup() {
    String[] voters = new String[2];
    voters[0] = "joe.mancini@mail.me*Joe*Mancini*H3C4B7";
    voters[1] = "raj@test.ru*Raj*Wong*H3E1B4";

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

      SequentialTextFileList elementOfElection =
          new SequentialTextFileList("datafiles/testfiles/testVoters.txt",
              "datafiles/testfiles/testElections.txt", "datafiles/testfiles/testTally.txt");

      Utilities.serializeObject(elementOfElection.getVoterDatabase(),
          "datafiles/testfiles/testVoters.ser");
      Utilities.serializeObject(elementOfElection.getElectionDatabase(),
          "datafiles/testfiles/testElections.ser");

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

  /**
   * Tests disconnect from VoterListDB
   * 
   * @author DesJC
   * @see election.data.VoterLisDB#disconnect()
   */
  private static void testDisconnect() {
    setup();

    ObjectSerializedList files = new ObjectSerializedList("datafiles/testfiles/testVoters.ser",
        "datafiles/testfiles/testElections.ser");

    VoterListDB voterDB = new VoterListDB(files);

    DawsonVoter toBeSaved = new DawsonVoter("Joe", "Mancini", "aoe.mancini@mail.me", "H3C4B7");

    System.out.println("Before :\n" + voterDB.toString());

    try {
      voterDB.add(toBeSaved);
      voterDB.disconnect();
    } catch (DuplicateVoterException | IOException e) {
      e.printStackTrace();
    }

    voterDB = new VoterListDB(files);

    System.out.println("After :\n" + voterDB.toString());

    if (voterDB.toString()
        .equals("Number of voters in database: 3\n" + "aoe.mancini@mail.me*Joe*Mancini*H3C4B7\n"
            + "joe.mancini@mail.me*Joe*Mancini*H3C4B7\n" + "raj@test.ru*Raj*Wong*H3E1B4\n")) {
      System.out.println("PASS !!");
    } else {
      System.out.println("FAIL :(");
    }

    teardown();
  }

  /**
   * Testing add method to make sure it works correctly. It is supposed to throw exception when
   * Voter is already exists Otherwise, it needs to add the Voter into the CORRECT place in the
   * database.
   * 
   * @param v The Voter that we want to add
   * @param voterFilePath The file path of Voter .txt file
   * @param electionFilePath The file path of Election .txt file
   * @param tallyFilePath The file path of Tally .txt file
   * @param toValid A String to verify if the add method works correctly or not
   * 
   * @author Cao Hoang
   */
  private static void testAdd(Voter v, String voterFilePath, String electionFilePath,
      String tallyFilePath, String toValid) {

    setup();
    System.out.println("***** STARTING NEW TEST *****\n");

    ObjectSerializedList file = new ObjectSerializedList(voterFilePath, electionFilePath);

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
          "Failed to add the new Voter to Database, Error: " + e + "\t\t === TEST PASSED ===\n");
    }
    teardown();
  }

  /**
   * Test toString method to see if it's working or not. It is supposed to return the total number
   * of Voter in the database and listing out all the Voter in the database in a certain format
   * (Please check the method in VoterListDB.java for detail)
   * 
   * @param voterFilePath The file path of Voter .txt file
   * @param electionFilePath The file path of Election .txt file
   * @param tallyFilePath The file path of Tally .txt file
   * @param toValid A String to verify if the toString works correctly or not
   * 
   * @author Cao Hoang
   */
  private static void testToString(String voterFilePath, String electionFilePath,
      String tallyFilePath, String toValid) {
    setup();
    ObjectSerializedList file = new ObjectSerializedList(voterFilePath, electionFilePath);

    VoterListDB voterDatabase = new VoterListDB(file);

    System.out.println("==> Content of Voter text files as seen by VoterListDB: \n");
    System.out.println(voterDatabase.toString());

    System.out.println("==> Content of Voter text files as seen by creating a valid String: \n");
    System.out.println(toValid.toString());

    if (voterDatabase.toString().equals(toValid.toString())) {
      System.out.println("========> TEST PASSED <========\n");
    } else {
      System.out.println("========> TEST FAILED <========\n");
    }
    teardown();
  }

  /**
   * getVoter returns the voter ref of a provided email if found or throws an exception if the email
   * was not found. testGetVoter test if getVoter returns the right voter if an existing email is
   * given or if it throws an exception when an inexistent email is passed to it.
   * 
   * @author Maja original template, Felicia filled out with specific test cases
   * @throws InexistentVoterException
   */
  private static void testGetVoter() {
    setup();
    ObjectSerializedList file = new ObjectSerializedList("datafiles/testfiles/testVoters.ser",
        "datafiles/testfiles/testElections.ser");
    VoterListDB db = new VoterListDB(file);

    System.out.println("\n** test getVoter ** ");
    System.out.println("\n\tTest case 1: Voter in database:");

    try {
      Voter voter = db.getVoter("raj@test.ru");
      System.out.println("\tSUCCESS: Voter found " + voter.toString());
    } catch (InexistentVoterException e) {
      System.out.println("\tFAILING TEST CASE: voter should be fould");
      System.out.println(e);
    }

    System.out.println("\n\tTest case 2: Voter not in database:");

    try {
      Voter voter = db.getVoter("jar@test.ru");
      System.out.println("\tFAILING TEST CASE: Voter found " + voter.toString());
    } catch (InexistentVoterException e) {
      System.out.println("\tSUCCESS: voter not found");
      System.out.println("\t" + e);
    }

    teardown();
  }

  /**
   * update takes an email and a postal code. uses the email to find the voter and updates the
   * postal code with the one provided testUpdate tests if update() properly changes the postal code
   * of an existing voter or if it throws an inexistenVoterException when the email is not found.
   * 
   * @author Maja original template, Felicia filled out specific test cases
   * @throws InexistentVoterException
   */
  private static void testUpdate() {
    setup();

    ObjectSerializedList file = new ObjectSerializedList("datafiles/testfiles/testVoters.ser",
        "datafiles/testfiles/testElections.ser");
    VoterListDB db = new VoterListDB(file);

    Email emailTest1 = new Email("joe.mancini@mail.me");
    PostalCode pcTest1 = new PostalCode("j4x2g3");

    System.out.println("\n** test update ** ");

    try {
      System.out.println(
          "\n\tTest case 1: Voter in database: " + db.getVoter(emailTest1.toString()).getName()
              + " -- " + db.getVoter(emailTest1.toString()).getPostalCode());
      System.out.println("\tChange current postal code   "
          + db.getVoter(emailTest1.toString()).getPostalCode() + "   to   J4X2G3");
      db.update(emailTest1, pcTest1);
      if (db.getVoter(emailTest1.toString()).getPostalCode().equals(pcTest1)) {
        System.out.println("\tVoter PC after running update() method: "
            + db.getVoter(emailTest1.toString()).getPostalCode());
        System.out.println(
            "\tSUCCESS: Postal code updated " + db.getVoter(emailTest1.toString()).getPostalCode());
      } else {
        System.out.println("\tVoter PC after running update() method: "
            + db.getVoter(emailTest1.toString()).getPostalCode());
        System.out.println("\tFAILING TEST CASE: Postal code should have been updated");
      }
    } catch (InexistentVoterException e) {
      System.out.println("\tFAILING TEST CASE: voter should be found");
      System.out.println(e);
    }

    Email emailTest2 = new Email("felicia.gorgatchov@gmail.com");
    PostalCode pcTest2 = new PostalCode("k5c3h4");

    System.out.println("\n\tTest case 2: Voter not in database: Felicia*Gorgatchov -- J4X2G3");
    try {
      db.update(emailTest2, pcTest2);
      System.out.println("\tFAILING TEST CASE: Voter found when it doesn't exist in the database: "
          + db.getVoter(emailTest1.toString()).getName());
    } catch (InexistentVoterException e) {
      System.out.println("\tSUCCESS: voter not found");
      System.out.println("\t" + e);
    }

    teardown();

  }// end testUpdate

}

