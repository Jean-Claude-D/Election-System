package election.data;

import java.io.IOException;
import election.business.interfaces.Voter;

public class ElectionFileLoaderTest {

  public static void main(String[] args) throws IOException {


    // Variables
    String nameOfFile = null;
    boolean expectedResult = false;


    // The test method where we will pass the variables

    // Variable Team mate 1
    String pathToVoter = "datafiles/voters1.txt";
    Voter[] expectedVoters;

    /*
     * Test GetVoterListFromSequentialFile with voters1.txt :
     * 
     * djflower@hotmail.com*Daisy*Johnson*H7N9L0 robsmith@gmail.com*Robert*Smith*J8F4K2
     * andrasemily@outlook.ca*Emily*Andras*T3K7V6 mscott@dundermifflin.com*Michael*Scott*J9F2N1
     * callmepeggy@gmail.com*Margaret*Carter*C1K9G6 thehunter217@hotmail.ca*Erin*Hunter*N6F8S5
     * basketball14@videotron.ca*Troy*Bolton*X7B0F6 blackbears@live.ca*Andrew*Belle*K4W4P7
     * sabrinacarpenter@gmail.com*Sabrina*Carpenter*V3Y0K1
     * fastestmanalive@bell.ca*Grant*Gustin*F3N7G8
     */


    testGetVoterListFromSequentialFile(pathToVoter, null, true);

    // Variable Team mate 2
    // testGetElectionListFromSequentialFile(nameOfFile, expectedResult); //Uncomment those!

    // Variable Team mate 3
    // testsetExistingTallyFromSequentialFile(nameOfFile, expectedResult); //Uncomment those!



  }// Main

  public static void testGetVoterListFromSequentialFile(String fileNameTest, Voter[] expectedVoters,
      boolean expectedValid) {
    System.out.println("\t\t\t\t\t\t\t\t\t\tBEGIN testGetVoterListFromSequentialFile");

    try {
      Voter[] voters = ElectionFileLoader.GetVoterListFromSequentialFile(fileNameTest);

    } catch (Exception e) {
      System.err.println("Something went wrong");
      e.printStackTrace();
    }

    System.out.println("\t\t\t\t\t\t\t\t\t\tEND testGetVoterListFromSequentialFile");
  }// End of Testing GetVoterListFromSequentialFile

  public static void testGetElectionListFromSequentialFile(String fileNameTest,
      boolean expectedValid) {

  }// End of Testing GetElectionListFromSequentialFile

  public static void testsetExistingTallyFromSequentialFile(String fileNameTest,
      boolean expectedValid) {

  }// End of testing SetExistingTallyFromSequentialFile


}
