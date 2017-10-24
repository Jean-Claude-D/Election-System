package election.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import election.business.interfaces.Election;
import election.business.interfaces.Voter;

/**
 * @author Maria Hossain
 * @version 0.0.1
 * 
 */

public class ElectionFileLoader {


  /**
   * 
   * @param filename
   * @return Voter[]
   * @throws IOException
   * 
   *         This method iterate through a list voter(contained in a text file) with its information
   *         such as email,first name,last name and postal code. And basically created and array of
   *         Voter Object with that following information.
   */


  public static Voter[] GetVoterListFromSequentialFile(String filename) throws IOException {

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
      m += Integer.parseInt(split[10]) + 1;
    }



  }

  /**
   * 
   * @param filename
   * @return Election[]
   * @throws IOException
   * 
   *         This method iterate through the text file and extract the different elections and will
   *         put it into a an array of Elections
   */



  /**
   * 
   * @param filename
   * @param elections
   * @throws IOException
   * 
   *         This method takes in a file and an election array. It will basically match the name of
   *         the election in that array and match it with the matching name and display the result
   *         in an int[][].
   */


  public static void setExistingTallyFromSequentialFile(String filename, Election[] elections)
      throws IOException {
    {

    }



  }
}
