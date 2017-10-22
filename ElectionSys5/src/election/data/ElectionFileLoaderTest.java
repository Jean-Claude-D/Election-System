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

    String pathToVoter1 = "datafiles/voters1.txt";
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

    testGetVoterListFromSequentialFile(pathToVoter1, validVoter1, true, null);

    /*
     * Test GetVoterListFromSequentialFile with null :
     * 
     * Should raise an IllegalArgumentException
     */

    testGetVoterListFromSequentialFile(null, null, false, illArg);

    /*
     * Test GetVoterListFromSequentialFile with null :
     */



    // Variable Team mate 2
    // testGetElectionListFromSequentialFile(nameOfFile, expectedResult); //Uncomment those!

    // Variable Team mate 3
    // testsetExistingTallyFromSequentialFile(nameOfFile, expectedResult); //Uncomment those!



  }// Main

  public static void testGetVoterListFromSequentialFile(String fileNameTest, Voter[] expectedVoters,
      boolean expectedValid, Class expectedException) {
    final String FAIL = "\n\t\t\t\t\t\t\t\t\t\t\t\t\tTEST FAILED";
    final String PASS = "\n\t\t\t\t\t\t\t\t\t\t\t\t\tTEST PASS";

    System.out.println("BEGIN testGetVoterListFromSequentialFile with :");
    System.out.println(fileNameTest);
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
