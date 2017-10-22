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
    String pathToVoterOne = "datafiles/voters1.txt";



    testGetVoterListFromSequentialFile(pathToVoterOne, true);

    // Variable Team mate 2
    // testGetElectionListFromSequentialFile(nameOfFile, expectedResult); //Uncomment those!

    // Variable Team mate 3
    // testsetExistingTallyFromSequentialFile(nameOfFile, expectedResult); //Uncomment those!



  }// Main

  public static void testGetVoterListFromSequentialFile(String fileNameTest,
      boolean expectedValid) {
    try {
      Voter[] voters =
          ElectionFileLoader.GetVoterListFromSequentialFile("path/leads/nowhere/at.txt");

      for (Voter v : voters)
        System.out.println(v);
    } catch (Exception e) {
      System.err.println("Something went wrong");
      e.printStackTrace();
    }


  }// End of Testing GetVoterListFromSequentialFile

  public static void testGetElectionListFromSequentialFile(String fileNameTest,
      boolean expectedValid) {

  }// End of Testing GetElectionListFromSequentialFile

  public static void testsetExistingTallyFromSequentialFile(String fileNameTest,
      boolean expectedValid) {

  }// End of testing SetExistingTallyFromSequentialFile


}
