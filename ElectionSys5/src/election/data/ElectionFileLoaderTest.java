package election.data;

import java.io.IOException;
import election.business.interfaces.Election;

public class ElectionFileLoaderTest {

  public static void main(String[] args) throws IOException {

    Election[] list =
        ElectionFileLoader.getElectionListFromSequentialFile("datafiles/unsorted/elections5.txt");

    System.out.println(list.length);

    for (int i = 0; i < list.length; i++) {
      System.out.println(list[i].toString());
    }


  }



  // Main

  public static void testGetVoterListFromSequentialFile(String fileNameTest,
      boolean expectedValid) {

  }// End of Testing GetVoterListFromSequentialFile

  public static void testGetElectionListFromSequentialFile(String fileNameTest,
      boolean expectedValid) {

  }// End of Testing GetElectionListFromSequentialFile

  public static void testsetExistingTallyFromSequentialFile(String fileNameTest,
      boolean expectedValid) {

  }// End of testing SetExistingTallyFromSequentialFile


}
