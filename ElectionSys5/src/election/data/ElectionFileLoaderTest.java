package election.data;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.NoSuchFileException;
import election.business.DawsonElectionFactory;
import election.business.interfaces.Voter;

public class ElectionFileLoaderTest {

  public static void main(String[] args) throws IOException {


    // Variables
    String nameOfFile = null;
    boolean expectedResult = false;


    // The test method where we will pass the variables

    // Variable Team mate 1
    final Class illArg = IllegalArgumentException.class;
    final Class noFile = NoSuchFileException.class;
    final Class invPath = InvalidPathException.class;
    final Class fileLost = FileNotFoundException.class;

    /*
     * Test GetVoterListFromSequentialFile with voters1.txt :
     * 
     * djflower@hotmail.com*Daisy*Johnson*H7N9L0
     * 
     * robsmith@gmail.com*Robert*Smith*J8F4K2
     * 
     * andrasemily@outlook.ca*Emily*Andras*T3K7V6
     * 
     * mscott@dundermifflin.com*Michael*Scott*J9F2N1
     * 
     * callmepeggy@gmail.com*Margaret*Carter*C1K9G6
     * 
     * thehunter217@hotmail.ca*Erin*Hunter*N6F8S5
     * 
     * basketball14@videotron.ca*Troy*Bolton*X7B0F6
     * 
     * blackbears@live.ca*Andrew*Belle*K4W4P7
     * 
     * sabrinacarpenter@gmail.com*Sabrina*Carpenter*V3Y0K1
     * 
     * fastestmanalive@bell.ca*Grant*Gustin*F3N7G8
     */

    Voter[] validVoter1 = {
        DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Daisy", "Johnson",
            "djflower@hotmail.com", "H7N9L0"),
        DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Emily", "Andras",
            "andrasemily@outlook.ca", "T3K7V6"),
        DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Margaret", "Carter",
            "callmepeggy@gmail.com", "C1K9G6"),
        DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Andrew", "Belle",
            "blackbears@live.ca", "K4W4P7"),
        DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Sabrina", "Carpenter",
            "sabrinacarpenter@gmail.com", "V3Y0K1")};


    testGetVoterListFromSequentialFile("datafiles/voters1.txt", validVoter1, true, null);

    /*
     * Test GetVoterListFromSequentialFile with voters21.txt :
     * 
     * IsaacSFinch@teleworm.us*Isaac*Finch*K7S2R5
     * 
     * 1-3_5678910121416182022242628303@abc1-2-3.b.com*Koodo Moodo*Tentucky*H5S 2J5
     * 
     * Michelle.Obama@Whitehouse.gov*Mich'elle*Obama*T2K0P7
     * 
     * maryjgarcia@dayrep.com*Mary*Garcia*M5H1P6
     * 
     * RandallDRabin@teleworm.us*Randall*Rabin*V9T5H3
     * 
     * SimonCroteau@gmail.com*Simon*Croteau*J2C 4N1
     * 
     * julietAssange12@hello.ca*Juliet*Assange*J4R9S1
     * 
     * SebStrol_89@kayak_com*Sebastian*Strol*J6L5T9
     * 
     * PaulS74@word*Paul*S*J8O2E6
     * 
     * RayanMars@lobster*Rayan*Mars*W8D9W2
     */

    Voter[] validVoter21 = {
        DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Isaac", "Finch",
            "IsaacSFinch@teleworm.us", "H5S 2J5"),
        DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Koodo Moodo", "Tentucky",
            "1-3_5678910121416182022242628303@abc1-2-3.b.com", "K7S2R5"),
        DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Mich'elle", "Obama",
            "Michelle.Obama@Whitehouse.gov", "T2K0P7"),
        DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Mary", "Garcia",
            "maryjgarcia@dayrep.com", "M5H1P6"),
        DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Randall", "Rabin",
            "RandallDRabin@teleworm.us", "V9T5H3"),
        DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Simon", "Croteau",
            "SimonCroteau@gmail.com", "J2C 4N1"),
        DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Juliet", "Assange",
            "julietAssange12@hello.ca", "J4R9S1"),
        DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Sebastian", "Strol",
            "SebStrol_89@kayak_com", "J6L5T9")};


    testGetVoterListFromSequentialFile("datafiles/voters21.txt", validVoter21, true, null);

    /*
     * Test GetVoterListFromSequentialFile with voters21.txt :
     * 
     * AronB43@hotmail.com*Aron*Bauer*H9S M2K
     * 
     * HarpPlayer45@gmail.com*Romeo*Harper*E7C V6T
     * 
     * Burkanator@yahoo.ca*Anthony*Burke*E3N L9G
     * 
     * warnerjaylene@gmail.com*Jaylene*Warner*K7A 3Y8
     * 
     * curtis-Rocks@gmail.com*Summer*Curtis*V1J 0C8
     * 
     * LawNoGotNoRules@outlook.com*Noel*Lawrence*H9J 2P0
     * 
     * currysmeller17@yahoo.ca*Kailyn*Curry*L4T 0R3
     * 
     * avah386@gmail.com*Avah*Walsh*E7B 0W2
     * 
     * queen.Fiona@hotmail.com*Fiona*Quinn*T9C 1P7
     * 
     * josh_matthew99@outlook.com*Josh*Mathews*E9B 2Y5
     */

    Voter[] validVoter7 = {
        DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Jaylene", "Warner",
            "warnerjaylene@gmail.com", "K7A 3Y8"),
        DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Summer", "Curtis",
            "curtis-Rocks@gmail.com", "V1J 0C8"),
        DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Noel", "Lawrence",
            "LawNoGotNoRules@outlook.com", "H9J 2P0"),
        DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Avah", "Walsh", "avah386@gmail.com",
            "E7B 0W2"),
        DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Fiona", "Quinn",
            "queen.Fiona@hotmail.com", "T9C 1P7"),
        DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Josh", "Mathews",
            "josh_matthew99@outlook.com", "E9B 2Y5")};

    testGetVoterListFromSequentialFile("datafiles/voters7.txt", validVoter7, true, null);


    /*
     * Test GetVoterListFromSequentialFile with null and "":
     * 
     * Should raise an InvalidPathException
     */

    testGetVoterListFromSequentialFile(null, null, false, InvalidPathException.class);
    testGetVoterListFromSequentialFile("", null, false, InvalidPathException.class);

    /*
     * Test GetVoterListFromSequentialFile with a path that leads no where :
     * 
     * Should raise an NoSuchFileException
     */

    testGetVoterListFromSequentialFile("There/is/no/file/at.txt", null, false,
        NoSuchFileException.class);

    testGetVoterListFromSequentialFile("datafiles/voters34.txt", null, false,
        NoSuchFileException.class);


    // Variable Team mate 2
    // testGetElectionListFromSequentialFile(nameOfFile, expectedResult); //Uncomment those!

    // Variable Team mate 3
    // testsetExistingTallyFromSequentialFile(nameOfFile, expectedResult); //Uncomment those!



  }// Main

  public static void testGetVoterListFromSequentialFile(String fileNameTest, Voter[] expectedVoters,
      boolean expectedValid, Class expectedException) {
    final String FAIL = "\n\t\t\t\t\t\t\t\t\t\t\t\t\tTEST FAILED";
    final String PASS = "\n\t\t\t\t\t\t\t\t\t\t\t\t\tTEST PASS";

    System.out.println(
        "==================================================================================================================");
    System.out.println("BEGIN testGetVoterListFromSequentialFile with :");
    System.out.println("fileNameTest : " + fileNameTest);
    if (expectedVoters == null || expectedVoters.length == 0) {
      System.out.println("expectedVoters is empty");
    } else {
      System.out.println("expectedVoters :");
      System.out.println('[');
      for (Voter v : expectedVoters) {
        System.out.println(v);
      }
      System.out.println(']');
    }
    System.out.println(expectedValid ? "Expected to be valid" : "Should not be valid");
    System.out.println(expectedException == null ? "No exception expected"
        : expectedException.getName() + " expected");
    System.out.println();
    System.out.println();


    try {
      Voter[] voters = ElectionFileLoader.GetVoterListFromSequentialFile(fileNameTest);

      if (voters.length == expectedVoters.length && expectedValid) {
        for (int i = 0; i < voters.length; i++) {
          if (!voters[i].equals(expectedVoters[i])) {
            System.out.println('[' + voters[i].toString() + ']' + " should equal " + '['
                + expectedVoters[i].toString() + ']' + FAIL);

            return;
          }
        }
        System.out.println("All Voters successfully have been read from " + fileNameTest
            + " and matched expectedVoters" + PASS);

        return;
      } else if (expectedValid) {
        System.out.println("voters length (" + voters.length + ") and expectedVoters length ("
            + expectedVoters.length + ") are not equal" + FAIL);
      } else if (!expectedValid) {
        System.out.println(fileNameTest + " did not throw any exception and should have" + FAIL);
      }

    } catch (Exception e) {
      if (expectedValid) {
        System.out
            .println("Data was supposed to be valid, but throwed " + e.getClass().getName() + FAIL);
        e.getStackTrace();

        return;
      }

      if (e.getClass().equals(expectedException)) {
        System.out.println(e.getClass().toString() + " was successfully catched" + PASS);

        return;
      }

      System.out.println("The expected error was '" + expectedException.toString() + "' but '"
          + e.getClass().toString() + "' was thrown" + FAIL);
    }
  }// End of Testing GetVoterListFromSequentialFile

  public static void testGetElectionListFromSequentialFile(String fileNameTest,
      boolean expectedValid) {

  }// End of Testing GetElectionListFromSequentialFile

  public static void testsetExistingTallyFromSequentialFile(String fileNameTest,
      boolean expectedValid) {

  }// End of testing SetExistingTallyFromSequentialFile


}
