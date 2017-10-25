package election.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import election.business.DawsonElectionFactory;
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
    return null;
  }



  /**
   * 
   * @param filename
   * @return Election[] that contains usually 3 El
   * @throws IOException
   * 
   *         This method iterate through the text file and extract the different elections and will
   *         put it into a an array of Elections
   */
  public static Election[] getElectionListFromSequentialFile(String filename) throws IOException {
    try {
      Path p = Paths.get(filename);
      List<String> allLines = Files.readAllLines(p);
      ArrayList<Election> listElection = new ArrayList<>();
      ArrayList<String> listString = new ArrayList<>();

      int lineOrder = 1;
      int numberOfChoices = 0;
      int lineOffset = 0;

      // Info line: 0, 6, 12

      String[] split;

      for (int i = 0; i < allLines.size(); i += Integer.parseInt(split[10]) + 1) {

        split = (allLines.get(i).split("\\*"));

        for (int j = 0; j < split.length; j++) {
          listString.add(split[j]);
        }
        listString.add("\n");

        numberOfChoices += Integer.parseInt(split[10]);

        for (int k = lineOrder; k <= numberOfChoices + lineOffset; k++) {
          listString.add(allLines.get(k) + "\n");
          // System.out.println("( " + k + " ) ");
        }

        String[] choices = allLines.subList(i + 1, i + Integer.parseInt(split[10]) + 1)
            .toArray(new String[Integer.parseInt(split[10])]);

        try {
          listElection.add(DawsonElectionFactory.DAWSON_ELECTION.getElectionInstance(
              listString.get(0), listString.get(9), Integer.parseInt(listString.get(1)),
              Integer.parseInt(listString.get(2)), Integer.parseInt(listString.get(3)),
              Integer.parseInt(listString.get(4)), Integer.parseInt(listString.get(5)),
              Integer.parseInt(listString.get(6)), listString.get(7), listString.get(8), choices));

          listString.clear();
        } catch (Exception e) {
          System.out.println("One of the variable is invalid" + e);
        }

        lineOffset++;
        lineOrder += Integer.parseInt(split[10]) + 1;
      }
      return listElection.toArray(new Election[listElection.size()]);
    } catch (NoSuchFileException e) {
      System.err.println("File not found: " + e.getMessage());
      return new Election[0];
    }
  }



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
