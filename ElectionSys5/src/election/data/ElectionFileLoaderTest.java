package election.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import election.business.interfaces.Election;

public class ElectionFileLoaderTest {

  public static void main(String[] args) throws IOException {


    String filename = "datafiles/unsorted/elections5.txt";
    Path p = Paths.get(filename);
    List<String> allLines = Files.readAllLines(p);
    ArrayList<Election> list = new ArrayList<Election>();
    Election placeHolder;
    ArrayList<String> tacticalList = new ArrayList<String>();
    
    System.out.println(allLines.size());

    
    String[] tactical = (allLines.get(0).split("\\*"));
    for (int i = 0, k = 0; i < allLines.size(); i += Integer.parseInt(tactical[10]) + 1 , k++) { 
      System.out.println(i);
      tactical = (allLines.get(k).split("\\*"));
      
      for (String s: tactical) {
        System.out.println(s);
      }
      
      for (int j = 0; j < tactical.length; j++) {
        tacticalList.add(tactical[j]);
        // System.out.print(tactical[i]);

      }

      for (int j = 1; j - 1 < Integer.parseInt(tactical[10]); j++) {
        tacticalList.add(allLines.get(j));
        // System.out.println(allLines.get(i));
      }
     // System.out.println(Integer.parseInt(tactical[10]));
    }

    System.out.println(tacticalList);



    // Variables
    String nameOfFile = null;
    boolean expectedResult = false;


    // The test method where we will pass the variables

    // Variable Team mate 1
    testGetVoterListFromSequentialFile(nameOfFile, expectedResult);

    // Variable Team mate 2
    testGetElectionListFromSequentialFile(nameOfFile, expectedResult);

    // Variable Team mate 3
    testsetExistingTallyFromSequentialFile(nameOfFile, expectedResult);



  }// Main

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
