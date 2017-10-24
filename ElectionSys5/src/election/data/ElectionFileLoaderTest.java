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

    // "datafiles/unsorted/elections5.txt"
    String filename = "datafiles/elections2.txt";
    Path p = Paths.get(filename);
    List<String> allLines = Files.readAllLines(p);
    ArrayList<Election> list = new ArrayList<Election>();
    Election placeHolder;
    ArrayList<String> listString = new ArrayList<String>();

    int i = 0;
    int m = 1;
    int n = 0;
    int x = 0;

    // Info line: 0, 6, 12

    while (i < allLines.size()) {

      String[] split = (allLines.get(i).split("\\*"));

      for (int j = 0; j < split.length; j++) {
        listString.add(split[j]);
      }
      listString.add("\n");

      n += Integer.parseInt(split[10]);

      for (int k = m; k <= n + x; k++) {
        listString.add(allLines.get(k) + "\n");
        // System.out.println("( " + k + " ) ");
      }

      x++;
      i += Integer.parseInt(split[10]) + 1;
      System.out.println("(- " + i + " -) ");
      System.out.println("= " + Integer.parseInt(split[10]) + " = ");
      m += Integer.parseInt(split[10]) + 1;
      System.out.println("( " + m + " ) ");
    }

    System.out.println(listString);
    System.out.println();
    System.out.println("====================");

    for (int z = 0; z < listString.size(); z++) {
      System.out.println(listString.get(z));
    }
    System.out.println(listString.size());


    // for (String s : split) {
    // System.out.println(s);
    // }

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
